package com.example.weartur.di

import android.content.Context
import androidx.room.Room
import com.example.weartur.data.GeocoderApi
import com.example.weartur.data.db.AppDatabase
import com.example.weartur.data.db.FavoriteFeatureDao
import com.example.weartur.data.repository.GeocoderRepositoryImpl
import com.example.weartur.domain.repository.GeocoderRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext applicationContext: Context): AppDatabase {
        return Room.databaseBuilder(applicationContext, AppDatabase::class.java, "weartur-db")
            .build()
    }

    @Provides
    @Singleton
    fun provideFavoriteFeatureDao(appDatabase: AppDatabase): FavoriteFeatureDao {
        return appDatabase.favoriteFeatureDao()
    }
}