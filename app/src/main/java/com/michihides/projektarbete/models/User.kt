package com.michihides.projektarbete.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// User Object which contains a username, password and level
@Parcelize
data class User(
    val username: String,
    val password: String,
    val level: Int
) : Parcelable