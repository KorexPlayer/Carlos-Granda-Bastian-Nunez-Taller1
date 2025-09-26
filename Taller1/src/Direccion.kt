class Direccion (
    private var calle: String,
    private var numero: Int,
    private var ciudad: String,
    private var region: String
){
    //GETS
    fun getCalle(): String = calle
    fun getNumero(): Int = numero
    fun getCiudad(): String = ciudad
    fun getRegion(): String = region
    //SETS
    fun setCalle(newcalle: String) { calle = newcalle }
    fun setNumero(newnumero: Int) { numero = newnumero }
    fun setCiudad(newciudad: String) { ciudad = newciudad }
    fun setRegion(newregion: String) { region = newregion }

    //FUNCTIONS
    fun cambiarUbicacion(nuevacalle: String, nuevonumero: Int, nuevaciudad: String, nuevaregion: String) {
        setCalle(nuevacalle)
        setRegion(nuevaregion)
        setCiudad(nuevaciudad)
        setNumero(nuevonumero)
    }
    override fun toString(): String {
        return "#${getNumero()} ${getCalle()}, ${getCiudad()}, ${getRegion()}"
    }
}