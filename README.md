## ANDROID 101

Este ejemplo de proyecto pretende demostrar como consumir datos desde un **end point** y mostrar el contenido del mismo por pantalla como una lista de **cardviews**.
La aplicación consume desde el siguiente end point [splashbase](http://www.splashbase.co/api)

## Modo de uso

Para reutilizar esta aplicación con cualquier otro end poitnseguur los siguientes pasos:

1. Cambiar en el archivo build.gradle la entrada  "API_URL" por la url deseada
 buildConfigField "String", "API_URL", "\"http://www.splashbase.co\""

2. Crear una clase al estilo ItemClient la cual contenga la ruta y el método HTTP necesario.
ejemplo
 @GET("/api/v1/images/latest")
 Call<ItemList> latestImages();

3. Crear un modelo de datos que soporte los items que retornara el llamado rest.
4. Modificar/ crear la vista (cards_layout.xml) y el adapter (PhotoAdapter.java) para soportar los elementos que desee mostrar por pantalla.

## Librerías

Ese proyecto se realizo utilizando las siguientes librerías:
- [OTTO BUS](http://square.github.io/otto/)
- [Retrofit](https://square.github.io/retrofit/)
- [Butterknife](http://jakewharton.github.io/butterknife/)
- [Picasso](http://square.github.io/picasso/)

## Imagenes

![alt tag](https://github.com/capraber/android101/blob/master/1.MainScreen.png)
![alt tag](https://github.com/capraber/android101/blob/master/2.Dialog.png)
