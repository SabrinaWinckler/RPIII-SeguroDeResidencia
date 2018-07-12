/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motor;

import DAO.ApoliceDAO;
import DAO.CandidatoDAO;
import DAO.PessoaDAO;
import DAO.ResidenciaDAO;
import DAO.SeguradoDAO;
import DAO.ServicoDAO;
import DAO.SolicitacaoDAO;
import Dominio.Candidato;
import Dominio.Pessoa;
import Dominio.Segurado;
import Dominio.Solicitacao;
import Dominio.Apolice;
import Dominio.ItemServico;
import Dominio.Residencia;
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
    SeguradoDAO daoSegurado = new SeguradoDAO();
    ApoliceDAO daoApolice = new ApoliceDAO();
    ServicoDAO servicoDAO = new ServicoDAO();

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

    /*
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
     */
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

    public void registrarApolice(String bandeiraCartao, long numeroApolice,
            float premioApolice, Date dataContratacaoApolice, String cartaoCreditoPagamento,
            String vencimentoCartao, long codSegurancaCartao, String nomeNoCartao, int codSolicitacao) {
        Apolice apolice = new Apolice(bandeiraCartao, numeroApolice, premioApolice,
                dataContratacaoApolice, cartaoCreditoPagamento, vencimentoCartao,
                codSegurancaCartao, nomeNoCartao);
        daoApolice.create(apolice, codSolicitacao);
    }

    public List<Solicitacao> listaSolicitacaoCliente(Candidato candidato) {
        SolicitacaoDAO daoSolicitacao = new SolicitacaoDAO();
        return daoSolicitacao.listaSolicitacaoCliente(candidato);
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

    public List<ItemServico> servicoPorCliente(Segurado segurado) {
        return servicoDAO.servicosSegurados(segurado);
    }

    public List<String> apolicePorCliente(Segurado segurado) {
        return daoApolice.apolicePorSegurado(segurado);
    }

    public void transformaCandidatoEmSegurado(String cpf) {
        daoSegurado.create(cpf);
    }
}
