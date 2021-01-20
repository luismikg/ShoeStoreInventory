package com.udacity.shoestore.ui.shoeDetail

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeDetailViewModel : ViewModel() {

    var shoe = Shoe(
        "",
        0,
        "",
        "",
        0
    )

    //save
    private val _eventSaveShoeDetailPress = MutableLiveData(false)
    val eventSaveShoeDetailPress: LiveData<Boolean>
        get() = _eventSaveShoeDetailPress

    //cancel
    private val _eventCancelShoeDetailPress = MutableLiveData(false)
    val eventCancelShoeDetailPress: LiveData<Boolean>
        get() = _eventCancelShoeDetailPress

    //shoe picture
    private val _eventPictureShoeDetailPress = MutableLiveData<String>()
    val eventPictureShoeDetailPress: LiveData<String>
        get() = _eventPictureShoeDetailPress

    //size
    private val _eventSizeViewShoeDetailPress = MutableLiveData<View>()
    val eventSizeViewShoeDetailPress: LiveData<View>
        get() = _eventSizeViewShoeDetailPress

    //missing name shoe
    private val _eventSaveFailByNameShoeDetail = MutableLiveData(false)
    val eventSaveFailByNameShoeDetail: LiveData<Boolean>
        get() = _eventSaveFailByNameShoeDetail

    //missing size shoe
    private val _eventSaveFailBySizeShoeDetail = MutableLiveData(false)
    val eventSaveFailBySizeShoeDetail: LiveData<Boolean>
        get() = _eventSaveFailBySizeShoeDetail

    //missing name company
    private val _eventSaveFailByNameCompanyShoeDetail = MutableLiveData(false)
    val eventSaveFailByNameCompanyShoeDetail: LiveData<Boolean>
        get() = _eventSaveFailByNameCompanyShoeDetail

    //Save
    fun saveShoeDetailStart() {
        when {
            shoe.company.trim().isEmpty() -> {
                _eventSaveFailByNameCompanyShoeDetail.value = true
            }
            shoe.name.trim().isEmpty() -> {
                _eventSaveFailByNameShoeDetail.value = true
            }
            shoe.size <= 0.9 -> {
                _eventSaveFailBySizeShoeDetail.value = true
            }
            else -> {
                _eventSaveShoeDetailPress.value = true
            }
        }
    }

    fun saveShoeDetailComplete() {
        _eventSaveShoeDetailPress.value = false
    }

    fun saveFailByNameShoeDetailComplete() {
        _eventSaveFailByNameShoeDetail.value = false
    }

    fun saveFailByNameCompanyShoeDetailComplete() {
        _eventSaveFailByNameCompanyShoeDetail.value = false
    }

    fun saveFailBySizeShoeDetailComplete() {
        _eventSaveFailBySizeShoeDetail.value = false
    }

    //Cancel
    fun cancelShoeDetailStart() {
        _eventCancelShoeDetailPress.value = true
    }

    fun cancelShoeDetailComplete() {
        _eventCancelShoeDetailPress.value = false
    }

    fun setSize(view: View, size: Int) {
        _eventSizeViewShoeDetailPress.value = view
        shoe.size = size
    }

    fun changeShoePicture() {
        shoe.modelShoe++
        if (shoe.modelShoe >= shoe.modelsAvailable.size) {
            shoe.modelShoe = 0
        }
        _eventPictureShoeDetailPress.value = shoe.modelsAvailable[shoe.modelShoe]
    }
}