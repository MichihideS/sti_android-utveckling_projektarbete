package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import com.michihides.projektarbete.ui.theme.WhiteTransparentTwo

// A reusable Button for the choose pokemon screen
@Composable
fun ChoosePokemonButton(
    buttonText: String,
    onClick: () -> Unit
) {
    /* Need to use context when using a composable function
    ** When in fragment or activity you can use this
    */
    val context = LocalContext.current

    Button(onClick = { mainButtonSound(context) ; onClick() },
        colors = ButtonDefaults.buttonColors(MainButtonColor),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .offset(y = (-30).dp)
            .padding(bottom = 6.dp)
            .width(140.dp)
            .height(40.dp),
        border = BorderStroke(2.dp, WhiteTransparentTwo)
    ){
        Text(
            text = buttonText,
            fontSize = 16.sp
        )
    }
}