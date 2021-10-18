package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.ui.caribbean

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CaribbeanViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Set sail on a Caribbean cruise and discover the cliff-diving, breeze-swaying, " +
                "sand-between-your-toes, no-worries pace of island life. Hundreds of years of history " +
                "have left jungle ruins from ancient times and vibrant colonial towns with brightly painted " +
                "buildings reflecting a fascinating history. Discover the white-sand beaches and rugged cliffs" +
                "of Barbados. See towering mountains like Petit Piton in St. Lucia, explore the lush rainforests " +
                "of Belize, or boost your adrenaline as you zip-line through the treetops of Labadee or Honduras. " +
                "If calm, contemplative nature is more your thing, " +
                "spend the day admiring cascading waterfalls in Jamaica and the " +
                "vivid coral reefs of Bonaire, home to manta rays and parrot fish."
    }
    val text: LiveData<String> = _text
}