package com.example.movieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.movieapp.databinding.FragmentFavoriteBinding
import kotlinx.coroutines.flow.collect

class FavoriteFragment : Fragment() {

    private val viewModel by viewModels<FavoriteViewModel>()
    private lateinit var fragmentFavoriteBinding: FragmentFavoriteBinding
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentFavoriteBinding = FragmentFavoriteBinding.inflate(layoutInflater)
        return fragmentFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        lifecycleScope.launchWhenCreated {
            viewModel.items.collect {
                adapter.favoriteMovieList = it as ArrayList<Movie>
                adapter.submitList(it)
            }
        }
    }

    private fun initViews() {
        adapter = MovieAdapter(this::onFavoriteMovieClicked)
        fragmentFavoriteBinding.recyclerView.adapter = adapter
        fragmentFavoriteBinding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun onFavoriteMovieClicked(movie: Movie, isFavorite: Boolean) {
        if (isFavorite.not()) {
            viewModel.delete(MovieEntity(movie.title, movie.image, movie.description))
        }
    }

}