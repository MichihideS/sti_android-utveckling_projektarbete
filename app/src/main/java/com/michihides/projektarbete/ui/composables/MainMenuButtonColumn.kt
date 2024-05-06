package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.michihides.projektarbete.ui.theme.GeneralBackground

// A reusable Column for the MainMenuButton that places them in the bottom of the screen
@Composable
fun MainMenuButtonColumn(
    content: @Composable ColumnScope.() -> Unit
) {
    var hideUi by rememberSaveable { mutableStateOf(false) }
    Column(modifier = Modifier.background(GeneralBackground)) {}
    BackGroundImage()

    if (!hideUi) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(bottom = 100.dp)
        ) {
            content()
        }
    }

    BoxWithConstraints(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(top = 120.dp)
    ){
        if (maxWidth > 500.dp) {
            hideUi = true
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(bottom = 20.dp)
            ) {
                content()
            }
        } else {
            hideUi = false
        }
    }
}