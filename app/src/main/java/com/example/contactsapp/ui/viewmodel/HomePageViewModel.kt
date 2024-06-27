package com.example.contactsapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contactsapp.data.entity.Person
import com.example.contactsapp.data.repo.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomePageViewModel @Inject constructor(var pr: PersonRepository):ViewModel() {

    var peopleList = MutableLiveData<List<Person>>()

    init {
        loadPeople()
    }

    fun deletePerson(person_id:Int) {
        CoroutineScope(Dispatchers.Main).launch {
            pr.deletePerson(person_id)
            peopleList.value = pr.loadPeople()
        }
    }
    fun loadPeople(){
        CoroutineScope(Dispatchers.Main).launch {
            peopleList.value = pr.loadPeople()
        }
    }
    fun search(keyword:String){
        CoroutineScope(Dispatchers.Main).launch {
            peopleList.value = pr.search(keyword)
        }
    }
}