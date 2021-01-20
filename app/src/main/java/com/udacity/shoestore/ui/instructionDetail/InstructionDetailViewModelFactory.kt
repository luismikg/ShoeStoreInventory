package com.udacity.shoestore.ui.instructionDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class InstructionDetailViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InstructionDetailViewModel::class.java)) {
            return InstructionDetailViewModel() as T
        }
        return null as T
    }
}