import { Imprimivel } from "../interfaces/Imprimivel";

export function imprimir(...objetos: Imprimivel[]) {
  for (let objeto of objetos) {
    console.log(objeto.paraTexto());
  }
}