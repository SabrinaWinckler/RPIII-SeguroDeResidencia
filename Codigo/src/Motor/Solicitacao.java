package Motor;

import DAO.ResidenciaDAO;
import dadosResidencia.Bem;
import dadosResidencia.Residencia;
import java.util.Date;
import java.util.List;

public class Solicitacao {

    private Date dataSolicitacao;

    private double valorSolicitacao;

    private Date dataVisitaResidencia;

    private String aprovadaSolicitacao;

    private String motivoReprovacao;

    private String motivoAlteracao;

    private Residencia residencia;

    private ResidenciaDAO daoResidencia;

    public Solicitacao(Date dataSolicitacao, double valorSolicitacao, Date dataVisitaResidencia, String aprovadaSolicitacao, String motivoReprovacao, String motivoAlteracao, Residencia residencia, ResidenciaDAO daoResidencia) {
        this.dataSolicitacao = dataSolicitacao;
        this.valorSolicitacao = valorSolicitacao;
        this.dataVisitaResidencia = dataVisitaResidencia;
        this.aprovadaSolicitacao = aprovadaSolicitacao;
        this.motivoReprovacao = motivoReprovacao;
        this.motivoAlteracao = motivoAlteracao;
        this.residencia = residencia;
        this.daoResidencia = daoResidencia;
    }

    public Solicitacao() {
        //this.dataSolicitacao = null;
        //this.residencia = new Residencia();
        //this.daoResidencia = new ResidenciaDAO();
    }

    @Override
    public String toString() {
        return "Solicitacao{" + "dataSolicitacao=" + dataSolicitacao + ", residencias=" + residencia + '}';
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public Residencia getResidencia() {

        return residencia;
    }

//    public ArrayList<Residencia> getResidencias() {
//        return residencias;
//    }
    public ResidenciaDAO getDaoResidencia() {
        return daoResidencia;
    }

    
    public void registrarSolicitacao(Residencia residencia, Date dataSolicitacao) {
        this.setResidencia(residencia);
        System.out.println(residencia.toString());
        residencia.registraResidencia(residencia, daoResidencia);
//        for(int i = 0; i< bens.size(); i++ ){
//            Bem bem = new Bem();
//            bem = (Bem)bens.get(i);
//            bem.registraBem(bem);
//        }
        this.setDataSolicitacao(dataSolicitacao);
    }

    /**
     * @param dataSolicitacao the dataSolicitacao to set
     */
    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    /**
     * @return the valorSolicitacao
     */
    public double getValorSolicitacao() {
        return valorSolicitacao;
    }

    /**
     * @param valorSolicitacao the valorSolicitacao to set
     */
    public void setValorSolicitacao(double valorSolicitacao) {
        this.valorSolicitacao = valorSolicitacao;
    }

    /**
     * @return the dataVisitaResidencia
     */
    public Date getDataVisitaResidencia() {
        return dataVisitaResidencia;
    }

    /**
     * @param dataVisitaResidencia the dataVisitaResidencia to set
     */
    public void setDataVisitaResidencia(Date dataVisitaResidencia) {
        this.dataVisitaResidencia = dataVisitaResidencia;
    }

    /**
     * @return the aprovadaSolicitacao
     */
    public String getAprovadaSolicitacao() {
        return aprovadaSolicitacao;
    }

    /**
     * @param aprovadaSolicitacao the aprovadaSolicitacao to set
     */
    public void setAprovadaSolicitacao(String aprovadaSolicitacao) {
        this.aprovadaSolicitacao = aprovadaSolicitacao;
    }

    /**
     * @return the motivoReprovacao
     */
    public String getMotivoReprovacao() {
        return motivoReprovacao;
    }

    /**
     * @param motivoReprovacao the motivoReprovacao to set
     */
    public void setMotivoReprovacao(String motivoReprovacao) {
        this.motivoReprovacao = motivoReprovacao;
    }

    /**
     * @param residencia the residencia to set
     */
    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }

    /**
     * @param daoResidencia the daoResidencia to set
     */
    public void setDaoResidencia(ResidenciaDAO daoResidencia) {
        this.daoResidencia = daoResidencia;
    }

    /**
     * @return the motivoAlteracao
     */
    public String getMotivoAlteracao() {
        return motivoAlteracao;
    }

    /**
     * @param motivoAlteracao the motivoAlteracao to set
     */
    public void setMotivoAlteracao(String motivoAlteracao) {
        this.motivoAlteracao = motivoAlteracao;
    }

}
