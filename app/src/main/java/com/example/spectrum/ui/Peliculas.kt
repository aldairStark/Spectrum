package com.example.spectrum.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spectrum.R
import com.example.spectrum.adapter.MovieAdapter
import com.example.spectrum.adapter.RecyclerAdapter
import com.example.spectrum.metadata.PeliculasData

class Peliculas : AppCompatActivity() {
    lateinit var pRecyclerView: RecyclerView
    val pAdapter: MovieAdapter = MovieAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peliculas)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        pRecyclerView = findViewById(R.id.rvMovies)
        pRecyclerView.setHasFixedSize(false)
        pRecyclerView.layoutManager = LinearLayoutManager(this)
        pAdapter.MovieAdapter(getMovie(),this)
        pRecyclerView.adapter = pAdapter
    }

    fun getMovie():MutableList<PeliculasData>{
        var peliculas:MutableList<PeliculasData> = ArrayList()
        peliculas.add(PeliculasData("Titanic","Romantica","1994","https://i.blogs.es/4a9cb1/titanic/840_560.jpeg"))
        return peliculas
    }
}