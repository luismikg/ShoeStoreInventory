package com.udacity.shoestore

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShareViewModel : ViewModel() {

    var shoe = Shoe(
        "",
        0,
        "",
        "",
        0
    )

    // Login ----------
    private val _eventLoginMade = MutableLiveData(false)
    val eventLoginMade: LiveData<Boolean>
        get() = _eventLoginMade
    // ----------------

    // Welcome --------
    private val _eventNextWelcomePress = MutableLiveData(false)
    val eventNextWelcomePress: LiveData<Boolean>
        get() = _eventNextWelcomePress
    // ---------------

    // Instruction -------------
    private val _eventNextInstructionPress = MutableLiveData(false)
    val eventNextInstructionPress: LiveData<Boolean>
        get() = _eventNextInstructionPress
    // -------------------------

    // Instructions Detail ------
    private val _eventNextInstructionDetailPress = MutableLiveData(false)
    val eventNextInstructionDetailPress: LiveData<Boolean>
        get() = _eventNextInstructionDetailPress
    // --------------------------

    // Login ------------
    fun goToWelcomeStart() {
        _eventLoginMade.value = true
    }

    fun goToWelcomeComplete() {
        _eventLoginMade.value = false
    }
    // ------------------

    // Instructions ----
    fun goToInstructionDetailStart() {
        _eventNextInstructionPress.value = true
    }

    fun goToInstructionDetailComplete() {
        _eventNextInstructionPress.value = false
    }
    // -----------------

    // Instructions Details --------
    fun goToShoeListStart() {
        _eventNextInstructionDetailPress.value = true
    }

    fun goToShoeListComplete() {
        _eventNextInstructionDetailPress.value = false
    }
    // -----------------------------

    // Welcome ----------
    fun goToInstructionStart() {
        _eventNextWelcomePress.value = true
    }

    fun goToInstructionComplete() {
        _eventNextWelcomePress.value = false
    }
    // ------------------

    //Shoes List -----------
    private var _shoesList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoesList: LiveData<MutableList<Shoe>>
        get() = _shoesList

    private val _eventAddShoeListPress = MutableLiveData(false)
    val eventAddShoeListPress: LiveData<Boolean>
        get() = _eventAddShoeListPress
    // ---------

    //Shoe detail ----------
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

    //Shoes List -------
    fun goToShoeDetailStart() {
        _eventAddShoeListPress.value = true
    }

    fun goToShoeDetailStartComplete() {
        _eventAddShoeListPress.value = false
    }
    // ---------

    //Shoe detail
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
                saveNewShoe()
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

    private fun saveNewShoe() {
        val list = _shoesList.value
        list?.let {
            it.add(shoe)
            _shoesList.setValue(list)
        }
    }

    fun clearShoeTemplate() {
        shoe = Shoe(
            "",
            0,
            "",
            "",
            0
        )
        _eventPictureShoeDetailPress.value = shoe.modelsAvailable[shoe.modelShoe]
    }
}