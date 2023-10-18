package com.example.weartur.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.weartur.domain.db.entities.FavoriteFeature

@Dao
interface FavoriteFeatureDao {
    @Query("SELECT * FROM FavoriteFeature")
    fun getAll(): List<FavoriteFeature>

    @Insert
    fun insertAl(vararg features: FavoriteFeature)

    @Delete
    fun delete(feature: FavoriteFeature)
}