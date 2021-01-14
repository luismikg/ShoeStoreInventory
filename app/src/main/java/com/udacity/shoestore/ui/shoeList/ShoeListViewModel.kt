package com.udacity.shoestore.ui.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel : ViewModel() {

    private val _eventAddShoeListPress = MutableLiveData<Boolean>(false)
    val eventAddShoeListPress: LiveData<Boolean>
        get() = _eventAddShoeListPress

    fun goToShoeDetailStart() {
        _eventAddShoeListPress.value = true
    }

    fun goToShoeDetailStartComplete() {
        _eventAddShoeListPress.value = false
    }
}