package Dominio;

public class Bem {

    private int codBem;
    private int codResidenciaPertencente;
    private float valorEstimadoBem;
    private String descricaoBem;

    public Bem(float valorEstimadoBem, String descricaoBem) {
        this.valorEstimadoBem = valorEstimadoBem;
        this.descricaoBem = descricaoBem;

    }

    public Bem(int codBem, int codResidenciaPertencente, float valorEstimadoBem, String descricaoBem) {
        this.codBem = codBem;
        this.codResidenciaPertencente = codResidenciaPertencente;
        this.valorEstimadoBem = valorEstimadoBem;
        this.descricaoBem = descricaoBem;
    }

    public Bem() {
    }

    @Override
    public String toString() {
        return "Bem:" + "\r\n Valor Estimado do Bem=" + valorEstimadoBem + "\r\n Descricao do Bem: " + descricaoBem;
    }

    public Bem(String desc, float valor) {
        this.valorEstimadoBem = valor;
        this.descricaoBem = desc;
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

    /**
     * @return the codBem
     */
    public int getCodBem() {
        return codBem;
    }

    /**
     * @param codBem the codBem to set
     */
    public void setCodBem(int codBem) {
        this.codBem = codBem;
    }

    /**
     * @return the codResidenciaPertencente
     */
    public int getCodResidenciaPertencente() {
        return codResidenciaPertencente;
    }

    /**
     * @param codResidenciaPertencente the codResidenciaPertencente to set
     */
    public void setCodResidenciaPertencente(int codResidenciaPertencente) {
        this.codResidenciaPertencente = codResidenciaPertencente;
    }

}
