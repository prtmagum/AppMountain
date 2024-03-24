package com.dicoding.appmountain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mountain(
    val name: String,
    val description: String,
    val photo: Int
):Parcelable