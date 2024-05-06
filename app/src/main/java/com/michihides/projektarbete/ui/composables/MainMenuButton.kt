package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.michihides.projektarbete.ui.theme.MainButtonColor
import com.michihides.projektarbete.ui.theme.WhiteTransparentTwo

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
    var hideUi by rememberSaveable { mutableStateOf(false) }

    if (!hideUi) {
        // Plays a sound and allows content for the button
        Button(
            onClick = { mainButtonSound(context); onClick() },
            colors = ButtonDefaults.buttonColors(MainButtonColor),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .padding(12.dp)
                .width(250.dp)
                .height(50.dp),
            border = BorderStroke(2.dp, WhiteTransparentTwo)
        ) {
            Text(
                text = buttonText,
                fontSize = 22.sp,
            )
        }
    }

    BoxWithConstraints {
        if (maxWidth > 500.dp) {
            hideUi = true
            // Plays a sound and allows content for the button
            Button(onClick = { mainButtonSound(context) ; onClick() },
                colors = ButtonDefaults.buttonColors(MainButtonColor),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .padding(12.dp)
                    .width(250.dp)
                    .height(50.dp),
                border = BorderStroke(2.dp, WhiteTransparentTwo)
            ){
                Text(
                    text = buttonText,
                    fontSize = 22.sp,
                )
            }
        } else {
            hideUi = false
        }
    }
}