package com.michihides.projektarbete.ui.composables

import androidx.annotation.ColorInt
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.michihides.projektarbete.R
import com.michihides.projektarbete.ui.theme.WhiteTransparent
import com.michihides.projektarbete.ui.theme.WhiteTransparentTwo

// A reusable button for the moves in the pokemon battles with sound onClick
@Composable
fun BattleMovesButton(
    buttonTextMove: String,
    buttonTextPower: Int,
    buttonColor: Color,
    onClick: () -> Unit
) {
    /* Need to use context when using a composable function
    ** When in fragment or activity you can use this
    */
    val context = LocalContext.current

    Button(onClick = { mainButtonSound(context) ; onClick() },
        colors = ButtonDefaults.buttonColors(buttonColor),
        modifier = Modifier
            .offset(y = (-30).dp)
            .padding(12.dp)
            .width(180.dp)
            .height(60.dp),
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(2.dp, WhiteTransparentTwo)
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = buttonTextMove,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )

            Text(
                text = "Power: $buttonTextPower",
                fontSize = 12.sp
            )
        }
    }
}