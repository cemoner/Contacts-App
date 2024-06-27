package com.example.contactsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.contactsapp.R
import com.example.contactsapp.databinding.FragmentHomePageBinding
import com.example.contactsapp.databinding.FragmentUpdatePersonBinding
import com.example.contactsapp.ui.viewmodel.HomePageViewModel
import com.example.contactsapp.ui.viewmodel.UpdatePersonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdatePersonFragment : Fragment() {

    private lateinit var binding: FragmentUpdatePersonBinding
    private lateinit var viewModel:UpdatePersonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bundle:UpdatePersonFragmentArgs by navArgs()
        val person = bundle.person
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_update_person, container,false)
        binding.updatePersonFragment = this
        binding.personObject = person
        binding.updatePersonToolbar = "Update Person"


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: UpdatePersonViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonUpdatePerson(personId:Int,personName:String,personNumber:String){
        viewModel.updatePerson(personId,personName,personNumber)
    }
}