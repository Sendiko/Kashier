package org.chevalierlab.kashier.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import kashier.composeapp.generated.resources.Res
import kashier.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TextsExample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(Res.string.app_name)
        )
        Text(
            text = stringResource(Res.string.app_name),
            fontSize = 20.sp
        )
        Text(
            text = stringResource(Res.string.app_name),
            fontSize = 20.sp,
            textDecoration = TextDecoration.LineThrough
        )
        Text(
            text = stringResource(Res.string.app_name),
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = stringResource(Res.string.app_name),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun TextsExamplePreview() {
    Surface {
        TextsExample()
    }
}