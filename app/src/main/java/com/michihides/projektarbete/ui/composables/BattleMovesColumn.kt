package com.michihides.projektarbete.ui.composables

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

// Column for the BattleMovesButton
@Composable
fun BattleMovesColumn(
    content: @Composable ColumnScope.() -> Unit
) {
    var hideUi by rememberSaveable { mutableStateOf(false) }

    if (!hideUi) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(bottom = 30.dp)
        ) {
            content()
        }
    }

    BoxWithConstraints(
        contentAlignment = Alignment.CenterEnd,
        modifier = Modifier
            .padding(20.dp)
    ) {
        if (maxWidth > 500.dp) {
            hideUi = true
            Column {
                content()
            }
        } else {
            hideUi = false
        }
    }
}