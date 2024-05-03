package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// A reusable Button for the choose pokemon screen
@Composable
fun ChoosePokemonButton(
    buttonText: String,
    onClick: () -> Unit
) {
    Button(onClick = onClick,
        modifier = Modifier
            .offset(y = (-30).dp)
            .padding(bottom = 6.dp)
            .width(140.dp)
            .height(40.dp),
        shape = RoundedCornerShape(5.dp)
    ){
        Text(
            text = buttonText,
            fontSize = 16.sp
        )
    }
}