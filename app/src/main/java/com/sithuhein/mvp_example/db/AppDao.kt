package com.sithuhein.mvp_example.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sithuhein.mvp_example.model.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie : Movie)

    @Query("Select * from movie")
    fun getMovies() : Flow<List<Movie>>
}