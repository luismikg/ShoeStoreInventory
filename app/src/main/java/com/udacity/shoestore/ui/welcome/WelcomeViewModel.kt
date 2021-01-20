package com.udacity.shoestore.ui.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    private val _eventNextInstructionPress = MutableLiveData(false)
    val eventNextInstructionPress: LiveData<Boolean>
        get() = _eventNextInstructionPress

    fun goToInstructionStart() {
        _eventNextInstructionPress.value = true
    }

    fun goToInstructionComplete() {
        _eventNextInstructionPress.value = false
    }
}