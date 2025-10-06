package org.chevalierlab.kashier.core

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.chevalierlab.kashier.home.presentation.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        HomeScreen()
    }
}