package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.michihides.projektarbete.R

// General logo background
@Composable
fun BackGroundImage(){
    Image(
        painter = painterResource(id = R.drawable.general_background),
        contentDescription = "",
        alpha = 0.3f,
        modifier = Modifier
            .size(400.dp)
    )
}