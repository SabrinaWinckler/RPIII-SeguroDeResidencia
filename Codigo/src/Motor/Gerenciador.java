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
import DAO.ServicoDAO;
import DAO.SolicitacaoDAO;
import Dominio.Candidato;
import Dominio.Corretor;
import Dominio.Pessoa;
import Dominio.Segurado;
import Dominio.Solicitacao;
import Dominio.Apolice;
import Dominio.ItemServico;
import Dominio.Residencia;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import service.WebServiceCep;

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
    
    public void registrarApolice(String bandeiraCartão, long numeroApolice,
            float premioApolice, Date dataContratacaoApolice, String cartaoCreditoPagamento,
            String vencimentoCartao, long codSegurancaCartao, String nomeNoCartao) {
        Apolice apolice = new Apolice(bandeiraCartão, numeroApolice, premioApolice,
                dataContratacaoApolice, cartaoCreditoPagamento, vencimentoCartao,
                codSegurancaCartao, nomeNoCartao);
        ApoliceDAO daoApolice = new ApoliceDAO();
        daoApolice.create(apolice);
    }

    public List<Solicitacao> listaSolicitacaoCliente(Candidato candidato) {
        SolicitacaoDAO daoSolicitacao = new SolicitacaoDAO();
        return daoSolicitacao.listaSolicitacaoCliente(candidato);
    }
    public double calcularValorSolicitacao(Solicitacao solicitacao) {
        double valorBaseSolicitacao = 0, valorComTaxas;
        WebServiceCep webServiceCep = WebServiceCep.searchCep("" + solicitacao.getResidencia().getCepRes());
        String Uf = webServiceCep.getUf();
        if (Uf.equalsIgnoreCase("RS") || Uf.equalsIgnoreCase("SC") || Uf.equalsIgnoreCase("PR")) {
            valorBaseSolicitacao = 346.00;
            valorComTaxas = valorBaseSolicitacao * 3 / 100 * solicitacao.getResidencia().getQntComodos();
            valorComTaxas += solicitacao.getResidencia().getAreaConstruida() * 8.54;
            valorComTaxas += valorBaseSolicitacao * 3 / 100 * solicitacao.getResidencia().getBens().size();
            valorComTaxas += valorBaseSolicitacao * solicitacao.getResidencia().getLocalizacaoPerigosa() / 100;
            valorComTaxas += valorBaseSolicitacao * solicitacao.getResidencia().getEstruturaAmeacada() / 100;
            valorComTaxas += valorBaseSolicitacao * solicitacao.getResidencia().getTerrenoPerigoso() / 100;
            valorComTaxas += valorBaseSolicitacao;
            return valorComTaxas;
        } else if (Uf.equalsIgnoreCase("SP") || Uf.equalsIgnoreCase("RJ")
                || Uf.equalsIgnoreCase("ES") || Uf.equalsIgnoreCase("MG")) {
            valorBaseSolicitacao = 394.80;
            valorComTaxas = valorBaseSolicitacao * 3 / 100 * solicitacao.getResidencia().getQntComodos();
            valorComTaxas += solicitacao.getResidencia().getAreaConstruida() * 8.54;
            valorComTaxas += valorBaseSolicitacao * 3 / 100 * solicitacao.getResidencia().getBens().size();
            valorComTaxas += valorBaseSolicitacao * solicitacao.getResidencia().getLocalizacaoPerigosa() / 100;
            valorComTaxas += valorBaseSolicitacao * solicitacao.getResidencia().getEstruturaAmeacada() / 100;
            valorComTaxas += valorBaseSolicitacao * solicitacao.getResidencia().getTerrenoPerigoso() / 100;
            valorComTaxas += valorBaseSolicitacao;
            return valorComTaxas;
        } else if (Uf.equalsIgnoreCase("AC") || Uf.equalsIgnoreCase("AM")
                || Uf.equalsIgnoreCase("RO") || Uf.equalsIgnoreCase("RR")
                || Uf.equalsIgnoreCase("PA") || Uf.equalsIgnoreCase("AP")
                || Uf.equalsIgnoreCase("TO")) {
            valorBaseSolicitacao = 302.00;
            valorComTaxas = valorBaseSolicitacao * 3 / 100 * solicitacao.getResidencia().getQntComodos();
            valorComTaxas += solicitacao.getResidencia().getAreaConstruida() * 8.54;
            valorComTaxas += valorBaseSolicitacao * 3 / 100 * solicitacao.getResidencia().getBens().size();
            valorComTaxas += valorBaseSolicitacao * solicitacao.getResidencia().getLocalizacaoPerigosa() / 100;
            valorComTaxas += valorBaseSolicitacao * solicitacao.getResidencia().getEstruturaAmeacada() / 100;
            valorComTaxas += valorBaseSolicitacao * solicitacao.getResidencia().getTerrenoPerigoso() / 100;
            valorComTaxas += valorBaseSolicitacao;
            return valorComTaxas;
        } else if (Uf.equalsIgnoreCase("MA") || Uf.equalsIgnoreCase("PI")
                || Uf.equalsIgnoreCase("BA") || Uf.equalsIgnoreCase("CE")
                || Uf.equalsIgnoreCase("PE") || Uf.equalsIgnoreCase("SE")
                || Uf.equalsIgnoreCase("AL") || Uf.equalsIgnoreCase("PB")
                || Uf.equalsIgnoreCase("RN")) {
            valorBaseSolicitacao = 327.90;
            valorComTaxas = valorBaseSolicitacao * 3 / 100 * solicitacao.getResidencia().getQntComodos();
            valorComTaxas += solicitacao.getResidencia().getAreaConstruida() * 8.54;
            valorComTaxas += valorBaseSolicitacao * 3 / 100 * solicitacao.getResidencia().getBens().size();
            valorComTaxas += valorBaseSolicitacao * solicitacao.getResidencia().getLocalizacaoPerigosa() / 100;
            valorComTaxas += valorBaseSolicitacao * solicitacao.getResidencia().getEstruturaAmeacada() / 100;
            valorComTaxas += valorBaseSolicitacao * solicitacao.getResidencia().getTerrenoPerigoso() / 100;
            valorComTaxas += valorBaseSolicitacao;
            return valorComTaxas;
        } else if (Uf.equalsIgnoreCase("MT") || Uf.equalsIgnoreCase("GO")
                || Uf.equalsIgnoreCase("MS")) {
            valorBaseSolicitacao = 341.55;
            valorComTaxas = valorBaseSolicitacao * 3 / 100 * solicitacao.getResidencia().getQntComodos();
            valorComTaxas += solicitacao.getResidencia().getAreaConstruida() * 8.54;
            valorComTaxas += valorBaseSolicitacao * 3 / 100 * solicitacao.getResidencia().getBens().size();
            valorComTaxas += valorBaseSolicitacao * solicitacao.getResidencia().getLocalizacaoPerigosa() / 100;
            valorComTaxas += valorBaseSolicitacao * solicitacao.getResidencia().getEstruturaAmeacada() / 100;
            valorComTaxas += valorBaseSolicitacao * solicitacao.getResidencia().getTerrenoPerigoso() / 100;
            valorComTaxas += valorBaseSolicitacao;
            return valorComTaxas;
        }

        return valorBaseSolicitacao;
    }
    public List<ItemServico> servicoPorCliente(Candidato segurado){
        ServicoDAO servicoDAO = new ServicoDAO();
       return servicoDAO.servicosSegurados(segurado);
    }
}
