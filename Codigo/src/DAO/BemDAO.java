/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dominio.Bem;
import Dominio.Residencia;
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
 * @author Matheus Montanha
 */
public class BemDAO {

    public void create(Bem bem) {
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
            stm = conexao.prepareStatement("INSERT INTO bem(valorBem, descricaoBem, idResidenciaPertencente)VALUES(?,?,?)");
            stm.setFloat(1, bem.getValorEstimadoBem());
            stm.setString(2, bem.getDescricaoBem());
            stm.setInt(3, idResidencia);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm);
        }
    }

    public List<Bem> read() {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Bem> listaDeBens = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT * FROM bem");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Bem bem = new Bem();
                bem.setCodBem(rs.getInt("idBem"));
                bem.setCodResidenciaPertencente(rs.getInt("idResidenciaPertencente"));
                bem.setDescricaoBem(rs.getString("descricaoBem"));
                bem.setValorEstimadoBem(rs.getFloat("valorBem"));
                listaDeBens.add(bem);
            }
        } catch (SQLException e) {
            Logger.getLogger(Bem.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return listaDeBens;
    }

    public List<Bem> bensPorResidencia(Residencia residencia) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Bem> listaDeBens = new ArrayList<>();
        try {
            stm = conexao.prepareStatement("select * from bem where "
                    + "bem.idResidenciaPertencente =" + residencia.getCodResidencia());
            rs = stm.executeQuery();
            while (rs.next()) {
                Bem bem = new Bem();
                bem.setCodBem(rs.getInt("idBem"));
                bem.setCodResidenciaPertencente(rs.getInt("idResidenciaPertencente"));
                bem.setDescricaoBem(rs.getString("descricaoBem"));
                bem.setValorEstimadoBem(rs.getFloat("valorBem"));
                listaDeBens.add(bem);
            }
        } catch (SQLException e) {
            Logger.getLogger(Bem.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm, rs);
        }
        return listaDeBens;
    }
}
