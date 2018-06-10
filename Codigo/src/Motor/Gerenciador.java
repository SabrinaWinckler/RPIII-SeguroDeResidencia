/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motor;

import DAO.ApoliceDAO;
import DAO.CandidatoDAO;
import DAO.CorretorDAO;
import DAO.PessoaDAO;
import DAO.RelataSinistroDAO;
import DAO.ResidenciaDAO;
import DAO.SolicitacaoDAO;
import Dominio.Candidato;
import Dominio.Corretor;
import Dominio.Pessoa;
import Dominio.Segurado;
import Dominio.Solicitacao;
import Dominio.Apolice;
import Dominio.Residencia;
import java.sql.Array;
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
            String nomePessoa, String cpf, String endereco, String telefone,
            String email, String usuarioCliente, String senhaCliente, String uf,
            String cidade, String bairro) throws NullPointerException {

        Pessoa pessoa = new Pessoa(nomePessoa, cpf, endereco, telefone, email, usuarioCliente, senhaCliente);
        PessoaDAO daoPessoa = new PessoaDAO();
        daoPessoa.create(pessoa);
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
                motivoAlteracao, residencia);
        SolicitacaoDAO daoSolicitacao = new SolicitacaoDAO();
        daoSolicitacao.create(solicitacao);
    }

    public void registrarResidencia(String uf, String cidade, String bairro,
            String descricaoRes, List bem, int numRes, long cepRes,
            int qntComodos, int qntBanheiros, int qntGaragens, float areaTotal,
            double areaC, int numAndares, int anoConstrucao, String ruaRes,
            int localizacaoPerigosa, int terrenoPerigoso,
            int estruturaAmeacada, Candidato candidato) throws NullPointerException {

        Residencia residencia = new Residencia(uf, cidade, bairro, descricaoRes,
                bem, numRes, cepRes, qntComodos, qntBanheiros, qntGaragens,
                areaTotal, areaC, numAndares, anoConstrucao, ruaRes,
                localizacaoPerigosa, terrenoPerigoso, estruturaAmeacada, candidato);
        ResidenciaDAO daoResidencia = new ResidenciaDAO();
        daoResidencia.create(residencia, candidato.getCpf());
    }

    public List<Candidato> retornaCliente() {
        CandidatoDAO daoCandidato = new CandidatoDAO();
        return daoCandidato.read();
    }

    public List<Corretor> retornarCorretor() {
        CorretorDAO daoCorretor = new CorretorDAO();
        return daoCorretor.read();
    }

    public List<Solicitacao> listaDeSolicitacoesPendentes() {
        SolicitacaoDAO daoSolicitacao = new SolicitacaoDAO();
        return daoSolicitacao.read();
    }

    public void registrarApolice(String bandeiraCartão, long numeroApolice,
            float premioApolice, Date dataContratacaoApolice, String cartaoCreditoPagamento,
            String vencimentoCartao, long codSegurancaCartao, String nomeNoCartao) {
        Apolice apolice = new Apolice(bandeiraCartão, numeroApolice, premioApolice,
                dataContratacaoApolice, cartaoCreditoPagamento, vencimentoCartao,
                codSegurancaCartao, nomeNoCartao);
        ApoliceDAO daoApolice = new ApoliceDAO();
        daoApolice.create(apolice);
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

    public void updateSituacaoSolicitacao(String resultado, String motivoReprovacao, String motivoAlteracao, String data, String cpf) {
        SolicitacaoDAO daoSolicitacao = new SolicitacaoDAO();
        //daoSolicitacao.updateStatusSolicitacao(resultado, motivoReprovacao, motivoAlteracao, data, cpf);
    }

    public List<Segurado> listaDeSinistrosPendentes() {
        RelataSinistroDAO daoSinistro = new RelataSinistroDAO();
        return daoSinistro.read();
    }

    public List<Solicitacao> listaSolicitacaoCliente(Candidato candidato) {
        SolicitacaoDAO daoSolicitacao = new SolicitacaoDAO();
        return daoSolicitacao.listaSolicitacaoCliente(candidato);
    }

    public void registrarDateVisitaResidencia(Solicitacao solicitacao) {
        SolicitacaoDAO daoSolicitacao = new SolicitacaoDAO();
        daoSolicitacao.registrarDataVisita(solicitacao);
    }

    public List<Solicitacao> filtrarSolicitacoesNaoVisualizadas() {
        listaDeSolicitacao = listaDeSolicitacoesPendentes();
        List<Solicitacao> listaDeSolicitacoesPendendes = new ArrayList<>();
        for (Solicitacao solicitacao : listaDeSolicitacao) {
            if (solicitacao.getDataVisitaResidencia() == null) {
                listaDeSolicitacoesPendendes.add(solicitacao);
            }
        }
        return listaDeSolicitacoesPendendes;
    }

    public List<Solicitacao> filtrarResidenciasParaAvaliar() {
        listaDeSolicitacao = listaDeSolicitacoesPendentes();
        List<Solicitacao> listaDeSolicitacoesPendendes = new ArrayList<>();
        for (Solicitacao solicitacao : listaDeSolicitacao) {
            if (solicitacao.getDataVisitaResidencia() != null && solicitacao.getAprovadaSolicitacao() == null) {
                listaDeSolicitacoesPendendes.add(solicitacao);
            }
        }
        return listaDeSolicitacoesPendendes;
    }

    public void updateStatusSolicitacao(Solicitacao solicitacao) {
        SolicitacaoDAO daoSolicitacao = new SolicitacaoDAO();
        daoSolicitacao.updateStatusSolicitacao(solicitacao);
    }

    public List<Solicitacao> filtrarResidenciasPendentes() {
        listaDeSolicitacao = listaDeSolicitacoesPendentes();
        List<Solicitacao> listaDeSolicitacoesPendendes = new ArrayList<>();
        for (Solicitacao solicitacao : listaDeSolicitacao) {
            if (!solicitacao.getAprovadaSolicitacao().isEmpty()) {
                listaDeSolicitacoesPendendes.add(solicitacao);
            }
        }
        return listaDeSolicitacoesPendendes;
    }
}
