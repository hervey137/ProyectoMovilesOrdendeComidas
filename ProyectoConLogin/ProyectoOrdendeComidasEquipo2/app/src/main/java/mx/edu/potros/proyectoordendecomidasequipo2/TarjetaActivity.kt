package mx.edu.potros.proyectoordendecomidasequipo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import mx.edu.potros.proyectoordendecomidasequipo2.R

class TarjetaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarjeta)

        val orden: ArrayList<Product>? = intent.getParcelableArrayListExtra("orden")


        val btn_comfirmar: Button = findViewById(R.id.btn_comfirmar)
        btn_comfirmar.setOnClickListener {
            val intent: Intent = Intent(this, PagoComfirmadoActivity::class.java)
            intent.putParcelableArrayListExtra("orden", orden)
            startActivity(intent)
        }
    }
}