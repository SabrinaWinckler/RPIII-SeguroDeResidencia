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
public class Servico {

    private int idCodServico;
    private String desc;

    public Servico() {

    }

    public Servico(String desc) {
        this.desc = desc;
    }

    public Servico(int codServico, String desc) {
        this.desc = desc;
        this.idCodServico = codServico;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the idCodServico
     */
    public int getIdCodServico() {
        return idCodServico;
    }

    /**
     * @param idCodServico the idCodServico to set
     */
    public void setIdCodServico(int idCodServico) {
        this.idCodServico = idCodServico;
    }
}
