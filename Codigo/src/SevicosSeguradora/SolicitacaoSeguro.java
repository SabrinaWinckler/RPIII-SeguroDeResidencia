/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SevicosSeguradora;

import DadosUsuarios.Candidato;

/**
 *
 * @author SABRINA
 */
public class SolicitacaoSeguro {

    private String dataSolicitacao;
    private float valorSolicitacao;
    private String dataVisitaResidencia;
    private String aprovadaSolicitacao;
    private String motivoReprovacao;
    private String motivoAlteracao;
    //private Residencia residencia;
    //private Candidato candidato;

    public SolicitacaoSeguro(String dataSolicitacao, float valorSolicitacao, String dataVisitaResidencia, String aprovadaSolicitacao, String motivoReprovacao, String motivoAlteracao) {
        this.dataSolicitacao = dataSolicitacao;
        this.valorSolicitacao = valorSolicitacao;
        this.dataVisitaResidencia = dataVisitaResidencia;
        this.aprovadaSolicitacao = aprovadaSolicitacao;
        this.motivoReprovacao = motivoReprovacao;
        this.motivoAlteracao = motivoAlteracao;
        //this.residencia = residencia;
        //this.candidato = candidato;
    }

    public SolicitacaoSeguro() {

    }

    /**
     * @return the dataSolicitacao
     */
    public String getDataSolicitacao() {
        return dataSolicitacao;
    }

    /**
     * @param dataSolicitacao the dataSolicitacao to set
     */
    public void setDataSolicitacao(String dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    /**
     * @return the valorSolicitacao
     */
    public float getValorSolicitacao() {
        return valorSolicitacao;
    }

    /**
     * @param valorSolicitacao the valorSolicitacao to set
     */
    public void setValorSolicitacao(float valorSolicitacao) {
        this.valorSolicitacao = valorSolicitacao;
    }

    /**
     * @return the dataVisitaResidencia
     */
    public String getDataVisitaResidencia() {
        return dataVisitaResidencia;
    }

    /**
     * @param dataVisitaResidencia the dataVisitaResidencia to set
     */
    public void setDataVisitaResidencia(String dataVisitaResidencia) {
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

    /**
     * @return the residencia
     */
    /*
    public Residencia getResidencia() {
        return residencia;
    }

    /**
     * @param residencia the residencia to set
     */
 /*
    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }
    /**
     * @return the candidato
     */
 /*
    public Candidato getCandidato() {
        return candidato;
    }

    /**
     * @param candidato the candidato to set
     */
 /*
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
     */
}
