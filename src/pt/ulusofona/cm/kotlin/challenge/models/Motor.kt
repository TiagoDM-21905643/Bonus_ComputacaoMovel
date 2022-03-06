package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.*
import pt.ulusofona.cm.kotlin.challenge.interfaces.*

class Motor (val cavalos: Int, val cilindrada: Int): Ligavel {
    private var ligado : Boolean = false

    override fun ligar() {
        if (ligado) throw VeiculoLigadoException()
        ligado = true
    }
    override fun desligar() {
        if (!ligado) throw VeiculoDesligadoException()
        ligado = false
    }
    override fun estaLigado(): Boolean  = ligado

    override fun toString(): String = "Motor | $cavalos | $cilindrada"
}