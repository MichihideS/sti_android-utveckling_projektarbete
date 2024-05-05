package com.michihides.projektarbete.ui.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.michihides.projektarbete.R
import com.michihides.projektarbete.ui.theme.DarkHomeScreen
import kotlinx.coroutines.delay

@Composable
fun HomeScreenColumn(
    onClick: () -> Unit,
) {
    /* Need to use context when using a composable function
    ** When in fragment or activity you can use this
    */
    val context = LocalContext.current

    // Need to use remember since LaunchedEffect is async
    var hiddenMenu by rememberSaveable { mutableStateOf(false) }
    var hiddenMenuTwo by rememberSaveable { mutableStateOf(false) }
    var hiddenText by rememberSaveable { mutableStateOf(false) }

    // Delays the pokemon image by 1800ms
    LaunchedEffect(Unit) {
        delay(1800)
        hiddenMenu = true
    }

    // Delays the ultimate image by 3200ms
    LaunchedEffect(Unit) {
        delay(3400)
        hiddenMenuTwo = true
    }

    // Delays the textview by 4200ms
    LaunchedEffect(Unit) {
        delay(4200)
        hiddenText = true
    }

    // Flash animation that pulsates between original size and 90%
    val flash by rememberInfiniteTransition(label = "").animateFloat(
        initialValue = 0.9f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(DarkHomeScreen)
            .clickable(onClick = { MainButtonSound(context); onClick() })
    ) {

        if (hiddenMenu) {
            Image(
                painter = painterResource(id = R.drawable.pokemon),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .padding(bottom = 400.dp)

            )
        }
    }

    AnimatedVisibility (hiddenMenuTwo) {
        Image(
            painter = painterResource(id = R.drawable.ultimate),
            contentDescription = "",
            modifier = Modifier
                .padding(horizontal = 90.dp)
                .padding(bottom = 150.dp)
        )
    }
    
    AnimatedVisibility (hiddenMenuTwo) {
        Image(
            painter = painterResource(id = R.drawable.pokemon_ball),
            contentDescription = "",
            modifier = Modifier
                .padding(horizontal = 180.dp)
                .padding(bottom = 250.dp)
        )
    }

    // Acts as a shadow
    AnimatedVisibility (hiddenText) {
        Text(
            text = "Click Anywhere to Start",
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 550.dp)
                .offset(
                    x = 2.dp,
                    y = 2.dp
                )
                .scale(flash)
        )
    }

    AnimatedVisibility (hiddenText) {
        Text(
            text = "Click Anywhere to Start",
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .padding(top = 550.dp)
                .scale(flash)
        )
    }
}