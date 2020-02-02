package com.fgrangeiro.movies.ui.movieGenre

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.fgrangeiro.movies.R
import com.fgrangeiro.movies.ui.MainActivity
import com.fgrangeiro.movies.ui.base.BaseActivity
import com.fgrangeiro.movies.ui.extensions.hide
import com.fgrangeiro.movies.ui.extensions.show
import com.fgrangeiro.movies.ui.movieGenre.adapter.MovieGenreAdapter
import com.fgrangeiro.movies.ui.movieGenre.adapter.MovieGenreAdapterInterface
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_movies_genre.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesGenreActivity : BaseActivity(), MovieGenreAdapterInterface {
    override val viewModel: MovieGenreViewModel by viewModel()

    private val movieGenreAdapter = MovieGenreAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_genre)
        setupToolbar("Gêneros")
        showLoading()
        setViewModelListeners()
        getMoviesGenres()
        setupAdapter()
        disableNavigationIcon()
    }

    private fun setupAdapter() {
        recyclerViewAdapter?.run {
            layoutManager = LinearLayoutManager(this@MoviesGenreActivity)
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

    override fun onClick(id: Int) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
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
