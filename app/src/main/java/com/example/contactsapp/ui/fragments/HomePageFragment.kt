package com.example.contactsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactsapp.R
import com.example.contactsapp.data.entity.Person
import com.example.contactsapp.databinding.FragmentHomePageBinding
import com.example.contactsapp.ui.adapter.PersonAdapter
import com.example.contactsapp.ui.viewmodel.AddPersonViewModel
import com.example.contactsapp.ui.viewmodel.HomePageViewModel
import com.example.contactsapp.util.doTransition
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    private lateinit var viewModel:HomePageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_page, container,false)
        binding.homepagePersonFragment = this
        binding.homePageToolbar = "Contacts"

        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null && newText != "") {
                    viewModel.search(newText)
                }
                else {
                    viewModel.loadPeople()
                }
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null && query != "") {
                    viewModel.search(query)
                }
                else {
                    viewModel.loadPeople()
                }
                return true
            }

        })

        viewModel.peopleList.observe(viewLifecycleOwner){
            val peopleAdapter:PersonAdapter = PersonAdapter(context = requireContext(),listOfPeople = it,viewModel)
            binding.personAdapter = peopleAdapter
        }




        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomePageViewModel by viewModels()
        viewModel = tempViewModel
    }



    fun clickAddButton(it:View) {
        Navigation.doTransition(it,R.id.addPersonTransition)
    }
}