package dadosResidencia;

public class Bem {

	private float valorEstimadoBem;

	private String descricaoBem;

    public Bem() {
        this.valorEstimadoBem = 0;
        this.descricaoBem = null;
    }
    public void resgitraBem(String descricao, float valor){
        this.setValorEstimadoBem(valor);
        this.setDescricaoBem(descricao);
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
