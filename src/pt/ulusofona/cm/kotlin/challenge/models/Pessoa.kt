package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.*
import pt.ulusofona.cm.kotlin.challenge.interfaces.*
import java.text.SimpleDateFormat

import java.util.*

class Pessoa(val nome: String, val dataDeNascimento: Date): Movimentavel {
    var veiculos: MutableList<Veiculo> = mutableListOf()
    var posicao: Posicao = Posicao(0, 0)
    lateinit var carta: Carta

    private fun menorDeIdade(): Boolean {
        val cal = Calendar.getInstance()
        cal.time = dataDeNascimento
        cal.add(Calendar.YEAR, 18)
        val dataDeMaioridade = cal.time
        return Date() < dataDeMaioridade
    }

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
        v.dataDeAquisicao = Date()  // TODO: CHECK LINE
        comprador.comprarVeiculo(v)
    }
    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        val v = pesquisarVeiculo(identificador)
        if (v.requerCarta() && !temCarta()) throw PessoaSemCartaException(nome)
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
        posicao.x = x
        posicao.y = y
    }
    override fun toString(): String = "Pessoa | $nome | ${SimpleDateFormat("dd-MM-yyyy").format(dataDeNascimento)} | Posicao | x:${posicao.x} | y:${posicao.y}"
}