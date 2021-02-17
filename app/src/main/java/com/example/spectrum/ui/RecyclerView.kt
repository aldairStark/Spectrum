package com.example.spectrum.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spectrum.R
import com.example.spectrum.adapter.RecyclerAdapter
import com.example.spectrum.metadata.Superheroes

class RecyclerView : AppCompatActivity() {
    lateinit var mRecyclerView:RecyclerView
    val mAdapter:RecyclerAdapter = RecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        setupRecyclerView()


    }

    private fun setupRecyclerView() {
        mRecyclerView = findViewById(R.id.rvSuper) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager=LinearLayoutManager(this)
        mAdapter.RecyclerAdapter(getSuperHeroes(),this)
        mRecyclerView.adapter = mAdapter

    }
    fun getSuperHeroes():MutableList<Superheroes>{
        var superheroes:MutableList<Superheroes> = ArrayList()
        superheroes.add(Superheroes("Peter","parker","Spiderman","Marvel","https://cronicaglobal.elespanol.com/uploads/s1/61/11/50/7/main-700b9bff30.jpeg"))
        superheroes.add(Superheroes("Bruce","Wane","Batman","DC","https://as02.epimg.net/meristation/imagenes/2020/07/08/noticias/1594221869_920953_1594221904_noticia_normal_recorte1.jpg"))
        superheroes.add(Superheroes("Clark","kent","Superman","DC","https://i.blogs.es/706ab7/henry-cavill-deja-de-ser-superman-warner-dc/1366_2000.jpg"))
        superheroes.add( Superheroes("Billy","Batzon","Shazam","","https://static.wikia.nocookie.net/marvel_dc/images/6/61/Shazam%21_Vol_3_1_Textless_Variant.jpg/revision/latest?cb=20181205234924"))
        return superheroes
    }
}