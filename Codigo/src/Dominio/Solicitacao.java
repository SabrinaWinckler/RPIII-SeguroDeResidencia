/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.Date;

/**
 *
 * @author SABRINA
 */
public class Solicitacao {

    private int codSolicitacao;

    private Date dataSolicitacao;

    private double valorSolicitacao;

    private Date dataVisitaResidencia;

    private String aprovadaSolicitacao;

    private String motivoReprovacao;

    private String motivoAlteracao;

    private Residencia residencia;

    private int idResidencia;

    public Solicitacao() {
        this.residencia = new Residencia();
    }

    public Solicitacao(Date dataSolicitacao, Residencia residencia, double valorSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
        this.residencia = residencia;
        this.aprovadaSolicitacao = null;
        this.dataVisitaResidencia = null;
        this.motivoAlteracao = null;
        this.motivoReprovacao = null;
        this.valorSolicitacao = valorSolicitacao;
    }

    public Solicitacao(Date dataSolicitacao, double valorSolicitacao, Date dataVisitaResidencia, String aprovadaSolicitacao, String motivoReprovacao, String motivoAlteracao, Residencia residencia) {
        this.valorSolicitacao = valorSolicitacao;
        this.dataSolicitacao = dataSolicitacao;
        this.residencia = residencia;
        this.aprovadaSolicitacao = aprovadaSolicitacao;
        this.motivoAlteracao = motivoAlteracao;
        this.motivoReprovacao = motivoReprovacao;
        this.dataVisitaResidencia = dataVisitaResidencia;
    }

    public Solicitacao(int codSolicitacao, Date dataSolicitacao, double valorSolicitacao, Date dataVisitaResidencia, String aprovadaSolicitacao, String motivoReprovacao, String motivoAlteracao, Residencia residencia) {
        this.codSolicitacao = codSolicitacao;
        this.dataSolicitacao = dataSolicitacao;
        this.valorSolicitacao = valorSolicitacao;
        this.dataVisitaResidencia = dataVisitaResidencia;
        this.aprovadaSolicitacao = aprovadaSolicitacao;
        this.motivoReprovacao = motivoReprovacao;
        this.motivoAlteracao = motivoAlteracao;
        this.residencia = residencia;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public void setValorSolicitacao(double valorSolicitacao) {
        this.valorSolicitacao = valorSolicitacao;
    }

    public void setDataVisitaResidencia(Date dataVisitaResidencia) {
        this.dataVisitaResidencia = dataVisitaResidencia;
    }

    public void setAprovadaSolicitacao(String aprovadaSolicitacao) {
        this.aprovadaSolicitacao = aprovadaSolicitacao;
    }

    public void setMotivoReprovacao(String motivoReprovacao) {
        this.motivoReprovacao = motivoReprovacao;
    }

    public void setMotivoAlteracao(String motivoAlteracao) {
        this.motivoAlteracao = motivoAlteracao;
    }

    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public double getValorSolicitacao() {
        return valorSolicitacao;
    }

    public Date getDataVisitaResidencia() {
        return dataVisitaResidencia;
    }

    public String getAprovadaSolicitacao() {
        return aprovadaSolicitacao;
    }

    public String getMotivoReprovacao() {
        return motivoReprovacao;
    }

    public String getMotivoAlteracao() {
        return motivoAlteracao;
    }

    public Residencia getResidencia() {
        return residencia;
    }

    @Override
    public String toString() {
        return "Solicitacao{" + "dataSolicitacao=" + dataSolicitacao + ", residencia=" + residencia.toString() + '}';
    }

    /**
     * @return the codSolicitacao
     */
    public int getCodSolicitacao() {
        return codSolicitacao;
    }

    /**
     * @param codSolicitacao the codSolicitacao to set
     */
    public void setCodSolicitacao(int codSolicitacao) {
        this.codSolicitacao = codSolicitacao;
    }

    /**
     * @return the idResidencia
     */
    public int getIdResidencia() {
        return idResidencia;
    }

    /**
     * @param idResidencia the idResidencia to set
     */
    public void setIdResidencia(int idResidencia) {
        this.idResidencia = idResidencia;
    }

}
