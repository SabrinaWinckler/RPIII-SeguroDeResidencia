/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus Montanha
 */
public class Segurado extends Candidato {

    private int idSegurado;
    private List<Sinistro> sinistros;
    private List<ItemServico> servicos;
    private List<Residencia> residencias;

    public Segurado() {
        sinistros = new ArrayList<>();
    }

    public Segurado(List<Sinistro> sinistros, List<ItemServico> servicos, List<Residencia> residencias, String sexo, long cep, String dataNescimento, String uf, String cidade, String bairro, int codPessoa, String nomePessoa, String cpf, String endereco, String telefone, String email, String usuarioCliente, String senhaCliente) {
        super(sexo, cep, dataNescimento, uf, cidade, bairro, codPessoa, nomePessoa, cpf, endereco, telefone, email, usuarioCliente, senhaCliente);
        this.sinistros = sinistros;
        this.servicos = servicos;
        this.residencias = residencias;
    }

    public Segurado(List<Sinistro> sinistros, List<ItemServico> servicos, List<Residencia> residencias, String sexo, long cep, String dataNescimento, String uf, String cidade, String bairro, String nomePessoa, String cpf, String endereco, String telefone, String email, String usuarioCliente, String senhaCliente) {
        super(sexo, cep, dataNescimento, uf, cidade, bairro, nomePessoa, cpf, endereco, telefone, email, usuarioCliente, senhaCliente);
        this.sinistros = sinistros;
        this.servicos = servicos;
        this.residencias = residencias;
    }

    public Segurado(int idSegurado, String sexo, long cep, String dataNescimento, String uf, String cidade, String bairro, String nomePessoa, String cpf, String endereco, String telefone, String email, String usuarioCliente, String senhaCliente) {
        super(sexo, cep, dataNescimento, uf, cidade, bairro, nomePessoa, cpf, endereco, telefone, email, usuarioCliente, senhaCliente);
        this.idSegurado = idSegurado;
    }

    /**
     * @return the sinistros
     */
    public List<Sinistro> getSinistros() {
        return sinistros;
    }

    /**
     * @param sinistros the sinistros to set
     */
    public void setSinistros(List<Sinistro> sinistros) {
        this.sinistros = sinistros;
    }

    /**
     * @return the servicos
     */
    public List<ItemServico> getServicos() {
        return servicos;
    }

    /**
     * @param servicos the servicos to set
     */
    public void setServicos(List<ItemServico> servicos) {
        this.servicos = servicos;
    }

    /**
     * @return the residencias
     */
    public List<Residencia> getResidencias() {
        return residencias;
    }

    /**
     * @param residencias the residencias to set
     */
    public void setResidencias(List<Residencia> residencias) {
        this.residencias = residencias;
    }

    /**
     * @return the idSegurado
     */
    public int getIdSegurado() {
        return idSegurado;
    }

    /**
     * @param idSegurado the idSegurado to set
     */
    public void setIdSegurado(int idSegurado) {
        this.idSegurado = idSegurado;
    }

}
