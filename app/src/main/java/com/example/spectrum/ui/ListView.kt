package com.example.spectrum.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.spectrum.R

class ListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

      val arrayAdapterProducto:ArrayAdapter<*>

      val productos= mutableListOf("jamones","papas","refrescos","persianas")
        val listviewPerson:ListView
        listviewPerson = findViewById(R.id.lvwProductos)

        arrayAdapterProducto = ArrayAdapter(this,android.R.layout.simple_list_item_1,productos)
       listviewPerson.adapter = arrayAdapterProducto

    }
}