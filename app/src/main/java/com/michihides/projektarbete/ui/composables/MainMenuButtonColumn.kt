package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.michihides.projektarbete.ui.theme.DarkHomeScreen
import com.michihides.projektarbete.ui.theme.GeneralBackground

// A reusable Column for the MainMenuButton that places them in the bottom of the screen
@Composable
fun MainMenuButtonColumn(
    content: @Composable ColumnScope.() -> Unit
) {
    Column(modifier = Modifier.background(GeneralBackground)) {}
    BackGroundImage()

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(bottom = 120.dp)
    ) {
        content()
    }
}