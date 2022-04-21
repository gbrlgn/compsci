import { Comparavel } from "../interfaces/comparavel";
import { Imprimivel } from "../interfaces/Imprimivel";

export class Negociacao implements Imprimivel, Comparavel<Negociacao> {
  constructor(
    private _data: Date, 
    public readonly quantidade: number, 
    public readonly valor: number
  ) {}

  public get volume(): number {
    return this.quantidade * this.valor;
  }

  public get data(): Date {
    const data = new Date(this._data.getTime());
    return data;
  }

  public static criaDe(
    dataS: string,
    quantidadeS: string,
    valorS: string
  ): Negociacao {
    const exp = /-/g;
    const date = new Date(dataS.replace(exp, ','));
    const quantidade = parseInt(quantidadeS);
    const valor = parseFloat(valorS);
    return new Negociacao(date, quantidade, valor);
  }

  public paraTexto(): string {
    return `
      Data: ${this.data},
      Quantidade: ${this.quantidade},
      Valor: ${this.valor}
    `;
  }

  public eIgual(negociacao: Negociacao): boolean {
    return this.data.getDate() === negociacao.data.getDate()
        && this.data.getMonth() === negociacao.data.getMonth()
        && this.data.getFullYear() === negociacao.data.getFullYear();
  }
}