package devmaufh.helloworldkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_verde.*

class VerdeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verde)

        val intent=intent
        if(intent!=null && intent.hasExtra(EXTRA_IMC)){
            tvVerde.text=intent.getDoubleExtra(EXTRA_IMC, DEFAULT_IMC).toString()
        }else{
            tvVerde.text=intent.getDoubleExtra(EXTRA_IMC, DEFAULT_IMC).toString()

        }
    }
    companion object VerdeActivity{
        val EXTRA_IMC="EXTRA_IMC_VERDE"
        private val DEFAULT_IMC=0.0
    }
}
