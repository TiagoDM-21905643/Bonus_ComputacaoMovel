package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.*
import pt.ulusofona.cm.kotlin.challenge.interfaces.*
import pt.ulusofona.cm.kotlin.challenge.models.*
import java.util.*

abstract class Veiculo (val identificador: String): Movimentavel {
    lateinit var posicao: Posicao
    lateinit var dataDeAquisicao: Date

    override fun moverPara(x: Int, y: Int) {
        if (x == posicao.x && y == posicao.y) { throw AlterarPosicaoException() }
        posicao.alterarPosicaoPara(x, y)
    }  // TODO: moverPara(x: Int, y: Int)

    abstract fun requerCarta(): Boolean
}