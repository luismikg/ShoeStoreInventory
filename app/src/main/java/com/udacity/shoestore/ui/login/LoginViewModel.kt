package com.udacity.shoestore.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _eventLoginMade = MutableLiveData<Boolean>(false)
    val eventLoginMade: LiveData<Boolean>
        get() = _eventLoginMade

    fun goToWelcomeStart() {
        _eventLoginMade.value = true
    }

    fun goToWelcomeComplete() {
        _eventLoginMade.value = false
    }
}