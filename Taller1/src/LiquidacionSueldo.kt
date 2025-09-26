class LiquidacionSueldo(
    private val periodo: String /*"YYYY-MM"*/,
    private val empleado: Empleado,
    private val imponible: Double,
    private val noimponible: Double,
    private val descAfp: Double,
    private val descSalud: Double = 0.07,
    private val descCesantia: Double = 0.006,
    private val totalDescuentos: Double,
    private val sueldoLiquido: Double
) {
    //GETS
    fun getPeriodo(): String = periodo
    fun getEmpleado(): Empleado = empleado
    fun getImponible(): Double = imponible
    fun getNoimponible(): Double = noimponible
    fun getDescSalud(): Double = descSalud
    fun getDescCesantia(): Double = descCesantia
    fun getTotalDescuentos(): Double = totalDescuentos
    fun getSueldoLiquido(): Double = sueldoLiquido
    fun getDescAfp(): Double = descAfp
    //FUNCTIONS
    fun calcular(periodo: String, empleado: Empleado, tasaSalud: Double = 0.07, tasaCesantia: Double = 0.006): LiquidacionSueldo{
        val imponible = empleado.sueldoImponible()
        val noimponible = empleado.getbonosnoImpo()
        val descAfp = imponible * empleado.getAfp().getTasa()
        val descSalud = imponible * tasaSalud
        val descCesantia = imponible * tasaCesantia
        val totaldescuentos = descAfp + descSalud + descCesantia
        val sueldoliquido = (imponible - totaldescuentos) + noimponible

        return LiquidacionSueldo(
            periodo,
            empleado,
            imponible,
            noimponible,
            descAfp,
            descSalud,
            descCesantia,
            totaldescuentos,
            sueldoliquido,
        )
    }
    override fun toString(): String{
        return """Periodo de empleado: ${getPeriodo()} 
            |Nombre Empleado: ${getEmpleado().getNombre()}
            |Rut: ${getEmpleado().getRUT()}
            |Sueldo Base: ${getEmpleado().getSueldoBase()}
            |Afp: ${getEmpleado().getAfp()}
            |Sueldo Imponible: ${getImponible()}
            |Sueldo no Imponible: ${getNoimponible()}
            |Descuento por Salud: ${getDescSalud()} 
            |Descuento por Cesantia: ${getDescCesantia()} 
            |Descuento AFP: ${getDescAfp()}
            |Descuento Total: ${getTotalDescuentos()}
            |Sueldo Liquido: ${getSueldoLiquido()}
            """.trimMargin()


            
    }
}