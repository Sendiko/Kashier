package org.chevalierlab.kashier.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ButtonsExample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { },
            content = {
                Text("Click me!")
            }
        )
        Button(
            onClick = { },
            content = {
                Text("Click me!")
            },
            shape = RoundedCornerShape(8.dp)
        )
        Button(
            onClick = { },
            content = {
                Text("Click me!")
            },
            contentPadding = PaddingValues(16.dp)
        )
        Button(
            onClick = { },
            content = {
                Text("Click me!")
            },
            border = BorderStroke(width = 5.dp, color = MaterialTheme.colorScheme.tertiary)
        )
    }
}

@Preview
@Composable
fun ButtonsExamplePreview() {
    Surface {
        ButtonsExample()
    }
}