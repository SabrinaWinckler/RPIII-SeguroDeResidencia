/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Matheus Montanha
 */
public class Pessoa {

    private String nomePessoa;
    private long cpf;
    private String endereco;
    private String telefone;
    private String email;
    private String usuarioCliente;
    private String senhaCliente;

    public Pessoa(String nomePessoa, long cpf, String endereco, String telefone, String email, String usuarioCliente, String senhaCliente) {
        this.nomePessoa = nomePessoa;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.usuarioCliente = usuarioCliente;
        this.senhaCliente = senhaCliente;
    }

    /**
     * @return the nomePessoa
     */
    public String getNomePessoa() {
        return nomePessoa;
    }

    /**
     * @param nomePessoa the nomePessoa to set
     */
    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    /**
     * @return the cpf
     */
    public long getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the usuarioCliente
     */
    public String getUsuarioCliente() {
        return usuarioCliente;
    }

    /**
     * @param usuarioCliente the usuarioCliente to set
     */
    public void setUsuarioCliente(String usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    /**
     * @return the senhaCliente
     */
    public String getSenhaCliente() {
        return senhaCliente;
    }

    /**
     * @param senhaCliente the senhaCliente to set
     */
    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }
}
