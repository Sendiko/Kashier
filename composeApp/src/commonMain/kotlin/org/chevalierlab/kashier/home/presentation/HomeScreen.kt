package org.chevalierlab.kashier.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kashier.composeapp.generated.resources.Res
import kashier.composeapp.generated.resources.all_item_label
import kashier.composeapp.generated.resources.app_name
import kashier.composeapp.generated.resources.selected_item_label
import org.chevalierlab.kashier.home.data.DummyDataSource
import org.chevalierlab.kashier.home.presentation.components.HomeSeparator
import org.chevalierlab.kashier.home.presentation.components.ItemCard
import org.chevalierlab.kashier.home.presentation.components.SaveButton
import org.chevalierlab.kashier.home.presentation.components.SelectedItemChip
import org.chevalierlab.kashier.home.presentation.components.TotalPriceHeader
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(Res.string.app_name))
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
        ) {
            item {
                TotalPriceHeader(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    totalPrice = 1000000.00
                )
            }
            item {
                SaveButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onSave = { TODO("Save data.") }
                )
            }
            item {
                HomeSeparator(
                    modifier = Modifier.padding(start = 16.dp, end = 4.dp),
                    title = stringResource(Res.string.selected_item_label),
                    visible = false,
                    onAction = { visible -> }
                )
            }
            item {
                FlowRow(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    content = {
                        DummyDataSource().getDatas().take(5).map { item ->
                            SelectedItemChip(
                                onRemove = { },
                                item = item
                            )
                        }
                    }
                )
            }
            item {
                HomeSeparator(
                    modifier = Modifier.padding(start = 16.dp, end = 4.dp),
                    title = stringResource(Res.string.all_item_label),
                    visible = false,
                    onAction = { visible -> }
                )
            }
            items(DummyDataSource().getDatas()) { item ->
                ItemCard(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                    item = item,
                    onEdit = {  },
                    onAdd = {  }
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}