package com.example.movieapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ItemMovieBinding

class MovieAdapter(
    private val onFavoriteMovieClicked: (Movie, Boolean) -> Unit,
    var favoriteMovieList: ArrayList<Movie> = arrayListOf()
) : ListAdapter<Movie, MovieAdapter.ViewHolder>(movieComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onFavoriteMovieClicked
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), favoriteMovieList.contains(getItem(position)))
    }

//    fun deleteData(movieEntity: MovieEntity) {
//        val movie = movieList.firstOrNull { it.title == movieEntity.title }
//        val index = movieList.indexOf(movie)
//        movieList.remove(movie)
//        notifyItemRemoved(index)
//    }

    inner class ViewHolder(
        private val binding: ItemMovieBinding,
        val onFavoriteMovieClicked: (Movie, Boolean) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie, isFavorite: Boolean){
            binding.movie = movie
            binding.isMovieFavorite = isFavorite
            binding.btnFavorite.setOnClickListener {
                onFavoriteMovieClicked(movie, isFavorite.not())
            }
        }
    }

    companion object {
        val movieComparator = object:DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem == newItem
        }

    }
}