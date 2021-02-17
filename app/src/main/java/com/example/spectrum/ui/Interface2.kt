package com.example.spectrum.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.spectrum.R

class interface2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interface2)

      val arrayList:ArrayAdapter<*>
      val personas = mutableListOf("performances","alonso")
        val listView:ListView
        listView = findViewById(R.id.lvDatos)

        arrayList = ArrayAdapter(this,android.R.layout.simple_expandable_list_item_2,personas)
        listView.adapter = arrayList
    }
}