package com.fgrangeiro.movies.ui.movieGenre

import android.util.Log
import com.fgrangeiro.movies.service.movieGenre.MovieGenreService
import com.fgrangeiro.movies.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieGenreViewModel(private val service: MovieGenreService) : BaseViewModel() {


    fun getMoviesGenres() {

        val disposable = service.getMovieGenres().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response, error ->
                response?.let {

                    Log.d("FGeadsa", it.toString())
                }


                error?.let {
                    Log.d("adasdw", it.toString())


                }
            }

        disposables.add(disposable)

    }
}