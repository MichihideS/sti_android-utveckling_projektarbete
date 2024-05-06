package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Text for the general text on the screens
@Composable
fun TitleTextNormal(
    title: String
){
    Text(
        text = title,
        fontSize = 48.sp,
        lineHeight = 50.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(40.dp)
        )
}