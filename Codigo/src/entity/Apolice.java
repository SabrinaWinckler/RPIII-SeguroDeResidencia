/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Débora Siqueira
 */
public class Apolice {

    private int codApolice;
    private int codSolicitacao;
    private String bandeiraCartão;
    private long numeroApolice;
    private float premioApolice;
    private Date dataContratacaoApolice;
    private String cartaoCreditoPagamento;
    private String vencimentoCartao;
    private int codSegurancaCartao;
    private String nomeNoCartao;
    private int quantidadeParcelas;
    private float valorParcela;

    public Apolice(int codSolicitacao, String bandeiraCartão, long numeroApolice, float premioApolice, Date dataContratacaoApolice, String cartaoCreditoPagamento, String vencimentoCartao, int codSegurancaCartao, String nomeNoCartao, int quantidadeParcelas, float valorParcela) {
        this.codSolicitacao = codSolicitacao;
        this.bandeiraCartão = bandeiraCartão;
        this.numeroApolice = numeroApolice;
        this.premioApolice = premioApolice;
        this.dataContratacaoApolice = dataContratacaoApolice;
        this.cartaoCreditoPagamento = cartaoCreditoPagamento;
        this.vencimentoCartao = vencimentoCartao;
        this.codSegurancaCartao = codSegurancaCartao;
        this.nomeNoCartao = nomeNoCartao;
        this.quantidadeParcelas = quantidadeParcelas;
        this.valorParcela = valorParcela;
    }

    public Apolice(int codApolice, String bandeiraCartão, long numeroApolice, float premioApolice, Date dataContratacaoApolice, String cartaoCreditoPagamento, String vencimentoCartao, int codSegurancaCartao, String nomeNoCartao) {
        this.codApolice = codApolice;
        this.bandeiraCartão = bandeiraCartão;
        this.numeroApolice = numeroApolice;
        this.premioApolice = premioApolice;
        this.dataContratacaoApolice = dataContratacaoApolice;
        this.cartaoCreditoPagamento = cartaoCreditoPagamento;
        this.vencimentoCartao = vencimentoCartao;
        this.codSegurancaCartao = codSegurancaCartao;
        this.nomeNoCartao = nomeNoCartao;
    }

    public Apolice(String bandeiraCartão, long numeroApolice, float premioApolice, Date dataContratacaoApolice, String cartaoCreditoPagamento, String vencimentoCartao, int codSegurancaCartao, String nomeNoCartao) {
        this.bandeiraCartão = bandeiraCartão;
        this.numeroApolice = numeroApolice;
        this.premioApolice = premioApolice;
        this.dataContratacaoApolice = dataContratacaoApolice;
        this.cartaoCreditoPagamento = cartaoCreditoPagamento;
        this.vencimentoCartao = vencimentoCartao;
        this.codSegurancaCartao = codSegurancaCartao;
        this.nomeNoCartao = nomeNoCartao;
    }

    /**
     * @return the codApolice
     */
    public int getCodApolice() {
        return codApolice;
    }

    /**
     * @param codApolice the codApolice to set
     */
    public void setCodApolice(int codApolice) {
        this.codApolice = codApolice;
    }

    /**
     * @return the bandeiraCartão
     */
    public String getBandeiraCartão() {
        return bandeiraCartão;
    }

    /**
     * @param bandeiraCartão the bandeiraCartão to set
     */
    public void setBandeiraCartão(String bandeiraCartão) {
        this.bandeiraCartão = bandeiraCartão;
    }

    /**
     * @return the numeroApolice
     */
    public long getNumeroApolice() {
        return numeroApolice;
    }

    /**
     * @param numeroApolice the numeroApolice to set
     */
    public void setNumeroApolice(long numeroApolice) {
        this.numeroApolice = numeroApolice;
    }

    /**
     * @return the premioApolice
     */
    public float getPremioApolice() {
        return premioApolice;
    }

    /**
     * @param premioApolice the premioApolice to set
     */
    public void setPremioApolice(float premioApolice) {
        this.premioApolice = premioApolice;
    }

    /**
     * @return the dataContratacaoApolice
     */
    public Date getDataContratacaoApolice() {
        return dataContratacaoApolice;
    }

    /**
     * @param dataContratacaoApolice the dataContratacaoApolice to set
     */
    public void setDataContratacaoApolice(Date dataContratacaoApolice) {
        this.dataContratacaoApolice = dataContratacaoApolice;
    }

    /**
     * @return the cartaoCreditoPagamento
     */
    public String getCartaoCreditoPagamento() {
        return cartaoCreditoPagamento;
    }

    /**
     * @param cartaoCreditoPagamento the cartaoCreditoPagamento to set
     */
    public void setCartaoCreditoPagamento(String cartaoCreditoPagamento) {
        this.cartaoCreditoPagamento = cartaoCreditoPagamento;
    }

    /**
     * @return the vencimentoCartao
     */
    public String getVencimentoCartao() {
        return vencimentoCartao;
    }

    /**
     * @param vencimentoCartao the vencimentoCartao to set
     */
    public void setVencimentoCartao(String vencimentoCartao) {
        this.vencimentoCartao = vencimentoCartao;
    }

    /**
     * @return the codSegurancaCartao
     */
    public int getCodSegurancaCartao() {
        return codSegurancaCartao;
    }

    /**
     * @param codSegurancaCartao the codSegurancaCartao to set
     */
    public void setCodSegurancaCartao(int codSegurancaCartao) {
        this.codSegurancaCartao = codSegurancaCartao;
    }

    /**
     * @return the nomeNoCartao
     */
    public String getNomeNoCartao() {
        return nomeNoCartao;
    }

    /**
     * @param nomeNoCartao the nomeNoCartao to set
     */
    public void setNomeNoCartao(String nomeNoCartao) {
        this.nomeNoCartao = nomeNoCartao;
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
     * @return the quantidadeParcelas
     */
    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    /**
     * @param quantidadeParcelas the quantidadeParcelas to set
     */
    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    /**
     * @return the valorParcela
     */
    public float getValorParcela() {
        return valorParcela;
    }

    /**
     * @param valorParcela the valorParcela to set
     */
    public void setValorParcela(float valorParcela) {
        this.valorParcela = valorParcela;
    }

}
