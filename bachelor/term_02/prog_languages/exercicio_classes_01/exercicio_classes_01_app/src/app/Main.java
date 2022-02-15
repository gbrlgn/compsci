package app;

public class Main {

    public static void main(String[] args) {
        MateriaPrima metal = new MateriaPrima("Cobre", 200);
        MateriaPrima plastico = new MateriaPrima("PVC", 400);

        metal.setTaxa(15);
        plastico.setValor(650);

        System.out.println("Estoque de " + metal.getNome() + ": " + metal.getEstoque() + ".");
        System.out.println("Valor do imposto de " + metal.getNome() + ": " + metal.getValorImposto() + ".");
	System.out.println("Preço de " + plastico.getNome() + ": " + plastico.getValor() + ".");
	
        metal.addQtd(50);
	metal.subQtd(20);
	metal.setTaxa(30);

	System.out.println("Estoque de " + meta.getNome() + ": " + metal.getEstoque() + ".");
	System.out.println("Valor do imposto de " + metal.getNome() + ": " + metal.getValorImposto() + ".");
	
        Smartphone novosmartphone = new Smartphone();

        System.out.println("DADOS DO PRODUTO: ");
        System.out.println("Nome da família de produtos: " + novosmartphone.getNome() + ".");
        System.out.println("Valor: R$" + novosmartphone.getValor() + ".");
        System.out.println("Número de série: " + novosmartphone.getNumSer() + ".");
        System.out.println("Código da filial: " + novosmartphone.getCodFil() + ".");
        System.out.println("Tipo de produto: " + novosmartphone.getTipProd() + ".");
        if (novosmartphone.getMetaProd() == 0) {
            System.out.println("Meta não informada.");
        } else {
            System.out.println("Porcentagem da meta atingida: " + novosmartphone.getMetaProd() + "%.");
        }
        System.out.println("Modelo: " + novosmartphone.getSpModelo() + ".");
        System.out.println("Quantidade de memória RAM: " + novosmartphone.getSpRAM() + ".");
        System.out.println("Quantidade de memória para armazenamento: " + novosmartphone.getSpArm() + ".");
        System.out.println("Resolução da câmera: " + novosmartphone.getSpResCam() + ".");

        System.out.println("FIM DA EXECUÇÃO.");
    }
    
}
