package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.ui.bahamas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BahamasViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "A respite for sun and sand seekers, the Bahamas is home to light blue beaches, " +
                "translucent underwater caves, a rich royal heritage and exclusive private isles. " +
                "These can all be found throughout a beautifully scattered string of 700 islands " +
                "(most of which are uninhabited). Cruise to the Bahamas to take a dive and witness a " +
                "majestic coral garden at Orange Bowl reef, hang out at ultra-luxurious resorts like " +
                "Atlantis, and shop resort fashion in Paradise Island or Nassau. The Bahamas " +
                "has an island for every taste and style, and it's easy to enjoy its subtropical " +
                "charm during an overnight stint or a week-long cruise." +
                "Duration: 4 Nights" +
                "Price: $1900/person"
    }
    val text: LiveData<String> = _text
}
