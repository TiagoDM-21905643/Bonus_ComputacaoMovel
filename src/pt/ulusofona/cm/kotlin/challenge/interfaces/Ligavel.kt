package pt.ulusofona.cm.kotlin.challenge.interfaces

import pt.ulusofona.cm.kotlin.challenge.models.*

interface Ligavel {
    fun ligar()
    fun desligar()
    fun estaLigado(): Boolean
}