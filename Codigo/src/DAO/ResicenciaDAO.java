/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DB.ConnectionFactory;
import dadosResidencia.Residencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author SABRINA
 */
public class ResicenciaDAO {
   
    public void create(Residencia residencia) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        
        try {
            stm = conexao.prepareStatement("INSERT INTO bem(valorEstimadoBem, descricaoBem)VALUES(?,?)");
            stm.setInt(1, residencia.getAnoConstrucao());
            stm.setString(2,residencia.getDescricaoRes());
            stm.setString(3,residencia.getRuaRes());
            stm.setLong(4,residencia.getCepRes());
            stm.setInt(5,residencia.getNumAndares());
            stm.setInt(6,residencia.getNumRes());
            stm.setInt(7,residencia.getQntBanheiros());
            stm.setInt(8,residencia.getQntComodos());
            stm.setInt(9,residencia.getQntGaragens());
            stm.setFloat(10,residencia.getAreaTotal());
            stm.setObject(11,residencia.getLocal());
            stm.setObject(12,residencia.getBem());
            stm.setInt(12,residencia.getLocalizacaoPerigosa());
            stm.setInt(12,residencia.getTerrenoPerigoso());
            stm.setInt(12,residencia.getEstruturaAmeacada());
            
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm);
        }
    }
}


