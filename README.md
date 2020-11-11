# Calculadora Swing
Ejercicio calculadora realizado en Swing
## AVISO: Este proyecto ha sido creado usando Gradle y IntelliJ
## Contenido

Esta calculadora consta de 20 Botones funcionales con la siguiente distribución al igual que su hermana gemela AWT
| | | | |
| :---: | :---: | :---: | :---: |
| Del | CE | C | / |
| 7 | 8 | 9 | * |
| 4 | 5 | 6 | - |
| 1 | 2 | 3 | + |
| . | 0 | % | = |

## Clases
### El ejercicio consta de 3 clases:
#### Main
Clase principal del programa, esta ejecutara un objeto Calculadora(), le asignara el titulo y hara que se cierre
#### Calculadora
Esta clase generara toda la estructura de la calculadora y le dara uso a los botones que hay en ella
##### Metodo generarBotones()
Este metodo es encargado de crear botones y darle funcion, requiere un array de Strings y no devuelve nada
```Java
public void generarBotones(String[] tecla){
        for(String x : tecla) {
           //Aqui el codigo para cada boton
        }
    }
```
#### Operaciones
Esta clase es una clase enum que contiene los siguientes enums
```Java
SUMA
RESTA
MULTIPLICACION
DIVISION
```
Estos enums sirven para guardar el estado en el que esta la calculadora

## Diferencias respecto a la Calculadora AWT
### NOTA: la calculadora AWT se copio de esta debido a que la original fue sobreescrita con la Swing

#### Estilo propio
Esta calculadora ha usado las bondades de gradle para importar temas de color concretamente **FlatLaf**
```Gradle
dependencies {
    implementation 'com.formdev:flatlaf:0.43'
    implementation 'com.formdev:flatlaf-intellij-themes:0.43'
}
```
Al usar gradle hay que añadir estas dos lineas en **build.gradle**

Esta calculadora tiene el siguiente codigo, que añade una barra personalizada en la aplicacion
```Java
      objeto.setUndecorated(true); //Quita la barra de windows
      objeto.getRootPane().setWindowDecorationStyle(JRootPane.FRAME); //Añade una barra, definida en este caso por FlatLaf
```
