package com.udacity.shoestore.ui.instructionList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionListViewModel : ViewModel() {

    private val _eventNextInstructionDetailPress = MutableLiveData(false)
    val eventNextInstructionDetailPress: LiveData<Boolean>
        get() = _eventNextInstructionDetailPress

    fun goToInstructionDetailStart() {
        _eventNextInstructionDetailPress.value = true
    }

    fun goToInstructionDetailComplete() {
        _eventNextInstructionDetailPress.value = false
    }
}