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
## ABSTRACCIÓN:
Un ejemplo de abstracción es la interfaz RemoteControl del ejemplo anterior, pues no implementa los métodos
y estos son implementados en las clases Tv o Door. También se puede lograr un efecto similar a través de las
clases abstractas de las que nunca se crean objetos y requieren de subclases que implementen dicha funcionalidad.

## ENCAPSULAMIENTO:
El encapsulamiento agrupa en una clase métodos y propiedades. En el ejemplo de polimorfismo, la clase Tv
tiene la propiedad Fabricante y el método up().

Para definir métodos y propiedades que solo se puedan acceder desde dentro de la clase los debemos
definir con el modificador private.

## PRINCIPIOS SOLID
**S - Single Responsability:** Una clase debería tener una única responsabilidad.
La clase Robot tiene una unica responsabilidad, Imprmir identificación de
Robot vigilante.
```kotlin
class Robot(var id: String = "Vigilante",var modalidad: String="VigilanciaMovil",
            var licencia: String = "LicSuperintendVigilYSegurPrivada") { 
  init{
      println("Robot initializing...")
  }

  fun printId(){
  println("id: $id \n"+
          "modalidad: $modalidad \n"+
          "licencia: $licencia " )
  }
}
```

**O - Open-Closed:** Las clases deben estar abiertas a la extensión, pero cerradas
a la modificación.
La clase Robot no modifica la funcion printId() para imprimir misión de Robot vigilante,
sino que crea una nueva función printMision().
```kotlin
class Robot(var id: String = "Vigilante",var modalidad: String="VigilanciaMovil",
              var licencia: String = "LicSuperintendVigilYSegurPrivada") { 
    init{
        println("Robot initializing...")
    }

    fun printId(){
        println("id: $id \n"+
                "modalidad: $modalidad \n"+
                "licencia: $licencia " )
    }

    fun printMision(){
        println("Proteger personas")
    }
}
```

**L - Liskov Substitution:** Si S es un subtipo de T, entonces los objetos de tipo T en un programa
pueden reemplazarse con objetos de tipo S sin alterar ninguna de las propiedades deseables de
ese programa.

Para crear un subtipo de la clase Robot se debe marcar la clase Robot con la palabra clave `open`.
similarmente para sobreescribir propiedades y variables miembro se les debe anteponer la palabra clave
`open`. como se muestra a continuación

```kotlin
open class Robot(open var id: String = "Vigilante",open var modalidad: String="VigilanciaMovil",
                 open var licencia: String = "LicSuperintendVigilYSegurPrivada") { 
    init{
        println("Robot initializing...")
    }

    fun printId(){
        println("id: $id \n"+
                "modalidad: $modalidad \n"+
                "licencia: $licencia " )
    }

    fun printMision(){
        println("Proteger personas")
    }
}
```

la clase subtipo se puede crear utilizando la palabra clave override de la siguiente forma

```kotlin
class RadioOperador(override var id: String,override var modalidad: String = "VigilanciaFija",
           override var licencia: String): Robot(id=id,modalidad=modalidad,licencia=licencia) {
  val CAD_Policia: String = "Rionegro"
}
```

De esta forma la clase RadioOperador es una subclase de la clase Robot y puede ser utilizada en reemplazo
de esta sin generar ningún tipo de error.

La herencia en el principio de Liskov permite la reutilización de código y facilita la extensión de código,
sin embargo, aumenta el acoplamiento entre clases, para solucionar esto acudimos a la segregación de interfaces.


**I - Interface Segregation:** Los clientes no deberían ser forzados a depender de métodos que no utilizan.
Este principio tiene como objetivo dividir un conjunto de acciones en conjuntos más pequeños para que
una Clase ejecute SÓLO el conjunto de acciones que requiere.

En la siguiente gráfica se observa que el rondero debe implementar métodos del vigilante de control de acceso
que no utiliza.
![Interface sin segregación](https://user-images.githubusercontent.com/67550843/168425673-da779122-151b-4631-ad87-76a8dce6428e.png)

para separar esta dependencia podemos separar las interfaces como se muestra a continuación.

![Interfaces segregadas](https://user-images.githubusercontent.com/67550843/168425678-1869f5a5-06a3-43c8-936c-0ceffc6d9ee7.png)


En el siguiente ejemplo la clase RobotAcceso hereda de la interfaz Icorrespondencia la función recibirCorrespondencia

```kotlin 
interface Icorrespondencia {
    fun recibirCorrespondencia()
}

class RobotAcceso: Icorrespondencia {
    override fun recibirCorrespondencia() {
        println("Robot scan barcode \nsend notification...")
    }
}

fun makeRobot(){
    val Robot1=RobotAcceso()
    Robot1.recibirCorrespondencia()
}

fun main(args: Array<String>) {
    makeRobot()
}
```

**D - Dependency Inversion:** Modulos de alto nivel no deberían depender de modulos de
bajo nivel. Ambos deberían depender de la abstracción.

Las abstracciones no deberían depender de detalles. Los detalles deberían depender de las
abstracciones.

Una clase particular no debería depender directamente de otra clase, pero si de una interfaz
de esta clase.

Ejemplo de violación del principio DIP (Dependency Inversion Principle):

```kotlin
class DeliveryDriver {
    fun deliverProduct() {
        println("producto enviado: R2D2 ")
    }
}

class DeliveryCompany {
    fun sendProduct() {
        val deliveryDriver = DeliveryDriver()
        deliveryDriver.deliverProduct()
    }
}
```

Como la clase DeliveryCompany crea y utiliza objetos de DeliveryDriver entonces la clase de alto nivel
DeliveryCompany depende de objetos de la clase de bajo nivel DeliveryDriver.
Para solucionar esta dependencia se crea la interfaz DeliveryService para tener una abstracción
En el siguiente código se APROXIMA una solución que se puede optimizar haciendo uso de Single Abstract Method
interfaces como se documenta en https://kotlinlang.org/docs/fun-interfaces.html

```kotlin
interface DeliveryService {
    fun deliverProduct(){
        println("Producto ")
    }
}

class DeliveryDriver : DeliveryService {
    override fun deliverProduct() {
        println("Producto entregado")
    }
}

//DeliveryCompany ahora depende de una abstracción y no de
// una clase de bajo nivel
class DeliveryCompany(private val deliveryService: DeliveryService) {
    fun sendProduct() {
        deliveryService.deliverProduct()
    }
}

fun makeCompany(){
    val deliveryDrive = DeliveryDriver()
    val company1=DeliveryCompany(deliveryDrive)
    company1.sendProduct()
}

fun main() {
    makeCompany()
}
```
Las dependencias son creadas en otro lugar y son inyectadas a través de la clase constructora.
La inversión de dependencia es diferente a la inyección de dependencia, pues esta última es uno de los
patrones que nos ayuda a lograr colaboración entre clases que no involucren dependencia entre ellas.

Seguir los principios SOLID facilita la extensión y la reutilización del código. Pero es importante no
aplicar estos principios de forma literal y tan apegados a ellos que vuelva nuestras soluciones complicadas
o se incremente demasiado la comunicación entre muchos módulos haciendo difícil la mantenibilidad.