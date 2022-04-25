const blacklist = require('./blacklist');
const jwt = require('jsonwebtoken');
const { createHash } = require('crypto');
const { promisify } = require('util');
const existsAsync = promisify(blacklist.exists).bind(blacklist);
const setAsync = promisify(blacklist.set).bind(blacklist);

function gerarHashToken(token) {
  return createHash('sha256').update(token).digest('hex');
}

module.exports = {
  adiciona: token => {
    const expiracao = jwt.decode(token).exp;
    const tokenHash = gerarHashToken(token);
    await setAsync(tokenHash, '');
    blacklist.expireat(tokenHash, expiracao);
  },

  contemToken: token => {
    const tokenHash = gerarHashToken(token);
    const resultados = await existsAsync(tokenHash);
    return resultados === 1;
  }
}