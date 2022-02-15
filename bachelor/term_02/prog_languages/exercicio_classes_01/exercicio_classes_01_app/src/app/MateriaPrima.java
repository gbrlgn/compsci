package app;

public class MateriaPrima extends Produto {
       
    private double taxa;
    private int estoque;
    
    public MateriaPrima(String nome, int qtd) {
        this.estoque = qtd;
        super.setNome(nome);
    }
    
    public int addQtd(int qtd) {
        this.estoque = this.getEstoque() + qtd;
        return this.getEstoque();
    }
    
    public int subQtd(int qtd) {
        this.estoque = this.getEstoque() - qtd;
        return this.getEstoque();
    }
    
    public double getValorImposto() {
        return (double) ((1000 - this.getEstoque()) * 1.5 * this.getTaxa());
    }
    
    public void setTaxa(double taxa) { 
        this.taxa = taxa;
    }
    
    public double getTaxa() { 
        return this.taxa;
    }
    
    public void setEstoque(int estoque) {  
        if (estoque == this.getEstoque()) {
            System.out.println("Estoque já etabelecido.");  
        } else {
            this.estoque = estoque;
        }
    }
    
    public int getEstoque() {
        return this.estoque;
    }
}
