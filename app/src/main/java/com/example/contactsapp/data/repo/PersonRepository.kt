package com.example.contactsapp.data.repo


import android.util.Log
import com.example.contactsapp.data.datasource.PersonDataSource
import com.example.contactsapp.data.entity.Person

class PersonRepository(var pds:PersonDataSource) {
    suspend fun addPerson(personName:String,personNumber:String) = pds.addPerson(personName,personNumber)

    suspend fun updatePerson(personId:Int,personName:String,personNumber:String) = pds.updatePerson(personId,personName,personNumber)

    suspend fun deletePerson(person_id:Int) = pds.deletePerson(person_id)

    suspend fun loadPeople():List<Person> = pds.loadPeople()

    suspend fun search(keyword:String): List<com.example.contactsapp.data.entity.Person> = pds.search(keyword)
}