package `androidKotlin-repo`
//modalidad puede ser: vigil fija, vigil movil, escolta, transporte de valores
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
        println("PROTEGER PERSONAS!!")
    }
}

class RadioOperador(override var id: String,override var modalidad: String = "VigilanciaFija",
                    override var licencia: String): Robot(id=id,modalidad=modalidad,licencia=licencia){
    val CAD_Policia: String = "Rionegro"
}