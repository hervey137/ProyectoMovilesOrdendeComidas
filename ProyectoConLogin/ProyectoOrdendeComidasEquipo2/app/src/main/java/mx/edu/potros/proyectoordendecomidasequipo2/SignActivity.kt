package mx.edu.potros.proyectoordendecomidasequipo2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import mx.edu.potros.proyectoordendecomidasequipo2.MainActivity
import mx.edu.potros.proyectoordendecomidasequipo2.R

class SignActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val emailEditText = findViewById<EditText>(R.id.editText_email)
        val passwordEditText = findViewById<EditText>(R.id.editText_password)
        val buttonSignup = findViewById<Button>(R.id.button_signup)
        val btn_registrarse = findViewById<Button>(R.id.btn_registrarse)

        btn_registrarse.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)}

        auth = FirebaseAuth.getInstance()

        buttonSignup.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Obtener el ID de usuario actual
                            val userId = FirebaseAuth.getInstance().currentUser?.uid
                            // Guardar información de usuario en la base de datos de autenticación
                            FirebaseDatabase.getInstance().getReference("users").child(userId.toString()).setValue(email)
                            // Redirigir al MainActivity
                            val intent = Intent(this, MenuActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            // Manejar el error de inicio de sesión
                            Toast.makeText(this, "La autenticación falló.", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                // Mostrar mensaje de campos vacíos
                Toast.makeText(this, "Por favor rellena todos los campos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}