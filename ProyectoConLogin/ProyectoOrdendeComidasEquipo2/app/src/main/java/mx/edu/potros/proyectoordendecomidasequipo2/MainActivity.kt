package mx.edu.potros.proyectoordendecomidasequipo2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnGetStarted = findViewById<Button>(R.id.btn_get_started)
        btnGetStarted.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                SignActivity::class.java
            )
            startActivity(intent)
        }
    }
}