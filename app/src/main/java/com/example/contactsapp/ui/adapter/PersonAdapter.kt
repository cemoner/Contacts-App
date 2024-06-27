package com.example.contactsapp.ui.adapter

import com.example.contactsapp.data.entity.Person
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp.R
import com.example.contactsapp.databinding.CardDesignBinding
import com.example.contactsapp.databinding.FragmentAddPersonBinding
import com.example.contactsapp.ui.fragments.HomePageFragmentDirections
import com.example.contactsapp.ui.viewmodel.HomePageViewModel
import com.example.contactsapp.util.doTransition
import com.google.android.material.snackbar.Snackbar
import java.util.function.Predicate

class PersonAdapter(var context: Context,var listOfPeople: List<Person>,var viewModel:HomePageViewModel) : RecyclerView.Adapter<PersonAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var designHolder:CardDesignBinding) : RecyclerView.ViewHolder(designHolder.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding:CardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.card_design, parent,false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val person:Person = listOfPeople[position]
        val binding = holder.designHolder
        binding.personObject = person

        binding.personCard.setOnClickListener {
            val transition = HomePageFragmentDirections.updatePersonTransition(person)
            Navigation.doTransition(it,transition)
        }

        binding.deleteIcon.setOnClickListener {
            Snackbar.make(it,"Do you want to delete ${person.person_name}?",Snackbar.LENGTH_LONG).setAction("Yes"){
                viewModel.deletePerson(person.person_id)
                Snackbar.make(it,"Deletion is Succesful!",Snackbar.LENGTH_SHORT).show()
            }.show()
        }

    }

    override fun getItemCount(): Int {
        return listOfPeople.size
    }
}