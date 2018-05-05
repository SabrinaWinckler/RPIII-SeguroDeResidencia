/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectionFactory;
import dadosResidencia.Local;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SABRINA
 */
public class LocalDAO {
    public void create(Local local) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        
        try {
            stm = conexao.prepareStatement("INSERT INTO bem(valorEstimadoBem, descricaoBem)VALUES(?,?)");
            stm.setString(1, local.getBairro());
            stm.setString(2, local.getCidade());
            stm.setString(2, local.getUf());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm);
        }
    }
}
