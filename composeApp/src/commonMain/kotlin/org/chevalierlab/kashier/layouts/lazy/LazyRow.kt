package org.chevalierlab.kashier.layouts.lazy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import org.chevalierlab.kashier.components.CardsExample
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LazyRowExample() {
    LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        item {
            CardsExample()
        }
    }
}

@Preview
@Composable
fun LazyRowExamplePreview() {
    LazyRowExample()
}