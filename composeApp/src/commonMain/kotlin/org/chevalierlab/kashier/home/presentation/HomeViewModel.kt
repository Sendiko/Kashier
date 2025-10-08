package org.chevalierlab.kashier.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import org.chevalierlab.kashier.home.data.DummyDataSource
import org.chevalierlab.kashier.home.domain.Item

class HomeViewModel: ViewModel() {

    private val _items = DummyDataSource().getDatas()
    private val _state = MutableStateFlow(HomeState(items = _items))
    val state = _state

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnRemoveItem -> removeItem(event.item)
            is HomeEvent.OnAddItem -> addItem(event.item)
            is HomeEvent.OnAllItemVisibilityChange -> setAllItemVisibility(event.isVisible)
            is HomeEvent.OnSelectedItemVisibilityChange -> setSelectedItemVisibility(event.isVisible)
            is HomeEvent.OnSearchQueryChange -> updateQuery(event.query)
            HomeEvent.OnSearchQuerySubmit -> search()
            HomeEvent.OnSaveTransaction -> saveTransaction()
        }
    }

    private fun removeItem(item: Item) {
        _state.update {
            it.copy(
                selectedItems = it.selectedItems - item,
                totalPrice = it.totalPrice - item.price
            )
        }
    }

    private fun saveTransaction() {
        TODO("Save Data to API.")
    }

    private fun addItem(item: Item) {
        _state.update {
            it.copy(
                selectedItems = it.selectedItems + item,
                totalPrice = it.totalPrice + item.price
            )
        }
    }

    private fun setAllItemVisibility(visible: Boolean) {
        _state.update { it.copy(allItemsVisible = visible) }
    }

    private fun setSelectedItemVisibility(visible: Boolean) {
        _state.update { it.copy(selectedItemVisible = visible) }
    }

    private fun search() {
        if (state.value.searchQuery.isNotBlank()) {
            _state.update { it.copy(
                items = _state.value.items.filter { item ->
                    item.name.contains(_state.value.searchQuery, ignoreCase = true)
                }
            ) }
        } else {
            _state.update { it.copy(items = _items) }
        }
    }

    private fun updateQuery(query: String) {
        _state.update { it.copy(searchQuery = query) }
        if (state.value.searchQuery.isBlank()) {
            _state.update { it.copy(items = _items) }
        }
    }

}