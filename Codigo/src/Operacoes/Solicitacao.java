/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacoes;

import DAO.ResidenciaDAO;
import dadosResidencia.Bem;
import dadosResidencia.Residencia;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author SABRINA
 */
public class Solicitacao {
    private Date dataSolicitacao;

    private double valorSolicitacao;

    private Date dataVisitaResidencia;

    private String aprovadaSolicitacao;

    private String motivoReprovacao;

    private String motivoAlteracao;

    private Residencia residencia;

    private ResidenciaDAO daoRes; // remover este atributo
    
    public Solicitacao(Date dataSolicitacao, Residencia residencia) {
        this.dataSolicitacao = dataSolicitacao;
        this.residencia = residencia;
        this.valorSolicitacao = 0;
        this.aprovadaSolicitacao = null;
        this.dataVisitaResidencia = null;
        this.motivoAlteracao = null;
        this.motivoReprovacao = null;
        this.valorSolicitacao = 0;
        
    }
    public Solicitacao(){
    
    }

    public Solicitacao(Date dataSolicitacao, double valorSolicitacao, Date dataVisitaResidencia, String aprovadaSolicitacao, String motivoReprovacao, String motivoAlteracao, Residencia residencia, ResidenciaDAO daoResidencia) {
        this.valorSolicitacao = valorSolicitacao;
        this.dataSolicitacao = dataSolicitacao;
        this.residencia = residencia;
        this.aprovadaSolicitacao = aprovadaSolicitacao; 
        this.motivoAlteracao = motivoAlteracao; 
        this.motivoReprovacao = motivoReprovacao; 
        this.dataVisitaResidencia = dataVisitaResidencia;
        this.daoRes = daoResidencia;
        
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
    
   
}

