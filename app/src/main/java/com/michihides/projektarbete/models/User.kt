package com.michihides.projektarbete.models

import android.os.Parcelable
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import kotlinx.parcelize.Parcelize

// User which contains a username, password and level
@Parcelize
data class User(
    var username: String,
    var password: String,
    var level: Int
) : Parcelable, DatabaseReference.CompletionListener {
    override fun onComplete(error: DatabaseError?, ref: DatabaseReference) {
        return
    }
}