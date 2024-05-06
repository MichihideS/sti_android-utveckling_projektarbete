package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.michihides.projektarbete.ui.theme.BlackTransparent

// Background for the battles aka LevelOneScreen, LevelTwoScreen, LevelThreeScreen
@Composable
fun BackGroundBattle(){
    Column(modifier = Modifier.background(BlackTransparent)) {}
}