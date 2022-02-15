package app;

public class ProdutoAcabado extends Produto {
    private int numSer; //número de série
    private int codFil; //código da filial
    private String tipProd; //tipo de produto
    private float metaProd; //porcentagem da meta de produção
    
    public void setNumSer(int numser) {
        this.numSer = numser;
    }
    public void setCodFil(int codfil) {
        this.codFil = codfil;
    }
    public void setTipProd(String tipprod) {
        this.tipProd = tipprod;
    }
    public void setMetaProd(float metaprod) {
        this.metaProd = metaprod;
    }
    public int getNumSer() {
        return this.numSer;
    }
    public int getCodFil() {
        return this.codFil;
    }
    public String getTipProd() {
        return this.tipProd;
    }
    public float getMetaProd() {
        return this.metaProd;
    }
}