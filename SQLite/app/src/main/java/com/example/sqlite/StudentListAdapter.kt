package com.example.sqlite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentListAdapter internal  constructor(
    context:Context
): RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(){
    private val inflater:LayoutInflater= LayoutInflater.from(context)
    private var students= emptyList<Student>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView=inflater.inflate(R.layout.student_item,parent,false)
        return StudentViewHolder(itemView)
    }

    override fun getItemCount()=students.size

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val current=students[position]
        holder.Nombre.text="Nombre: "+current.nombre
        holder.Control.text="NoControl: "+current.noControl
        holder.Carrera.text="Carrera: "+current.carrera
        holder.Edad.text="Edad: "+current.edad
    }

    inner class StudentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val Control:TextView =itemView.findViewById(R.id.item_control)
        val Nombre:TextView=itemView.findViewById(R.id.item_nombres)
        val Carrera:TextView=itemView.findViewById(R.id.item_carrera)
        val Edad:TextView=itemView.findViewById(R.id.item_edad)
    }

    fun setStudentList(studentList: List<Student>){
        this.students=studentList
        notifyDataSetChanged()
    }
}