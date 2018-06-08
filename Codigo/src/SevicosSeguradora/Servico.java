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
public class Servico {
    private String desc;
    private int qnt;

    public Servico() {
    }

    public Servico(String desc, int qnt) {
        this.desc = desc;
        this.qnt = qnt;
    }

    public String getDesc() {
        return desc;
    }

    public int getQnt() {
        return qnt;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }
    
    
}
