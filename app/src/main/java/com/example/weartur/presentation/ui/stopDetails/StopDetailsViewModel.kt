package com.example.weartur.presentation.ui.stopDetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.weartur.data.repository.GeocoderRepositoryImpl
import com.example.weartur.domain.model.geocoder.Feature
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class StopDetailsViewModel @Inject constructor(private val geocoderRepository: GeocoderRepositoryImpl) :
    ViewModel() {
    var stop by mutableStateOf<Feature?>(null)
        private set

    fun findStop(id: String) {
        stop = geocoderRepository.findById(id)
    }
}