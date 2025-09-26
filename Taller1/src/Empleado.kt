class Empleado(
    private var rut: String,
    private var nombre: String,
    private var sueldobase: Double,
    private var afp: AFP,
    private var direccion: Direccion,
    private var bonosimponibles: Double = 0.0,
    private var bonosnoimponibles: Double = 0.0
) {
    //SETS Y GETS
    fun getRUT(): String = rut
    fun getNombre(): String = nombre
    fun getSueldoBase(): Double = sueldobase
    fun getAfp(): AFP = afp
    fun getDireccion(): Direccion = direccion
    fun getbonosImpo(): Double = bonosimponibles
    fun getbonosnoImpo(): Double = bonosnoimponibles

    fun setRUT(nuevorut: String) {rut = nuevorut}
    fun setNombre(nuevonombre: String) {nombre = nuevonombre}
    fun setSueldoBase(nuevosueldobase: Double) {sueldobase = nuevosueldobase}
    fun setAfp(nuevonombre: String, nuevatasa: Double) {afp.cambiarAfp(nuevonombre, nuevatasa)}
    fun setDireccion(nuevacalle: String, nuevonumero: Int, nuevaciudad: String, nuevaregion: String) {direccion.cambiarUbicacion(nuevacalle, nuevonumero, nuevaciudad, nuevaregion)}
    //Funciones
    fun cambiarAtributos(){
        println("""1.- Cambiar rut
            |2.- Cambiar nombre
            |3.- Cambiar Direccion
            |4.- Cambiar Sueldo Base
            |5.- Cambiar AFP
        """.trimMargin())
        val opcion = readln().toInt()
        when(opcion){
            1->{print("Ingrese el nuevo rut: ")
                val nuevorut =readln()
                setRUT(nuevorut)}
            2->{print("Ingrese el nuevo nombre: ")
            val nuevonombre = readln()
            setNombre(nuevonombre)}
            3->{print("Ingrese la nueva direccion: ")
            val nuevaciudad = readln()
            val nuevacalle}

        }
    }
    fun sueldoImponible(): Double {
        val sueldoimponible = getSueldoBase() + getbonosImpo()
        return sueldoimponible
    }


    override fun toString(): String {
        return """Nombre: ${getNombre()}
            |RUT: ${getRUT()}
            |Sueldo Base: ${getSueldoBase()}
            |AFP: ${getAfp().toString()}
            |Direccion: ${getDireccion().toString()}
            |Bonos imponibles: ${getbonosImpo()}
            |Bonos no Imponibles ${getbonosnoImpo()}""".trimMargin()
    }


}