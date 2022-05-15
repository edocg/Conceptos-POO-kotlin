package `androidKotlin-repo`

fun buildRobot() {
    val myRobot = Robot()
    myRobot.modalidad="Escolta"
    myRobot.licencia="R2D2"
    myRobot.printId()
    myRobot.printMision()
    val myRadioOperador = RadioOperador()
    myRadioOperador.printId()
}

fun main(){
    buildRobot()
}
