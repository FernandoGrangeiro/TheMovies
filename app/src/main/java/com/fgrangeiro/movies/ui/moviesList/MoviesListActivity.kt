package com.fgrangeiro.movies.ui.moviesList

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.fgrangeiro.movies.R
import com.fgrangeiro.movies.ui.base.BaseActivity
import com.fgrangeiro.movies.ui.extensions.hide
import com.fgrangeiro.movies.ui.extensions.show
import com.fgrangeiro.movies.ui.moviesList.adapter.MovieListAdapter
import com.fgrangeiro.movies.ui.moviesList.adapter.MovieListInterface
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_movies_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesListActivity : BaseActivity(), MovieListInterface {
    override val viewModel: MoviesListViewModel by viewModel()

    private val movieGenreAdapter = MovieListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_list)
        setupAdapter()
        setViewModelListeners()
        getMovieList()

    }

    private fun getMovieList() {
        viewModel.getMovieList()
    }

    private fun setupAdapter() {
        recyclerViewMovie?.run {
            layoutManager =
                GridLayoutManager(
                    this@MoviesListActivity, 3,
                    GridLayoutManager.VERTICAL, false
                )
            adapter = movieGenreAdapter
        }
    }

    private fun setViewModelListeners() {
        viewModel.movieListLiveData.observe(this, Observer { movieList ->
            movieList?.let {
                movieGenreAdapter.setMovieList(it)
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
            "Não foi possível pegar a lista de Filmes",
            Snackbar.LENGTH_SHORT
        ).show()
    }

    override fun onClick(id: Int) {
        val intent = Intent(this, MoviesListActivity::class.java)
        startActivity(intent)
    }
}
