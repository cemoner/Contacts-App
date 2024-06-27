package com.example.contactsapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity("people")
data class Person(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "person_id") @NotNull var person_id:Int,
    @ColumnInfo(name = "person_name") @NotNull var person_name:String,
    @ColumnInfo(name = "person_no") @NotNull var person_no:String):Serializable {


}