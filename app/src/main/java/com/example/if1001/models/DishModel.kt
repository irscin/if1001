package com.example.if1001.models

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DishModel(val name: String, val price: Double, val rating: Int) : Parcelable