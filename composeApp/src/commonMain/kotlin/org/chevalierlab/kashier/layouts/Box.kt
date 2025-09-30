package org.chevalierlab.kashier.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BoxExample() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.size(256.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.primary)
                .align(Alignment.TopCenter)
        )
        Box(
            modifier = Modifier.size(156.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.secondary)
                .align(Alignment.TopEnd)
        )
        Box(
            modifier = Modifier.size(56.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.tertiary)
                .align(Alignment.Center)
        )
        Box(
            modifier = Modifier.size(128.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.inversePrimary)
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview
@Composable
fun BoxExamplePreview() {
    Surface {
        BoxExample()
    }
}
