package app;
import java.util.Scanner;

public class Smartphone extends ProdutoAcabado {
    private String spModelo;
    private int spRAM;
    private int spArm;
    private int spResCam;
    private int spNumeroMeta;
    private int spNumeroProd;

    public Smartphone() {
        
        Scanner in = new Scanner(System.in);
        
        System.out.println(">> DEFINIR PRODUTO <<");
        System.out.println("Informe o nome da família de smartphones: ");
        String spnome = in.next();
        System.out.println("Informe o valor do smartphone (em reais): ");
        int spvalor = in.nextInt();

        System.out.println(">> DEFINIR DETALHES LOGÍSTICOS <<");
        System.out.println("Informe o codigo da filial: ");
        int cdfil = in.nextInt();
        System.out.println("Informe o tipo de produto: ");
        String tpprod = in.next();

        System.out.println("META - Informe a quantidade de unidades a serem produzidas esperada: ");
        int nummet = in.nextInt();
            if (nummet == 0) {
                System.out.println("Meta não contabilizada.");
            } else {
                this.spNumeroMeta = nummet;
            }
        System.out.println("META - Informe quantidade produzida: ");
        int nummetprod = in.nextInt();
            if (nummetprod == 0) {
                System.out.println("Meta não contabilizada.");
            } else {
                this.spNumeroProd = nummetprod;
            }
    
        System.out.println(">> DEFINIR MODELO <<");
        System.out.println("Informe o nome do modelo: ");
        String modelo = in.next();

        System.out.println("Informe a quantidade de memória RAM (em gigabytes): ");
        int ram = in.nextInt();

        System.out.println("Informe a quantidade de memória para armazenamento (em gigabytes): ");
        int arm = in.nextInt();

        System.out.println("Informe a resolução da câmera (em megapixels): ");
        int rescam = in.nextInt();

        in.close();

        super.setNome(spnome);
        super.setValor(spvalor);
        super.setNumSer(super.getNumSer() * 1 + 1);
        super.setCodFil(cdfil);
        super.setTipProd(tpprod);
        
        if (this.spNumeroMeta == 0 ) {
            setMetaProd(0);
        } else if (this.spNumeroProd == 0) {
            setMetaProd(0);
        } else {
            setMetaProd((float) this.spNumeroProd / (float) this.spNumeroMeta * 100);
        }

        setSpModelo(modelo);
        setSpRAM(ram);
        setSpArm(arm);
        setSpResCam(rescam);
    }


    
    public void setSpModelo(String modelo) {
        this.spModelo = modelo;
    }
    public void setSpRAM(int ram) {
        this.spRAM = ram;
    }
    public void setSpArm(int arm) {
        this.spArm = arm;
    }
    public void setSpResCam(int rescam) {
        this.spResCam = rescam;
    }
    public String getSpModelo() {
        return this.spModelo;
    }
    public int getSpRAM() {
        return this.spRAM;
    }
    public int getSpArm() {
        return this.spArm;
    }
    public int getSpResCam() {
        return this.spResCam;
    }
}
