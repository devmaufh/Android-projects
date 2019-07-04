package devmaufh.helloworldkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_amarilla.*

class AmarillaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amarilla)
        val intent=intent
        if(intent!=null && intent.hasExtra(EXTRA_IMC)){
            tvAmarilla.text=intent.getDoubleExtra(EXTRA_IMC, DEFAULT_IMC).toString()
        }else{
            tvAmarilla.text=intent.getDoubleExtra(EXTRA_IMC, DEFAULT_IMC).toString()
        }
    }
    companion object AmarillaActivity{
        val EXTRA_IMC="EXTRA_IMC_VERDE"
        private val DEFAULT_IMC=0.0
    }
}
