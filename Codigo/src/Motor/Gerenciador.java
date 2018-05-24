/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motor;

import DAO.CandidatoDAO;
import DAO.ResidenciaDAO;
import DAO.SolicitacaoDAO;
import DadosUsuarios.Candidato;
import dadosResidencia.Residencia;
import java.util.ArrayList;
import java.util.Date;
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

        Candidato candidato = new Candidato(sexo, cep, dataNescimento, nomePessoa,
                cpf, endereco, telefone, email, usuarioCliente, senhaCliente, uf,
                cidade, bairro);
        CandidatoDAO daoCandidato = new CandidatoDAO();
        daoCandidato.create(candidato);
    }

    public void registrarSolicitacao(Date dataSolicitacao, double valorSolicitacao,
            Date dataVisitaResidencia, String aprovadaSolicitacao,
            String motivoReprovacao, String motivoAlteracao, Residencia residencia,
            ResidenciaDAO daoResidencia) throws NullPointerException {

        Solicitacao solicitacao = new Solicitacao(dataSolicitacao, valorSolicitacao,
                dataVisitaResidencia, aprovadaSolicitacao, motivoReprovacao,
                motivoAlteracao, residencia, daoResidencia);
        SolicitacaoDAO daoSolicitacao = new SolicitacaoDAO();
        daoSolicitacao.create(solicitacao);
    }

    public void registrarResidencia(String uf, String cidade, String bairro,
            String descricaoRes, List bem, int numRes, long cepRes,
            int qntComodos, int qntBanheiros, int qntGaragens, float areaTotal,
            double areaC, int numAndares, int anoConstrucao, String ruaRes,
            int localizacaoPerigosa, int terrenoPerigoso,
            int estruturaAmeacada) throws NullPointerException {

        Residencia residencia = new Residencia(uf, cidade, bairro, descricaoRes,
                bem, numRes, cepRes, qntComodos, qntBanheiros, qntGaragens,
                areaTotal, areaC, numAndares, anoConstrucao, ruaRes,
                localizacaoPerigosa, terrenoPerigoso, estruturaAmeacada);
        ResidenciaDAO daoResidencia = new ResidenciaDAO();
        daoResidencia.create(residencia);
    }

    public List<Candidato> retornaCliente() {
        CandidatoDAO daoCandidato = new CandidatoDAO();
        return daoCandidato.read();
    }

    public List<Solicitacao> listaDeResidenciasPendentes() {
        SolicitacaoDAO daoSolicitacao = new SolicitacaoDAO();
        List<Solicitacao> lista = daoSolicitacao.read();
        return lista;
    }

    public List<Solicitacao> organizarListaDeSolicitacoes() {
        SolicitacaoDAO daoSolicitacao = new SolicitacaoDAO();
        List<Solicitacao> listaDeSolicitacoes;
        listaDeSolicitacoes = daoSolicitacao.read();
        boolean houveTroca;
        if (listaDeSolicitacoes.size() >= 2) {
            do {
                houveTroca = false;
                for (int i = 0; i < listaDeSolicitacoes.size() - 2; i++) {
                    if (listaDeSolicitacoes.get(i).getDataSolicitacao().after(listaDeSolicitacoes.get(i + 1).getDataVisitaResidencia())) {
                        Solicitacao temp = listaDeSolicitacoes.get(i);
                        listaDeSolicitacoes.set(i, listaDeSolicitacoes.get(i + 1));
                        listaDeSolicitacoes.set(i + 1, temp);
                        houveTroca = true;
                    }
                }
                if (!houveTroca) {
                    break;
                }
                for (int i = listaDeSolicitacoes.size() - 2; i >= 0; i--) {
                    if (listaDeSolicitacoes.get(i).getDataSolicitacao().after(listaDeSolicitacoes.get(i + 1).getDataVisitaResidencia())) {
                        Solicitacao temp = listaDeSolicitacoes.get(i);
                        listaDeSolicitacoes.set(i, listaDeSolicitacoes.get(i + 1));
                        listaDeSolicitacoes.set(i + 1, temp);
                        houveTroca = true;
                    }
                }
            } while (houveTroca);
            return listaDeSolicitacoes;
        } else {
            return listaDeSolicitacoes;
        }
    }

    public void updateSituacaoSolicitacao() {
        SolicitacaoDAO daoSolicitacao = new SolicitacaoDAO();
        daoSolicitacao.solicitacaoAprovada();
    }
}
