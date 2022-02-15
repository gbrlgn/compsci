# **Exercício Sobre Classes** #

#### *Gabriel Gian Fonseca Lemos* ####

Neste projeto em Java, foram definidas quatro classes: Produto, que é a classe mãe; MateriaPrima, que herda atributos de Produto; ProdutoAcabado, que também herda atributos de Produto, e Smartphone, que por sua vez herda atributos de ProdutoAcabado. 

A Classe produto detém os atributos valor e nome, e os métodos setValor (integer) e setNome (string). 

A classe MateriaPrima detém os atributos estoque e taxa e Detém os métodos setEstoque, setTaxa (e seus respetivos métodos de retorno "get"), getValorImposto, addQtd e subQtd. Seu construtor sempre procura como parâmetro, no momento do instanciamento, uma string e um integer. Ele usa, então, essa string no método herdado setNome e o integer é definido como o número de unidades em estoque. A classe ProdutoAcabado detém os atributos numSerie, codFil, tipProd e metaProd, além dos métodos a eles relacionados.

Por fim, a classe Smartphone detém os atributos spModelo (String), spRAM (integer), spArm (integer), spResCam (integer), spNumeroMeta (integer) e spNumeroProd (integer.)

Seu construtor inicia a sua operação criando um objeto da classe Scanner, importada da biblioteca java.util.Scanner, que é usado para obter a entrada do usuário numa série de parâmetros, que são salvos em variáveis relacionadas e, no fim do bloco, aplicadas aos atributos por meio dos seus respectivos métodos. Em especial, o número de série sempre será somado com 1, de maneira crescente, a cada nova entrada criada. O número de meta e o número de produção, caso tenha o valor informado pelo usuário igual a 0, avisaré a não contabilização do mesmo; caso o oposto ocorra, uma operação de porcentagem em relação aos dois é executada, salvando o número final — a porcentagem da meta estabelecida que foi produzida até o momento — no atributo metaProd, convertendo-o antes para o tipo float, da classe ProdutoAcabado por meio de um método que faz o uso do termo super.

Por fim, a rotina Main executa, premeditadamente, a criação de 2 objetos da classe MateriaPrima e a inserção de valores de taxa, valor e estoque, o cálculo da taxa e a soma e a subtração dos valores do estoque, imprimindo seus retornos logo em seguida.

Após isso, ela executa a criação de um objeto da classe Smartphone (novosmartphone), requerendo as entradas manuais descritas no construtor no momento do instanciamento e por fim imprimindo-as na tela.
