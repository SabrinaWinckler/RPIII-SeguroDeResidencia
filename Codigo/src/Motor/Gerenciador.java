/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motor;

import DAO.CandidatoDAO;
import DAO.ResidenciaDAO;
import DadosUsuarios.Candidato;
import dadosResidencia.Residencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Débora Siqueira
 */
public class Gerenciador {

    List<Object> listaCliente;
    List<Solicitacao> listaDeSolicitacao;

    public Gerenciador() {
    }

    public void cadastrarCliente(String sexo, long cep, String dataNescimento,
            String nomePessoa, long cpf, String endereco, String telefone,
            String email, String usuarioCliente, String senhaCliente, String uf,
            String cidade, String bairro) throws NullPointerException {
        Candidato candidato = new Candidato(sexo, cep, dataNescimento, nomePessoa, cpf, endereco, telefone, email, usuarioCliente, senhaCliente, uf, cidade, bairro);
        CandidatoDAO daoCandidato = new CandidatoDAO();
        daoCandidato.create(candidato);
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

    public List<Residencia> listaDeResidenciasPendentes() {
        ResidenciaDAO daoResidencia = new ResidenciaDAO();
        return daoResidencia.read();
    }
}
