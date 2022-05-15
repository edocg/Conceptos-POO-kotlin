package `androidKotlin-repo`
fun main(){

    val precioGerente: Double = 200.0
    val precioOperador: Double = 10.0
    val precioContador: Double  = 50.0

    val horasLabsGerente: Int = 200
    val horasLabsOperador: Int = 230
    val horasLabsContador: Int = 200

    print("Ingrese Rol del empleado 1.Gerente, 2.Operador, 3.Contador: ")
    val Rol = readLine()
    print("Cuantas horas laboro?, un valor menor a 288 horas: ")
    val horas = readLine()!!.toInt()

    val precio = when (Rol) {
        "1" -> precioGerente
        "2" -> precioOperador
        "3" -> precioContador
        else -> "$Rol is invalid rol."
    }

    val horasLaborales = when (Rol) {
        "1" -> horasLabsGerente
        "2" -> horasLabsOperador
        "3" -> horasLabsContador
        else -> "$Rol is invalid rol."
    }
    println("El salario es ${(precio as Double) * horas } y su bonus es ${(horas - (horasLaborales as Int)) * (precio as Double)}")

}


