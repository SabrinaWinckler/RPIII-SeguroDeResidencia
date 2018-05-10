/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import DAO.BemDAO;
import DAO.ResidenciaDAO;
import View.Tela_Login;
import dadosResidencia.Bem;
import dadosResidencia.Local;
import dadosResidencia.Residencia;
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
        Residencia residencia = new Residencia(descricaoRes, numRes, cepRes, qntComodos, numAndares, qntGaragens, areaTotal, numAndares, anoConstrucao, ruaRes, ufResidencia, areaConstruida, localizacaoPerigosa, terrenoPerigoso, estruturaAmeacada);
        ResidenciaDAO dao = new ResidenciaDAO();
        dao.create(residencia);
         */
        Tela_Login telaLogin = new Tela_Login();

        telaLogin.setVisible(true);
    }

}
