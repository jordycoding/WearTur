package com.example.weartur.domain.model.geocoder


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Geometry(
    @SerialName("coordinates")
    val coordinates: List<Double?>? = null,
    @SerialName("type")
    val type: String? = null
): Parcelable