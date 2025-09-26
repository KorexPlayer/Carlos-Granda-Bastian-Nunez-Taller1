fun main() {
    var program = true
    val repo = Repositorio(listOf(AFP("Capital", 0.1154),AFP("Habitad", 0.1137),AFP("Modelo", 0.1068)), mutableListOf(), mutableListOf())
    while(program){
        println("""
            1.- Listar empleados
            2.- Agregar empleados
            3.- Generar liquidaciones por RUT
            4.- Listar liquidaciones
            5.- Filtrar empleados por AFP
            6.- Eliminar empleados
            7.- Salir del programa
        """.trimIndent())
        val select = readln().toInt()

        when(select){
            1 -> {repo.mostrarEmpleados()}// Listar empleados
            2 -> {
                repo.agregarEmpleados()
            }// Agregar empleados
            3 -> { print("Ingrese el RUT del empleado: ")
                val rut = readln()
                repo.generarLiquidacion(rut)}// Generar liquidacion por RUT

            4 -> {
                println() // Listar liquidaciones
                repo.listarLiquidaciones()
            }

            5 -> {
                repo.filtrarEmpleadosporafp()
                println() // Filtrar empleados por AFP
            }

            6 -> {
                print("RUT del empleado a eliminar: ")
                val rut = readln()
                repo.eliminarEmpleados(rut)
                println() // Eliminar empleados
            }

            7 -> {
                program = false
                println("Programa terminado.")
            }
        }
    }
}