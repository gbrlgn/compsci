import { NegociacaoDoDia } from "../interfaces/negociacao-do-dia";
import { Negociacao } from "../models/negociacao";

export class NegociacoesService {
  public obterNegociacoes(): Promise<Negociacao[]> {
    return fetch('https://localhost:8080/dados')
      .then(res => res.json())
      .then((dados: NegociacaoDoDia[]) => {
        return dados.map(dado => {
          return new Negociacao(
            new Date(),
            dado.montante,
            dado.valor
          )
        })
      });
  }
}