error id: file:///C:/Users/jacds/Downloads/practica-scala/parte3/torneo-twenty-one/src/main/scala/Main.scala:
file:///C:/Users/jacds/Downloads/practica-scala/parte3/torneo-twenty-one/src/main/scala/Main.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -mejor_puntuacion_segunda_rondamejor_puntuacion_primera_ronda.
	 -mejor_puntuacion_segunda_rondamejor_puntuacion_primera_ronda#
	 -mejor_puntuacion_segunda_rondamejor_puntuacion_primera_ronda().
	 -scala/Predef.mejor_puntuacion_segunda_rondamejor_puntuacion_primera_ronda.
	 -scala/Predef.mejor_puntuacion_segunda_rondamejor_puntuacion_primera_ronda#
	 -scala/Predef.mejor_puntuacion_segunda_rondamejor_puntuacion_primera_ronda().
offset: 3809
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
            if (estadoMano(puntuaciones(i)) == buscar)
                cnt += 1
            i+=1
        }
        cnt
    }

    // Devuelve la puntación más alta
    def mejorPuntuacion(puntuaciones: Array[Int]): Int ={
        var i = 1
        var mejor = puntuaciones(0)
        while (i<puntuaciones.length){
            mejor = mejorMano(mejor, puntuaciones(i))
            i+=1
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
    println("Jugadores: "+jugadores.length)
    println("Manos válidas: "+contarManos(puntuaciones, "VALID"))
    println("Bust: "+contarManos(puntuaciones, "BUST"))
    val mejor_puntuacion_primera_ronda = mejorPuntuacion(puntuaciones) 
    println("Mejor puntuación válida: "+mejor_puntuacion_primera_ronda)


    // Segunda ronda
    val puntuacionesRonda2 = Array(
        22,
        19,
        20,
        21,
        17
    )

    println("\n\n--- SEGUNDA RONDA ---\n")
    
    // Recorremos las colecciones
    i = 0
    while (i < puntuacionesRonda2.length){
        val mano = puntuacionesRonda2(i)
        val jugador = jugadores(i)
        val estado = estadoMano(mano)

        println(s"$jugador -> $mano -> $estado")
        
        i+=1
    }

    // Resumen de la ronda
    println("\n--- Resumen de la ronda ---\n")
    println("Jugadores: "+jugadores.length)
    println("Manos válidas: "+contarManos(puntuaciones, "VALID"))
    println("Bust: "+contarManos(puntuaciones, "BUST"))
    val mejor_puntuacion_segunda_ronda = mejorPuntuacion(puntuaciones) 
    println("Mejor puntuación válida: "+mejor_puntuacion_segunda_ronda)


    // Comparación de rondas
    println("\n\n--- Comparación de rondas ---\n")

    println(s"Mejor puntuación de la primera ronda: $mejor_puntuacion_primera_ronda")
    println(s"Mejor puntuación de la segunda ronda: $mejor_puntuacion_segunda_ronda")
    if (mejor_puntuacion_primera_ronda > mejor_puntuacion_segunda_ronda)
        println(s"La primera ronda tuvo una mejor puntuación: $mejor_puntuacion_primera_ronda > $mejor_puntuacion_segunda_ronda")
    else if (mejor_puntuacion_primera_ronda < mejor_puntuacion_segunda_ronda)
        println(s"La segunda ronda tuvo una mejor puntuación: $mejor_puntuacion_segunda_rondamejo@@r_puntuacion_primera_ronda > $mejor_puntuacion_segunda_ronda")
    else
        println(s"Ambas rondas tuvieron la misma mejor puntuación: $mejor_puntuacion_primera_ronda")
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: 