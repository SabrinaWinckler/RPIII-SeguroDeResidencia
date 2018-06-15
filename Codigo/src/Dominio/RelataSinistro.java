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
public class RelataSinistro {

    private int idSinistro;
    private int idPessoa;

    public RelataSinistro(int idSinistro, int idPessoa) {
        this.idSinistro = idSinistro;
        this.idPessoa = idPessoa;
    }

    /**
     * @return the idSinistro
     */
    public int getIdSinistro() {
        return idSinistro;
    }

    /**
     * @param idSinistro the idSinistro to set
     */
    public void setIdSinistro(int idSinistro) {
        this.idSinistro = idSinistro;
    }

    /**
     * @return the idPessoa
     */
    public int getIdPessoa() {
        return idPessoa;
    }

    /**
     * @param idPessoa the idPessoa to set
     */
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

}
