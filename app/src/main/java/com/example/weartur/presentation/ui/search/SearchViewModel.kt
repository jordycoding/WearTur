package com.example.weartur.presentation.ui.search

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weartur.data.RetrofitFactory
import com.example.weartur.domain.model.geocoder.Feature
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    var isLoading by mutableStateOf(false)
    var data = mutableStateListOf<Feature>()
        private set

    fun search(query: String) {
        val geocoder = RetrofitFactory.getGeocoderService()
        viewModelScope.launch {
            isLoading = true
            val response = geocoder.search(query)
            Log.d("RESULT", response.body().toString())
            response.body()?.let { data.addAll(it.features?.filterNotNull() ?: emptyList()) }
            isLoading = false
        }
    }
}