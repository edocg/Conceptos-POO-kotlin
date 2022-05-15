# TEMAS CLAVE PROGRAMACIÓN ORIENTADA A OBJETOS

## HERENCIA: 
Permite definir nuevas clases a partir de clases existentes para reutilizar código existente.
Ver el ejemplo implementado en el principio de Liskov más adelante.

## POLIMORFISMO:
Se refiere a la posibilidad de varios objetos de diferentes familias para responder a lo
mismo, pudiendo ser intercambiables en determinadas circunstancias.

En el siguiente ejemplo los objetos Tv y Door responden a los mismo, y son intercambiables desde el punto
de vista de RemoteControl.

```kotlin
interface RemoteControl {
    fun up()
    fun down()
}

class Tv:RemoteControl {
    val fabricante:String = "Samsumg"
    override fun up(){
        println("subir el volumen")
    }
    override fun down(){
        println("bajar el volumen")
    }
}

class Door:RemoteControl {
    override fun up(){
        println("subir puerta")
    }
    override fun down(){
        println("bajar puerta")
    }
}

fun useRemoteControl() {
   val tv =Tv()
   tv.up()
}

fun main(){
    useRemoteControl()
}
```
