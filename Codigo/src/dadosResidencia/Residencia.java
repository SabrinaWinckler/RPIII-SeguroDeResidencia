package dadosResidencia;

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

    private NivelDePericulosidade nivelDePericulosidade;

    private List<Bem> bens;
    
    private Local local;

    public Residencia(String descricaoRes, int numRes, long cepRes, int qntComodos, int qntBanheiros, int qntGaragens, float areaTotal, int numAndares, int anoConstrucao, String ruaRes, NivelDePericulosidade nivelDePericulosidade, Local local) {
        this.descricaoRes = descricaoRes;
        this.numRes = numRes;
        this.cepRes = cepRes;
        this.qntComodos = qntComodos;
        this.qntBanheiros = qntBanheiros;
        this.qntGaragens = qntGaragens;
        this.areaTotal = areaTotal;
        this.numAndares = numAndares;
        this.anoConstrucao = anoConstrucao;
        this.ruaRes = ruaRes;
        this.nivelDePericulosidade = nivelDePericulosidade;
        this.local = local;
        this.bens = null;
    }

    /**
     * @return the bem
     */
    public List<Bem> getBem() {
        return bens;
    }

    /**
     * @param bem the bem to set
     */
    public void setBem(List<Bem> bem) {
        this.bens = bem;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Local getLocal() {
        return local;
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

    /**
     * @return the nivelDePericulosidade
     */
    public NivelDePericulosidade getNivelDePericulosidade() {
        return nivelDePericulosidade;
    }

    /**
     * @param nivelDePericulosidade the nivelDePericulosidade to set
     */
    public void setNivelDePericulosidade(NivelDePericulosidade nivelDePericulosidade) {
        this.nivelDePericulosidade = nivelDePericulosidade;
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

}
