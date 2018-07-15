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
public class Corretor extends Pessoa {

    private String ativoCorretor;
    private Date dataConstratacao;

    public Corretor() {

    }

    public Corretor(String ativoCorretor, Date dataConstratacao, int codPessoa, String nomePessoa, String cpf, String endereco, String telefone, String email, String usuarioCliente, String senhaCliente) {
        super(codPessoa, nomePessoa, cpf, endereco, telefone, email, usuarioCliente, senhaCliente);
        this.ativoCorretor = ativoCorretor;
        this.dataConstratacao = dataConstratacao;
    }

    /**
     * @return the ativoCorretor
     */
    public String getAtivoCorretor() {
        return ativoCorretor;
    }

    /**
     * @param ativoCorretor the ativoCorretor to set
     */
    public void setAtivoCorretor(String ativoCorretor) {
        this.ativoCorretor = ativoCorretor;
    }

    /**
     * @return the dataConstratacao
     */
    public Date getDataConstratacao() {
        return dataConstratacao;
    }

    /**
     * @param dataConstratacao the dataConstratacao to set
     */
    public void setDataConstratacao(Date dataConstratacao) {
        this.dataConstratacao = dataConstratacao;
    }

}
