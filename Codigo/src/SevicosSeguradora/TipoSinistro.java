/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SevicosSeguradora;

/**
 *
 * @author Matheus Montanha
 */
public class TipoSinistro {

    private String tipoSinistro;

    public TipoSinistro(String tipoSinistro) {
        this.tipoSinistro = tipoSinistro;
    }

    public TipoSinistro() {

    }

    /**
     * @return the tipoSinistro
     */
    public String getTipoSinistro() {
        return tipoSinistro;
    }

    /**
     * @param tipoSinistro the tipoSinistro to set
     */
    public void setTipoSinistro(String tipoSinistro) {
        this.tipoSinistro = tipoSinistro;
    }

}
