const jwt = require('jsonwebtoken');
const crypto = require('crypto');
const moment = require('moment');
const allowlistRefreshToken = require('../../redis/allowlist-refresh-token');
const blocklistAccessToken = require('../../redis/blocklist-access-token');

function criaTokenJWT(id,[tempoQuant, tempoUnid]) {
  const payload = { id };

  const token = jwt.sign(payload, process.env.CHAVE_JWT, { expiresIn: tempoQuant + tempoUnid });
  return token;
}

async function verificaTokenNaBlocklist(token, blocklist) {
  if (!blocklist) {
    return;
  }
  
  const tokenNaBlocklist = await blocklist.contemToken(token);
  if (tokenNaBlocklist) {
    throw new jwt.JsonWebTokenError(`${nome} token inválido por logout!`);
  }
}

async function verificaTokenJWT(token, blocklist) {
  await verificaTokenNaBlocklist(token, blocklist);
  const { id } = jwt.verify(token, process.env.CHAVE_JWT);
  return id;
}

function criarTokenOpaco(id, [tempoQuant, tempoUnid], allowlist) {
  const tokenOpaco = crypto.randomBytes(24).toString('hex');
  const dataExpiracao = moment().add(tempoQuant, tempoUnid).unix();
  await allowlist.adiciona(tokenOpaco, id, dataExpiracao);
  return tokenOpaco;
}

function verificaTokenInvalido(id, nome) {
  if (!id) {
    throw new InvalidArgumentError(`${nome} token inválido.`);
  }
}

function verificaTokenEnviado(token, nome) {
  if (!token) {
    throw new InvalidArgumentError(`${nome} token não enviado.`);
  }
}

async function verificaTokenOpaco(token, nome, allowlist) {
  verificaTokenEnviado(token, nome);
  const id = await allowlist.buscaValor(token);
  verificaTokenInvalido(id, nome);
  return id;
}

async function invalidaTokenJWT(token, blocklist) {
  await blocklist.adiciona(token);
}

async function invalidaTokenOpaco(token, alowlist) {
  await alowlist.deleta(token);
}

module.exports = {
  access: {
    nome: "Access",
    blocklist: blocklistAccessToken,
    expiracao: [15, "m"],
    cria(id) {
      return criaTokenJWT(id, this.expiracao);
    },
    verifica(token) {
      return verificaTokenJWT(token, this.nome, this.blocklist);
    },
    invalida(token) {
      return invalidaTokenJWT(token, this.blocklist);
    }
  },
  
  refresh: {
    nome: "Refresh",
    allowlist: allowlistRefreshToken,
    expiracao: [5, "d"],
    cria(id) {
      return criarTokenOpaco(id, this.expiracao, this.allowlist);
    },
    verifica(token) {
      return verificaTokenOpaco(token, this.nome, this.allowlist);
    },
    invalida(token) {
      return invalidaTokenOpaco(token, this.allowlist);
    }
  },

  verificacaoEmail: {
    nome: 'Verification',
    expiracao: [1, 'h'],
    cria(id) {
      return criaTokenJWT(id, this.expiracao);
    },
    verifica(token) {
      return verificaTokenJWT(token, this.nome);
    }
  }
}