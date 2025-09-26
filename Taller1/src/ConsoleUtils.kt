class ConsoleUtils {
    fun leerLineaNoVacia(prompt: String): String{ return prompt }
    fun leerDouble(prompt: String): Double{ return prompt.toDouble() }
    fun leerInt(prompt: String): Int{ return prompt.toInt() }
    fun pause() {}
    fun formatearMonto(v: Double): String {
        var nuevo = ""
        var i = 1
        for(numero in v.toString()){
            nuevo += numero.toString()
            if (i%3 == 0){
                nuevo += "."
            }
            i += 1
        }
        return nuevo
    }
}