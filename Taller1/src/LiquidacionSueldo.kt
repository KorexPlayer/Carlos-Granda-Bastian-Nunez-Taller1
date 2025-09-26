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
        val descuentos = descAfp + descSalud + descCesantia
        val liquido = imponible - descuentos + noimponible

        return LiquidacionSueldo(
            periodo,
            empleado,
            imponible,
            noimponible,
            descAfp,
            descSalud,
            descCesantia,
            descuentos,
            liquido,
        )
    }
    override fun toString(): String{
        return """Periodo de empleado: ${getPeriodo()} 
            |Empleado: ${getEmpleado().toString()} 
            |Descuento por Salud: ${getDescSalud()} 
            |Descuento por Cesantia: ${getDescCesantia()} 
            |Descuento Total: ${getTotalDescuentos()}
            |Descuento AFP: ${getEmpleado().getAfp().getTasa()}""".trimMargin()
    }
}