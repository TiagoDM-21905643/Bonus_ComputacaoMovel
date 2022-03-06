package pt.ulusofona.cm.kotlin.challenge.models

import java.time.LocalDate
import java.time.format.DateTimeFormatter

private val DATE_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

class Bicicleta (identificador: String): Veiculo(identificador) {
    override fun requerCarta(): Boolean = false
    override fun toString(): String = "Bicicleta | $identificador |" +
            "${LocalDate.parse(dataDeAquisicao.toString(), DATE_FORMATTER)} | Posicao | x:${posicao.x} | y:${posicao.y}"
}