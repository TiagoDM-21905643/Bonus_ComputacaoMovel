package pt.ulusofona.cm.kotlin.challenge.exceptions


class AlterarPosicaoException (): Exception()
class MenorDeIdadeException (): Exception()
class PessoaSemCartaException (nome: String): Exception("$nome não tem carta para conduzir o veículo indicado")
class VeiculoNaoEncontradoException (): Exception()
class VeiculoDesligadoException (): Exception()
class VeiculoLigadoException (): Exception()