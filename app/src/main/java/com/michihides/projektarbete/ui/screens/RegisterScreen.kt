package com.michihides.projektarbete.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun RegisterScreen(
    navigator: DestinationsNavigator
) {
    val db = FirebaseDatabase
        .getInstance("https://projektarbete-au-default-rtdb.europe-west1.firebasedatabase.app/")
        .getReference("users")
    
    // Toasts, should use context for Composable function
    val context = LocalContext.current
    val toastUserCreated = Toast.makeText(context, "User Created", Toast.LENGTH_SHORT)
    val toastUserExists = Toast.makeText(context, "User Already Exists", Toast.LENGTH_SHORT)

    Column {
        // Listener
        Button(onClick = {
            db.setValue(
                "NEW VALUE",
            )
                .addOnSuccessListener { toastUserCreated.show() }
                .addOnFailureListener { toastUserExists.show() }
        }) {
            Text(text = "DATABASETEST")
        }
    }
}