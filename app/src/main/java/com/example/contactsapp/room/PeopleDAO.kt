package com.example.contactsapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.contactsapp.data.entity.Person


@Dao
interface PeopleDAO {
    @Query("SELECT * FROM people")
    suspend fun loadPeople():List<Person>


    @Insert
    suspend fun insert(person: Person)

    @Update
    suspend fun update(person: Person)

    @Delete
    suspend fun delete(person: Person)

    @Query("SELECT * FROM people WHERE person_name like '%' || :keyword || '%'")
    suspend fun search(keyword:String):List<Person>
}