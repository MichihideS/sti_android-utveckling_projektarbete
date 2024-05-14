package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.michihides.projektarbete.R

@Composable
fun ElementCircleSmall() {
    var hideUi by rememberSaveable { mutableStateOf(false) }

    if (!hideUi) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            Image(
                painter = painterResource(id = R.drawable.element_cicle),
                contentDescription = "",
                alpha = 0.8f,
                modifier = Modifier
                    .size(150.dp)
                    .offset(x = 35.dp)
                    .offset(y = 130.dp)
            )
        }
    }

    BoxWithConstraints(
        contentAlignment = Alignment.BottomEnd,
    ) {
        if (maxWidth > 500.dp) {
            hideUi = true
            Column {
                Image(
                    painter = painterResource(id = R.drawable.element_cicle),
                    contentDescription = "",
                    alpha = 0.8f,
                    modifier = Modifier
                        .size(150.dp)
                        .offset(x = (-150).dp)
                )
            }
        } else {
            hideUi = false
        }
    }
}