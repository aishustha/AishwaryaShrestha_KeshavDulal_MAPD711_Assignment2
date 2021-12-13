package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.ui.sampler

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SamplerViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Ever dreamt of going on a cruise only to have your hopes shattered by an unaccommodating " +
                "calendar or a disobliging budget? Those days are over! Thanks to a little something the " +
                "industry likes to call ‘sampler cruises’ holidaymakers can enjoy whirlwind at-sea getaways " +
                "that last a matter of days. Want to know more? Read on for our insider’s guide to sampler " +
                "cruises and what makes them so popular."+
                "Duration: 6 Nights" +
                "Price: $2300/person"
    }
    val text: LiveData<String> = _text
}
