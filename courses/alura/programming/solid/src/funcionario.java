public class Funcionario {

    private String nome;
    private String cpf;
    private Cargo cargo;
    private double salario;

    public void reajustarSalario(double aumento) {
        double percentualReajuste = (aumento / salario) * 100;

        if (percentualReajuste > 40) {
            throw new IllegalArgumentException(
                "Percentual de reajuste deve ser inferior a 40%.";
        }

        this.salario += aumento;
    }

    public static void main(String[] args) {
        Funcionario funcionario = carregarDoBancoDeDados();

        double valorTotalReajustes = 0;
        List<Reajuste> reajustes = funcionatio.getReajustes();
        for (Reajuste r : reajustes) {
            valorTotalReajustes += r.getValor();
        }
    }
}