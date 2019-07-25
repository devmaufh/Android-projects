package com.devmaufh.chart

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.github.florent37.runtimepermission.kotlin.askPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragment(LineFragment())
        askForExternalStorage()
        home_BottomNav.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.menu_barra ->{
                    Toast.makeText(this, "Click barra", Toast.LENGTH_SHORT).show();
                    setFragment(BarFragment())
                }
                R.id.menu_lineal ->{
                    Toast.makeText(this, "Click lineal", Toast.LENGTH_SHORT).show();
                    setFragment(LineFragment())
                }
                R.id.menu_pie -> {
                    Toast.makeText(this, "Click pie", Toast.LENGTH_SHORT).show();
                    setFragment(PieFragment())
                }
            }
            true
        }
       llenarBD()
    }

    fun setFragment(fragment: Fragment){
        val fragmentTransation=supportFragmentManager.beginTransaction()
        fragmentTransation.replace(R.id.frame_home,fragment)
        fragmentTransation.commit()
    }
    fun llenarBD(){
        val db=adBD(this)
        for(i in 0 until 100){
            val nombre="ESTADO $i"
            val habitantes=(1 .. 20).random()
            val fin= habitantes*i
            val res=db.Ejecuta("INSERT INTO estados(nombre,habitantes) VALUES('$nombre',$fin)")
            Log.w("DATABASE INSERTED: ","$res")
        }
    }
    fun askForExternalStorage(){
        askPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE){

        }.onDeclined { e ->
            if (e.hasDenied()) {
                e.denied.forEach {
                }

                AlertDialog.Builder(this@MainActivity)
                    .setMessage("Please accept our permissions")
                    .setPositiveButton("yes") { dialog, which ->
                        e.askAgain();
                    } //ask again
                    .setNegativeButton("no") { dialog, which ->
                        dialog.dismiss();
                    }
                    .show();
            }
        }
    }
}
