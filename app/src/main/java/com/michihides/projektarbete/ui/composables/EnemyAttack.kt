package com.michihides.projektarbete.ui.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.michihides.projektarbete.ui.theme.BlackTransparent
import com.michihides.projektarbete.ui.theme.DarkerWhite
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.logging.Handler

// Shows what attack the enemy used and disappears after 2000ms
@Composable
fun EnemyAttack(
    enemy: String,
    attack: String
) {
    var removeText by rememberSaveable { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(2000)
        removeText = false
    }

    AnimatedVisibility (removeText) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$enemy used $attack!",
                fontSize = 26.sp,
                textAlign = TextAlign.Center,
                color = Color.Red,
                lineHeight = 36.sp,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .border(5.dp, Color.Black)
                    .background(BlackTransparent)
                    .padding(24.dp)
            )
        }
    }
}