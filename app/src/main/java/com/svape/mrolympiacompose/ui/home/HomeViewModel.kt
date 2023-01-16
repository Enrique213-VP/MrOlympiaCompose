package com.svape.mrolympiacompose.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svape.mrolympiacompose.data.api.model.ClassicPhysique
import com.svape.mrolympiacompose.data.repository.OlympiaRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val olympiaRepo: OlympiaRepo
) : ViewModel() {

    private val _state = MutableStateFlow(emptyList<ClassicPhysique>())
    val state: StateFlow<List<ClassicPhysique>>
        get() = _state

    init {
        viewModelScope.launch {
            val olympia = olympiaRepo.getOlympias()
            _state.value = olympia
        }
    }

}