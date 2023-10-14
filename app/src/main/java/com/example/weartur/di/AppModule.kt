package com.example.weartur.di

import com.example.weartur.data.GeocoderApi
import com.example.weartur.data.repository.GeocoderRepositoryImpl
import com.example.weartur.domain.repository.GeocoderRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideGeocoderApi(): GeocoderApi {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder().baseUrl("https://api.entur.io/geocoder/v1/")
            .addConverterFactory(Json.asConverterFactory(contentType)).build()
            .create(GeocoderApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGeocoderRepository(geocoderApi: GeocoderApi): GeocoderRepositoryImpl {
       return GeocoderRepositoryImpl(geocoderApi)
    }
}