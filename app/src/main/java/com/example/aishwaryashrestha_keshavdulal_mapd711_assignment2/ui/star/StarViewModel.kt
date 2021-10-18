package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.ui.star

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StarViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Star Cruises’ commitment to offering best-in-class services and facilities is " +
                "reflected in a host of recognitions and accolades received over the years. These " +
                "include being inducted into the prestigious Travel Trade Gazette’s “Travel Hall of Fame” " +
                "for the ninth year in 2016, in recognition of winning “Best Cruise Operator in the Asia-Pacific” " +
                "for 10 consecutive years. " +
                "Star Cruises was also recently voted “Asia’s Leading Cruise Line” at the World Travel " +
                "sAwards for the fifth year in a row in 2016."
    }
    val text: LiveData<String> = _text
}