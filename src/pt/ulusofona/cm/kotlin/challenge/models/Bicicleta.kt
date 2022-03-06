package pt.ulusofona.cm.kotlin.challenge.models

import java.text.SimpleDateFormat

class Bicicleta (identificador: String): Veiculo(identificador) {
    override fun requerCarta(): Boolean = false
    override fun toString(): String = "Bicicleta | $identificador | ${SimpleDateFormat("dd-MM-yyyy").format(dataDeAquisicao)} | Posicao | x:${posicao.x} | y:${posicao.y}"
}