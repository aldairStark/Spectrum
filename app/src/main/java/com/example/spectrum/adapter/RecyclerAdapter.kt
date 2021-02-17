package com.example.spectrum.adapter

import android.content.Context
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.spectrum.R
import com.example.spectrum.metadata.Superheroes
import com.example.spectrum.ui.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerAdapter:androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    var superheroes:MutableList<Superheroes> = ArrayList()
    lateinit var context: Context
    fun RecyclerAdapter(superheroes:MutableList<Superheroes>,context: Context){
        this.superheroes=superheroes
        this.context=context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
       val layoutInflater:LayoutInflater= LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_superhero,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val item = superheroes.get(position)
        holder.bind(item, context)
    }

    override fun getItemCount(): Int = superheroes.size

    class ViewHolder(view: View):androidx.recyclerview.widget.RecyclerView.ViewHolder(view){
        val superheroName= view.findViewById(R.id.tvNameHero) as TextView
        val realname = view.findViewById(R.id.tvRealName) as TextView
        val secondname= view.findViewById(R.id.tvSecondName) as TextView
        val franchise = view.findViewById(R.id.tvFranquice) as TextView
        val image= view.findViewById(R.id.imageHero) as ImageView

        fun bind(superheroes: Superheroes, context: Context){
            superheroName.text = superheroes.nameSuperhero
            realname.text = superheroes.name
            secondname.text = superheroes.secondName
            franchise.text= superheroes.franquicie
            image.loadUrl(superheroes.image)
        }
        fun ImageView.loadUrl(url:String){
            Picasso.with(context).load(url).into(this)
        }

    }
}