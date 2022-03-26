package com.example.movieapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ItemMovieBinding

class MovieAdapter(
    private val onFavoriteBuTTONcL
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var movieList: ArrayList<Movie> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size

    fun setData(list: ArrayList<Movie>) {
        movieList = list
        notifyDataSetChanged()
    }

    fun deleteData(movieEntity: MovieEntity) {
        val movie = movieList.firstOrNull { it.title == movieEntity.title }
        val index = movieList.indexOf(movie)
        movieList.remove(movie)
        notifyItemRemoved(index)
    }

    inner class ViewHolder(
        private val binding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie){
            binding.movie = movie
            binding.btnFavorite.run {
                isSelected =
            }
        }
    }
}