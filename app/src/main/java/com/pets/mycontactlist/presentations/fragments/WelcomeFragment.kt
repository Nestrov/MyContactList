package com.pets.mycontactlist.presentations.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.pets.mycontactlist.R
import com.pets.mycontactlist.data.api.randomuser.State
import com.pets.mycontactlist.databinding.FragmentWelcomeBinding
import com.pets.mycontactlist.presentations.models.ContactListViewModel
import kotlinx.coroutines.delay


class WelcomeFragment : Fragment() {


    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    private val  viewModel: ContactListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWelcomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.pbWelcome.isVisible = true

    }

    override fun onStart() {
        super.onStart()
        viewModel.state.observe(this){
            when (it) {
                is State.Error -> {
                    Toast.makeText(activity, it.errMsg, Toast.LENGTH_SHORT).show()
                    binding.pbWelcome.isVisible = false
                }
                State.Loading -> {
                    binding.pbWelcome.isVisible = true
                }

                State.Success ->{
                    findNavController().navigate(R.id.action_welcomeFragment_to_userListFragment)
                }
            }

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }


}