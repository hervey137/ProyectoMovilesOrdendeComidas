package mx.edu.potros.proyectoordendecomidasequipo2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class ProductosActivity : AppCompatActivity() {

    var menu: ArrayList<Product> = ArrayList<Product>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        var imagen: ImageView = findViewById(R.id.imageView)
        var menuOption: String? = intent.getStringExtra("menuType")
        agregarProductos(menuOption)

        var listview: ListView = findViewById(R.id.listView) as ListView

        var adaptador: AdaptadorProductos = AdaptadorProductos(this, menu)
        listview.adapter = adaptador

        //letreros

        when(menuOption) {
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
        when(option) {
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
    }

    private class AdaptadorProductos: BaseAdapter {
        var productos = ArrayList<Product>()
        var contexto: Context? = null

        constructor(contexto: Context, productos: ArrayList<Product>) {
            this.productos = productos
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(p0: Int): Any {
            return productos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var prod = productos[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.producto_view, null)

            var imagen = vista.findViewById(R.id.producto_img) as ImageView
            var nombre = vista.findViewById(R.id.producto_nombre) as TextView
            var desc = vista.findViewById(R.id.producto_desc) as TextView
            var precio = vista.findViewById(R.id.producto_precio) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")
            return vista
        }
    }
}