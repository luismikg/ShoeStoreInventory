package com.udacity.shoestore.ui.instruction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionViewModel : ViewModel() {

    private val _eventNextInstructionPress = MutableLiveData<Boolean>(false)
    val eventNextInstructionPress: LiveData<Boolean>
        get() = _eventNextInstructionPress

    fun goToShoeListStart() {
        _eventNextInstructionPress.value = true
    }

    fun goToShoeListStartComplete() {
        _eventNextInstructionPress.value = false
    }
}