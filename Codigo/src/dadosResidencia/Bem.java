package dadosResidencia;

public class Bem {

    private float valorEstimadoBem;

    private String descricaoBem;

    public Bem() {
    }

    public Bem(String descricao, float valor) {
        this.valorEstimadoBem = valor;
        this.descricaoBem = descricao;
    }

    /**
     * @return the valorEstimadoBem
     */
    public float getValorEstimadoBem() {
        return valorEstimadoBem;
    }

    /**
     * @param valorEstimadoBem the valorEstimadoBem to set
     */
    public void setValorEstimadoBem(float valorEstimadoBem) {
        this.valorEstimadoBem = valorEstimadoBem;
    }

    /**
     * @return the descricaoBem
     */
    public String getDescricaoBem() {
        return descricaoBem;
    }

    /**
     * @param descricaoBem the descricaoBem to set
     */
    public void setDescricaoBem(String descricaoBem) {
        this.descricaoBem = descricaoBem;
    }

}
