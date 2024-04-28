package mx.edu.potros.proyectoordendecomidasequipo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class PagoConfirmadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago_comfirmado)
    }

    fun onConfirmButtonClick(view: View) {
        // Iniciar la actividad PagoConfirmadoActivity
        val intent = Intent(this, PagoConfirmadoActivity::class.java)
        startActivity(intent)
    }
}