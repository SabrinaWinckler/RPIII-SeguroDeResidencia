package dadosResidencia;

import DAO.BemDAO;

public class Bem {

    private float valorEstimadoBem;

    private String descricaoBem;
    
    private BemDAO dao;

    public Bem(float valorEstimadoBem, String descricaoBem) {
        this.valorEstimadoBem = valorEstimadoBem;
        this.descricaoBem = descricaoBem;
        
    }

    public Bem() {
        this.dao = new BemDAO();
    }

    @Override
    public String toString() {
        return "Bem:" + "\n Valor Estimado do Bem=" + valorEstimadoBem + "\n Descricao do Bem: " + descricaoBem;
    }

    public Bem(String desc, float valor) {
        this.valorEstimadoBem = valor;
        this.descricaoBem = desc;
    }
    public void registraBem(Bem bem){
        dao.create(bem);
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
