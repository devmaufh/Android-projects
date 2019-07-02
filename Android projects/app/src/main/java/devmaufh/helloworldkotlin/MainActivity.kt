package devmaufh.helloworldkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var weigth: Double=0.0
    var height: Double=0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getIMC(weight: Double,height: Double ): Double{
        Log.d("PESO:","$weight")
        Log.d("Estatura:", "$height")
        return weight/(height*height)
    }
    fun calculateIMC(v: View) {
        Toast.makeText(this@MainActivity,"Aver",Toast.LENGTH_LONG).show()
        if (!edEstatura.text.isEmpty() && !edPeso.text.isEmpty()) {
            val result=getIMC(edPeso.text.toString().toDouble(),edEstatura.text.toString().toDouble()/100)

            Toast.makeText(this@MainActivity,getString(R.string.resultIMC)+alternativeState(result),Toast.LENGTH_LONG).show()

          //  Toast.makeText(this@MainActivity,getString(R.string.resultIMC)+getState(result),Toast.LENGTH_LONG).show()

        }else{
            Toast.makeText(this@MainActivity,getString(R.string.validaCampos),Toast.LENGTH_LONG).show()
        }
    }
    fun getState(imc: Double):String{
        var state=""
        if(imc<25)            state= "Tu imc es el adecuado"
        if(imc>=25&&imc<30)   state= "Tu imc es de sobrepeso"
        if(imc>=30&&imc<=40)  state= "Tu imc es de obesidad"
        return state
    }
    fun alternativeState(imc:Double):String{
        var res=""
        when{
            imc<25           -> res  = "Tu imc es el adecuado"
            imc>=25&&imc<30  -> res  = "Tu imc es de sobrepeso"
            imc>=30&&imc<=40 -> res  = "Tu imc es de obseidad"
            else             -> res  = "Pasate el limite compa :c"
        }
        Log.w("IMC ", "$imc")
        return res
    }
}
