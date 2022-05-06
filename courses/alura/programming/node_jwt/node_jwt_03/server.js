require('dotenv').config()

const { JsonWebTokenError, TokenExpiredError } = require('jsonwebtoken')
const { ConversorErro } = require('./src/conversores')
const app = require('./app')
require('./database')
require('./redis/blocklist-access-token')
require('./redis/allowlist-refresh-token')
const routes = require('./rotas')
const { InvalidArgumentError, NaoEncontrado, NaoAutorizado } = require('./src/erros')
routes(app)
const port = 3000

app.use((req, res, next) => {
  res.set({
    'Content-Type': 'application/json'
  })

  next()
})

app.use((err, req, res, next) => {
  let status = 500
  const corpo = {
    mensagem: err.message
  }

  if (err instanceof NaoEncontrado) {
    status = 404
  }

  if (err instanceof NaoAutorizado) {
    status = 403
  }

  if (err instanceof InvalidArgumentError) {
    status = 400
  }

  if (err instanceof JsonWebTokenError) {
    status = 401
  }

  if (err instanceof TokenExpiredError) {
    status = 40
    corpo.expiradoEm = err.expiredAt
  }
  
  res.status(status)
  res.json(corpo)
})

app.listen(port, () => console.log('A API está funcionando!'))
