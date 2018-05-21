/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import DAO.BemDAO;
import DAO.CandidatoDAO;
import DAO.PessoaDAO;
import DAO.ResidenciaDAO;
import DAO.SolicitacaoDAO;
import DadosUsuarios.Candidato;
import DadosUsuarios.Pessoa;
import Motor.Solicitacao;
import View.Tela_Login;
import dadosResidencia.Bem;
import dadosResidencia.Residencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Matheus Montanha
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CANDIDATO
        String sexo = "Masculino";
        long cep = 97547590;
        String dataNescimento = "06/09/1998";
        String uf = "RS";
        String cidade = "Alegrete";
        String bairro = "Centro";
        //pessoa atributo
        String nomePessoa = "Matheus Montanha";
        long cpf = 0345;
        String endereco = "Joaquim Rodrigues Paim, 410";
        String telefone = "034565236";
        String email = "estranho@gmail.com";
        String usuarioCliente = "jojoPaulin";
        String senhaCliente = "0352635";
        
        Pessoa pessoa = new Pessoa(nomePessoa, cpf, endereco, telefone, email, usuarioCliente, senhaCliente);
        PessoaDAO pesDAO = new PessoaDAO();
        pesDAO.create(pessoa);
        
        Candidato candidato = new Candidato(sexo, cep, dataNescimento, nomePessoa, cpf, endereco, telefone, email, usuarioCliente, senhaCliente, uf, cidade, bairro);
        CandidatoDAO canDAO = new CandidatoDAO();
        canDAO.create(candidato);

        //RESIDENCIA
        String descricaoRes = "Casa verde";
        int numRes = 410;
        long cepRes = 97547590;
        int qntComodos = 7;
        int qntGaragens = 1;
        float areaTotal = 5285;
        int numAndares = 3;
        int anoConstrucao = 2011;
        String ruaRes = "Joaquim Rodrigues", ufResidencia = "RS";
        double areaConstruida = 510;
        int localizacaoPerigosa = 4;
        int terrenoPerigoso = 5;
        int estruturaAmeacada = 5;
        int quantidadeBanheiros = 1;
        int quantidadeGaragens = 1;
        
        ArrayList<Bem> bens = new ArrayList<>();

        //BEM
        String descricaoBem = "Sofa";
        float valorBem = 540;
        Bem bem = new Bem(descricaoBem, valorBem);
        bens.add(bem);
        
        Residencia residencia = new Residencia(uf, cidade, bairro, descricaoRes, bens, numRes,
                cepRes, qntComodos, quantidadeBanheiros, quantidadeGaragens, areaTotal,
                areaConstruida, numAndares, anoConstrucao, endereco, localizacaoPerigosa, terrenoPerigoso,
                estruturaAmeacada);
        ResidenciaDAO dao = new ResidenciaDAO();
        dao.create(residencia);
        
        BemDAO bemDAO = new BemDAO();
        bemDAO.create(bem);

        //SOLICITACAO
        Date dataSolicitacao = new Date();
        float valorSolicitacao = 250;
        Date dataVisitaResidencia = new Date();
        String aprovadaSolicitacao = "Não";
        String motivoReprovacao = "Reprovada por ser perigosa";
        String motivoAlteracao = "Sem alterações";
        Solicitacao solicitacao = new Solicitacao(dataSolicitacao, valorSolicitacao,
                dataVisitaResidencia, aprovadaSolicitacao, motivoReprovacao,
                motivoAlteracao, residencia, dao);
        SolicitacaoDAO daoSolicitacao = new SolicitacaoDAO();
        daoSolicitacao.create(solicitacao);
        Tela_Login telaLogin = new Tela_Login();
        
        telaLogin.setVisible(true);
    }
    
}
