/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import DAO.BemDAO;
import DAO.ResidenciaDAO;
import DAO.SolicitacaoDAO;
import DadosUsuarios.Candidato;
import View.Tela_Login;
import dadosResidencia.Bem;
import dadosResidencia.Residencia;
import dadosResidencia.SolicitacaoSeguro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus Montanha
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
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
        int quantidadeDeBanheiros = 2;

        ArrayList<Bem> bens = new ArrayList<>();

        //BEM
        String descricaoBem = "Sofa";
        float valorBem = 540;
        Bem bem = new Bem(descricaoBem, valorBem);
        bens.add(bem);

        Residencia residencia = new Residencia(descricaoRes, numRes, cepRes, qntComodos, numAndares, qntGaragens, areaTotal, numAndares, anoConstrucao, bens, ruaRes, ufResidencia, areaConstruida, localizacaoPerigosa, terrenoPerigoso, estruturaAmeacada);

        BemDAO bemDAO = new BemDAO();
        bemDAO.create(bem);

        ResidenciaDAO dao = new ResidenciaDAO();
        dao.create(residencia);

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
        String usuarioCliente = "joaoRoberto";
        String senhaCliente = "0352635";

        Candidato candidato = new Candidato(sexo, cep, dataNescimento, nomePessoa, cpf, endereco, telefone, email, usuarioCliente, senhaCliente, uf, cidade, bairro);

        //SOLICITACAO
        String dataSolicitacao = "06/06/2018";
        float valorSolicitacao = 250;
        String dataVisitaResidencia = "09/08/2018";
        String aprovadaSolicitacao = "Sim";
        String motivoReprovacao = "Reprovada por ser perigosa";
        String motivoAlteracao = "Sem alterações";

        SolicitacaoSeguro solicitacao = new SolicitacaoSeguro(dataSolicitacao, valorSolicitacao, dataVisitaResidencia, aprovadaSolicitacao, motivoReprovacao, motivoAlteracao);

        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
        solicitacaoDAO.create(solicitacao);
        
         */
        Tela_Login telaLogin = new Tela_Login();

        telaLogin.setVisible(true);
    }

}
