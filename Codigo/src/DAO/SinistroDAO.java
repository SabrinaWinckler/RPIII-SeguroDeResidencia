/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectionFactory;
import SevicosSeguradora.Sinistro;
import dadosResidencia.Residencia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Montanha
 */
public class SinistroDAO {
    
    public void create(Sinistro sinistro) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        ResultSet rs;
        int idTipo = -1;
        try {
            stm = conexao.prepareStatement("SELECT max(tiposinistro.idTipo) from tiposinistro");
            rs = stm.executeQuery();
            while (rs.next()) {
                idTipo = rs.getInt(1);
            }
            stm = conexao.prepareStatement("INSERT INTO sinistro(parecerAvaliador, dataSinistro, descricaoSinistro,"
                    + "autorizadoSinistro, valorSinistro, idTipo)VALUES(?,?,?,?,?,?)");
            stm.setString(1, sinistro.getParecerAvaliador());
            stm.setDate(2, Date.valueOf("2018-05-23"));
            stm.setString(3, sinistro.getDescricaoSinistro());
            stm.setString(4, sinistro.getAutorizadoSinistro());
            stm.setFloat(5, sinistro.getValorSinistro());
            stm.setInt(6, idTipo);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SinistroDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm);
        }
    }
    
    public List<Sinistro> read() {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Sinistro> listaDeSinistros = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT * FROM sinistro");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Sinistro sinistro = new Sinistro();
                sinistro.setParecerAvaliador(rs.getString("parecerAvaliador"));
                sinistro.setDataSinistro(rs.getDate("dataSinistro"));
                sinistro.setDescricaoSinistro(rs.getString("descricaoSinistro"));
                sinistro.setValorSinistro(rs.getFloat("valorSinistro"));
                listaDeSinistros.add(sinistro);
            }
        } catch (SQLException e) {
            Logger.getLogger(SinistroDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return listaDeSinistros;
    }
}
