/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motor;

import DadosUsuarios.Candidato;
import java.util.ArrayList;

/**
 *
 * @author Débora Siqueira
 */
public class Motor {

    ArrayList<Object> listaCliente;
    ArrayList<Solicitacao> listaDeSolicitacao = new ArrayList<>();

    public Motor() {
        listaCliente = new ArrayList<>();

    }

    public boolean cadastrarCliente(Candidato candidato) {
        if (listaCliente.add(candidato)) {
            return true;
        } else {
            return false;
        }

    }

    public Object retornaCliente() {
        return listaCliente.get(0);
    }

    public boolean enviarSoliciacao(Solicitacao solicitacao) {
        if (listaDeSolicitacao.add(solicitacao)) {
            return true;
        } else {
            return false;
        }
    }
}
