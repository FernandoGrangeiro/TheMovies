package com.fgrangeiro.movies.entities.movieGenre

import com.google.gson.annotations.SerializedName

data class MovieGenreListResponse(
    @SerializedName("genres")
    val genres: List<MovieGenre>
)