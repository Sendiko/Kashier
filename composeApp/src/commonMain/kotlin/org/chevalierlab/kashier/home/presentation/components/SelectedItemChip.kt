package org.chevalierlab.kashier.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SelectedItemChip(
    modifier: Modifier = Modifier,
    onRemove: () -> Unit,
    text: String
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Row(
            modifier = Modifier.padding(start = 16.dp, end = 4.dp, top = 2.dp, bottom = 2.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            Text(text = text, style = MaterialTheme.typography.bodyLarge)
            IconButton(
                onClick = { onRemove() },
                content = {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = text
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun SelectedItemChipPreview() {
    Surface {
        SelectedItemChip(
            onRemove = { },
            text = "Jeruk Mandarin 1 KG",
            modifier = Modifier.padding(16.dp)
        )
    }
}