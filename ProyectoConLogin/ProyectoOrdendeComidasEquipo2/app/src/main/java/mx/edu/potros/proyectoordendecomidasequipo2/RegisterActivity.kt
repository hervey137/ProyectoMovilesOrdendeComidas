package mx.edu.potros.proyectoordendecomidasequipo2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import mx.edu.potros.proyectoordendecomidasequipo2.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        binding.btnRegister.setOnClickListener {
            val email = binding.emailInput.text.toString()
            val password = binding.passwordInput.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(baseContext, "Por favor rellena todos los campos.", Toast.LENGTH_SHORT).show()
            } else {
                registerUser(email, password)
            }
        }
    }

    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    user?.let {
                        val userId = user.uid
                        val userData = hashMapOf(
                            "email" to email,
                            "password" to password
                            // Agrega otros datos que desees guardar
                        )
                        database.reference.child("users").child(userId).setValue(userData)
                    }
                    // Registro exitoso, redirigir a SignActivity
                    val intent = Intent(this, SignActivity::class.java)
                    startActivity(intent)
                    finish() // Finalizar la actividad actual para evitar volver aquí al presionar atrás
                } else {
                    // Registro fallido, mostrar mensaje de error
                    Log.w("TAG", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Registro fallido. Inténtalo de nuevo.", Toast.LENGTH_SHORT).show()
                }
            }
    }
}