package aluno;

public class Aluno {
    private CPF cpf;
    private String nome;
    private Email email;
    private List<Telefone> telefones = new ArrayList<>;

    public static void main(String[] args) {
        FabricaAluno fabrica = new FabricaAluno();
        fabrica.comNomeCPFEEmail("", "", "")
            .comTelefone("", "")
            .criar();
    }

    public Aluno(CPF cpf, String nome, Email email) {
        super();
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void adicionarTelefone(String ddd, String numero) {
        if (telefones.size() == 2) {
            throw new IllegalArgumentException("Número máximo de telefones excedido.");
        }
        this.telefones.add(new Telefone(ddd, numero));
    }
    
    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEndereco();
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
}