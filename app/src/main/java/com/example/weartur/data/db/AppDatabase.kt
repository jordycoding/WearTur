package com.example.weartur.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weartur.domain.db.entities.FavoriteFeature

@Database(entities = [FavoriteFeature::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteFeatureDao(): FavoriteFeatureDao
}