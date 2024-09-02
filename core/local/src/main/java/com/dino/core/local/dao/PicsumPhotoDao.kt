package com.dino.core.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dino.core.local.model.PicsumPhotoLocal

@Dao
interface PicsumPhotoDao {

    @Query("SELECT * FROM PicsumPhotoLocal WHERE id = :id")
    suspend fun getPicsumPhoto(id: String): PicsumPhotoLocal?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(picsumPhotos: List<PicsumPhotoLocal>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(picsumPhoto: PicsumPhotoLocal)
}
