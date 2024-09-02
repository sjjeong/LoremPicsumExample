package com.dino.core.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dino.core.local.dao.PicsumPhotoDao
import com.dino.core.local.model.PicsumPhotoLocal

@Database(
    entities = [
        PicsumPhotoLocal::class,
    ],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun picsumPhotoDao(): PicsumPhotoDao
}
