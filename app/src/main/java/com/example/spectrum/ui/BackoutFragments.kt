package com.example.spectrum.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.spectrum.R
import com.example.spectrum.interfaces.OnClickFragmentButton

class BackoutFragments : AppCompatActivity(),OnClickFragmentButton {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backout_fragments)
    }

    override fun onclickFragmentButton() {
        Toast.makeText(this,"El boton ha sido pinchado",Toast.LENGTH_SHORT).show()
    }
}