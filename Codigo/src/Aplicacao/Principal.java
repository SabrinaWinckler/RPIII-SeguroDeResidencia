/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao;

import entity.Bem;
import entity.Pessoa;
import entity.Residencia;
import entity.Solicitacao;
import Motor.GerenciadorViewCorretor;
import View.TelaLogin;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

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
        /*
        String sexo = "Masculino";
        long cep = 97547590;
        String dataNescimento = "06/09/1998";
        String uf = "RS";
        String cidade = "Alegrete";
        String bairro = "Centro";
        /*

        //pessoa atributo
        String nomePessoa = "Matheus Montanha";
        String cpf = "0345";
        String endereco = "Joaquim Rodrigues Paim, 410";
        String telefone = "034565236";
        String email = "estranho@gmail.com";
        String usuarioCliente = "jojoPaulin";
        String senhaCliente = "0352635";

        Pessoa pessoa = new Pessoa(nomePessoa, cpf, endereco, telefone, email, usuarioCliente, senhaCliente);
        //PessoaDAO pesDAO = new PessoaDAO();
        //pesDAO.create(pessoa);
        Candidato candidato = new Candidato(sexo, cep, dataNescimento, nomePessoa, cpf, endereco, telefone, email, usuarioCliente, senhaCliente, uf, cidade, bairro);
        CandidatoDAO canDAO = new CandidatoDAO();
        canDAO.create(candidato);
         

        //RESIDENCIA
        String descricaoRes = "Casa verde";
        int numRes = 410;
        long cepRes = 97547590;
        int qntComodos = 7;
        int qntGaragens = 1;
        float areaTotal = 250;
        int numAndares = 3;
        int anoConstrucao = 2011;
        String ruaRes = "Joaquim Rodrigues", ufResidencia = "RS";
        double areaConstruida = 75;
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

        Residencia residencia = new Residencia(descricaoRes, numRes, cepRes,
                qntComodos, quantidadeBanheiros, qntGaragens, areaTotal,
                numAndares, anoConstrucao, ruaRes, ufResidencia, cidade,
                bairro, areaConstruida, bens, localizacaoPerigosa,
                terrenoPerigoso, estruturaAmeacada);
        /*
        ResidenciaDAO dao = new ResidenciaDAO();
        dao.create(residencia);

        BemDAO bemDAO = new BemDAO();
        bemDAO.create(bem);
         

        //SOLICITACAO
        Date dataSolicitacao = new Date();
        float valorSolicitacao = 250;
        Date dataVisitaResidencia = new Date();
        String aprovadaSolicitacao = "Não";
        String motivoReprovacao = "";
        String motivoAlteracao = "";
        Solicitacao solicitcao = new Solicitacao(dataSolicitacao, areaConstruida,
                dataVisitaResidencia, aprovadaSolicitacao, motivoReprovacao,
                motivoAlteracao, residencia);
        GerenciadorViewCorretor gerenciador = new GerenciadorViewCorretor(new ArrayList());
        double valorTeste = gerenciador.calcularValorSolicitacao(solicitcao);
        //String valorString = "" + valorTeste;
        //float valorFloat = Float.parseFloat(valorString);
        DecimalFormat df = new DecimalFormat("0,000.00");
        System.out.println(df.format(valorTeste));
        /*
        //TIPO DE SINISTRO
        String tipoSinistroRoubo = "Roubo";
        TipoSinistro tipoSinistro = new TipoSinistro(tipoSinistroRoubo);
        TipoSinistroDAO daoTipoSinistro = new TipoSinistroDAO();
        daoTipoSinistro.create(tipoSinistro);

        //SINISTRO
        Date dataSinistro = new Date();
        String descricaoSinistro = "Dois homens com mascara.";
        float valorSinistro = 250;
        String autorizadoSinistro = "Autorizado";
        String parecerAvaliador = "Sinistro muito louco";
        Sinistro sinistro = new Sinistro(dataSinistro, descricaoSinistro, valorSinistro, autorizadoSinistro, parecerAvaliador, tipoSinistroRoubo);

        SinistroDAO daoSinistro = new SinistroDAO();
        daoSinistro.create(sinistro);
         */
        TelaLogin telaLogin = new TelaLogin();

        telaLogin.setVisible(true);
    }

}
