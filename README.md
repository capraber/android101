## ANDROID 101

Este proyecto pretende demostrar como consumir datos desde un **end point** y mostrar el contenido del mismo por pantalla como una lista de **cardviews**.
La aplicación consume desde el siguiente end point [splashbase](http://www.splashbase.co/api)

## Instalación del ambiente
Seguir los pasos del instructivo oficial de android developer para instalar el Android Studio
- [Instalar AS](https://developer.android.com/studio/install.html?hl=es-419)

## Modo de uso

Para reutilizar esta aplicación con cualquier otro end point seguir los siguientes pasos:

1. Al buildConfigField definido en el archivo build.gradle, llamado "API_URL" cambiarle la url deseada. Ejemplo:  buildConfigField "String", "API_URL", "\"http://www.otherurl.com\""

2. Crear una clase al estilo ItemClient la cual contenga la ruta y el método HTTP necesario.
ejemplo
 @GET("/api/v1/images/latest")
 Call<ItemList> latestImages();

3. Crear un modelo de datos que soporte los items que retornara el llamado rest.
4. Modificar/ crear la vista (cards_layout.xml) y el adapter (PhotoAdapter.java) para soportar los elementos que desee mostrar por pantalla.
5. Por ultimo la aplicación cuenta con un ejemplo de como utilizar google maps al presionar el botón del mapa a la izquierda de la pantalla.

## Como ejecutar el proyecto en un dispositivo (real o emulador)
Seguir los pasos de la pagina oficial de android developer
- [Ejecutar la aplicación](https://developer.android.com/training/basics/firstapp/running-app.html?hl=es-419)

## Librerías

Ese proyecto se realizo utilizando las siguientes librerías:
- [OTTO BUS](http://square.github.io/otto/)
- [Retrofit](https://square.github.io/retrofit/)
- [Butterknife](http://jakewharton.github.io/butterknife/)
- [Picasso](http://square.github.io/picasso/)
- [Google Maps](https://developers.google.com/maps/documentation/android-api/intro?hl=es-419)

## Imagenes

![alt tag](https://github.com/capraber/android101/blob/master/1.MainScreen.png)
![alt tag](https://github.com/capraber/android101/blob/master/2.Dialog.png)
![alt tag](https://github.com/capraber/android101/blob/master/3.GoogleMapExample.png)
