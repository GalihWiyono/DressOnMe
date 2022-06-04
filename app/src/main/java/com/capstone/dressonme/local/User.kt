package com.capstone.dressonme.local

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class User(
  val userId: String,
  val token: String
): Parcelable