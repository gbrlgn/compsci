class Conversor {
  converter(dados) {
    if (this.camposPublicos.indexOf('*') === -1) {
      dados = this.filtrar(dados)
    }

    if (this.tipoConteudo === 'json') {
      return this.json(dados)
    }
  }

  json(dados) {
    return JSON.stringify(dados)
  }

  filtrar(dados) {
    if (Array.isArray(dados)) {
      dados = dados.map((post) => this.filtrarObjeto(post))
    } else {
      dados = this.filtrarObjeto(dados)
    }
  }

  filtrarObjeto(objeto) {
    const objetoFiltrado = {}

    this.camposPublicos.forEach((campo) => {
      if (Reflect.has(objeto, campo)) {
        objetoFiltrado[campo] = objeto[campo]
      }
    })

    return objetoFiltrado
  }
}

class ConversorPost extends Conversor {
  constructor(tipoConteudo, camposExtras = []) {
    this.tipoConteudo = tipoConteudo
    this.camposPublicos = ['titulo', 'conteudo'].concat(camposExtras)
  }
}

class ConversorUsuario extends Conversor {
  constructor(tipoConteudo, camposExtras = []) {
    super()
    this.tipoConteudo = tipoConteudo
    this.camposPublicos = ['nome'].concat(camposExtras)
  }
}

module.exports = ConversorPost, ConversorUsuario