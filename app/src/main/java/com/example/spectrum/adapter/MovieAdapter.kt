package com.example.spectrum.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spectrum.R
import com.example.spectrum.metadata.PeliculasData
import com.squareup.picasso.Picasso

class MovieAdapter:RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    var peliculasData:MutableList<PeliculasData> = ArrayList()
    lateinit var context: Context
    fun MovieAdapter(peliculasData: MutableList<PeliculasData>, context: Context){
        this.peliculasData=peliculasData
        this.context=context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val layoutInflater:LayoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_peliculas,parent,false))
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        val item = peliculasData.get(position)
        holder.bind(item,context)
    }

    override fun getItemCount(): Int = peliculasData.size

    class ViewHolder(item: View):RecyclerView.ViewHolder(item){
        val nameMovie = item.findViewById(R.id.tvNameMovie) as TextView
        val genMovie = item.findViewById(R.id.tvGenMovie) as TextView
        val yearMovie = item.findViewById(R.id.tvYearMovie) as TextView
        val imageMovie = item.findViewById(R.id.movieImage) as ImageView

        fun bind(peliculasData: PeliculasData , context: Context){
            nameMovie.text = peliculasData.nombrePelicula
            genMovie.text = peliculasData.genero
            yearMovie.text = peliculasData.ano
            imageMovie.load(peliculasData.imageMovie)
        }
        fun ImageView.load(url:String){
            Picasso.with(context).load(url).into(this)
        }

    }
}