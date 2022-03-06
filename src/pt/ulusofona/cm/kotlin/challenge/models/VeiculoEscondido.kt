package pt.ulusofona.cm.kotlin.challenge.models

import java.time.LocalDate
import java.time.format.DateTimeFormatter

private val DATE_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

class VeiculoEscondido (identificador: String): Veiculo(identificador) {
    override fun requerCarta(): Boolean = false  // TODO: Chec
    override fun toString(): String = "VeiculoEscondido | $identificador |" +
            "${LocalDate.parse(dataDeAquisicao.toString(), DATE_FORMATTER)} | Posicao | x:${posicao.x} | y:${posicao.y}"
}