package com.example.if1001.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RestaurantModel(val name: String,
                           val address: String,
                           val rating: ArrayList<RatingModel>,
                           val menu: ArrayList<DishModel>,
                           val about: String,
                           val coords: HashMap<String, Double>,
                           var uuid: String = "") : Parcelable