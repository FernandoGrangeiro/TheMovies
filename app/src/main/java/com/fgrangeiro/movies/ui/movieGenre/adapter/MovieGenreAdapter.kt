package com.fgrangeiro.movies.ui.movieGenre.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fgrangeiro.movies.R
import com.fgrangeiro.movies.entities.movieGenre.MovieGenre
import kotlinx.android.synthetic.main.item_movie_genre.view.*

class MovieGenreAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val movieGenreList: MutableList<MovieGenre> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_movie_genre,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return movieGenreList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.name.run {
            text = movieGenreList[position].name
        }
    }

    fun setGenreList(movieGenreList: List<MovieGenre>) {
        this.movieGenreList.addAll(movieGenreList)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}