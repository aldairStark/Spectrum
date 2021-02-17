package com.example.spectrum.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spectrum.R
import com.example.spectrum.metadata.Superheroes
import com.squareup.picasso.Picasso

class AdapterSuperheros:RecyclerView.Adapter<AdapterSuperheros.Viewholder>(){
    var superheros:MutableList<Superheroes> = ArrayList()
    lateinit var context: Context

    fun AdapterSuperheros(superheroes:MutableList<Superheroes>,context: Context){
        this.superheros= superheroes
        this.context= context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterSuperheros.Viewholder {
       val layoutInflater:LayoutInflater= LayoutInflater.from(parent.context)
        return Viewholder(layoutInflater.inflate(R.layout.item_superhero,parent,false))
    }

    override fun onBindViewHolder(holder: AdapterSuperheros.Viewholder, position: Int) {
       val item = superheros.get(position)
        holder.bind(item,context)
    }

    override fun getItemCount(): Int = superheros.size
    class Viewholder(item: View):RecyclerView.ViewHolder(item){

        val nameReal =  item.findViewById(R.id.tvRealName) as TextView
        val secondname = item.findViewById(R.id.tvSecondName) as TextView
        val franchise = item.findViewById(R.id.tvFranquice) as TextView
        val nameHero=item.findViewById(R.id.tvNameHero) as TextView
        val image = item.findViewById(R.id.imageHero) as ImageView

        fun bind(superheros: Superheroes , context: Context){
                nameReal.text = superheros.name
                secondname.text = superheros.secondName
                franchise.text = superheros.franquicie
                nameHero.text = superheros.nameSuperhero
                image.loadUrl(superheros.image)
        }
        fun ImageView.loadUrl(url:String){
            Picasso.with(context).load(url).into(this)
        }
    }
}