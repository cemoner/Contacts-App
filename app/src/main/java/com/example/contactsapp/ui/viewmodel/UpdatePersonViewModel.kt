package com.example.contactsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.contactsapp.data.repo.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UpdatePersonViewModel @Inject constructor(var pr: PersonRepository):ViewModel() {
    fun updatePerson(personId:Int,personName:String,personNumber:String) {
        CoroutineScope(Dispatchers.Main).launch {
            pr.updatePerson(personId,personName,personNumber)
        }

    }
}