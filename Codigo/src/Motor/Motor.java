/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motor;

import DadosUsuarios.Candidato;
import java.util.ArrayList;
import java.util.List;

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
        for (int i = 0; i < listaCliente.size(); i++) {
            return listaCliente.get(i);
        }
        return null;
    }

    public boolean enviarSoliciacao(Solicitacao solicitacao) {
        if (listaDeSolicitacao.add(solicitacao)) {
            return true;
        } else {
            return false;
        }
    }
}
