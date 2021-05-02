package com.example.if1001.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class RatingModel(val rating: Int, val comment: String) : Parcelable