const controle = require('../controle-de-acesso');

const metodos = {
  ler: {
    todos: 'readAny',
    apenasSeu: 'readOwn'
  },
  criar: {
    todos: 'createAny',
    apenasSeu: 'createOwn'
  },
  criar: {
    todos: 'deleteAny',
    apenasSeu: 'deleteOwn'
  }
}

module.exports = (entidade, acao) => (req, res, next) => {
  const acoes = metodos[acao];
  const permissoesCargo = controle.can(req.user.cargo);
  const permissaoTodos = permissoesCargo[acoes.todos](entidade);
  const permissaoApenasSeu = permissoesCargo[acoes.apenasSeu](entidade);

  if (permissaoTodos.granted === false
    && permissaoApenasSeu.granted === false) {
    res.status(403);
    res.end();
    return
  }

  req.acesso = {
    todos: {
      permitido: permissaoTodos.granted,
      atributos: permissaoTodos.attributes
    },
    apenasSeu: {
      permitido: permissaoApenasSeu.granted,
      atributos: permissaoApenasSeu.attributes
    },
    atributos: permissao.attributes
      
  }

  next();
}