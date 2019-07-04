package devmaufh.helloworldkotlin

import android.content.Intent
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
            getState(result)
          //  Toast.makeText(this@MainActivity,getString(R.string.resultIMC)+alternativeState(result),Toast.LENGTH_LONG).show()

           // Toast.makeText(this@MainActivity,getString(R.string.resultIMC)+getState(result),Toast.LENGTH_LONG).show()

        }else{
            Toast.makeText(this@MainActivity,getString(R.string.validaCampos),Toast.LENGTH_LONG).show()
        }
    }
    fun getState(imc: Double){
        Toast.makeText(this@MainActivity,"IMC: $imc",Toast.LENGTH_LONG).show()
        var state=""
        if(imc<25)            startActivity(startVerde(imc))
        if(imc>=25&&imc<30)   startActivity(startAmarillo(imc))//state= "Tu imc es de sobrepeso"
        if(imc>=30&&imc<=40)  startActivity(startRojo(imc))//state= "Tu imc es de obesidad"
    }
    fun alternativeState(imc:Double):String{
        var intent:Intent
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
    fun startVerde(imc:Double):Intent{
        val intent= Intent(this,VerdeActivity::class.java)
        intent.putExtra(VerdeActivity.EXTRA_IMC,imc)
        return intent
    }
    fun startAmarillo(imc:Double):Intent{
        val intent= Intent(this,AmarillaActivity::class.java)
        intent.putExtra(AmarillaActivity.EXTRA_IMC,imc)
        return intent
    }
    fun startRojo(imc:Double):Intent{
        val intent= Intent(this,RojaActivity::class.java)
        intent.putExtra(RojaActivity.EXTRA_IMC,imc)
        return intent
    }
}
