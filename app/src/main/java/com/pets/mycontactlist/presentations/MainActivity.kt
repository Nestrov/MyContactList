package com.pets.mycontactlist.presentations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels

import com.pets.mycontactlist.R
import com.pets.mycontactlist.presentations.models.ContactListViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: ContactListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}