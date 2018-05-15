/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SevicosSeguradora;

import java.util.Date;

/**
 *
 * @author Matheus Montanha
 */
public class Sinistro {

    Date dataSinistro;
    String descricaoSinistro;
    float valorSinistro;
    String autorizadoSinistro;
    String parecerAvaliador;

    public Sinistro(Date dataSinistro, String descricaoSinistro, float valorSinistro, String autorizadoSinistro, String parecerAvaliador) {
        this.dataSinistro = dataSinistro;
        this.descricaoSinistro = descricaoSinistro;
        this.valorSinistro = valorSinistro;
        this.autorizadoSinistro = autorizadoSinistro;
        this.parecerAvaliador = parecerAvaliador;
    }

    public Sinistro() {

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

}
