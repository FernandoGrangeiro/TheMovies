package com.fgrangeiro.movies.entities.movieList

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    val id: Int,
    @SerializedName("poster_path")
    val image: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("release_date")
    val releaseDate: String
)