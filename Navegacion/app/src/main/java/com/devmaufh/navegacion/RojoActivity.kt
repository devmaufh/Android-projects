package com.devmaufh.navegacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_rojo.*

class RojoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rojo)

        val intent=intent
        if(intent!=null && intent.hasExtra(EXTRA_EDAD)){
            age.text=intent.getIntExtra(EXTRA_EDAD, DEFAULT_EDAD).toString()
        }else{
            age.text=intent.getIntExtra(EXTRA_EDAD, DEFAULT_EDAD).toString()

        }
    }
    companion object{
        val EXTRA_EDAD="extraEdad"
        private val DEFAULT_EDAD: Int=-1
    }
}
