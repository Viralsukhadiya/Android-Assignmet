package com.example.movielist.adapter

import android.R
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.movielist.model.Movie
import com.example.myfirstapp.Recycler.MovieDetailActivity
import com.example.myfirstapp.databinding.DialogMovieLayoutBinding
import com.example.myfirstapp.databinding.ItemMovieLayoutBinding

class MovieListAdapter(var context: Context,var movieList:MutableList<Movie>) :
    RecyclerView.Adapter<MovieListAdapter.MyViewHoldar>() {

    lateinit var binding: ItemMovieLayoutBinding

    class MyViewHoldar(var bind: ItemMovieLayoutBinding) : RecyclerView.ViewHolder(bind.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHoldar {
        binding = ItemMovieLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHoldar(binding)
    }

    override fun onBindViewHolder(holder: MyViewHoldar, position: Int) {
        var movie = movieList[position]
        holder.bind.tvName.text = movie.name
        holder.bind.tvType.text = movie.type
        holder.bind.tvYear.text = "${movie.year}"
        holder.bind.ratingBar.rating = movie.reting
        holder.bind.ivThumbnail.setImageResource(movie.image)



        //cardview click event
        holder.bind.cardView.setOnClickListener {
            var intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra("MOVIE",movie)
            context.startActivity(intent)

        }
        //image click event
        holder.bind.ivThumbnail.setOnClickListener {
            showImageDialog(movie)

        }

    }

    private fun showImageDialog(movie: Movie) {
        var dialogBinding = DialogMovieLayoutBinding.inflate(LayoutInflater.from(context))

        var builder = AlertDialog.Builder(context)
        builder.setView(dialogBinding.root)

        dialogBinding.ivThumbnail.setImageResource(movie.image)

        var dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(R.color.transparent);
        dialog.show()

    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}