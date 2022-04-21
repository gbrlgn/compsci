import { inspect } from "../decorators/inspect";
import { logarTempo } from "../decorators/logar-tempo-de-execucao";

export abstract class View<T> {
  protected elemento: HTMLElement;

  constructor(seletor: string) {
    const elemento = document.querySelector(seletor);
    if (elemento) {
      this.elemento = elemento as HTMLElement;
    } else {
      throw Error("Seletor não existe no DOM.");
    }
    
    this.elemento = document.querySelector(seletor) as HTMLInputElement;
  }

  protected abstract template(model: T): string;
  
  @logarTempo(true)
  @inspect
  public update(model: T): void {
    let template = this.template(model);
    this.elemento.innerHTML = template;
  }
}