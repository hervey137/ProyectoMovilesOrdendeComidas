package mx.edu.potros.proyectoordendecomidasequipo2

import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class ProductosActivity : AppCompatActivity() {

    var menu: ArrayList<Product> = ArrayList<Product>()
    lateinit var adaptador: AdaptadorProductos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        var imagen: ImageView = findViewById(R.id.imageView)
        var menuOption: String? = intent.getStringExtra("menuType")

        var listview: ListView = findViewById(R.id.listView) as ListView

        adaptador = AdaptadorProductos(this, menu)
        listview.adapter = adaptador

        agregarProductos(menuOption)

        val btnFinalizarPedido = findViewById<Button>(R.id.btnFinalizarPedido)

        btnFinalizarPedido.setOnClickListener {
            val totalCompra = calcularTotalCompra()

            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Total de la Compra")
            alertDialogBuilder.setMessage("El total a pagar es: $${"%.2f".format(totalCompra)}")
            alertDialogBuilder.setPositiveButton("Aceptar") { _, _ ->
                // Aquí puedes agregar lógica adicional cuando el usuario acepte el total
            }
            alertDialogBuilder.setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }

            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }

        when (menuOption) {
            "Rollos" -> {
                imagen.setImageResource(R.mipmap.sushiletrasbanner)
            }
            "Platillos" -> {
                imagen.setImageResource(R.mipmap.platillo)
            }
            "Bebidas" -> {
                imagen.setImageResource(R.mipmap.bebidas)
            }
            "Sopas" -> {
                imagen.setImageResource(R.mipmap.sopas)
            }
        }
    }

    fun agregarProductos(option: String?) {
        when (option) {
            "Rollos" -> {
                menu.add(Product("California Tradicional", R.mipmap.californiatradicional, "Pepino, aguacate, phila y un ingrediente: res, marlin, tocino, pollo, plátano, chile toreado, camarón, surimi o tampico.", 120.00))
                menu.add(Product("Teriyaki Roll", R.mipmap.teriyakiroll, "Aguacate, queso phila, pepino, pollo y zanahoria con salga teriyaki y ajonjolí.", 135.00))
                menu.add(Product("Manchego Roll", R.mipmap.manchegoroll, "Pepino, aguacate, queso phila, tocino, res y gratinado con queso manchego.", 155.00))
                menu.add(Product("Cosmo Roll", R.mipmap.cosmoroll, "Pepino, aguacate, queso phila, camarón por dentro y salmón por fuera.", 155.00))
            }
            "Platillos" -> {
                menu.add(Product("Gohan", R.mipmap.gohan, "Tazón de arroz blanco con queso phila, tampico y furikake.", 100.00))
                menu.add(Product("Tepanyaki", R.mipmap.teppanyaki, "Riquísimas verduras salteadas (cebolla, brócoli, zanahoria, chile morrón, apio y calabaza) servido en una cama de arroz blanco o arroz frito, bañado con salsa de la casa y ajonjolí espolvoreado. Ingredientes a elegir: camarón, pollo o res. Extra: \$30", 160.00))
                menu.add(Product("Chicharrones de Atun", R.mipmap.chicharronesdeatun, "Trozos de atún fritos sazonados y acompañados de una salsa de aceite y semillas con un toque cítrico.", 170.00))
            }
            "Bebidas" -> {
                menu.add(Product("Limonada de Frutos Rojos", R.mipmap.limonadafrutosrojos, "Limonada de Frutos Rojos", 50.00))
                menu.add(Product("Te 1/2 L", R.mipmap.te, "Te 1/2 L", 35.00))
                menu.add(Product("Limonada Natural", R.mipmap.limonadanatural, "Limonada Natural", 40.00))
                menu.add(Product("Refresco 600ml", R.mipmap.refresco600ml, "Refresco 600ml", 35.00))
                menu.add(Product("Agua 330ml", R.mipmap.agua330ml, "Agua 330ml", 35.00))
            }
            "Sopas" -> {
                menu.add(Product("Sopa Udón", R.mipmap.sopaudon, "Pasta de fideos gruesos acompañado de vegetales, hongo shitake y proteína a elegir. Puede ser Vegetariana,pollo,camaron", 105.00))
                menu.add(Product("Sopa Udón Spicy", R.mipmap.sopaudonspicy, "Pasta de fideos gruesos acompañados de vegetales y hongos shitake, sazonada con exquisito toque picosito. Puede ser Vegetariana,pollo,camaron", 110.00))
            }
        }
        adaptador.notifyDataSetChanged() // Notificar al adaptador de los cambios en los datos
    }

    private fun calcularTotalCompra(): Double {
        var total = 0.0
        for (producto in menu) {
            val cantidad = producto.cantidadSeleccionada
            if (cantidad > 0) {
                total += producto.price * cantidad
            }
        }
        return total
    }

    class AdaptadorProductos(contexto: Context, productos: ArrayList<Product>) :
        BaseAdapter() {

        private val productos = productos
        private val contexto = contexto

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val prod = productos[position]
            val inflador = LayoutInflater.from(contexto)
            val vista = inflador.inflate(R.layout.producto_view, null)

            val imagen = vista.findViewById<ImageView>(R.id.producto_img)
            val nombre = vista.findViewById<TextView>(R.id.producto_nombre)
            val desc = vista.findViewById<TextView>(R.id.producto_desc)
            val precio = vista.findViewById<TextView>(R.id.producto_precio)
            val btnAgregar = vista.findViewById<Button>(R.id.btnAgregar)
            val btnEliminar = vista.findViewById<Button>(R.id.btnEliminar)
            val textViewCantidad = vista.findViewById<TextView>(R.id.textViewCantidad)

            imagen.setImageResource(prod.image)
            nombre.text = prod.name
            desc.text = prod.description
            precio.text = "$${prod.price}"
            textViewCantidad.text = prod.cantidadSeleccionada.toString()

            btnAgregar.setOnClickListener {
                prod.cantidadSeleccionada++
                textViewCantidad.text = prod.cantidadSeleccionada.toString()
            }

            btnEliminar.setOnClickListener {
                if (prod.cantidadSeleccionada > 0) {
                    prod.cantidadSeleccionada--
                    textViewCantidad.text = prod.cantidadSeleccionada.toString()
                }
            }

            return vista
        }
    }
}