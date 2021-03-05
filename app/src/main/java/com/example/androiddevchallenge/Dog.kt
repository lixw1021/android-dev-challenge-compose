package com.example.androiddevchallenge

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Dog(
    val id: Int,
    val name: String,
    val age: Int,
    val category: GogCategory,
    val address: String,
    val introduce: String,
    @DrawableRes val image: Int
) : Parcelable

enum class GogCategory(val breed: String) {
    Terrier("Terrier"),
    Basset_Hound("Basset Hound"),
    Basset_Retriever("Basset Retriever"),
    Beagle("Beagle"),
    Cavapoo("Cavapoo"),
    Finnish_Spitz("Finnish_Spitz")
}
