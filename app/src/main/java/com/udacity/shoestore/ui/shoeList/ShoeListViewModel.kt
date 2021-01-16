package com.udacity.shoestore.ui.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private var listShoe: MutableList<Shoe> = mutableListOf()

    private val _eventAddShoeListPress = MutableLiveData<Boolean>(false)
    val eventAddShoeListPress: LiveData<Boolean>
        get() = _eventAddShoeListPress

    fun goToShoeDetailStart() {
        _eventAddShoeListPress.value = true
    }

    fun goToShoeDetailStartComplete() {
        _eventAddShoeListPress.value = false
    }

    fun saveNewShoe(shoe: Shoe) {
        listShoe.add(shoe)
    }

    fun getShoe(index: Int): Shoe {
        return listShoe[index]
    }

    fun getShoeSize(): Int {
        return listShoe.size
    }
}