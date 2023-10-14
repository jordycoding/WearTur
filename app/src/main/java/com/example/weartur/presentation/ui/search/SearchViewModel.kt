package com.example.weartur.presentation.ui.search

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weartur.data.RetrofitFactory
import com.example.weartur.data.repository.GeocoderRepositoryImpl
import com.example.weartur.domain.model.geocoder.Feature
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val geocoderRepository: GeocoderRepositoryImpl): ViewModel() {
    var isLoading by mutableStateOf(false)
    var data = mutableStateListOf<Feature>()
        private set

    fun search(query: String) {
        viewModelScope.launch {
            isLoading = true
            val response = geocoderRepository.search(query)
            response?.let { data.addAll(it.features?.filterNotNull() ?: emptyList()) }
            isLoading = false
        }
    }
}