error id: file:///C:/Users/jacds/Downloads/practica-scala/parte3/torneo-twenty-one/src/main/scala/Main.scala:scala/Array#length().
file:///C:/Users/jacds/Downloads/practica-scala/parte3/torneo-twenty-one/src/main/scala/Main.scala
empty definition using pc, found symbol in pc: scala/Array#length().
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -puntuaciones/length.
	 -puntuaciones/length#
	 -puntuaciones/length().
	 -scala/Predef.puntuaciones.length.
	 -scala/Predef.puntuaciones.length#
	 -scala/Predef.puntuaciones.length().
offset: 1469
uri: file:///C:/Users/jacds/Downloads/practica-scala/parte3/torneo-twenty-one/src/main/scala/Main.scala
text:
```scala
object Main extends App {
    val jugadores = List(
        "Alex",
        "Chen",
        "Marta",
        "Sindhu",
        "Luis"
    )

    val puntuaciones = Array(
        18,
        24,
        21,
        20,
        26
    )

    def bust(puntuacion: Int): Boolean ={
        if (puntuacion > 21)
            true
        else
            false
    }

    def estadoMano(puntuacion: Int): String ={
        val estado = bust(puntuacion)
        if (!estado)
            "VALIDA"
        else
            "BUST"
    }

    def mejorMano(handA: Int, handB: Int): Int ={
        if (handA > 21 && handB > 21){
            0
        }else if(handA > 21){
            handB
        }else if(handB > 21){
            handA
        }else{
            if (handA > handB)
                handA
            else
                handB
        }
    }

    // Funciones mias
    // Devuelve la cantidad de manos que hay con "VALID" o "BUST"
    // para esto se usa el parámetro buscar
    def contarManos(puntuaciones: Array[Int], buscar: String): Int ={
        var i = 0
        var cnt = 0
        while (i<puntuaciones.length){
            if (bust(puntuaciones(i)) == buscar)
                cnt += 1
        }
        cnt
    }

    // Devuelve la puntación más alta
    def mejorPuntuacion(puntuaciones: Array[Int]): Int ={
        var i = 0
        var mejor = 0
        while (i<puntuaciones.lengt@@h-1){
            mejor = mejorMano(puntuaciones(i), puntuaciones(i+1))
        }
        mejor
    }


    // Recorremos las colecciones
    var i = 0
    while (i < puntuaciones.length){
        val mano = puntuaciones(i)
        val jugador = jugadores(i)
        val estado = estadoMano(mano)

        println(s"$jugador -> $mano -> $estado")
        
        i+=1
    }

    // Resumen de la ronda
    println("\n--- Resumen de la ronda ---\n")
    println("Manos válidas: "+jugadores.length)
    println("Bust: "+jugadores.length)
    println("Mejor puntuación válida: "+mejorPuntuacion(puntuaciones))
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: scala/Array#length().