const Usuario = require('./usuarios-modelo')
const tokens = require('./tokens')
const { EmailVerificacao, EmailRedefinicao } = require('./emails')
const { ConversorUsuario } = require('../conversores')
const { NaoEncontrado, InvalidArgumentError } = require('../erros')

function geraEndereco (rota, token) {
  const baseURL = process.env.BASE_URL
  return `${baseURL}${rota}${token}`
}

module.exports = {
  async adiciona (req, res, next) {
    const { nome, email, senha, cargo } = req.body

    try {
      const usuario = new Usuario({
        nome,
        email,
        emailVerificado: false,
        cargo
      })
      await usuario.adicionaSenha(senha)
      await usuario.adiciona()

      const token = tokens.verificacaoEmail.cria(usuario.id)
      const endereco = geraEndereco('/usuario/verifica_email/', token)
      const emailVerificacao = new EmailVerificacao(usuario, endereco)
      emailVerificacao.enviaEmail().catch(console.log)

      res.status(201).json()
    } catch (erro) {
      next(erro)
    }
  },

  async login (req, res, next) {
    try {
      const accessToken = tokens.access.cria(req.user.id)
      const refreshToken = await tokens.refresh.cria(req.user.id)
      res.set('Authorization', accessToken)
      res.status(200).json({ refreshToken })
    } catch (erro) {
      next(erro)
    }
  },

  async logout (req, res, next) {
    try {
      const token = req.token
      await tokens.access.invalida(token)
      res.status(204).json()
    } catch (erro) {
      next(erro)
    }
  },

  async lista (req, res, next) {
    try {
      const usuarios = await Usuario.lista()
      const conversor = new ConversorUsuario(
        'json', 
        req.acesso.todos.permitido ? 
          req.acesso.todos.tributos : 
          req.acesso.apenasSeu.atributos
      )
      res.send(conversor.converter(usuarios))
      res.json(usuarios)
    } catch (erro) {
      next(erro)
    }
  },

  async verificaEmail (req, res, next) {
    try {
      const usuario = req.user
      await usuario.verificaEmail()
      res.status(200).json()
    } catch (erro) {
      next(erro)
    }
  },

  async deleta (req, res, next) {
    try {
      const usuario = await Usuario.buscaPorId(req.params.id)
      await usuario.deleta()
      res.status(200).json()
    } catch (erro) {
      next(erro)
    }
  },

  async esqueciMinhaSenha (req, res, next) {
    const reposta = { mensagem: 'Um email de recuperação da senha foi enviado.'}
    try {
      const email = req.body.email
      const usuario = await Usuario.buscaPorEmail(email)
      const token = await tokens.redefinicaoSenha.criarToken(usuario.id)
      const emailVerificacao = new EmailRedefinicao(usuario, token)
      await emailVerificacao.enviaEmail()
      res.send(reposta)
    } catch (erro) {
      if (erro instanceof NaoEncontrado) {
        res.send(reposta)
        return
      }
    }

    next(erro)
  },

  async trocarSenha (req, res, next) {
    try {
      if (typeof req.body.token === 'string' && req.body.token.length === 0) {
        throw new InvalidArgumentError('O token está inválido.')
      }

      const id = await tokens
        .redefinicaoSenha
        .verifica(req.body.token)
      const usuario = await Usuario.buscaPorId(id)
      await usuario.adicionaSenha(req.body.senha)
      await usuario.atualizarSenha()
      res.send({ mensagem: 'Senha atualizada com sucesso.' })
    } catch (erro) {
      next(erro)
    }
  }
}
