package com.example.weartur.presentation.ui.stopDetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weartur.data.db.FavoriteFeatureDao
import com.example.weartur.data.repository.GeocoderRepositoryImpl
import com.example.weartur.domain.db.entities.FavoriteFeature
import com.example.weartur.domain.model.geocoder.Feature
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class StopDetailsViewModel @Inject constructor(
    private val geocoderRepository: GeocoderRepositoryImpl,
    private val favoriteFeatureDao: FavoriteFeatureDao
) :
    ViewModel() {
    var stop by mutableStateOf<Feature?>(null)
        private set

    fun findStop(id: String) {
        stop = geocoderRepository.findById(id)
    }

    fun addToFavorites() {
        viewModelScope.launch(Dispatchers.IO) {
            val feature = stop?.properties?.category?.get(0)?.let {
                stop?.properties?.name?.let { it1 ->
                    stop?.properties?.id?.let { it2 ->
                        FavoriteFeature(
                            0, it1, it2,
                            it
                        )
                    }
                }
            }
            feature?.let { favoriteFeatureDao.insertAl(it) }
        }
    }
}