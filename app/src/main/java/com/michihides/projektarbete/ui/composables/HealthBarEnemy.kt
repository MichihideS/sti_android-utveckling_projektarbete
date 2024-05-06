package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.michihides.projektarbete.ui.theme.LightGreen
import com.michihides.projektarbete.ui.theme.LightRed
import com.michihides.projektarbete.ui.theme.Wind

// Enemy health bar which changes color depending on how much hp you have left
@Composable
fun HealthBarEnemy(
    healthEnemy: Int
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (healthEnemy > 100) {
            Text(
                text = "HP: $healthEnemy",
                fontSize = 32.sp,
                modifier = Modifier
                    .offset((-90).dp)
                    .padding(top = 50.dp)
                    .border(5.dp, Color.Black)
                    .background(LightGreen)
                    .padding(20.dp)
            )
        } else {
            Text(
                text = "HP: $healthEnemy",
                fontSize = 32.sp,
                modifier = Modifier
                    .offset((-90).dp)
                    .padding(top = 50.dp)
                    .border(5.dp, Color.Black)
                    .background(LightRed)
                    .padding(20.dp)
            )
        }
    }
}