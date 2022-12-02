package com.example.movielist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielist.adapter.MovieListAdapter
import com.example.movielist.adapter.MovieListhorizontalAdapter
import com.example.movielist.model.Movie
import com.example.myfirstapp.R
import com.example.myfirstapp.Recycler.MovieDetailActivity
import com.example.myfirstapp.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerBinding
    private var movieList = mutableListOf<Movie>()
    private lateinit var mAdapter:MovieListAdapter
    private lateinit var mHoriAdapter:MovieListhorizontalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieList.add(Movie(1, "Dawn of the planet of the Apes", "Action, Drama, Sci-Fi", 4.3f, R.drawable.image_1, 2004))
        movieList.add(Movie(2, "District 9", "Action, Thriller, Sci-Fi", 4.0f, R.drawable.image_2, 2000))
        movieList.add(Movie(3, "Transformers: Age of Extinction", "Action, Adventure, Sci-Fi", 5.0f, R.drawable.image_3, 2004))
        movieList.add(Movie(4, "X-Men: Days of future past", "Action, Thriller, Sci-Fi", 3.5f, R.drawable.image_4, 2009))
        movieList.add(Movie(5, "The Machinist", "Drama, Thriller", 3f, R.drawable.image_5, 2014))
        movieList.add(Movie(1, "Dawn of the planet of the Apes", "Action, Drama, Sci-Fi", 4.3f, R.drawable.image_1, 2004))
        movieList.add(Movie(2, "District 9", "Action, Thriller, Sci-Fi", 4.0f, R.drawable.image_2, 2000))
        movieList.add(Movie(3, "Transformers: Age of Extinction", "Action, Adventure, Sci-Fi", 5.0f, R.drawable.image_3, 2004))
        movieList.add(Movie(4, "X-Men: Days of future past", "Action, Thriller, Sci-Fi", 3.5f, R.drawable.image_4, 2009))
        movieList.add(Movie(5, "The Machinist", "Drama, Thriller", 3f, R.drawable.image_5, 2014))


        // passing data to adapter
        mAdapter = MovieListAdapter(this, movieList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)      // vertical
        binding.recyclerView.adapter = mAdapter


        // passing data to adapter
        mHoriAdapter = MovieListhorizontalAdapter(this, movieList)
        binding.recyclerViewHorizontal.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewHorizontal.adapter = mHoriAdapter

        mHoriAdapter.setOnMovieItemClickListener(object : MovieListhorizontalAdapter.OnMovieItemClickListener {
            override fun OnItemClicked(movie:Movie) {
                var intent = Intent(applicationContext, MovieDetailActivity::class.java)
                intent.putExtra("MOVIE",movie)
                startActivity(intent)
            }


        })


    }
}