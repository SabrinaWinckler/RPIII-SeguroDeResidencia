/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;

/**
 *
 * @author SABRINA
 */
public class Contato {
    String email;
    String mensagem;
    Date data;
    String resposta;

    public Contato(String email, String mensagem, Date data) {
        this.email = email;
        this.mensagem = mensagem;
        this.data = data;
    }

    public Contato() {
    }

    public String getEmail() {
        return email;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Date getData() {
        return data;
    }

    public String getResposta() {
        return resposta;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
    
}
