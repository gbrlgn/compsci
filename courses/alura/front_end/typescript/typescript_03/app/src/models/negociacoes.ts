import { Comparavel } from '../interfaces/comparavel.js';
import { Imprimivel } from '../interfaces/Imprimivel.js';
import { Negociacao } from './negociacao.js';

export class Negociacoes implements Imprimivel, Comparavel<Negociacoes> {
  private negociacoes: Negociacao[] = [];

  public adiciona(negociacao: Negociacao) {
    this.negociacoes.push(negociacao);
  }

  public lista(): readonly Negociacao[] {
    return this.negociacoes;
  }

  public paraTexto(): string {
    return JSON.stringify(this.negociacoes, null, 2);
  }

  public eIgual(negociacao: Negociacoes): boolean {
    return JSON.stringify(this.negociacoes)
      === JSON.stringify(negociacao.lista());
  }
}