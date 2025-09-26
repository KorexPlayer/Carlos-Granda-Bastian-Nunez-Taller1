fun main() {
    var program = true
    var repo = Repositorio()
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
            3 -> {
                println() // Generar liquidacion por RUT
            }

            4 -> {
                println() // Listar liquidaciones
                repo.listar_liquidaciones()
            }

            5 -> {
                repo.filtrarEmpleadosporafp()
                println() // Filtrar empleados por AFP
            }

            6 -> {
                println() // Eliminar empleados
            }

            7 -> {
                program = false
                println("Programa terminado.")
            }
        }
    }
}