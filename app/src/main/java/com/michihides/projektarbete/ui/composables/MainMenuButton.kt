package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.michihides.projektarbete.ui.theme.MainButtonColor

// A reusable Button for the main menu navigation
@Composable
fun MainMenuButton(
    buttonText: String,
    onClick: () -> Unit,
) {
    /* Need to use context when using a composable function
    ** When in fragment or activity you can use this
    */
    val context = LocalContext.current

    // Plays a sound and allows content for the button
    Button(onClick = { MainButtonSound(context) ; onClick() },
        colors = ButtonDefaults.buttonColors(MainButtonColor),
        modifier = Modifier
            .padding(12.dp)
            .width(250.dp)
            .height(50.dp),
        shape = RoundedCornerShape(5.dp)
            ){
        Text(
            text = buttonText,
            fontSize = 22.sp
        )
    }
}