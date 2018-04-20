/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DadosResidencia;

import java.util.Objects;

/**
 *
 * @author Matheus Montanha
 */
public class SolicitacaoSeguro {

    private int localizacaoPerigosa;
    private int terrenoPerigo;
    private int estruturaAmeacada;
    private String dataSolicitacao;
    private String dataVisita;
    private double valorSolicitacao;
    private boolean aprovadaResidencia;
    private String motivoReprovacao;

    public SolicitacaoSeguro(int localizacaoPerigosa, int terrenoPerigo, int estruturaAmeacada, String dataSolicitacao, String dataVisita, double valorSolicitacao, boolean aprovadaResidencia, String motivoReprovacao) {
        this.localizacaoPerigosa = localizacaoPerigosa;
        this.terrenoPerigo = terrenoPerigo;
        this.estruturaAmeacada = estruturaAmeacada;
        this.dataSolicitacao = dataSolicitacao;
        this.dataVisita = dataVisita;
        this.valorSolicitacao = valorSolicitacao;
        this.aprovadaResidencia = aprovadaResidencia;
        this.motivoReprovacao = motivoReprovacao;
    }

    /**
     * @return the localizacaoPerigosa
     */
    public int getLocalizacaoPerigosa() {
        return localizacaoPerigosa;
    }

    /**
     * @param localizacaoPerigosa the localizacaoPerigosa to set
     */
    public void setLocalizacaoPerigosa(int localizacaoPerigosa) {
        this.localizacaoPerigosa = localizacaoPerigosa;
    }

    /**
     * @return the terrenoPerigo
     */
    public int getTerrenoPerigo() {
        return terrenoPerigo;
    }

    /**
     * @param terrenoPerigo the terrenoPerigo to set
     */
    public void setTerrenoPerigo(int terrenoPerigo) {
        this.terrenoPerigo = terrenoPerigo;
    }

    /**
     * @return the estruturaAmeacada
     */
    public int getEstruturaAmeacada() {
        return estruturaAmeacada;
    }

    /**
     * @param estruturaAmeacada the estruturaAmeacada to set
     */
    public void setEstruturaAmeacada(int estruturaAmeacada) {
        this.estruturaAmeacada = estruturaAmeacada;
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
     * @return the dataVisita
     */
    public String getDataVisita() {
        return dataVisita;
    }

    /**
     * @param dataVisita the dataVisita to set
     */
    public void setDataVisita(String dataVisita) {
        this.dataVisita = dataVisita;
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
     * @return the aprovadaResidencia
     */
    public boolean isAprovadaResidencia() {
        return aprovadaResidencia;
    }

    /**
     * @param aprovadaResidencia the aprovadaResidencia to set
     */
    public void setAprovadaResidencia(boolean aprovadaResidencia) {
        this.aprovadaResidencia = aprovadaResidencia;
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

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SolicitacaoSeguro other = (SolicitacaoSeguro) obj;
        if (this.localizacaoPerigosa != other.localizacaoPerigosa) {
            return false;
        }
        if (this.terrenoPerigo != other.terrenoPerigo) {
            return false;
        }
        if (this.estruturaAmeacada != other.estruturaAmeacada) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorSolicitacao) != Double.doubleToLongBits(other.valorSolicitacao)) {
            return false;
        }
        if (this.aprovadaResidencia != other.aprovadaResidencia) {
            return false;
        }
        if (!Objects.equals(this.dataSolicitacao, other.dataSolicitacao)) {
            return false;
        }
        if (!Objects.equals(this.dataVisita, other.dataVisita)) {
            return false;
        }
        if (!Objects.equals(this.motivoReprovacao, other.motivoReprovacao)) {
            return false;
        }
        return true;
    }

}
