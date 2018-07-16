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
public class Sinistro extends TipoSinistro {

    private int codSinistro;
    private int codResidencia;
    private Date dataSinistro;
    private String descricaoSinistro;
    private float valorSinistro;
    private String autorizadoSinistro;
    private String parecerAvaliador;
    private String motivoReprovacao;

    public Sinistro() {

    }

    public Sinistro(Date dataSinistro, String descricaoSinistro, float valorSinistro, String autorizadoSinistro, String parecerAvaliador, String tipoSinistro) {
        super(tipoSinistro);
        this.dataSinistro = dataSinistro;
        this.descricaoSinistro = descricaoSinistro;
        this.valorSinistro = valorSinistro;
        this.autorizadoSinistro = autorizadoSinistro;
        this.parecerAvaliador = parecerAvaliador;
    }

    public Sinistro(int codSinistro, Date dataSinistro, String descricaoSinistro, float valorSinistro, String autorizadoSinistro, String parecerAvaliador, int codTipo, String tipoSinistro) {
        super(codTipo, tipoSinistro);
        this.codSinistro = codSinistro;
        this.dataSinistro = dataSinistro;
        this.descricaoSinistro = descricaoSinistro;
        this.valorSinistro = valorSinistro;
        this.autorizadoSinistro = autorizadoSinistro;
        this.parecerAvaliador = parecerAvaliador;
    }

    public Sinistro(Date dataSinistro, String descricaoSinistro, float valorSinistro, String tipoSinistro) {
        super(tipoSinistro);
        this.dataSinistro = dataSinistro;
        this.descricaoSinistro = descricaoSinistro;
        this.valorSinistro = valorSinistro;
    }

    public Sinistro(String tipoSinistro) {
        super(tipoSinistro);

    }

    public Date getDataSinistro() {
        return dataSinistro;
    }

    public void setDataSinistro(Date dataSinistro) {
        this.dataSinistro = dataSinistro;
    }

    public String getDescricaoSinistro() {
        return descricaoSinistro;
    }

    public void setDescricaoSinistro(String descricaoSinistro) {
        this.descricaoSinistro = descricaoSinistro;
    }

    public float getValorSinistro() {
        return valorSinistro;
    }

    public void setValorSinistro(float valorSinistro) {
        this.valorSinistro = valorSinistro;
    }

    public String getAutorizadoSinistro() {
        return autorizadoSinistro;
    }

    public void setAutorizadoSinistro(String autorizadoSinistro) {
        this.autorizadoSinistro = autorizadoSinistro;
    }

    public String getParecerAvaliador() {
        return parecerAvaliador;
    }

    public void setParecerAvaliador(String parecerAvaliador) {
        this.parecerAvaliador = parecerAvaliador;
    }

    /**
     * @return the codSinistro
     */
    public int getCodSinistro() {
        return codSinistro;
    }

    /**
     * @param codSinistro the codSinistro to set
     */
    public void setCodSinistro(int codSinistro) {
        this.codSinistro = codSinistro;
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

}
