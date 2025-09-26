class Repositorio(
    val afps: List<AFP>,
    val empleados: MutableList<Empleado>,
    val liquidaciones: MutableList<LiquidacionSueldo>
) {
    //GETS
    fun getAfps(): List<AFP> = afps
    fun getEmpleados(): MutableList<Empleado> = empleados
    fun getLiquidaciones(): MutableList<LiquidacionSueldo> = liquidaciones

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
        println("Ingrese nombre de afp: ")
        val afp = readln()
        println("Ingrese la tasa de su afp")
        val tasa = readln().toDouble()
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
        println("Ingrese su periodo (YYYY-MM): ")
        val periodo: String = readln()
        val empleadonuevo = Empleado(rut, nombreEmpleado, base, AFP(afp, tasa), Direccion(calle, numero, ciudad, region), bonoimpo, bononoimpo)
        empleados.add(empleadonuevo)
        val liquidacion = LiquidacionSueldo(periodo, empleadonuevo, bonoimpo, bononoimpo, tasa, 0.07, 0.006, tasa+0.07+0.006, empleadonuevo.sueldoImponible())
        liquidaciones.add(liquidacion)
        println("EMPLEADO AGREGADO")
    }
    fun eliminarEmpleados(empleado: Empleado) {
        empleados.remove(empleado)
        println("EMPLEADO ELIMINADO")
    }
    fun filtrarEmpleadosporafp(){
        for (afp in afps){
            for (empleado in empleados){
                val tipo = empleado.getAfp()
                if (tipo == afp){
                    println(empleado.toString())
                }
            }
        }
    }

    //FUNCIONES LIQUIDACIONES
    fun generar_liquidacion(rut: String){
        val empleado = empleados.find { it.getRUT() == rut}

            if (empleado != null) {
                val liquidacionGenerada = LiquidacionSueldo(
                    periodo = periodo,
                    empleado = empleado,
                    imponible = 0.0,
                    noimponible = 0.0,
                    descAfp = 0.0,
                    descSalud = 0.0,
                    descCesantia = 0.0,
                    descuentos = 0.0,
                    liquido = 0.0
                ).calcular(periodo, empleado)

                liquidaciones.add(liquidacionGenerada)
                println("liquidacion generada correctamente")
                prinln(liquidacionGenerada.toString())
            }else {
                println("No se encontro el rut")
            }
        }
    }
    fun listar_liquidaciones(){
        for(liquidacion in liquidaciones){
            println(liquidacion.toString())
        }
    }
}