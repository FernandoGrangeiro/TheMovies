package com.fgrangeiro.movies.entities.movieGenre

import com.google.gson.annotations.SerializedName

data class MovieGenre(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)