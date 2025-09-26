class Repositorio(
    val afps: List<AFP>,
    val empleados: MutableList<Empleado>,
    val liquidaciones: MutableList<LiquidacionSueldo>
) {

    //FUNCIONES EMPLEADOS
    fun mostrarEmpleados() {
        for(empleado in empleados){
            println(empleado.toString())
        }
    }
    fun agregarEmpleados() {
        println("Ingrese el nombre del empleado: ")
        val nombreEmpleado: String = readln()
        println("Ingrese el RUT: ")
        val rut: String = readln()
        println("Ingrese el sueldo base: ")
        val base: Double = readln().toDouble()
        println("AFPs disponibles:")
        for (afp in afps) {
            println(afp.toString())
        }
        print("Escoge un afp (1-3):")
        val eleccion: Int = readln().toInt()
        val nafp: AFP = afps[eleccion - 1]
        println("Ingrese el numero de su casa: ")
        val numero = readln().toInt()
        println("Ingrese calle de su casa: ")
        val calle = readln()
        println("Ingrese la Ciudad: ")
        val ciudad = readln()
        println("Ingrese la region: ")
        val region = readln()
        println("Ingrese bono imponible: ")
        val bonoimpo: Double = readln().toDouble()
        println("Ingrese bono no imponible: ")
        val bononoimpo: Double = readln().toDouble()
        val empleadonuevo = Empleado(rut, nombreEmpleado, base, nafp, Direccion(calle, numero, ciudad, region), bonoimpo, bononoimpo)
        empleados.add(empleadonuevo)
        println("Ingrese su periodo (YYYY-MM): ")
        val periodo: String = readln()
        val liquidacion = LiquidacionSueldo(periodo, empleadonuevo, bonoimpo, bononoimpo, nafp.getTasa(), 0.07, 0.006, nafp.getTasa()+0.07+0.006, empleadonuevo.sueldoImponible())
        liquidaciones.add(liquidacion)
        println("EMPLEADO AGREGADO")
    }
    fun eliminarEmpleados(rut: String) {
        val liqui = liquidaciones.find { it.getEmpleado().getRUT() == rut }
        val emple = empleados.find { it.getRUT() == rut }
        if (liqui != null) {
            liquidaciones.remove(liqui)
            empleados.remove(emple)
        }
        println("EMPLEADO ELIMINADO")
    }
    fun filtrarEmpleadosporafp(){
        for (afp in afps){
            println("-----------------------------------------")
            println(afp.toString())
            for (empleado in empleados){
                val tipo = empleado.getAfp()
                if (tipo == afp){
                    println("++++++++++++++++++++++++++++++++++++")
                    println(empleado.toString())
                    println("++++++++++++++++++++++++++++++++++++")
                }
            }
            println("-----------------------------------------")
        }
    }

    //FUNCIONES LIQUIDACIONES
    fun generarLiquidacion(rut: String){
        val empleado = empleados.find { it.getRUT() == rut}
        if (empleado != null) {
            println("Ingrese su periodo (YYYY-MM): ")
            val periodo: String = readln()
            val liquidacionGenerada = LiquidacionSueldo(
                periodo = periodo,
                empleado = empleado,
                imponible = 0.0,
                noimponible = 0.0,
                descAfp = empleado.getAfp().getTasa(),
                descSalud = 0.0,
                descCesantia = 0.0,
                totalDescuentos = 0.0,
                sueldoLiquido = 0.0
                ).calcular(periodo, empleado)

                liquidaciones.add(liquidacionGenerada)
                println("liquidacion generada correctamente")
                println(liquidacionGenerada.toString())
        }else {
                println("No se encontro el rut")
        }
    }
    fun listarLiquidaciones(){
        for(liquidacion in liquidaciones){
            println(liquidacion.toString())
        }
    }
}