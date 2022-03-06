package pt.ulusofona.cm.kotlin.challenge.models

import java.time.LocalDate
import java.time.format.DateTimeFormatter

private val DATE_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

class Carro (identificador: String, val motor: Motor): Veiculo(identificador) {
    override fun moverPara(x: Int, y: Int) {
        if (!motor.estaLigado()) { motor.ligar() }  // TODO : not necessary
        super.moverPara(x, y)
        motor.desligar()  // TODO : not necessary
    }
    override fun requerCarta(): Boolean = true
    override fun toString(): String = "Carro | $identificador |" +
            "${LocalDate.parse(dataDeAquisicao.toString(), DATE_FORMATTER)} | Posicao | x:${posicao.x} | y:${posicao.y}"
}