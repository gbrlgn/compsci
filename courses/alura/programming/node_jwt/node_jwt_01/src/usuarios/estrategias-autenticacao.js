const passport = require('passport');
const LocalStrategy = require('passport-local').Strategy;
const Usuario = require('./usuarios-modelo');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const { InvalidArgumentError } = require('../erros');
const blacklist = require('../../redis/manipular-blacklist');

function verificarUsuario(usuario) {
  if (!usuario) {
    throw InvalidArgumentError('Não existe um usuário com este email.');
  }
}

async function verificarTokenBlacklist(token) {
  const tokenBlacklist = await blacklist.contemToken(token);
  if (!tokenBlacklist) {
    throw new jwt.JsonWebTokenError('Token inválido por logout.');
  }
}

async function verificarSenha(senha, senhaHash) {
  const senhaValida = bcrypt.compare(senha, senhaHash);
  if (!senhaValida) {
    throw InvalidArgumentError('Email ou senha inválidos.');
  }
}

passport.use(
  new LocalStrategy(
    {
      usernameField: 'email',
      passwordField: 'senha',
      session: false
    }, 
    async (email, senha, done) => {
      try {
        const usuario = await Usuario.buscarPorEmail(email);
        verificarUsuario(usuario);
        await verificarSenha(senha, usuario.senhaHash);
      } catch (erro) {
        done(erro);
      }
    }
  ),
);

passport.use(
  new BearerStrategy(
    (token, done) => {
      try {
        await verificarTokenBlacklist(token);
        const payload = jwt.verify(token, process.env.CHAVE_JWT);
        const usuario = await Usuario.buscaPorId(payload.id);
        done(null, usuario, { token: token });
      } catch (erro) {
        done(erro);
      }
    }
  )
);