package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.michihides.projektarbete.ui.theme.MainButtonColor
import com.michihides.projektarbete.ui.theme.WhiteTransparentTwo

@Composable
fun MainTextNormal(
    text: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            fontSize = 26.sp,
            textAlign = TextAlign.Center,
            color = MainButtonColor,
            lineHeight = 36.sp,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(bottom = 350.dp)
                .border(5.dp, MainButtonColor)
                .background(WhiteTransparentTwo)
                .padding(20.dp)
        )
    }
}