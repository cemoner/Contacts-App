package com.example.contactsapp.di

import android.content.Context
import androidx.room.Room
import com.example.contactsapp.data.datasource.PersonDataSource
import com.example.contactsapp.data.repo.PersonRepository
import com.example.contactsapp.room.Database
import com.example.contactsapp.room.PeopleDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePersonDataSource(peopleDAO: PeopleDAO):PersonDataSource {
        return PersonDataSource(peopleDAO)
    }
    @Provides
    @Singleton
    fun providePersonRepository(personDataSource: PersonDataSource):PersonRepository {
        return PersonRepository(personDataSource)
    }
    @Provides
    @Singleton
    fun providePeopleDao(@ApplicationContext context:Context):PeopleDAO {
        val db = Room.databaseBuilder(context, Database::class.java,"contacts.sqlite").createFromAsset("contacts.sqlite").build()
        return db.getPeopleDAO()
    }
}