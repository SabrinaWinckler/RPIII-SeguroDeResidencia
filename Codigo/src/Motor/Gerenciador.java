/*
 
 * To change this license header, choose License Headers in Project Properties.
 
 * To change this template file, choose Tools | Templates
 
 * and open the template in the editor.
 
 */
package Motor;

import DAO.ApoliceDAO;

import DAO.CandidatoDAO;

import DAO.ResidenciaDAO;

import DAO.SeguradoDAO;

import DAO.ServicoDAO;

import DAO.SolicitacaoDAO;

import entity.Candidato;

import entity.Segurado;

import entity.Solicitacao;

import entity.Apolice;

import entity.ItemServico;

import entity.Residencia;

import java.util.Date;

import java.util.List;

import service.WebServiceCep;

/**
 *
 *
 *
 * @author Débora Siqueira
 *
 */
public class Gerenciador {

    List<Object> listaCliente;

    List<Solicitacao> listaDeSolicitacao;

    SeguradoDAO daoSegurado = new SeguradoDAO();

    ApoliceDAO daoApolice = new ApoliceDAO();

    ServicoDAO servicoDAO = new ServicoDAO();

    SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();

    public Gerenciador() {

    }

    public void cadastrarCliente(String sexo, long cep, String dataNescimento,
            String nomePessoa, String cpf, String endereco, String telefone,
            String email, String usuarioCliente, String senhaCliente, String uf,
            String cidade, String bairro) throws NullPointerException {

        Candidato candidato = new Candidato(sexo, cep, dataNescimento, nomePessoa,
                cpf, endereco, telefone, email, usuarioCliente, senhaCliente, uf,
                cidade, bairro);

        CandidatoDAO daoCandidato = new CandidatoDAO();

        daoCandidato.create(candidato);

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
    }

    public void registrarApolice(String bandeiraCartao, String numeroApolice,
            float premioApolice, Date dataContratacaoApolice, String cartaoCreditoPagamento,
            String vencimentoCartao, int codSegurancaCartao, String nomeNoCartao, int codSolicitacao,
            int quantidadeParcelas,
            float valorParcela, int codSegurado) {
        Apolice apolice = new Apolice(codSolicitacao, bandeiraCartao,
                numeroApolice, premioApolice, dataContratacaoApolice,
                cartaoCreditoPagamento, vencimentoCartao, codSegurancaCartao,
                nomeNoCartao, quantidadeParcelas, valorParcela);
        daoApolice.create(apolice, codSolicitacao, codSegurado);

    }

    public List<Solicitacao> listaSolicitacaoCliente(int idUsuario) {
        SolicitacaoDAO daoSolicitacao = new SolicitacaoDAO();
        return daoSolicitacao.listaSolicitacaoCliente(idUsuario);
    }

    public double calculaValorSolicitacao(Residencia residencia) {
        WebServiceCep webServiceCep = WebServiceCep.searchCep("" + residencia.getCepRes());
        String Uf = webServiceCep.getUf();
        double valorBaseSolicitacao = 0;
        if (Uf.equalsIgnoreCase("RS") || Uf.equalsIgnoreCase("SC") || Uf.equalsIgnoreCase("PR")) {
            valorBaseSolicitacao = 346.00;
            return calculoGeral(residencia, valorBaseSolicitacao);
        } else if (Uf.equalsIgnoreCase("SP") || Uf.equalsIgnoreCase("RJ")
                || Uf.equalsIgnoreCase("ES") || Uf.equalsIgnoreCase("MG")) {
            valorBaseSolicitacao = 394.80;
            return calculoGeral(residencia, valorBaseSolicitacao);
        } else if (Uf.equalsIgnoreCase("AC") || Uf.equalsIgnoreCase("AM")
                || Uf.equalsIgnoreCase("RO") || Uf.equalsIgnoreCase("RR")
                || Uf.equalsIgnoreCase("PA") || Uf.equalsIgnoreCase("AP")
                || Uf.equalsIgnoreCase("TO")) {
            valorBaseSolicitacao = 302.00;
            return calculoGeral(residencia, valorBaseSolicitacao);
        } else if (Uf.equalsIgnoreCase("MA") || Uf.equalsIgnoreCase("PI")
                || Uf.equalsIgnoreCase("BA") || Uf.equalsIgnoreCase("CE")
                || Uf.equalsIgnoreCase("PE") || Uf.equalsIgnoreCase("SE")
                || Uf.equalsIgnoreCase("AL") || Uf.equalsIgnoreCase("PB")
                || Uf.equalsIgnoreCase("RN")) {
            valorBaseSolicitacao = 327.90;
            return calculoGeral(residencia, valorBaseSolicitacao);
        } else if (Uf.equalsIgnoreCase("MT") || Uf.equalsIgnoreCase("GO")
                || Uf.equalsIgnoreCase("MS")) {
            valorBaseSolicitacao = 341.55;
            return calculoGeral(residencia, valorBaseSolicitacao);
        }
        return valorBaseSolicitacao;
    }

    public double calculoGeral(Residencia residencia, double valorBase) {
        double valorBaseSolicitacao = valorBase, valorComTaxas = 0;
        valorComTaxas = valorBaseSolicitacao * 3 / 100 * residencia.getQntComodos();
        valorComTaxas += residencia.getAreaConstruida() * 8.54;
        valorComTaxas += valorBaseSolicitacao * 3 / 100 * residencia.getBens().size();
        valorComTaxas += valorBaseSolicitacao * residencia.getLocalizacaoPerigosa() / 100;
        valorComTaxas += valorBaseSolicitacao * residencia.getEstruturaAmeacada() / 100;
        valorComTaxas += valorBaseSolicitacao * residencia.getTerrenoPerigoso() / 100;
        return valorComTaxas += valorBaseSolicitacao;
    }

    public List<ItemServico> servicoPorCliente(int idSegurado) {
        return servicoDAO.servicosSegurados(idSegurado);
    }

    public List<String> apolicePorCliente(int idsegurado) {
        return daoApolice.apolicePorSegurado(idsegurado);
    }

    public List<Apolice> listaDeApolices(int idSegurado) {
        return daoApolice.listaDeApolicePorCliente(idSegurado);
    }

    public void transformaCandidatoEmSegurado(String cpf) {
        daoSegurado.create(cpf);
    }

    public List<Solicitacao> minhasSolicitacoes(int id) {
        return solicitacaoDAO.listaSolicitacaoCliente(id);
    }

}
