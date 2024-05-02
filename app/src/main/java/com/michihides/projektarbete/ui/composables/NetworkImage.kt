package com.michihides.projektarbete.ui.composables

import androidx.compose.runtime.Composable
import coil.compose.AsyncImage

@Composable
fun NetworkImage(url: String) {
    AsyncImage(model = url, contentDescription = "")
}