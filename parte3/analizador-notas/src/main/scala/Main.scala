object Main extends App {
  val estudiantes = List(
    "Ana",
    "Luis",
    "Marta",
    "Pedro",
    "Sofia"
  )

  val notas = Array(
    8,
    4,
    10,
    6,
    3
  )

  def aprobado(nota: Int): Boolean ={
    if (nota >= 5)
      true
    else
      false
  }

  def estadoNota(nota: Int): String ={
    if (aprobado(nota))
      "APROBADO"
    else
      "SUSPENSO"
  }

  def maxNota(a: Int, b: Int): Int ={
    if (a > b)
      a
    else
      b
  }

  def clasificacion(nota: Int): String={
    if (nota >= 9)
      "EXCELENTE"
    else if(nota >= 7)
      "NOTABLE"
    else if(nota >= 5)
      "APROBADO"
    else
      "SUSPENSO"
  }

  // Funciones hechas por mi
  def contarNotas(notas: Array[Int], buscar: String): Int ={
    var i = 0
    var cnt = 0
    while (i<notas.length){
      if (estadoNota(notas(i)) == buscar)
        cnt += 1
      i+=1
    }
    cnt
  }

  // Devuelve la puntación más alta
  def mejorNota(puntuaciones: Array[Int]): Int ={
    var i = 1
    var mejor = puntuaciones(0)
    while (i<puntuaciones.length){
      mejor = maxNota(mejor, puntuaciones(i))
      i+=1
    }
    mejor
  }

  // Listado de estudiantes
  var i = 0
  while (i < notas.length){
    val nota = notas(i)
    val estudiante = estudiantes(i)
    val estado = estadoNota(nota)

    println(s"$estudiante -> $nota -> $estado")

    i+=1
  }

  // Resumen de la ronda
  println("\n--- Resumen del grupo ---\n")
  println("Estudiantes: "+estudiantes.length)
  val aprobados_primera_eva = contarNotas(notas, "APROBADO")
  println("Aprobados: "+aprobados_primera_eva)
  println("Suspensos: "+contarNotas(notas, "SUSPENSO"))
  val mejor_nota_primera_eva = mejorNota(notas)
  println("Mejor nota: "+mejor_nota_primera_eva)

  // Mostramos la clasificación adicional
  i = 0
  while (i < notas.length) {
    val nota = notas(i)
    val estudiante = estudiantes(i)
    val clasi = clasificacion(nota)

    println(s"$estudiante -> $nota -> $clasi")

    i += 1
  }


  // Segunda evaluación
  val notasSegundaEvaluacion = Array(
    9,
    5,
    8,
    7,
    6
  )

  // Listado de estudiantes
  i = 0
  while (i < notasSegundaEvaluacion.length){
    val nota = notasSegundaEvaluacion(i)
    val estudiante = estudiantes(i)
    val estado = estadoNota(nota)

    println(s"$estudiante -> $nota -> $estado")

    i+=1
  }

  // Resumen de la ronda
  println("\n--- Resumen del grupo ---\n")
  println("Estudiantes: "+estudiantes.length)
  val aprobados_segunda_eva = contarNotas(notasSegundaEvaluacion, "APROBADO")
  println("Aprobados: "+aprobados_segunda_eva)
  println("Suspensos: "+contarNotas(notasSegundaEvaluacion, "SUSPENSO"))
  val mejor_nota_segunda_eva = mejorNota(notasSegundaEvaluacion)
  println("Mejor nota: "+mejor_nota_segunda_eva)

  // Mostramos la clasificación adicional
  i = 0
  while (i < notasSegundaEvaluacion.length) {
    val nota = notasSegundaEvaluacion(i)
    val estudiante = estudiantes(i)
    val clasi = clasificacion(nota)

    println(s"$estudiante -> $nota -> $clasi")

    i += 1
  }

  // Comparación de evaluaciones
  println("\n\n--- Comparación de evaluaciones ---\n")

  println(s"Mejor nota de la primera evaluación: $mejor_nota_primera_eva")
  println(s"Mejor puntuación de la segunda ronda: $mejor_nota_segunda_eva")
  println(s"Número de aprobado en la primera evaluación: $aprobados_primera_eva")
  println(s"Número de aprobado en la segunda evaluación: $aprobados_segunda_eva")
  if (aprobados_primera_eva > aprobados_segunda_eva)
    println("Ha empeorado.")
  else if (aprobados_primera_eva < aprobados_segunda_eva)
    println("Ha mejorado.")
  else
    println("Se ha mantenido igual.")


  // Uso de listas
  val nuevosEstudiantes = "Christian" :: estudiantes

  println(estudiantes)
  println(nuevosEstudiantes)
}
