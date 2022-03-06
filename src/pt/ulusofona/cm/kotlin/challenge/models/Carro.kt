package pt.ulusofona.cm.kotlin.challenge.models

import java.text.SimpleDateFormat

class Carro (identificador: String, val motor: Motor): Veiculo(identificador) {
    override fun moverPara(x: Int, y: Int) {
        if (!motor.estaLigado()) { motor.ligar() }  // TODO : not necessary
        super.moverPara(x, y)
        motor.desligar()  // TODO : not necessary
    }
    override fun requerCarta(): Boolean = true
    override fun toString(): String = "Carro | $identificador | ${SimpleDateFormat("dd-MM-yyyy").format(dataDeAquisicao)} | $posicao"
}