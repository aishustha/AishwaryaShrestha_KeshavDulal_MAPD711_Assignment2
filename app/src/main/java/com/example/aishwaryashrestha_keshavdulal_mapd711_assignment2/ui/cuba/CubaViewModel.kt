package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.ui.cuba

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CubaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Bermuda is buzzing with history. From Hamilton to St. George's, " +
                "there are hundreds of years of historical buildings and places to explore. " +
                "Visit Bermuda to discover the colonial roots of these vibrant cities, " +
                "where cultures collide into a distinctive mix of European and indigenous " +
                "influences you won't find replicated anywhere in the world."+
                "Duration: 5 Nights" +
                "Price: $2200/person"
    }
    val text: LiveData<String> = _text
}
