package com.pets.mycontactlist.presentations.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.pets.mycontactlist.R
import com.pets.mycontactlist.data.api.randomuser.State
import com.pets.mycontactlist.databinding.FragmentUserListBinding
import com.pets.mycontactlist.presentations.adapters.ContactListAdapter
import com.pets.mycontactlist.presentations.models.ContactListViewModel

class UserListFragment : Fragment() {

    private var _binding: FragmentUserListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ContactListViewModel by activityViewModels()

    private val contactListAdapter = ContactListAdapter {
        onItemClick(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentUserListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btRefresh.isVisible = false
        binding.pbList.isVisible = true

        binding.rvUserList.adapter = contactListAdapter

        binding.btRefresh.setOnClickListener {
            viewModel.reloadUserList()
        }


    }

    override fun onStart() {
        super.onStart()

        viewModel.state.observe(this) {
            when (it) {
                is State.Error -> {
                    Toast.makeText(activity, it.errMsg, Toast.LENGTH_SHORT).show()
                    binding.rvUserList.isEnabled = false
                    binding.btRefresh.isVisible = true
                    binding.pbList.isVisible = false
                }

                State.Loading -> {
                    binding.rvUserList.isEnabled = false
                    binding.btRefresh.isVisible = false
                    binding.pbList.isVisible = true
                }

                State.Success -> {
                    binding.rvUserList.isEnabled = true
                    binding.btRefresh.isVisible = true
                    binding.pbList.isVisible = false
                }
            }

        }
        viewModel.userList.observe(this) {
            contactListAdapter.update(it)
        }

    }

    private fun onItemClick(index: Int) {
        if (binding.rvUserList.isEnabled) {
            val bundle = Bundle().apply {
                putInt(UserCardFragment.ARG_INDEX, index)
            }

            findNavController().navigate(R.id.action_userListFragment_to_userCardFragment2, bundle)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }


}