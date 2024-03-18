package com.pets.mycontactlist.presentations.models

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.pets.mycontactlist.R
import com.pets.mycontactlist.data.api.RetrofitInstance
import com.pets.mycontactlist.data.api.randomuser.State
import com.pets.mycontactlist.data.database.StoredUserInfoDao
import com.pets.mycontactlist.entitis.userinfo.UserInfo
import com.pets.mycontactlist.data.database.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class ContactListViewModel(application: Application) : AndroidViewModel(application) {

    var state: MutableLiveData<State> = MutableLiveData(State.Loading)
    var userList: MutableLiveData<List<UserInfo>> = MutableLiveData(listOf())

    private val dao: StoredUserInfoDao = (application as App).db.storedUserInfoDao()

    private val context = getApplication<Application>().applicationContext

    init{
        getUserList()
    }


    fun getUserInfo(index: Int): UserInfo {

        return userList.value?.get(index)!!
    }

    private suspend fun getNewUserList(): List<UserInfo> {
        val res = RetrofitInstance.getUserList().results
        dao.clear()
        dao.insertAll(res?.map { it.toStoredUserInfo() } ?: listOf())
        return res?.map { it.toUserInfo() } ?: listOf()
    }

    fun  reloadUserList(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                state.postValue(State.Loading)
                userList.postValue(getNewUserList())
                state.postValue(State.Success)
            }catch (e: Exception) {
                userList.postValue(listOf())
                state.postValue(
                    State.Error(
                        context.getString(R.string.err_get_user_list)
                    )
                )
            }
        }
    }

    private fun getUserList() {

        viewModelScope.launch(Dispatchers.IO) {

            try {
                state.postValue(State.Loading)
                delay(2000)
                var list = dao.getStoredUserInfo().map { it.toUserInfo() }

                if (list.isEmpty()) {
                    list = getNewUserList()
                }

                userList.postValue(list)

                state.postValue(State.Success)
            } catch (e: Exception) {
                userList.postValue(listOf())
                state.postValue(
                    State.Error(
                        context.getString(R.string.err_get_user_list)
                    )
                )
            }

        }

    }
}