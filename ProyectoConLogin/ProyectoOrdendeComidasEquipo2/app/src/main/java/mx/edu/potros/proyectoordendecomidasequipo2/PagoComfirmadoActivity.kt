package mx.edu.potros.proyectoordendecomidasequipo2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class PagoComfirmadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago_comfirmado)

        //espero que la orden siga con nosostros en esta clase
        val orden: ArrayList<Product>? = intent.getParcelableArrayListExtra("orden")

        //obtenemos el estado actual de la base de datos de firebase
        val db = FirebaseDatabase.getInstance()
        //decimos como se llama la seccion de la base de datos donde vamos a escribir en
        val dbref = db.getReference("orden")

        //y simplemente ponemos los datos en la bd
        dbref.push().setValue(orden)

        //y regresamos a la pagina principal.
        var btn_principal: Button = findViewById(R.id.btn_principal)
        btn_principal.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}