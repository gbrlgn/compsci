const usuariosControlador = require('./usuarios-controlador');
const middlewaresAutenticacao = require('./middlewares-autenticacao');
const autorizacao = require('../middlewares/autorizacao');

module.exports = app => {
  app
    .route('/usuario/esqueci-minha-senha')
    .post(usuariosControlador.esqueciMinhaSenha)
    .route('/usuario/atualiza_token')
    .post(middlewaresAutenticacao.refresh, usuariosControlador.login)
    .route('/usuario/login')
    .post(middlewaresAutenticacao.local, usuariosControlador.login)
    .route('/usuario/logout')
    .post(
      [middlewaresAutenticacao.refresh, middlewaresAutenticacao.bearer],
      usuariosControlador.logout
    )
    .route('/usuario/verifica_email/:token')
    .get(
      middlewaresAutenticacao.verificacaoEmail,
      usuariosControlador.verificaEmail
    )
    .route('/usuario')
    .post(usuariosControlador.adiciona)
    .get(
      [
        middlewaresAutenticacao.bearer, autorizacao('usuario', 'ler')
      ],
      usuariosControlador.lista
    )
    .route('/usuario/:id')
    .delete(
      [
        middlewaresAutenticacao.bearer,
        middlewaresAutenticacao.local
      ],
      usuariosControlador.deleta
    );
}