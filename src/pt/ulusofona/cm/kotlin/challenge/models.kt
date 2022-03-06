package pt.ulusofona.cm.kotlin.challenge

import java.time.Instant
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


val DATE_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

abstract class Veiculo (val identificador: String): Movimentavel {
    lateinit var posicao: Posicao
    lateinit var dataDeAquisicao: Date

    override fun moverPara(x: Int, y: Int) {
        if (x == posicao.x && y == posicao.y) { throw AlterarPosicaoException() }
        posicao.alterarPosicaoPara(x, y)
    }  // TODO: moverPara(x: Int, y: Int)

    abstract fun requerCarta(): Boolean
}

class Posicao (var x: Int, var y: Int) {
    fun alterarPosicaoPara(x: Int, y:Int) {
        this.x = x
        this.y = y
    }

    override fun toString(): String = "Posicao | x:$x | y:$y"
}
class Carta

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
class Bicicleta (identificador: String): Veiculo(identificador) {
    override fun requerCarta(): Boolean = false
    override fun toString(): String = "Bicicleta | $identificador |" +
            "${LocalDate.parse(dataDeAquisicao.toString(), DATE_FORMATTER)} | Posicao | x:${posicao.x} | y:${posicao.y}"
}
class VeiculoEscondido (identificador: String): Veiculo(identificador) {
    override fun requerCarta(): Boolean = false  // TODO: Chec
    override fun toString(): String = "VeiculoEscondido | $identificador |" +
            "${LocalDate.parse(dataDeAquisicao.toString(), DATE_FORMATTER)} | Posicao | x:${posicao.x} | y:${posicao.y}"
}

class Pessoa(val nome: String, val dataDeNascimento: Date): Movimentavel {
    var veiculos: MutableList<Veiculo> = mutableListOf()
    var posicao: Posicao = Posicao(0, 0)
    lateinit var carta: Carta

    private fun menorDeIdade(): Boolean {
        return false
    }  // TODO: menorDeIdade(): Boolean

    fun comprarVeiculo(veiculo: Veiculo) {
        veiculos.add(veiculo)
    }
    fun pesquisarVeiculo(identificador: String): Veiculo {
        for (veiculo in veiculos) {
            if (veiculo.identificador == identificador) {
                return veiculo
            }
        }
        throw VeiculoNaoEncontradoException()
    }
    fun venderVeiculo(identificador: String, comprador: Pessoa) {
        val v = pesquisarVeiculo(identificador)
        veiculos.remove(v)
        v.dataDeAquisicao = Date.from(Instant.now())  // TODO: CHECK LINE
        comprador.comprarVeiculo(v)
    }
    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        val v = pesquisarVeiculo(identificador)
        if (v.requerCarta() && !temCarta()) throw MenorDeIdadeException()
        v.moverPara(x, y)
    }
    fun temCarta(): Boolean {
        return this::carta.isInitialized
    }
    fun tirarCarta() {
        if (menorDeIdade()) throw MenorDeIdadeException()
        else carta = Carta()
    }

    override fun moverPara(x: Int, y: Int) {

    }  // TODO: moverPara(x: Int, y: Int)
    override fun toString(): String = "Pessoa | $nome |" +
            "${LocalDate.parse(dataDeNascimento.toString(), DATE_FORMATTER)} | Posicao | x:${posicao.x} | y:${posicao.y}"
}