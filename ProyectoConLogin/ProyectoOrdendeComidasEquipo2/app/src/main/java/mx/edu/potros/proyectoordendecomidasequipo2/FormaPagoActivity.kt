package mx.edu.potros.proyectoordendecomidasequipo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FormaPagoActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formadepago)


        //aqui, en teoria, que paso nuestra orden de la clase de ProductosActivity a esta
        val orden: ArrayList<Product>? = intent.getParcelableArrayListExtra("orden")

        var btn_tarjeta: Button = findViewById(R.id.btn_tarjeta)
        var btn_efectivo: Button = findViewById(R.id.btn_efectivo)

        //el proceso es igual para los dos tipos de pago, mandamos nuestra orden por esas dos clases
        //para que al final lleguen a la clase de PagoCOmfirmadoActivity y ahi registramos
        //la orden en la base de datos de firebase. eso espero
        btn_tarjeta.setOnClickListener {
            var intent: Intent = Intent(this, TarjetaActivity::class.java)
            intent.putParcelableArrayListExtra("orden", orden)
            startActivity(intent)
        }
        btn_efectivo.setOnClickListener {
            var intent: Intent = Intent(this,EfectivoActivity::class.java)
            intent.putParcelableArrayListExtra("orden", orden)
            startActivity(intent)
        }
    }
}