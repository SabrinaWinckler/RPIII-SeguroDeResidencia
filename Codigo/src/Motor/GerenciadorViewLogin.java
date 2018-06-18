/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motor;

import DAO.PessoaDAO;
import java.util.List;

/**
 *
 * @author Matheus Montanha
 */
public class GerenciadorViewLogin {

    PessoaDAO daoPessoa = new PessoaDAO();

    public List<String> esqueciASenha() {
        return daoPessoa.readUserName();
    }
}
