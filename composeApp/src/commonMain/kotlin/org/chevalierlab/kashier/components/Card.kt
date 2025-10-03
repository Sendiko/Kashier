package org.chevalierlab.kashier.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kashier.composeapp.generated.resources.Res
import kashier.composeapp.generated.resources.app_name
import kashier.composeapp.generated.resources.body_card_text
import kashier.composeapp.generated.resources.compose_multiplatform
import kashier.composeapp.generated.resources.title_card_text
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CardsExample() {
    Card {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(64.dp),
                painter = painterResource(Res.drawable.compose_multiplatform),
                contentDescription = stringResource(Res.string.app_name)
            )
            Text(
                text = stringResource(Res.string.title_card_text),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = stringResource(Res.string.body_card_text),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun HorizontalCardExample() {
    Card {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(64.dp),
                painter = painterResource(Res.drawable.compose_multiplatform),
                contentDescription = stringResource(Res.string.app_name)
            )
            Column {
                Text(
                    text = stringResource(Res.string.title_card_text),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = stringResource(Res.string.body_card_text),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview
@Composable
fun CardsExamplePreview() {
    Column {
        CardsExample()
        HorizontalCardExample()
    }
}