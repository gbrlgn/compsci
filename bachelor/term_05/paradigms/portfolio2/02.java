// Implementar um sistema de registros de animais,
// de maneira modular o bastante que permita o reuso
// eficiente do código de acordo com o animal graças
// à programação orientada a objetos; neste exemplo,
// o registro de um gato.

public class RegistroAnimal()
{
    String dono;
    Sreing nome;
    String especie;
    String raca;
    int idade;
    float tamanho;
    Boolean castrado;

    // Construtor
    public RegistroAnimal(String dono, String nome, String especie 
            
                           String raca, int idade, int tamanho)
    {
        this.dono = dono;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.tamanho = tamanho;
    }

    // Declarações de getters e setters
    
}

// A classe RegistroGato herda atributos e métodos
// da classe mãe RegistroAnimal, economizando na
// implementação dos mesmos.

public class RegistroGato extends registroAnimal()
{
    private int tamanhoDasUnhas;
    private float intensidadeMiado;

    public RegistroGato()
    {
        // Código do construtor
    }

    // Getters e setters
}
