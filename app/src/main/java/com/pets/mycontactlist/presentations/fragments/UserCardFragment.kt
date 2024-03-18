package com.pets.mycontactlist.presentations.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.pets.mycontactlist.R
import com.pets.mycontactlist.databinding.FragmentUserCardBinding

import com.pets.mycontactlist.presentations.models.ContactListViewModel


class UserCardFragment : Fragment() {
    private var _binding: FragmentUserCardBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ContactListViewModel by activityViewModels()

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            index = it.getInt(ARG_INDEX)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserCardBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = viewModel.getUserInfo(index)

        Glide.with(binding.ivUserAvatar)
            .load(item.bigPhotoUrl)
            .error(R.drawable.ic_empty_photo)
            .into(binding.ivUserAvatar)

        binding.tvFio.text = item.fio
        binding.tvEmail.text = item.email
        binding.tvPhone.text = item.phone
        binding.tvAddress.text = item.address

        binding.tvLatitude.text = item.latitude.toString()
        binding.tvLongitude.text = item.longitude.toString()


        binding.tvEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.data = Uri.parse("mailto:")
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(item.email))

            try {
                startActivity(Intent.createChooser(intent, "Send Email"))
            } catch (e: Exception) {
                Toast.makeText(
                    activity,
                    getString(R.string.send_email_err),
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

        binding.tvPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${item.phone}")

            try {
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(
                    activity,
                    getString(R.string.send_call_err),
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

        binding.tvAddress.setOnClickListener {
            showOnMap("${item.latitude},${item.longitude}", item.address)
        }
        binding.tvLatitude.setOnClickListener {
            showOnMap("${item.latitude},${item.longitude}", item.address)
        }

        binding.tvLongitude.setOnClickListener {
            showOnMap("${item.latitude},${item.longitude}", item.address)
        }

    }

    private fun showOnMap(coordinates: String, address : String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("geo:${coordinates}?q=$address")
        //intent.setPackage("com.google.android.apps.maps")
        try {
            startActivity(Intent.createChooser(intent, "Show on map"))
        } catch (e: Exception) {
            Toast.makeText(
                activity,
                getString(R.string.send_map_err),
                Toast.LENGTH_SHORT
            ).show()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val ARG_INDEX = "Index"
    }
}