package mx.edu.potros.proyectoordendecomidasequipo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)

        val button: Button = findViewById(R.id.signUpbutton)

        button.setOnClickListener {
            val intentLogin: Intent = Intent(this, RegisterActivity::class.java)
            startActivity(intentLogin)
        }
    }
}