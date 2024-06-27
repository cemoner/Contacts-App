package com.example.contactsapp.data.datasource

import android.app.Person
import android.provider.Contacts.People
import android.util.Log
import com.example.contactsapp.room.PeopleDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonDataSource(var pdao:PeopleDAO) {

    suspend fun loadPeople(): List<com.example.contactsapp.data.entity.Person> =
        withContext(Dispatchers.IO) {
            return@withContext pdao.loadPeople()
        }


    suspend fun search(keyword:String): List<com.example.contactsapp.data.entity.Person> =
        withContext(Dispatchers.IO) {
            return@withContext pdao.search(keyword)
        }

    suspend fun addPerson(personName:String,personNumber:String){
        Log.e("Add Person","$personName - $personNumber")
        val person = com.example.contactsapp.data.entity.Person(0, personName, personNumber)
        pdao.insert(person)

    }

    suspend fun updatePerson(person_id:Int,personName:String,personNumber:String){
        val person = com.example.contactsapp.data.entity.Person(person_id, personName, personNumber)
        pdao.update(person)
    }

    suspend fun deletePerson(person_id:Int) {
        Log.e("delete people","$person_id")
        val person = com.example.contactsapp.data.entity.Person(person_id, "", "")
        pdao.delete(person)
    }
}