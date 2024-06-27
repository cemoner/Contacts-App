package com.example.contactsapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.contactsapp.data.entity.Person

@Database(entities = [Person::class], version = 1)
abstract class Database:RoomDatabase() {
    abstract fun getPeopleDAO():PeopleDAO
}