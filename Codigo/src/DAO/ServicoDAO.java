/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectionFactory;
import SevicosSeguradora.Servico;
import dadosResidencia.Bem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SABRINA
 */
public class ServicoDAO {
    public void create(Servico servico) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        int idResidencia = -1;
        ResultSet rs;
        try {
            stm = conexao.prepareStatement("SELECT max(residencia.idResidencia) FROM residencia");
            rs = stm.executeQuery();
            while (rs.next()) {
                idResidencia = rs.getInt(1);
            }
            stm = conexao.prepareStatement("INSERT INTO servico(servicoEscolhido, qnt)VALUES(?,?,?)");
            stm.setFloat(1, servico.getQnt());
            stm.setString(2, servico.getDesc());
            stm.setInt(3, idResidencia);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm);
        }
    }
    
    public Servico read() {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Servico servico = new Servico();
        try {
            stmt = conexao.prepareStatement("SELECT * FROM bem");
            rs = stmt.executeQuery();
           
              
                //servico.setCodServico(rs.getInt("idServico"));
                //servico.setCodResidenciaPertencente(rs.getInt("idResidenciaPertencente"));
                servico.setDesc(rs.getString("desc"));
                servico.setQnt(rs.getInt("qnt"));
             
        } catch (SQLException e) {
            Logger.getLogger(Bem.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return servico;
    }
    
}
