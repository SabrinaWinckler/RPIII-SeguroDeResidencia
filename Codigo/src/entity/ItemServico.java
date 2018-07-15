/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Matheus Montanha
 */
public class ItemServico extends Servico {

    private String descricaoRecusa;
    private String descricaoAtendimento;
    private Date dataDeAtendimento;
    private String atendidaSolicitacaoServico;
    private String aceitaSolicitacao;
    private String descricaoSolicitacao;
    private Date dataSolicitacaoServico;
    private int idItemServico;

    public ItemServico() {

    }

    public ItemServico(String descricaoRecusa, String descricaoAtendimento, Date dataDeAtendimento, String atendidaSolicitacaoServico, String aceitaSolicitacao, String descricaoSolicitacao, Date dataSolicitacaoServico, int idItemServico, int codServico, String desc, int qnt, Date data, Date visitaResidencia) {
        super(codServico, desc, qnt, data, visitaResidencia);
        this.descricaoRecusa = descricaoRecusa;
        this.descricaoAtendimento = descricaoAtendimento;
        this.dataDeAtendimento = dataDeAtendimento;
        this.atendidaSolicitacaoServico = atendidaSolicitacaoServico;
        this.aceitaSolicitacao = aceitaSolicitacao;
        this.descricaoSolicitacao = descricaoSolicitacao;
        this.dataSolicitacaoServico = dataSolicitacaoServico;
        this.idItemServico = idItemServico;
    }

    /**
     * @return the descricaoRecusa
     */
    public String getDescricaoRecusa() {
        return descricaoRecusa;
    }

    /**
     * @param descricaoRecusa the descricaoRecusa to set
     */
    public void setDescricaoRecusa(String descricaoRecusa) {
        this.descricaoRecusa = descricaoRecusa;
    }

    /**
     * @return the descricaoAtendimento
     */
    public String getDescricaoAtendimento() {
        return descricaoAtendimento;
    }

    /**
     * @param descricaoAtendimento the descricaoAtendimento to set
     */
    public void setDescricaoAtendimento(String descricaoAtendimento) {
        this.descricaoAtendimento = descricaoAtendimento;
    }

    /**
     * @return the dataDeAtendimento
     */
    public Date getDataDeAtendimento() {
        return dataDeAtendimento;
    }

    /**
     * @param dataDeAtendimento the dataDeAtendimento to set
     */
    public void setDataDeAtendimento(Date dataDeAtendimento) {
        this.dataDeAtendimento = dataDeAtendimento;
    }

    /**
     * @return the atendidaSolicitacaoServico
     */
    public String getAtendidaSolicitacaoServico() {
        return atendidaSolicitacaoServico;
    }

    /**
     * @param atendidaSolicitacaoServico the atendidaSolicitacaoServico to set
     */
    public void setAtendidaSolicitacaoServico(String atendidaSolicitacaoServico) {
        this.atendidaSolicitacaoServico = atendidaSolicitacaoServico;
    }

    /**
     * @return the aceitaSolicitacao
     */
    public String getAceitaSolicitacao() {
        return aceitaSolicitacao;
    }

    /**
     * @param aceitaSolicitacao the aceitaSolicitacao to set
     */
    public void setAceitaSolicitacao(String aceitaSolicitacao) {
        this.aceitaSolicitacao = aceitaSolicitacao;
    }

    /**
     * @return the descricaoSolicitacao
     */
    public String getDescricaoSolicitacao() {
        return descricaoSolicitacao;
    }

    /**
     * @param descricaoSolicitacao the descricaoSolicitacao to set
     */
    public void setDescricaoSolicitacao(String descricaoSolicitacao) {
        this.descricaoSolicitacao = descricaoSolicitacao;
    }

    /**
     * @return the dataSolicitacaoServico
     */
    public Date getDataSolicitacaoServico() {
        return dataSolicitacaoServico;
    }

    /**
     * @param dataSolicitacaoServico the dataSolicitacaoServico to set
     */
    public void setDataSolicitacaoServico(Date dataSolicitacaoServico) {
        this.dataSolicitacaoServico = dataSolicitacaoServico;
    }

    /**
     * @return the idItemServico
     */
    public int getIdItemServico() {
        return idItemServico;
    }

    /**
     * @param idItemServico the idItemServico to set
     */
    public void setIdItemServico(int idItemServico) {
        this.idItemServico = idItemServico;
    }

}
