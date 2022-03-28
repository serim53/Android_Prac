package com.example.movieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.movieapp.databinding.FragmentRankBinding

class RankFragment : Fragment() {

    private val rankViewModel by viewModels<RankViewModel>()
    private val favoriteViewModel by viewModels<FavoriteViewModel>()
    private lateinit var fragmentRankBinding: FragmentRankBinding

    //private lateinit var adapter: MovieAdapter
    private val adapter by lazy {
        MovieAdapter(this::onFavoriteMovieClicked)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentRankBinding = FragmentRankBinding.inflate(inflater, container, false)
        return fragmentRankBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        rankViewModel.getMovies()
        favoriteViewModel.getAll().observe(viewLifecycleOwner) { list ->
            adapter.favoriteMovieList = list.map {
                Movie(
                    it.title,
                    it.image,
                    it.description
                )
            } as ArrayList<Movie>
            adapter.notifyDataSetChanged()
        }
        rankViewModel.myResponse.observe(viewLifecycleOwner) {
            adapter.submitList(it as ArrayList<Movie>)
        }
    }

    private fun initViews() {
        //adapter = MovieAdapter()
        fragmentRankBinding.recyclerView.adapter = adapter
        fragmentRankBinding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun onFavoriteMovieClicked(movie: Movie, isFavorite: Boolean) {
        if (isFavorite) {
            rankViewModel.insert(movie)
        } else {
            rankViewModel.delete(movie)
        }
        favoriteViewModel.getAll()
    }
}