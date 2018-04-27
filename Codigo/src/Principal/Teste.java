/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import DAO.BemDAO;
import View.Tela_Login;
import dadosResidencia.Bem;

/**
 *
 * @author Matheus Montanha
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bem bem = new Bem();
        bem.setDescricaoBem("Teste de descrição");
        bem.setValorEstimadoBem(1000);
        BemDAO dao = new BemDAO();
        dao.create(bem);
        Tela_Login telaLogin = new Tela_Login();
        telaLogin.setVisible(true);
    }
    
}
