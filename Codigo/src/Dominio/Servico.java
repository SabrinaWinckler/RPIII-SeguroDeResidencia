/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.Date;

/**
 *
 * @author Matheus Montanha
 */
public class Servico {

    private int idCodServico;
    private String desc;
    private int qnt;
    private Date dataDeSolitacao;
    private Date dataDeVisita;

    public Servico() {
    }

    public Servico(int codServico, String desc, int qnt, Date data, Date visitaResidencia) {
        this.desc = desc;
        this.qnt = qnt;
        this.idCodServico = codServico;
        this.dataDeSolitacao = data;
        this.dataDeVisita = visitaResidencia;
    }

    public Servico(String desc, int qnt, Date data, Date visitaResidencia) {
        this.desc = desc;
        this.qnt = qnt;
        this.dataDeSolitacao = data;
        this.dataDeVisita = visitaResidencia;
    }

    public String getDesc() {
        return desc;
    }

    public int getQnt() {
        return qnt;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    /**
     * @return the idCodServico
     */
    public int getIdCodServico() {
        return idCodServico;
    }

    /**
     * @param idCodServico the idCodServico to set
     */
    public void setIdCodServico(int idCodServico) {
        this.idCodServico = idCodServico;
    }

    /**
     * @return the dataDeSolitacao
     */
    public Date getDataDeSolitacao() {
        return dataDeSolitacao;
    }

    /**
     * @param dataDeSolitacao the dataDeSolitacao to set
     */
    public void setDataDeSolitacao(Date dataDeSolitacao) {
        this.dataDeSolitacao = dataDeSolitacao;
    }

    /**
     * @return the dataDeVisita
     */
    public Date getDataDeVisita() {
        return dataDeVisita;
    }

    /**
     * @param dataDeVisita the dataDeVisita to set
     */
    public void setDataDeVisita(Date dataDeVisita) {
        this.dataDeVisita = dataDeVisita;
    }

}
