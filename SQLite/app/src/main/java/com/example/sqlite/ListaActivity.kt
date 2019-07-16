package com.example.sqlite

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)


        val rview=findViewById<RecyclerView>(R.id.lista_rv)
        val adapter=StudentListAdapter(this)
        rview.adapter=adapter


        //rview.layoutManager=GridLayoutManager(this,2) //Muestra los elementos en grillas,
                                                    // si quieren que les muestre grillas de 2,3 o 4 o N numeros
                                                    //Solo cambién el 2 que tiene ahí


        rview.layoutManager=LinearLayoutManager(this) //Muestra los elementos en lista de 1, es alternativo al de arriba,
                                                            //Solo pueden usar uno, por eso comenté el otro v:




        adapter.setStudentList(DbStudentList())
    }

    fun DbStudentList():List<Student>{
        var students= ArrayList<Student>()
        val database=adBD(this)
        val cursor=database.consulta("SELECT noControl,nomEst,carrera,edadEst FROM Estudiante")
        if(cursor!!.moveToFirst())do{
            val stu=Student(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3))
            students.add(stu)
        }
        while(cursor!!.moveToNext())
        cursor.close()
        return students
    }
}
