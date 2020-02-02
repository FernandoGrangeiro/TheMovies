package com.fgrangeiro.movies.ui.movieGenre

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.fgrangeiro.movies.R
import com.fgrangeiro.movies.ui.base.BaseActivity
import com.fgrangeiro.movies.ui.extensions.hide
import com.fgrangeiro.movies.ui.extensions.show
import com.fgrangeiro.movies.ui.movieGenre.adapter.MovieGenreAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_movies_genre.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieGenreActivity : BaseActivity() {
    override val viewModel: MovieGenreViewModel by viewModel()

    private val movieGenreAdapter = MovieGenreAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_genre)
        setupToolbar("Gêneros")
        showLoading()
        setViewModelListeners()
        getMoviesGenres()
        setupAdapter()
    }

    private fun setupAdapter() {
        recyclerViewAdapter?.run {
            layoutManager = LinearLayoutManager(this@MovieGenreActivity)
            adapter = movieGenreAdapter
        }
    }

    private fun getMoviesGenres() {
        viewModel.getMoviesGenres()
    }

    private fun setViewModelListeners() {
        viewModel.movieGenreListLiveData.observe(this, Observer { genreList ->
            genreList?.let {
                movieGenreAdapter.setGenreList(it)
                hideLoading()
            }
        })
        viewModel.errorLiveData.observe(this, Observer {
            showErrorMessage()
            hideLoading()
        })
    }

    private fun hideLoading() {
        loading.hide()
    }

    private fun showLoading() {
        loading.show()
    }

    private fun showErrorMessage() {
        Snackbar.make(
            loading,
            "Não foi possível pegar a lista de Gêneros",
            Snackbar.LENGTH_SHORT
        ).show()
    }
}
