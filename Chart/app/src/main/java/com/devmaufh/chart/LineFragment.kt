package com.devmaufh.chart


import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.BarGraphSeries
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class LineFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_line, container, false)

        var graph=view.findViewById(R.id.lines) as GraphView //obtenemos la referencia de nuestro gráfico
        val database = adBD(context!!.applicationContext) //creamos una instancia de nuestra base de datos
        val cursor = database.consulta("SELECT id_estado, nombre, habitantes FROM estados") //Ejecutamos la consulta para obtener los datos
        var arrayAux = ArrayList<DataPoint>()//Definimos un arrayList vacío de DataPoints para almacenar los puntos
        if (cursor!!.moveToFirst()) do { //Verificamos si el cursor tiene datos
            arrayAux.add(DataPoint(cursor.getInt(0).toDouble(), cursor.getInt(2).toDouble())) //Añadimos el DataPoint a nuestro array
        } while (cursor!!.moveToNext()) //Verificamos si existen más datps

        var arrayPoints = arrayOfNulls<DataPoint>(arrayAux.size) //Definimos un arrayOfNulls de data points
        for (point in 0 until arrayAux.size) { //Iteramos el arrayList con los puntos que obtuvimos de la DB
            arrayPoints[point] = arrayAux.get(point) //Añadimos los elementos del arrayList a nuestro array
        }
        val series= LineGraphSeries(arrayPoints) //Creamos una serie y le pasamos de parámetro el array de puntos
        series.setAnimated(true)
        graph.addSeries(series) //Añadimos la serie a nuestro gráfico
        graph.viewport.setScalableY(true)
        graph.viewport.setScalable(true)

        graph.setOnLongClickListener {
            val savedImageURL = MediaStore.Images.Media.insertImage(
                view.context.contentResolver,
                graph.takeSnapshot(),
                "Mi gráfica",
                "Descripción de mi grafica"
            )
            Toast.makeText(view.context, "Imagen almacenada en: $savedImageURL", Toast.LENGTH_SHORT).show();
            true
        }
        graph.setOnClickListener {
            graph.takeSnapshotAndShare(view.context, "graphic", "Gráfica de líneas");
        }

        return view
    }
}
