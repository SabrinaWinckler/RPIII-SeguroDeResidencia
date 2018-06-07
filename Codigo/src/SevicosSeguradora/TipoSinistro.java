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

    private int codTipo;
    private String tipoSinistro;

    public TipoSinistro(String tipoSinistro) {
        this.tipoSinistro = tipoSinistro;
    }

    public TipoSinistro() {

    }

    public TipoSinistro(int codTipo, String tipoSinistro) {
        this.codTipo = codTipo;
        this.tipoSinistro = tipoSinistro;
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

    /**
     * @return the codTipo
     */
    public int getCodTipo() {
        return codTipo;
    }

    /**
     * @param codTipo the codTipo to set
     */
    public void setCodTipo(int codTipo) {
        this.codTipo = codTipo;
    }

}
