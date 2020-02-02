package com.fgrangeiro.movies.ui.movieGenre

import androidx.lifecycle.MutableLiveData
import com.fgrangeiro.movies.entities.movieGenre.MovieGenre
import com.fgrangeiro.movies.service.movieGenre.MovieGenreService
import com.fgrangeiro.movies.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieGenreViewModel(private val service: MovieGenreService) : BaseViewModel() {

    val movieGenreListLiveData = MutableLiveData<List<MovieGenre>>()
    val errorLiveData = MutableLiveData<Unit>()

    fun getMoviesGenres() {

        val disposable = service.getMovieGenres().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response, error ->
                response?.let {
                    movieGenreListLiveData.postValue(it.genres)
                }
                error?.let {
                    errorLiveData.postValue(Unit)
                }
            }

        disposables.add(disposable)
    }


}