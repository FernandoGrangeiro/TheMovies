package com.fgrangeiro.movies.entities.movieList

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("results")
    val results: List<Movie>
)