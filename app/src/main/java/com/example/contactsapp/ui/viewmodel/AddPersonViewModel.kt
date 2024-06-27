package com.example.contactsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.contactsapp.data.repo.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddPersonViewModel @Inject constructor(var pr: PersonRepository):ViewModel() {
    fun buttonAddPerson(personName:String,personNumber:String) {
        CoroutineScope(Dispatchers.Main).launch {
            pr.addPerson(personName,personNumber)
        }
    }
}