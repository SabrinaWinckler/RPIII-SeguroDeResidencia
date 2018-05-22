/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DadosUsuarios;

import dadosResidencia.Residencia;

/**
 *
 * @author Matheus Montanha
 */
public class Candidato extends Pessoa {

    private String sexo;
    private long cep;
    private String dataNescimento;
    private String uf;
    private String cidade;
    private String bairro;

    public Candidato(String sexo, long cep, String dataNescimento, String nomePessoa,
            long cpf, String endereco, String telefone, String email,
            String usuarioCliente, String senhaCliente, String uf, String cidade,
            String bairro) {
        super(nomePessoa, cpf, endereco, telefone, email, usuarioCliente, senhaCliente);
        this.sexo = sexo;
        this.cep = cep;
        this.dataNescimento = dataNescimento;
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
    }

    public Candidato() {
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
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
     * @return the dataNescimento
     */
    public String getDataNescimento() {
        return dataNescimento;
    }

    /**
     * @param dataNescimento the dataNescimento to set
     */
    public void setDataNescimento(String dataNescimento) {
        this.dataNescimento = dataNescimento;
    }

    @Override
    public String toString() {
        return "Candidato{" + "sexo=" + sexo + ", cep=" + cep + ", dataNescimento=" + dataNescimento + '}';
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
