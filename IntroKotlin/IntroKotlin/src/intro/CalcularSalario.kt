package intro

import java.util.Scanner

fun main() {

    calcularSalario()
}

/** Metodo que calcula el salario
 * @param salario is Double
 */
private fun calcularSalario() {

    var pago = 50.50
    val jornadaCompleta = 40
    var salario : Double? = null

    val sc = Scanner(System.`in`)

    println("Cuantas horas trabajas a la semana?")

    var horasTrabajadas = sc.nextInt()

    if (horasTrabajadas > jornadaCompleta) {
        var horasExtra = horasTrabajadas - 40
        salario = (horasTrabajadas - horasExtra) * 50.50 + horasExtra * (50.50 + 25.25)
        println("Horas extra: $horasExtra")
    } else {
        salario = horasTrabajadas * 50.50
    }

    println("Tu salario es $salario")
}