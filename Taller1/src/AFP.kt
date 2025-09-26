class AFP (
    private var nombre: String,
    private var tasa: Double
){
    //GET Y SET
    fun getNombre(): String = nombre
    fun setNombre(newnombre: String) { nombre = newnombre }
    fun getTasa(): Double = tasa
    fun setTasa(newtasa: Double) { tasa = newtasa }
    //Funciones
    fun cambiarAfp(nuevonombre: String, nuevatasa: Double) {
        setNombre(nuevonombre)
        setTasa(nuevatasa)
    }
    override fun toString(): String {
        return "Nombre: ${getNombre()}, tasa: ${getTasa()}"
    }
}