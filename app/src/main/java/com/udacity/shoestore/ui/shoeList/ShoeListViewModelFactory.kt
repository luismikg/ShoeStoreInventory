package com.udacity.shoestore.ui.shoeList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ShoeListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoeListViewModel::class.java)) {
            return ShoeListViewModel() as T
        }
        return null as T
    }
}