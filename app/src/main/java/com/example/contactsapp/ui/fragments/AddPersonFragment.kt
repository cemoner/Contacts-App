package com.example.contactsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.contactsapp.R
import com.example.contactsapp.databinding.FragmentAddPersonBinding
import com.example.contactsapp.databinding.FragmentUpdatePersonBinding
import com.example.contactsapp.ui.viewmodel.AddPersonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddPersonFragment : Fragment() {

    private lateinit var binding: FragmentAddPersonBinding
    private lateinit var viewModel:AddPersonViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_person,container,false)
        binding.addPersonFragment = this
        binding.addPersonToolbar = "Add Person"


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:AddPersonViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun buttonAddPerson(personName:String,personNumber:String){
        viewModel.buttonAddPerson(personName,personNumber)
    }

}