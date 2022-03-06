package pt.ulusofona.cm.kotlin.challenge.models

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

private val DATE_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

class VeiculoEscondido (identificador: String): Veiculo(identificador) {
    override fun requerCarta(): Boolean = false  // TODO: Check
    override fun toString(): String = "VeiculoEscondido | $identificador | ${SimpleDateFormat("dd-MM-yyyy").format(dataDeAquisicao)} | $posicao"
}