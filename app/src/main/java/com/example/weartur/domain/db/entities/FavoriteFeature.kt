package com.example.weartur.domain.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteFeature(
    @PrimaryKey(autoGenerate = true) val favoriteId: Long,
    val displayName: String,
    val featureId: String,
    val category: String
)
