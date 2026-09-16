## 1.1 Entorno 1 — JupyterLab + Almond Kernel + Scala 2.12.21

Ahora debemos descargar Python, para ello accedemos a esta página [python.org/downloads/release/python-3129](https://www.python.org/downloads/release/python-3129/) y nos descargamos la versión 3.12 que es la que se recomienda

![Descargar Python](../images/01_DescargarPython.png)

Una vez descargado procedemos a su instalación marcando la casilla 'ADD TO PATH'.

![Instalación Python](../images/02_InstalacionPython.png)

Abrimos un cmd y ejecutamos 'python --version' para comprobar que lo tenemos instalado

![Versión Python](../images/03_VersionPython.png)

Teniendo miniconda o anaconda y python instalado y funcionando pasamos a la instalación de JupyterLab.
Abrimos un cmd y escribimos 'pip install jupyterlab'

![Descargando JupyterLab](../images/04_DescargandoJupyterLab.png)

Pasamos a descargarnos Java SDK 17, accedemos a esta página y bajamos hasta Windows [oracle.com/java/technologies/javase/jdk17-archive-downloads](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

![Descargar Java SDK 17](../images/05_DescargarJavaSDK17.png)

Durante el asistente de instalación debemos marcar la casilla de ADD TO JAVA_HOME, en caso de que no salga como es mi caso, debemos abrir la aplicación 'EDITAR VARIABLES DE ENTORNO' de windows y agregar la nueva variable como se puede observar en la imagen

![Java SDK en JAVA_HOME](../images/06_JavaSDKEnJAVA_HOME.png)

Ahora en un nuevo cmd comprobamos la versión

![Versión Java SDK](../images/07_VersionJavaSDK.png)

Ahora instalaremos el kernel de Almond y Scala 2.12.21. Para ello debemos descargarnos coursier y coursier.bat desde este enlace [github.com/coursier/launchers](https://github.com/coursier/launchers) que nos permitirá instalar tanto el kernel como scala de la forma más sencilla

![Descargar Coursier](../images/08_DescargarCoursier.png)

Debemos dirigirnos a la carpeta en la que lo hayamos descargado y ejecutar el comando `coursier.bat launch almond:0.14.5 --scala 2.12.21 -- --install`

![Instalar kernel Scala](../images/09_InstalarKernelScala.png)

Nos dirigimos a la carpeta en la que queremos tener nuestro workspace y ejecutamos el comando 'jupyter lab'

![Ejecutar JupyterLab](../images/10_EjecutarJupyterLab.png)

Abrimos jupyterlab en el navegador usando la URL proporcionada por el propio comando y debemos ver la opción de Scala

![Notebook Scala](../images/11_NotebookScala.png)

Para comprobar que funciona vamos a pulsar sobre el icono de Scala (dentro del apartado de notebook) y guardaremos el notebook de Scala en nuestro workspace

![Guardar notebook Scala](../images/12_GuardarNotebookScala.png)

**Prueba 01:** Verificar versión exacta de Scala

![Prueba 01 Scala](../images/13_Prueba01Scala.png)

**Prueba 02:** Ejecutar el código de prueba

![Prueba 02 Scala](../images/14_Prueba02Scala.png)

## 1.2 Entorno 2 — Visual Studio Code + Metals + Scala 2.12.21 + JDK 17 + sbt

Instalamos Java SDK 17 (este paso es el mismo que los anteriores).
Pasamos a descargarnos Java SDK 17, accedemos a esta página y bajamos hasta Windows [oracle.com/java/technologies/javase/jdk17-archive-downloads](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

![Descargar Java SDK 17](../images/05_DescargarJavaSDK17.png)

Durante el asistente de instalación debemos marcar la casilla de ADD TO JAVA_HOME, en caso de que no salga como es mi caso, debemos abrir la aplicación 'EDITAR VARIABLES DE ENTORNO' de windows y agregar la nueva variable como se puede observar en la imagen

![Java SDK en JAVA_HOME](../images/06_JavaSDKEnJAVA_HOME.png)

Ahora en un nuevo cmd comprobamos la versión

![Versión Java SDK](../images/07_VersionJavaSDK.png)

Instalamos Visual Studio Code desde [code.visualstudio.com](https://code.visualstudio.com/) y simplemente seguimos el asistente de instalación

![Descargar VSCode](../images/15_DescargarVSCode.png)

Una vez dentro de VSCode nos vamos a extensiones (ctrl+shift+x) y buscamos Scala (Metals)

![Buscamos extensión](../images/16_BuscamosExtension.png)
![Scala Metals instalado](../images/17_ScalaMetalsInstalado.png)

Pasamos a instalar sbt, para esto nos dirigimos a su GitHub [github.com/sbt/sbt/releases](https://github.com/sbt/sbt/releases) y descargamos la última versión

![Descargar SBT](../images/18_DescargarSBT.png)

Seguimos el asistente de instalación y en cuestión de segundos ya lo tendremos instalado

![Instalar SBT](../images/19_InstalarSBT.png)

Para comprobar si se ha instalado correctamente, abrimos un cmd y ejecutamos `sbt --version`

![Versión SBT](../images/20_VersionSBT.png)

Con todo lo necesario, abrimos la carpeta que vamos a usar como workspace con VSCode y creamos la estructura del proyecto

```
scala-vscode/
├── build.sbt
├── project/
└── src/
    └── main/
        └── scala/
            └── Main.scala
```

![Estructura de carpetas](../images/21_EstructuraCarpetas.png)

Dentro del fichero build.sbt debemos indicar el nombre del proyecto, la versión del proyecto y la versión de scala

![Contenido build.sbt](../images/22_ContenidoScalaSBT.png)

Dentro del fichero Main.scala creamos un pequeño programa

![Contenido Main.scala](../images/23_ContenidoMainScala.png)

Al tener la extensión de Scala (Metals) se nos crean varios directorios nuevos que permanecen ocultos por defecto

![Nuevos directorios](../images/24_NuevosDirectorios.png)

Para comprobar si nuestro proyecto funciona, en VSCode abrimos una nueva terminal (ctrl+ñ) y ejecutamos `sbt compile`

![Compilar Scala](../images/26_CompileScala.png)

Es probable que no se pueda usar `sbt compile` y te pida usar antes `sbt new` o `sbt --allow-empty`. En este caso, puedes usar `sbt --allow-empty` y luego `sbt compile` ya que usando `sbt new` te obligará a seleccionar un template para poder continuar.

![SBT allow empty](../images/25_SBTAllowEmpty.png)

Después de compilar ejecutamos `sbt run` para lanzar el programa

![Scala ejecutado](../images/27_ScalaEjecutado.png)

## 1.3 Entorno 3 — IntelliJ IDEA Community + Scala 2.12.21 + sbt

Nos dirigimos a [jetbrains.com/es-es/idea/download](https://www.jetbrains.com/es-es/idea/download/?section=windows) y pulsamos el botón de Descargar

![Descargar IntelliJ](../images/28_DescargarIntelliJ.png)

Seguimos el asistente de instalación. Podemos marcar el checkbox 'ADD TO PATH' si queremos poder lanzar la aplicación desde la terminal. Como no es mi caso, no la marco.

![Instalando IntelliJ](../images/29_InstalandoIntelliJ.png)

Una vez instalado, lo abrimos y nos dirigimos a los plugins para instalar el plugin oficial de Scala

![Plugin Scala IntelliJ](../images/30_PluginScalaIntelliJ.png)

Con el plugin instalado, vamos a la pantalla principal y pulsamos en Nuevo Proyecto. Debemos seleccionar Scala en el panel de la izquierda y elegir las versiones de sbt y Scala que ya hemos instalado en los pasos anteriores (en caso de no haber hecho los pasos anteriores podemos marcar la casilla de Download para que se descarguen automáticamente)

![Nuevo proyecto Scala IntelliJ](../images/31_NuevoProyectoScalaIntelliJ.png)

Comprobamos que la estructura de los ficheros es la correcta

![Ficheros Scala IntelliJ](../images/32_FicherosScalaIntelliJ.png)

Comprobamos el contenido del fichero build.sbt y verificamos la versión de scala

![Contenido build.sbt](../images/33_ContenidoBuildSBT.png)

Nos dirigimos hasta la carpeta src > main > scala y hacemos click derecho y pulsamos en New > Scala Class/File, seleccionamos Object y de nombre ponemos Main.

![Fichero Main IntelliJ](../images/34_FicheroMainIntelliJ.png)

Para compilar y ejecutar pulsamos el botón verde superior y se nos abrirá en la parte inferior una terminal donde podremos ver el output de la ejecución.

![Ejecutando Scala IntelliJ](../images/35_EjecutandoScalaIntelliJ.png)