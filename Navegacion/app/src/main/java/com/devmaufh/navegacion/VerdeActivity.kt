package com.devmaufh.navegacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_verde.*

class VerdeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verde)
        val intent=intent
        name.text=intent.getStringExtra("nombre")
    }
}
