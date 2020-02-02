package com.fgrangeiro.movies.service.movieGenre

import com.fgrangeiro.movies.entities.movieGenre.MovieGenreListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface MovieGenreApi {

    @GET("genre/movie/list?api_key=2976f1fea52bc5d5a136db9f81a36714&language=pt-br")
    fun getMeetingExchanges(): Single<MovieGenreListResponse>
}