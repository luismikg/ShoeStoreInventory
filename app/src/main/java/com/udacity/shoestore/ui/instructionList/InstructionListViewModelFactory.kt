package com.udacity.shoestore.ui.instructionList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class InstructionListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InstructionListViewModel::class.java)) {
            return InstructionListViewModel() as T
        }
        return null as T
    }
}