package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.michihides.projektarbete.ui.theme.MainButtonColor

// Text for the general text on the screens
@Composable
fun TitleTextNormal(
    title: String
){
    Text(
        text = title,
        color = MainButtonColor,
        fontSize = 62.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 62.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(top = 30.dp)
            .padding(horizontal = 20.dp)
        )
}