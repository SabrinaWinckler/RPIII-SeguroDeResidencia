/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectionFactory;
import SevicosSeguradora.TipoSinistro;
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
public class TipoSinistroDAO {
    
    public void create(TipoSinistro tipoSinistro) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        try {
            stm = conexao.prepareStatement("INSERT INTO tipoSinistro(descricaoTipoSinistro)VALUES(?)");
            stm.setString(1, tipoSinistro.getTipoSinistro());
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(TipoSinistroDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm);
        }
    }
    
    public List<TipoSinistro> read() {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<TipoSinistro> listaDeTipoSinistro = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT * FROM tipoSinistro");
            rs = stmt.executeQuery();
            while (rs.next()) {
                TipoSinistro tipoSinistro = new TipoSinistro();
                tipoSinistro.setCodTipo(rs.getInt("idTipo"));
                tipoSinistro.setTipoSinistro(rs.getString("descricaoTipoSinistro"));
                listaDeTipoSinistro.add(tipoSinistro);
            }
        } catch (SQLException e) {
            Logger.getLogger(TipoSinistroDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return listaDeTipoSinistro;
    }
}
