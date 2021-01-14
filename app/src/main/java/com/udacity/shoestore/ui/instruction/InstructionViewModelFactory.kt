package com.udacity.shoestore.ui.instruction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class InstructionViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InstructionViewModel::class.java)) {
            return InstructionViewModel() as T
        }
        return null as T
    }
}