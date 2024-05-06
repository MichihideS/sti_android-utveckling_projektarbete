package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.michihides.projektarbete.R
import com.michihides.projektarbete.ui.theme.BlackTransparent

// Background for the battles aka LevelOneScreen, LevelTwoScreen, LevelThreeScreen
@Composable
fun BackGroundBattle(){
    Column(modifier = Modifier.background(BlackTransparent)) {}
}