package com.devmaufh.navegacion

import android.content.Context
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    var nom:String=""
    var eda:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun verde(v: View){
        var intent=Intent(this,VerdeActivity::class.java)
        nom=ed1.text.toString()
        intent.putExtra("nombre",nom)

        startActivity( intent )

    }
    fun rojo(v: View){
        if(ed2.text.isEmpty()){
            startActivity(Intent(this,RojoActivity::class.java))
        }else{
            val intent=Intent(this,RojoActivity::class.java)
            eda=ed2.text.toString().toInt()
            intent.putExtra(RojoActivity.EXTRA_EDAD,eda)
            startActivity(intent)
        }
    }
}
