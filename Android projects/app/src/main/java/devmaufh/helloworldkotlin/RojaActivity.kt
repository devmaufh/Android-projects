package devmaufh.helloworldkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_roja.*

class RojaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roja)
        val intent=intent
        if(intent!=null && intent.hasExtra(EXTRA_IMC)){
            tvRoja.text=intent.getDoubleExtra(EXTRA_IMC, DEFAULT_IMC).toString()
        }else{
            tvRoja.text=intent.getDoubleExtra(EXTRA_IMC, DEFAULT_IMC).toString()

        }
    }
    companion object RojaActivity{
        val EXTRA_IMC="EXTRA_IMC_VERDE"
        private val DEFAULT_IMC=0.0
    }
}
