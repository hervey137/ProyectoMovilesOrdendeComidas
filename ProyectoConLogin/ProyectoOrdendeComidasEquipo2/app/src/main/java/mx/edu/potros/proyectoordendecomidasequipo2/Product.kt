package mx.edu.potros.proyectoordendecomidasequipo2

import android.os.Parcel
import android.os.Parcelable

data class Product(
    var name: String,
    var image: Int,
    var description: String,
    var price: Double,
    var cantidadSeleccionada: Int = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(image)
        parcel.writeString(description)
        parcel.writeDouble(price)
        parcel.writeInt(cantidadSeleccionada)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun toMap(): Map<String, Any> {
        val productMap = HashMap<String, Any>()
        productMap["name"] = name
        productMap["description"] = description
        productMap["image"] = image
        productMap["price"] = price
        productMap["cantidadSeleccionada"] = cantidadSeleccionada
        return productMap
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}