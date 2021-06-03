package com.sithuhein.mvp_example.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sithuhein.mvp_example.model.Movie


@Database(entities = [Movie::class] , version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appDao() : AppDao
}