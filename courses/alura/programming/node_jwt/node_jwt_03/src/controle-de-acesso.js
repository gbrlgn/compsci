const AccessControl = require('accesscontrol');
const controle = new AccessControl();

controle
  .grant('assinante')
    .readAny('post', ['id', 'titulo', 'conteudo', 'autor'])
    .readAny('usuario', ['nome'])
  .grant('editor')
    .extend('assinante')
    .createOwn('post')
    .deleteOwn('post')
  .grant('admin')
    .createAny('post')
    .deleteAny('post')
    .readAny('usuario')
    .deleteAny('usario');

module.exports = controle;