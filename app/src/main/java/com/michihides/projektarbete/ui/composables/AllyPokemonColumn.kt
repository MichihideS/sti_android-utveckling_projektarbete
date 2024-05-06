package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Column for where the ally pokemon is placed
@Composable
fun AllyPokemonColumn(
    content: @Composable ColumnScope.() -> Unit
) {
    var hideUi by rememberSaveable { mutableStateOf(false) }

    if (!hideUi) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(bottom = 10.dp)
                .offset(x = (-70).dp)
        ) {
            content()
        }
    }

    BoxWithConstraints(
        contentAlignment = Alignment.BottomStart
    ) {
        if (maxWidth > 500.dp) {
            hideUi = true
            Column(
                modifier = Modifier
                    .offset(y = 50.dp)
                    .offset(x = (-30).dp)
            ) {
                content()
            }
        } else {
            hideUi = false
        }
    }
}