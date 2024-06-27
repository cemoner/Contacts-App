package com.example.contactsapp.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.doTransition(it:View,id:Int){
    Navigation.findNavController(it).navigate(id)
}


fun Navigation.doTransition(it:View,directions: NavDirections){
    Navigation.findNavController(it).navigate(directions)
}