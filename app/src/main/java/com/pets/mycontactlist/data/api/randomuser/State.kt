package com.pets.mycontactlist.data.api.randomuser


sealed class State{
    data object Loading : State()
    data object Success: State()
    data class Error (val errMsg: String) : State()
}
