package com.example.weartur.domain.model.geocoder


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Properties(
    @SerialName("accuracy")
    val accuracy: String? = null,
    @SerialName("borough")
    val borough: String? = null,
    @SerialName("borough_gid")
    val boroughGid: String? = null,
    @SerialName("category")
    val category: List<String?>? = null,
    @SerialName("country_a")
    val countryA: String? = null,
    @SerialName("county")
    val county: String? = null,
    @SerialName("county_gid")
    val countyGid: String? = null,
    @SerialName("gid")
    val gid: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("label")
    val label: String? = null,
    @SerialName("layer")
    val layer: String? = null,
    @SerialName("locality")
    val locality: String? = null,
    @SerialName("locality_gid")
    val localityGid: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("popular_name")
    val popularName: String? = null,
    @SerialName("source")
    val source: String? = null,
    @SerialName("source_id")
    val sourceId: String? = null,
    @SerialName("street")
    val street: String? = null,
    @SerialName("tariff_zones")
    val tariffZones: List<String?>? = null
): Parcelable