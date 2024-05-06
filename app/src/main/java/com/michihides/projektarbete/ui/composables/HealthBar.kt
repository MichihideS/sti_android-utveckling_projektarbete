package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.michihides.projektarbete.ui.theme.LightGreen
import com.michihides.projektarbete.ui.theme.LightRed

// Ally health bar which changes color depending on how much hp you have left
@Composable
fun HealthBar(
    health: Int
) {
    var hideUi by rememberSaveable { mutableStateOf(false) }

    if (!hideUi) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (health > 100) {
                Text(
                    text = "HP: $health",
                    fontSize = 32.sp,
                    modifier = Modifier
                        .offset(90.dp)
                        .padding(top = 270.dp)
                        .border(5.dp, Color.Black)
                        .background(LightGreen)
                        .padding(20.dp)
                )
            } else {
                Text(
                    text = "HP: $health",
                    fontSize = 32.sp,
                    modifier = Modifier
                        .offset(90.dp)
                        .padding(top = 270.dp)
                        .border(5.dp, Color.Black)
                        .background(LightRed)
                        .padding(20.dp)
                )
            }
        }
    }

    BoxWithConstraints(
        contentAlignment = Alignment.BottomCenter
    ) {
        if (maxWidth > 500.dp) {
            hideUi = true
            Column(
                modifier = Modifier
                    .offset(x = (-250).dp)
                    .offset(y = (-40).dp)
            ) {
                if (health > 100) {
                    Text(
                        text = "HP: $health",
                        fontSize = 32.sp,
                        modifier = Modifier
                            .offset(90.dp)
                            .padding(top = 270.dp)
                            .border(5.dp, Color.Black)
                            .background(LightGreen)
                            .padding(20.dp)
                    )
                } else {
                    Text(
                        text = "HP: $health",
                        fontSize = 32.sp,
                        modifier = Modifier
                            .offset(90.dp)
                            .padding(top = 270.dp)
                            .border(5.dp, Color.Black)
                            .background(LightRed)
                            .padding(20.dp)
                    )
                }
            }
        } else {
            hideUi = false
        }
    }
}