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
    private Residencia residencia;

    public Candidato(String sexo, long cep, String dataNescimento, String nomePessoa, long cpf, String endereco, String telefone, String email, String usuarioCliente, String senhaCliente, String uf, String cidade, String bairro) {
        super(nomePessoa, cpf, endereco, telefone, email, usuarioCliente, senhaCliente);
        this.sexo = sexo;
        this.cep = cep;
        this.dataNescimento = dataNescimento;
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
}
