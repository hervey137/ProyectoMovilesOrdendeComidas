package mx.edu.potros.proyectoordendecomidasequipo2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnRegister: Button = findViewById(R.id.btn_register)

        btnRegister.setOnClickListener {
            // Simular una sesión iniciada al presionar el botón de registro
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish() // Opcional: cerrar LoginActivity para evitar volver atrás con el botón de retroceso
        }
    }
}