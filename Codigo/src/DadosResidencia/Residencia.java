/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DadosResidencia;

/**
 *
 * @author Matheus Montanha
 */
public class Residencia {

    private String descricaoResidencia;
    private String enderecoResidencia;
    private long cep;
    private String bairroResidencia;
    private String cidadeResidencia;
    private String UFResidencia;
    private int quantidadeComodos;
    private int quantidadeBanheiros;
    private int quantidadeGaragem;
    private double areaConstruida;
    private double areaTotal;
    private int numeroAndares;
    private int anoConstrucao;

    public Residencia(String descricaoResidencia, String enderecoResidencia, long cep, String bairroResidencia, String cidadeResidencia, String UFResidencia, int quantidadeComodos, int quantidadeBanheiros, int quantidadeGaragem, double areaConstruida, double areaTotal, int numeroAndares, int anoConstrucao) {
        this.descricaoResidencia = descricaoResidencia;
        this.enderecoResidencia = enderecoResidencia;
        this.cep = cep;
        this.bairroResidencia = bairroResidencia;
        this.cidadeResidencia = cidadeResidencia;
        this.UFResidencia = UFResidencia;
        this.quantidadeComodos = quantidadeComodos;
        this.quantidadeBanheiros = quantidadeBanheiros;
        this.quantidadeGaragem = quantidadeGaragem;
        this.areaConstruida = areaConstruida;
        this.areaTotal = areaTotal;
        this.numeroAndares = numeroAndares;
        this.anoConstrucao = anoConstrucao;
    }

    /**
     * @return the descricaoResidencia
     */
    public String getDescricaoResidencia() {
        return descricaoResidencia;
    }

    /**
     * @param descricaoResidencia the descricaoResidencia to set
     */
    public void setDescricaoResidencia(String descricaoResidencia) {
        this.descricaoResidencia = descricaoResidencia;
    }

    /**
     * @return the enderecoResidencia
     */
    public String getEnderecoResidencia() {
        return enderecoResidencia;
    }

    /**
     * @param enderecoResidencia the enderecoResidencia to set
     */
    public void setEnderecoResidencia(String enderecoResidencia) {
        this.enderecoResidencia = enderecoResidencia;
    }

    /**
     * @return the cep
     */
    public long getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(long cep) {
        this.cep = cep;
    }

    /**
     * @return the bairroResidencia
     */
    public String getBairroResidencia() {
        return bairroResidencia;
    }

    /**
     * @param bairroResidencia the bairroResidencia to set
     */
    public void setBairroResidencia(String bairroResidencia) {
        this.bairroResidencia = bairroResidencia;
    }

    /**
     * @return the cidadeResidencia
     */
    public String getCidadeResidencia() {
        return cidadeResidencia;
    }

    /**
     * @param cidadeResidencia the cidadeResidencia to set
     */
    public void setCidadeResidencia(String cidadeResidencia) {
        this.cidadeResidencia = cidadeResidencia;
    }

    /**
     * @return the UFResidencia
     */
    public String getUFResidencia() {
        return UFResidencia;
    }

    /**
     * @param UFResidencia the UFResidencia to set
     */
    public void setUFResidencia(String UFResidencia) {
        this.UFResidencia = UFResidencia;
    }

    /**
     * @return the quantidadeComodos
     */
    public int getQuantidadeComodos() {
        return quantidadeComodos;
    }

    /**
     * @param quantidadeComodos the quantidadeComodos to set
     */
    public void setQuantidadeComodos(int quantidadeComodos) {
        this.quantidadeComodos = quantidadeComodos;
    }

    /**
     * @return the quantidadeBanheiros
     */
    public int getQuantidadeBanheiros() {
        return quantidadeBanheiros;
    }

    /**
     * @param quantidadeBanheiros the quantidadeBanheiros to set
     */
    public void setQuantidadeBanheiros(int quantidadeBanheiros) {
        this.quantidadeBanheiros = quantidadeBanheiros;
    }

    /**
     * @return the quantidadeGaragem
     */
    public int getQuantidadeGaragem() {
        return quantidadeGaragem;
    }

    /**
     * @param quantidadeGaragem the quantidadeGaragem to set
     */
    public void setQuantidadeGaragem(int quantidadeGaragem) {
        this.quantidadeGaragem = quantidadeGaragem;
    }

    /**
     * @return the areaConstruida
     */
    public double getAreaConstruida() {
        return areaConstruida;
    }

    /**
     * @param areaConstruida the areaConstruida to set
     */
    public void setAreaConstruida(double areaConstruida) {
        this.areaConstruida = areaConstruida;
    }

    /**
     * @return the areaTotal
     */
    public double getAreaTotal() {
        return areaTotal;
    }

    /**
     * @param areaTotal the areaTotal to set
     */
    public void setAreaTotal(double areaTotal) {
        this.areaTotal = areaTotal;
    }

    /**
     * @return the numeroAndares
     */
    public int getNumeroAndares() {
        return numeroAndares;
    }

    /**
     * @param numeroAndares the numeroAndares to set
     */
    public void setNumeroAndares(int numeroAndares) {
        this.numeroAndares = numeroAndares;
    }

    /**
     * @return the anoConstrucao
     */
    public int getAnoConstrucao() {
        return anoConstrucao;
    }

    /**
     * @param anoConstrucao the anoConstrucao to set
     */
    public void setAnoConstrucao(int anoConstrucao) {
        this.anoConstrucao = anoConstrucao;
    }
}
