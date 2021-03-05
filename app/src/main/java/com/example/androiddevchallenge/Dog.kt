/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
