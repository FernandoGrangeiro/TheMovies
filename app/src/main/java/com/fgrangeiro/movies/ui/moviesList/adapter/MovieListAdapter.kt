package com.fgrangeiro.movies.ui.moviesList.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fgrangeiro.movies.R
import com.fgrangeiro.movies.entities.movieList.Movie
import com.fgrangeiro.movies.ui.base.GlideApp
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieListAdapter(private val movieListInterface: MovieListInterface) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val movieList: MutableList<Movie> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_movie,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movie = movieList[position]
        holder.itemView.run {
            movieName.text = movie.title
            movieName.setOnClickListener {
                movieListInterface.onClick(movie.id)
            }

            GlideApp.with(context)
                .load(
                    "https://image.tmdb.org/t/p/original/" + movie.image.removeRange(
                        IntRange(
                            0,
                            0
                        )
                    )
                )
                .into(movieImage)

        }

    }

    fun setMovieList(movieList: List<Movie>) {
        this.movieList.addAll(movieList)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}