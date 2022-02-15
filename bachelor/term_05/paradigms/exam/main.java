import java.util.Scanner;
import Funcionario;

public static void main(String args[]) {
    Scanner scn = new Scanner(System.in);
    Funcionario fnc = new Funcionario();

    System.out.println("Insira o nome do funcionário: ");
    String nome = scn.nextLine();

    System.out.println("Insira o salário do funcionário: ");
    int salairo = scn.nextInt();

    fnc.setNome(nome);
    fnc.setSalario(salario);

    System.out.println("O IRRF a ser pago por " + 
                        fnc.getNome(); + " é: " + fnc.getIrrf());

    scn.close();

}