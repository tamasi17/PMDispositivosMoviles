package intro

fun main() {


    ej1()
    ej2()
    ej3()
    ej4()
    saludar("Mati")

    println("Dame un numero")
    var a = readLine()!!.toInt()
    println("Dame otro numero")
    var b = readLine()!!.toInt()
    sumar(a,b)

    println("Dime tu edad")
    a = readLine()!!.toInt()
    ej7(a)

    // ej8
    mostrarMenu();

}


fun ej1() {
    var nombre: String = "Asuranceturix";
    println("Hola, $nombre");
}


fun ej2() {
    val nombre: String = "Mati"
    val edad: Int = 30
    val altura: Double = 1.99
    val esEstudiante: Boolean = true
    var soyEstudiante: String? = null

    if (esEstudiante) {
        soyEstudiante = "soy estudiante"
    } else {
        soyEstudiante = "no estudio na"
    }

    println("Mi nombre es $nombre, tengo $edad años, mido $altura cm y $soyEstudiante")
}


fun ej3() {
    val birth: Int = 1994
    var edad: Int = 29
    edad = 30


    println("Año: $birth \n Edad: $edad \n val es read-only, no se puede cambiar")
}

/*
Añado algunas combinaciones de llamadas a teclado
 */
fun ej4() {
    println("Dime tu edad:")

    // !! -> confío en que la entrada no es null; si lo es, lanza una excepción (NullPointerException)".
    val edad = readLine()!!.toInt()
    println("Dentro de 5 años tendrás: ${edad + 5}")

    // ?. — Safe call solo llama si no es null :
    println("Dime tu altura en cm:")
    val longitud = readln()?.length

    // ?: — Elvis operator : usa valor alternativo si es null
    println("Dame un nombre cualquiera")
    val nombre = readLine() ?: "Desconocido"

    // ?.let { ... } — Ejecuta solo si no es null
    // si no nombras parametro, puedes llamarlo con $it
    println("Dame un nombre mas guay ese es mu basico")
    readLine()?.let {
        println("Hola, $it")  // Solo se ejecuta si readLine() no es null
    }


}

/*
    Ej5: Saludar
 */
fun saludar(nombre: String) {
    println("Hola $nombre")
}

/*
Crea una función sumar(a: Int, b: Int): Int que devuelva la suma.
Pide los valores por consola y muestra el resultado usando la función.
 */
fun sumar(a: Int, b: Int){
    var suma = a+b
    println("La suma es: $suma")
}

/*
Crea una función esMayorDeEdad(edad: Int): Boolean que devuelva true si edad >= 18.
Desde main, pide la edad al usuario y muestra un mensaje disƟnto según el resultado.
 */
fun ej7(a: Int){
    var mayor: Boolean?
    if (a>=18){
        mayor = true
    println("Eres mayor de edad (boolean = $mayor)")
    } else {
        mayor = false
        println("No eres mayor de edad o has escrito mal (boolean = $mayor)")
    }
}

/*
Crea una función mostrarMenu() que imprima:
1. Saludar 2. Sumar dos numeros 3. Salir
Usa un when para ejecutar la opción elegida
 */
fun mostrarMenu(){


    var menu: Boolean = true;


    while (menu){


        println("1. Saludar")
        println("2. Sumar 2 numeros")
        println("3. Salir")


        var numero: Int = readLine()!!.toInt();


        when(numero) {
            1 -> {
                println("Dime tu nombre")
                var nombre: String = readLine()!!.toString()
                saludar(nombre)
            }
            2 -> {
                println("Dame 2 numeros para sumar: ")
                val a: Int = readLine()!!.toInt()
                val b: Int = readLine()!!.toInt()
                println("El resultado es: " + sumar(a, b))
            }
            3 -> {
                menu = false;
            }
        }
    }
}

