
# Scala Multi-Environment Setup Guide
### Configuración de 3 entornos de desarrollo para Scala 2.12.21

*Guía paso a paso, con capturas propias, para levantar Scala en tres flujos de trabajo distintos: notebooks interactivos (JupyterLab), edición ligera (VSCode) y un IDE completo (IntelliJ).*

---

## Sobre esta guía

Este documento recoge la instalación y configuración **de principio a fin** de tres entornos de desarrollo para **Scala 2.12.21**, pensados para cubrir distintos casos de uso: experimentación rápida en notebooks, desarrollo ágil en editor ligero, y un IDE completo con todas las herramientas integradas.

| Entorno | Herramientas principales | Ideal para |
|---|---|---|
| **Entorno 1** | JupyterLab + Almond Kernel | Prototipado rápido y notebooks interactivos |
| **Entorno 2** | VS Code + Metals + sbt | Desarrollo ágil con editor ligero |
| **Entorno 3** | IntelliJ IDEA Community + sbt | Proyectos completos con IDE integrado |

**Requisitos comunes:** Windows · JDK 17 · Scala 2.12.21 · sbt

*Las imágenes referenciadas se encuentran en la carpeta [`../images`](../images) del repositorio.*

---

## Índice

- [1.1 — JupyterLab + Almond Kernel + Scala](#11-entorno-1--jupyterlab--almond-kernel--scala-21221)
- [1.2 — Visual Studio Code + Metals + sbt](#12-entorno-2--visual-studio-code--metals--scala-21221--jdk-17--sbt)
- [1.3 — IntelliJ IDEA Community + sbt](#13-entorno-3--intellij-idea-community--scala-21221--sbt)

---

## 1.1 Entorno 1 — JupyterLab + Almond Kernel + Scala 2.12.21

> Entorno orientado a la experimentación interactiva con notebooks, combinando Python, Java y el kernel de Scala **Almond**.

### Paso 1 — Instalar Python

Accedemos a la [página oficial de descargas de Python](https://www.python.org/downloads/release/python-3129/) y descargamos la **versión 3.12**, la recomendada para este entorno.

![Descargar Python](../images/01_DescargarPython.png)

Durante la instalación, marcamos la casilla **`ADD TO PATH`**.

![Instalación de Python](../images/02_InstalacionPython.png)

Verificamos la instalación abriendo un `cmd` y ejecutando:

```bash
python --version
```

![Versión de Python](../images/03_VersionPython.png)

### Paso 2 — Instalar JupyterLab

Con Python (o Miniconda/Anaconda) ya operativo, instalamos JupyterLab:

```bash
pip install jupyterlab
```

![Descargando JupyterLab](../images/04_DescargandoJupyterLab.png)

### Paso 3 — Instalar Java SDK 17

Descargamos el JDK desde la [página oficial de Oracle](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) (sección Windows).

![Descargar Java SDK 17](../images/05_DescargarJavaSDK17.png)

Durante la instalación marcamos **`ADD TO JAVA_HOME`**. Si esa opción no aparece, añadimos la variable manualmente desde **Editar variables de entorno** en Windows:

![Java SDK en JAVA_HOME](../images/06_JavaSDKEnJAVA_HOME.png)

Comprobamos la instalación:

```bash
java -version
```

![Versión de Java SDK](../images/07_VersionJavaSDK.png)

### Paso 4 — Instalar el kernel Almond + Scala

Descargamos `coursier` y `coursier.bat` desde [github.com/coursier/launchers](https://github.com/coursier/launchers), que simplifica la instalación tanto del kernel como de Scala.

![Descargar Coursier](../images/08_DescargarCoursier.png)

Desde la carpeta de descarga, ejecutamos:

```bash
coursier.bat launch almond:0.14.5 --scala 2.12.21 -- --install
```

![Instalar kernel de Scala](../images/09_InstalarKernelScala.png)

### Paso 5 — Ejecutar JupyterLab

Desde la carpeta de nuestro workspace:

```bash
jupyter lab
```

![Ejecutar JupyterLab](../images/10_EjecutarJupyterLab.png)

Abrimos la URL proporcionada en el navegador y confirmamos que aparece la opción de **Scala**:

![Notebook de Scala disponible](../images/11_NotebookScala.png)

Creamos un notebook de Scala y lo guardamos en nuestro workspace:

![Guardar notebook de Scala](../images/12_GuardarNotebookScala.png)

### Verificación

| Prueba | Descripción | Resultado |
|---|---|---|
| **Prueba 01** | Verificar la versión exacta de Scala | ![Prueba 01](../images/13_Prueba01Scala.png) |
| **Prueba 02** | Ejecutar código de prueba en el notebook | ![Prueba 02](../images/14_Prueba02Scala.png) |

---

## 1.2 Entorno 2 — Visual Studio Code + Metals + Scala 2.12.21 + JDK 17 + sbt

> Entorno ligero y ágil, ideal para trabajar con proyectos sbt directamente desde un editor de código.

### Paso 1 — Java SDK 17

*(Mismo procedimiento que en el Entorno 1)*

Descargamos el JDK desde la [página oficial de Oracle](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html):

![Descargar Java SDK 17](../images/05_DescargarJavaSDK17.png)

Marcamos **`ADD TO JAVA_HOME`** durante la instalación, o lo añadimos manualmente si no aparece la opción:

![Java SDK en JAVA_HOME](../images/06_JavaSDKEnJAVA_HOME.png)

Comprobamos la versión instalada:

![Versión de Java SDK](../images/07_VersionJavaSDK.png)

### Paso 2 — Instalar Visual Studio Code

Descargamos e instalamos VS Code desde [code.visualstudio.com](https://code.visualstudio.com/):

![Descargar VS Code](../images/15_DescargarVSCode.png)

Desde el panel de extensiones (`Ctrl+Shift+X`), buscamos e instalamos **Scala (Metals)**:

<table>
<tr>
<td><img src="../images/16_BuscamosExtension.png" alt="Buscar extensión Metals" width="100%"></td>
<td><img src="../images/17_ScalaMetalsInstalado.png" alt="Metals instalado" width="100%"></td>
</tr>
</table>

### Paso 3 — Instalar sbt

Descargamos la última versión desde el [repositorio oficial de sbt en GitHub](https://github.com/sbt/sbt/releases):

![Descargar sbt](../images/18_DescargarSBT.png)

Completamos el asistente de instalación:

![Instalar sbt](../images/19_InstalarSBT.png)

Verificamos la instalación:

```bash
sbt --version
```

![Versión de sbt](../images/20_VersionSBT.png)

### Paso 4 — Crear la estructura del proyecto

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

En `build.sbt` definimos el nombre del proyecto, su versión y la versión de Scala:

![Contenido de build.sbt](../images/22_ContenidoScalaSBT.png)

En `Main.scala` creamos un pequeño programa de prueba:

![Contenido de Main.scala](../images/23_ContenidoMainScala.png)

> Al instalar la extensión de Metals, VS Code genera automáticamente varios directorios ocultos por defecto:

![Nuevos directorios generados](../images/24_NuevosDirectorios.png)

### Paso 5 — Compilar y ejecutar

Desde una nueva terminal en VS Code (`Ctrl+Ñ`):

```bash
sbt compile
```

![Compilar proyecto Scala](../images/26_CompileScala.png)

> **Nota:** si `sbt compile` solicita ejecutar antes `sbt new` o `sbt --allow-empty`, usa **`sbt --allow-empty`** — `sbt new` obliga a seleccionar una plantilla para continuar.

![sbt allow-empty](../images/25_SBTAllowEmpty.png)

Una vez compilado, lanzamos el programa:

```bash
sbt run
```

![Scala ejecutado correctamente](../images/27_ScalaEjecutado.png)

---

## 1.3 Entorno 3 — IntelliJ IDEA Community + Scala 2.12.21 + sbt

> IDE completo, con gestión de proyecto, autocompletado y depuración integrados de serie.

### Paso 1 — Instalar IntelliJ IDEA

Descargamos IntelliJ IDEA Community desde [jetbrains.com](https://www.jetbrains.com/es-es/idea/download/?section=windows):

![Descargar IntelliJ IDEA](../images/28_DescargarIntelliJ.png)

Seguimos el asistente de instalación (opcionalmente marcamos **`ADD TO PATH`** para lanzarlo desde terminal):

![Instalando IntelliJ IDEA](../images/29_InstalandoIntelliJ.png)

### Paso 2 — Instalar el plugin de Scala

Desde el marketplace de plugins, instalamos el plugin oficial de **Scala**:

![Plugin de Scala en IntelliJ](../images/30_PluginScalaIntelliJ.png)

### Paso 3 — Crear el proyecto

Desde la pantalla principal, **Nuevo Proyecto → Scala**, seleccionando las versiones de sbt y Scala ya instaladas (o marcando *Download* si aún no las tenemos):

![Nuevo proyecto Scala en IntelliJ](../images/31_NuevoProyectoScalaIntelliJ.png)

Verificamos que la estructura de ficheros generada es correcta:

![Estructura de ficheros en IntelliJ](../images/32_FicherosScalaIntelliJ.png)

Comprobamos el contenido de `build.sbt` y la versión de Scala configurada:

![Contenido de build.sbt](../images/33_ContenidoBuildSBT.png)

### Paso 4 — Crear el fichero Main

En `src > main > scala`, clic derecho → **New → Scala Class/File** → seleccionamos **Object** → nombre **`Main`**:

![Fichero Main.scala en IntelliJ](../images/34_FicheroMainIntelliJ.png)

### Paso 5 — Compilar y ejecutar

Pulsamos el botón verde de la parte superior; el output de ejecución aparece en la terminal inferior:

![Ejecutando Scala en IntelliJ](../images/35_EjecutandoScalaIntelliJ.png)

---

### Resultado final

Al completar esta guía tendrás **tres entornos de desarrollo Scala 2.12.21 completamente funcionales**, cada uno optimizado para un flujo de trabajo distinto: notebooks interactivos, edición ágil y un IDE completo.