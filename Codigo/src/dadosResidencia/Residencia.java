package dadosResidencia;

import java.util.ArrayList;
import java.util.List;

public class Residencia {

    private String descricaoRes;

    private int numRes;

    private long cepRes;

    private int qntComodos;

    private int qntBanheiros;

    private int qntGaragens;

    private float areaTotal;

    private int numAndares;

    private int anoConstrucao;

    private String ruaRes;

    private String ufResidencia;
    
    private String cidade;
    
    private String bairro;

    private double areaConstruida;

    private List<Bem> bens;

    private int localizacaoPerigosa;

    private int terrenoPerigoso;

    private int estruturaAmeacada;

    public Residencia() {
    }

    public Residencia(String uf, String cidade, String bairro, String descricaoRes, List bem, int numRes, long cepRes, int qntComodos, int qntBanheiros, int qntGaragens, float areaTotal,double areaC, int numAndares, int anoConstrucao, String ruaRes, int localizacaoPerigosa, int terrenoPerigoso, int estruturaAmeacada) {
        this.descricaoRes = descricaoRes;
        this.numRes = numRes;
        this.cepRes = cepRes;
        this.qntComodos = qntComodos;
        this.qntBanheiros = qntBanheiros;
        this.qntGaragens = qntGaragens;
        this.areaTotal = areaTotal;
        this.areaConstruida = areaC;
        this.numAndares = numAndares;
        this.anoConstrucao = anoConstrucao;
        this.ruaRes = ruaRes;
        this.bens = bem;
        this.ufResidencia = uf;
        this.cidade = cidade;
        this.bairro = bairro;
        this.areaConstruida = areaConstruida;
        this.localizacaoPerigosa = localizacaoPerigosa;
        this.terrenoPerigoso = terrenoPerigoso;
        this.estruturaAmeacada = estruturaAmeacada;
    }

    

   

    /**
     * @return the descricaoRes
     */
    public String getDescricaoRes() {
        return descricaoRes;
    }

    /**
     * @param descricaoRes the descricaoRes to set
     */
    public void setDescricaoRes(String descricaoRes) {
        this.descricaoRes = descricaoRes;
    }

    /**
     * @return the numRes
     */
    public int getNumRes() {
        return numRes;
    }

    /**
     * @param numRes the numRes to set
     */
    public void setNumRes(int numRes) {
        this.numRes = numRes;
    }

    /**
     * @return the cepRes
     */
    public long getCepRes() {
        return cepRes;
    }

    /**
     * @param cepRes the cepRes to set
     */
    public void setCepRes(long cepRes) {
        this.cepRes = cepRes;
    }

    /**
     * @return the qntComodos
     */
    public int getQntComodos() {
        return qntComodos;
    }

    /**
     * @param qntComodos the qntComodos to set
     */
    public void setQntComodos(int qntComodos) {
        this.qntComodos = qntComodos;
    }

    /**
     * @return the qntBanheiros
     */
    public int getQntBanheiros() {
        return qntBanheiros;
    }

    /**
     * @param qntBanheiros the qntBanheiros to set
     */
    public void setQntBanheiros(int qntBanheiros) {
        this.qntBanheiros = qntBanheiros;
    }

    /**
     * @return the qntGaragens
     */
    public int getQntGaragens() {
        return qntGaragens;
    }

    /**
     * @param qntGaragens the qntGaragens to set
     */
    public void setQntGaragens(int qntGaragens) {
        this.qntGaragens = qntGaragens;
    }

    /**
     * @return the areaTotal
     */
    public float getAreaTotal() {
        return areaTotal;
    }

    /**
     * @param areaTotal the areaTotal to set
     */
    public void setAreaTotal(float areaTotal) {
        this.areaTotal = areaTotal;
    }

    /**
     * @return the numAndares
     */
    public int getNumAndares() {
        return numAndares;
    }

    /*
    public List<Bem> getBens() {
        return bens;
    }
     */
    public int getLocalizacaoPerigosa() {
        return localizacaoPerigosa;
    }

    public int getTerrenoPerigoso() {
        return terrenoPerigoso;
    }

    public int getEstruturaAmeacada() {
        return estruturaAmeacada;
    }

    /**
     * @param numAndares the numAndares to set
     */
    public void setNumAndares(int numAndares) {
        this.numAndares = numAndares;
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

    /**
     * @return the ruaRes
     */
    public String getRuaRes() {
        return ruaRes;
    }

    /**
     * @param ruaRes the ruaRes to set
     */
    public void setRuaRes(String ruaRes) {
        this.ruaRes = ruaRes;
    }

    public double getAreaConstrucao() {
        return this.areaConstruida;
    }

    public void setAreaConstruida(double areaConstruida) {
        this.areaConstruida = areaConstruida;
    }

    public void registraResidencia() {

    }

    public void registraLocalizacao(String endereco, long cep) {

    }

    public void registraInfo(String descricao, int anoConstrucao) {

    }

    public void registraTamanho(float areaT, int numAndares, int qntGaragem, int qntComodo, int qntBanheiro) {

    }

    public void calculaNivelPericulosidade() {

    }

    /**
     * @param bens the bens to set
     */
    /*
    public void setBens(List<Bem> bens) {
        this.bens = bens;
    }
     */
    /**
     * @param localizacaoPerigosa the localizacaoPerigosa to set
     */
    public void setLocalizacaoPerigosa(int localizacaoPerigosa) {
        this.localizacaoPerigosa = localizacaoPerigosa;
    }

    /**
     * @param terrenoPerigoso the terrenoPerigoso to set
     */
    public void setTerrenoPerigoso(int terrenoPerigoso) {
        this.terrenoPerigoso = terrenoPerigoso;
    }

    /**
     * @param estruturaAmeacada the estruturaAmeacada to set
     */
    public void setEstruturaAmeacada(int estruturaAmeacada) {
        this.estruturaAmeacada = estruturaAmeacada;
    }

    public String getufResidencia() {
        return ufResidencia;
    }

    public void setufResidencia(String ufResidencia) {
        this.ufResidencia = ufResidencia;
    }

}
