package com.sithuhein.mvp_example.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie")
data class Movie(

    @PrimaryKey
    @SerializedName("id")
    val id : Int,
    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title : String,
    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    val overview : String,
    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    val releaseDate : String,
    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    val poster : String?
)