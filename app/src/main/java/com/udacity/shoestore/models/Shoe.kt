package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String,
    var size: Int,
    var company: String,
    var description: String,
    var modelShoe: Int,
    val modelsAvailable: MutableList<String> = mutableListOf(
        "model_0",
        "model_1",
        "model_2",
        "model_3",
        "model_4",
        "model_5"
    )
) : Parcelable