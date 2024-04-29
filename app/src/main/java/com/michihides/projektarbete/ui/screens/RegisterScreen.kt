package com.michihides.projektarbete.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.michihides.projektarbete.models.User
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

    val user = User("Michan2", "123", 1)
    val userDatabase = db.child("").child(user.username)

    Column {
        // Listener
        Button(onClick = {
           userDatabase.addListenerForSingleValueEvent(object : ValueEventListener {
               override fun onDataChange(snapshot: DataSnapshot) {
                   if (snapshot.exists()) {
                       toastUserExists.show()
                   } else {
                       userDatabase.setValue(user)
                       toastUserCreated.show()
                   }
               }

               override fun onCancelled(error: DatabaseError) {
                   TODO("Not yet implemented")
               }
           })
        }) {
            Text(text = "DATABASETEST")
        }
    }
}