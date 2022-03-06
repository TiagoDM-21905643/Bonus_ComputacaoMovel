package pt.ulusofona.cm.kotlin.challenge.exceptions


class AlterarPosicaoException (): Exception()
class MenorDeIdadeException (): Exception()
class PessoaSemCartaException (): Exception("Nome da Pessoa não tem carta para conduzir o veículo indicado")
class VeiculoNaoEncontradoException (): Exception()
class VeiculoDesligadoException (): Exception()
class VeiculoLigadoException (): Exception()