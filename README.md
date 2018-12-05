- Curso: Inteligencia Artificial
- Catedratico: Jorge Santos
- Universidad Mariano Galvez de Guatemala 
Plan Fin de Semana


[![Watch the video](https://raw.github.com/GabLeRoux/WebMole/master/ressources/WebMole_Youtube_Video.png)](https://youtu.be/uZDgm-PeL2U)

# vista del proyecto en Python
ademas de este proyecto en android en mi rep pueden encontrar la carpeta que contiene el archivo en python le adjunto una pantalla del funcionamiento del sistema 
<p align="center">
<img src="https://github.com/acalel/imagenes/blob/master/producto%20final.png" />
 </p>


# Introduccion

El presente proyecto tiene como objetivo principal demostrar cuan beneficioso puede ser aplicar la inteligencia artifical dentro de la vida cotidiana ya que esto, utilizando librerias que nos proveeen como ejemplo tenemos Open CV y Tensor flow estas librerias estan diseñadas para la vision artificial dentro de lo cual nos facilita la forma de implementar nuestro proyecto, el presente proyecto fue basado en el proyecto de eduardo quien implemento el proyecto de reconocimiento facial, ahora nosotros Angel Calel y Walter Rios hemos modificado el proyecto e implementado el reconocimiento de vehiculos, la primera version se creo en Python utilizando Open CV esto utilizando un archivo previamente entrenado el cual tiene extension XML este archivo es previamente entrenado con diversas imagenes tanto negativas como positivas, cuando nos referimos a positivas es cuando en la imagen aparece el objeto a reconocer, y las imagenes negativas es cuando esta el ambiente menos el objeto a detectar.


# Objetivo
El Objetivo Primordial es comprobar la deteccion de vehiculos lo cual es logrado con el archivo XML previamente entrenado, para los efectos se creo una aplicacion Movil dentro del cual contiene archivos XML con cantidad especifica de imagenes entrenados.

Requerimientos
===
- Android Studio
- Open CV para Android
- Open CV Manager 
El ultimo de los requerimientos debe de esta instalado previamente en el dispositivo que se utilizara para las pruebas respectivas ya que esto ayuda al dispositivo para que instale los archivos nesesarios.

1.Configuracion de Entorno de Desarrollo de Android 
=================================================
Android Studio fue el ide utilizado para el desarrollo del reconocimiento de vehiculos en la version movil, para el desarrollo del sistema debe de contar con este ide y que esten instalados los archivos nesesarios, dentro de este tutorial solo veremos la configuracion del entorno del desarrollo de este proyecto.

2.Configuracion de OpenCV para android
=====================================
uno de los primeros pasos es descargar Open CV para android el cual se puede acceder desde la pagina oficial de Open CV para los efectos de este proyecto se descargo la libreria 3.4.3 de Open CV se puede descargar la que ustedes gusten ya que la configuracion es exactamente igual en las pruebas configure la version 2.4 y en este proyecto configure la libreria 3.4.3 

<p align="center">
<img src="https://github.com/acalel/imagenes/blob/master/inicio.jpg" />
 </p>
 
 en la siguiente pantalla se reemplaza My Application por el combre que ustedes deseen y todos lo demas valores los dejan tal y como los a definidos android studio y luego le damos siguiente.
 
 <p align="center">
<img src="https://github.com/acalel/imagenes/blob/master/creaccion.jpg" />
 </p>
 
 en la siguiente imagen podemos a preciar que definimos el SDK minimo en el cual se podra compilar nuestra aplicacion yo escogi este para los efectos del proyecto ustedes pueden escoger el que deseen
 
  <p align="center">
<img src="https://github.com/acalel/imagenes/blob/master/SDK.jpg" />
 </p>
 
 luego de esto se seleccion el activity que se estara utilizando en la imagen pueden apreciar que estoy seleccionando un activity en blanco
 
  <p align="center">
<img src="https://github.com/acalel/imagenes/blob/master/activity.jpg" />
 </p>
 
