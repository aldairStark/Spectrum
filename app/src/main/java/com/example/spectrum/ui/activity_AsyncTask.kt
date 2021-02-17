package com.example.spectrum.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.spectrum.R
import java.lang.Exception
import java.net.URL

class activity_AsyncTask : AppCompatActivity() {
    lateinit var  content:LinearLayout
    lateinit var progresbar:ProgressBar
    lateinit var  textInfo:TextView
    lateinit var btnStart:Button
    lateinit var btnStop:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)

btnStart = findViewById(R.id.btnStar)
        btnStop =  findViewById(R.id.btnStop)
textInfo = findViewById(R.id.textView2)
progresbar = findViewById(R.id.progressbar)
content = findViewById(R.id.content)

        val asyncTask=MyASYncTask(this,content,progresbar,textInfo)
        btnStart.setOnClickListener {
            asyncTask.execute("https://chignahuapan.gob.mx/wp-content/uploads/2018/12/arrancones-de-trailers10.jpg",
                "https://info-transportes.com.mx/media/k2/items/cache/95834591cf23c925a93641e9f929b922_XL.jpg",
                "https://www.cinemascomics.com/wp-content/uploads/2021/02/Nuevo-trailer-lleno-de-accion-de-Godzilla-vs-Kong-960x720.jpg")
            it.isEnabled=false
            btnStop.isEnabled= true
        }
        btnStop.setOnClickListener {
            asyncTask.cancel(true)
            it.isEnabled=false
        }


    }
    private inner class MyASYncTask(val context: Context, val content:LinearLayout, val progresbar:ProgressBar,
    val txtInfo:TextView):AsyncTask<String, Int, MutableList<Bitmap>>(){
        override fun onPreExecute() {
            super.onPreExecute()
            progresbar.progress = 0
            txtInfo.text="Descarga Iniciada"
        }
        override fun doInBackground(vararg params: String?): MutableList<Bitmap> {
           val list= ArrayList<Bitmap>()
            for (i in 0 until params.size){
                val urlimage = URL(params[i])
                try {
                    val input = urlimage.openStream()
                    list.add(BitmapFactory.decodeStream(input))

                }catch (e:Exception){
                    Log.println(Log.WARN,"doInBackGround","${e.message}");
                }
                publishProgress((((i+1)*100)/params.size.toFloat()).toInt())
                if (isCancelled)break
            }
            return list
        }

        override fun onPostExecute(result: MutableList<Bitmap>) {
            txtInfo.text= "Descarga finalizada \n ${result?.size} Archivos descargados"
            for (image in result!!){
                content.addView(addImage(image))
            }
            super.onPostExecute(result)
        }

        override fun onProgressUpdate(vararg values: Int?) {
            progresbar.progress =  values[0]!!
            txtInfo.text="Descarga ${values[0]}%"
            super.onProgressUpdate(*values)
        }

        override fun onCancelled(result: MutableList<Bitmap>) {

            super.onCancelled(result)
            txtInfo.text= "Descarga cancelada \n ${result?.size} Archivos descargados"
            for (image in result!!){
                content.addView(addImage(image))
            }
        }
        private fun addImage(bitmap: Bitmap):ImageView{
            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,400)
            params.bottomMargin=20
            val imageView = ImageView(context)
            imageView.layoutParams=params
            imageView.run {
                setImageBitmap(bitmap)
                setBackgroundResource(R.color.teal_200)
            }
            return imageView
        }
    }
}