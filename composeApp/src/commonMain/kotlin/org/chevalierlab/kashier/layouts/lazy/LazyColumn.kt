package org.chevalierlab.kashier.layouts.lazy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import org.chevalierlab.kashier.components.HorizontalCardExample
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LazyColumnExample() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(100) { item ->
            HorizontalCardExample()
        }
    }
}

@Preview
@Composable
fun LazyColumnExamplePreview() {
    LazyColumnExample()
}