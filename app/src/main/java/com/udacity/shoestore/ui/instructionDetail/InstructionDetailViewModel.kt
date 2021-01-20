package com.udacity.shoestore.ui.instructionDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionDetailViewModel : ViewModel() {

    private val _eventNextInstructionDetailPress = MutableLiveData(false)
    val eventNextInstructionDetailPress: LiveData<Boolean>
        get() = _eventNextInstructionDetailPress

    fun goToShoeListStart() {
        _eventNextInstructionDetailPress.value = true
    }

    fun goToShoeListComplete() {
        _eventNextInstructionDetailPress.value = false
    }
}