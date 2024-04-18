package mx.edu.potros.proyectoordendecomidasequipo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnRollos: Button = findViewById(R.id.button_rollos) as Button
        var btnPlatillos: Button = findViewById(R.id.button_platillos) as Button
        var btnBebidas: Button = findViewById(R.id.button_bebidas) as Button
        var btnSopas: Button = findViewById(R.id.button_sopas) as Button
        var btnPagar: Button = findViewById(R.id.button_pago) as Button
        var btnMesas: Button = findViewById(R.id.button_mesas) as Button

        btnRollos.setOnClickListener {
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Rollos")
            startActivity(intent)
        }

        btnPlatillos.setOnClickListener {
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Platillos")
            startActivity(intent)
        }

        btnBebidas.setOnClickListener {
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Bebidas")
            startActivity(intent)
        }

        btnSopas.setOnClickListener {
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Sopas")
            startActivity(intent)
        }

        btnPagar.setOnClickListener {
            var intent: Intent = Intent(this, FormaPagoActivity::class.java)
            startActivity(intent)
        }
        btnMesas.setOnClickListener {
            var intent: Intent = Intent(this, SeatSelection::class.java)
            startActivity(intent)
        }
    }
}