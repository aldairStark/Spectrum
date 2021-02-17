package com.example.spectrum

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.spectrum.ui.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val a="Perrors"
        showCase()
        Funciones.Toast(this)
        Funciones.shara(a)

        var btn:Button
        var btnLvwP:Button
        var btnRvw:Button
        var btnMovies:Button
        var btnFragments:Button
        var btnAsyncTask:Button

    btnAsyncTask=findViewById(R.id.btnAsync)
        btnFragments = findViewById(R.id.btnFragments)
        btnMovies = findViewById(R.id.rvwPeliculas)

        btnRvw= findViewById(R.id.rvwSupers) as Button
        btnLvwP=findViewById(R.id.btnLvwProd)
        btnLvwP.setOnClickListener {
            val intent:Intent = Intent(this, ListView::class.java)
            startActivity(intent)
        }

        btn = findViewById(R.id.btnIntent)
        btn.setOnClickListener {
            val intent:Intent = Intent(this, interface2::class.java)
            startActivity(intent)
        }
        btnRvw.setOnClickListener {
            val intent:Intent= Intent(this,RecyclerView::class.java)
            startActivity(intent)
        }
        btnMovies.setOnClickListener {
            val intent:Intent = Intent(this, Peliculas::class.java)
            startActivity(intent)
        }
        btnFragments.setOnClickListener {
            val intent:Intent = Intent(this, BackoutFragments::class.java)
            startActivity(intent)
        }
        btnAsyncTask.setOnClickListener { val intent:Intent = Intent(this, activity_AsyncTask::class.java)
            startActivity(intent) }


    }

    fun showCase(){
        showCase01()
        showCase02()
    }

    fun showCase01(){
       val we = Myclass.flaq
        Myclass.welcome()
    }
    fun showCase02(){
        Myclass2.Welcome()
    }

}
class Myclass {

    companion object {
        val flaq = 1
        fun welcome(){
            Log.w("WELCOME","WELCOME IN COMPANION OBJET")
        }
    }
}
class Myclass2{
    companion object:lub{
        override fun Welcome() {
            Log.w("WELCOME","WELCOME IN COMPANION OBJET + interfaces")
        }

    }

}
interface lub{
    fun Welcome()
}
class Funciones{
    companion object {
        fun Toast(context: Context) {
            android.widget.Toast.makeText(context, "hola", android.widget.Toast.LENGTH_LONG).show()

        }
        fun shara(a:String){
            Log.e("TAGSPRUEBA","TG DE PRUEBA + $a")
        }
    }
}

