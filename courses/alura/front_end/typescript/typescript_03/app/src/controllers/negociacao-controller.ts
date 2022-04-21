import { domInject } from '../decorators/dom-inject.js';
import { NegociacaoDoDia } from '../interfaces/negociacao-do-dia.js';
import { Negociacao } from '../models/negociacao.js';
import { Negociacoes } from '../models/negociacoes.js';
import { NegociacoesService } from '../services/negociacoes-service.js';
import { imprimir } from '../utils/imprimir.js';
import { MensagemView } from '../views/mensagem-view.js';
import { NegociacoesView } from '../views/negociacoes-view.js';

export class NegociacaoController {
  @domInject('#data')
  private inputData: HTMLInputElement;
  
  @domInject('#quantidade')
  private inputQuantidade: HTMLInputElement;
  
  @domInject('#valor')
  private inputValor: HTMLInputElement;
  
  private negociacoes = new Negociacoes();
  private negociacoesView = new NegociacoesView('#negociacoesView');
  private mensagemView = new MensagemView('#mensagemView');
  private negociacoesService = new NegociacoesService();
  
  onstructor() {
    this.negociacoesView.update(this.negociacoes);
  }

  public adiciona(): void {
    const negociacao = Negociacao.criaDe(
      this.inputData.value,
      this.inputQuantidade.value,
      this.inputValor.value
    );

    if (!this.eDiaUtil(negociacao.data)) {
      this.mensagemView
        .update('Negociações permitidas apenas em dias úteis.');
    }

    this.negociacoes.adiciona(negociacao);
    imprimir(negociacao, this.negociacoes);
    this.atualizarView();
    this.limparFormulario();
  }

  public importarDados(): void {
    this.negociacoesService
    .obterNegociacoes()
    .then(negociacoesHoje => {
      return negociacoesHoje.filter(negociacaoHoje => {
        return !this.negociacoes
          .lista()
          .some(
            negociacao => negociacao.eIgual(negociacaoHoje)
          )
      })
    })
    .then(negociacoesHoje => {
      for (let negociacao of negociacoesHoje) {
        this.negociacoes.adiciona(negociacao);
      }
      this.negociacoesView.update(this.negociacoes);
    });
  }

  private eDiaUtil(data: Date): boolean {
    return data.getDay() > DiasDaSemana.DOMINGO
      && data.getDay() < DiasDaSemana.SABADO;
  }

  private limparFormulario(): void {
    this.inputData.value = '';
    this.inputQuantidade.value = '';
    this.inputValor.value = '';
    this.inputData.focus();
  }

  private atualizarView(): void {
    this.negociacoesView.update(this.negociacoes);
    this.mensagemView.update('Negociação adicionada com sucesso.');
  }
}
