/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectionFactory;
import dadosResidencia.Bem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Montanha
 */
public class BemDAO {
    
    public void create(Bem bem) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        
        try {
            stm = conexao.prepareStatement("INSERT INTO bem(valorBem, descricaoBem)VALUES(?,?)");
            stm.setFloat(1, bem.getValorEstimadoBem());
            stm.setString(2, bem.getDescricaoBem());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm);
        }
    }
}
