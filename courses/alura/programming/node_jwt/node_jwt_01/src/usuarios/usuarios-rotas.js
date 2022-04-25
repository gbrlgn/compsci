const usuariosControlador = require('./usuarios-controlador');
const middlewaresAut = require('./middlewares-autenticacao');
const { middlewaresAutenticacao } = require('.');

module.exports = app => {
  app
    .route('/usuario/login')
    .post(
      middlewaresAut.local,usuariosControlador.login
    );

  app
    .route('/usuario/logout')
    .get(
      middlewaresAutenticacao.bearer,
      usuariosControlador.logout
    );

  app
    .route('/usuario')
    .post(usuariosControlador.adiciona)
    .get(usuariosControlador.lista);

  app
    .route('/usuario/:id')
    .delete(
      middlewaresAutenticacao.bearer,
      usuariosControlador.deleta
    );
};
