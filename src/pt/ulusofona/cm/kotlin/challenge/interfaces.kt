package pt.ulusofona.cm.kotlin.challenge

interface Ligavel {
    fun ligar()
    fun desligar()
    fun estaLigado(): Boolean
}
interface Movimentavel {
    fun moverPara(x: Int, y: Int)
}