package mx.edu.potros.proyectoordendecomidasequipo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FormaPagoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formadepago)

        var btn_tarjeta: Button = findViewById(R.id.btn_tarjeta)
        var btn_efectivo: Button = findViewById(R.id.btn_efectivo)

        btn_tarjeta.setOnClickListener {
            var intent: Intent = Intent(this, TarjetaActivity::class.java)
            startActivity(intent)
        }
        btn_efectivo.setOnClickListener {
            var intent: Intent = Intent(this,EfectivoActivity::class.java)
            startActivity(intent)
        }
    }
}