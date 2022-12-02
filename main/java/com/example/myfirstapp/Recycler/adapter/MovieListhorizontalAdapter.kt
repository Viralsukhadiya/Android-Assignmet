package com.example.movielist.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.movielist.model.Movie
import com.example.myfirstapp.databinding.ItemMovieLayoutHorizontalBinding

class MovieListhorizontalAdapter(var context: Context, var movieList:MutableList<Movie>) :
    RecyclerView.Adapter<MovieListhorizontalAdapter.MyViewHoldar>() {

    private lateinit var listener: OnMovieItemClickListener
    interface OnMovieItemClickListener{
        fun OnItemClicked(movie:Movie)
    }

    fun setOnMovieItemClickListener(listener: OnMovieItemClickListener){
        this.listener = listener
    }

    lateinit var binding: ItemMovieLayoutHorizontalBinding

    class MyViewHoldar(var bind: ItemMovieLayoutHorizontalBinding) : RecyclerView.ViewHolder(bind.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHoldar {
        binding = ItemMovieLayoutHorizontalBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHoldar(binding)
    }

    override fun onBindViewHolder(holder: MyViewHoldar, position: Int) {
        var movie = movieList[position]
        holder.bind.tvName.text = movie.name
        holder.bind.ivThumbnail.setImageResource(movie.image)



        //cardview click event
        holder.bind.cardView.setOnClickListener {
            listener.OnItemClicked(movie)

        }

    }



    override fun getItemCount(): Int {
        return movieList.size
    }
}