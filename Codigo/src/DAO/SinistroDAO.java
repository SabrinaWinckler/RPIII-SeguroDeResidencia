/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectionFactory;
import SevicosSeguradora.Sinistro;
import java.sql.Connection;
import java.sql.Date;
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
        String tipoSinistro;
        java.util.Date dataSinistro;
        String descricaoSinistro;
        float valorSinistro;
        String autorizadoSinistro = "";
        String parecerAvaliador;
        int codSinistro, codTipoSinitro;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Sinistro> listaDeSinistros = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("select * from sinistro inner join tiposinistro on"
                    + " sinistro.idTipo = tiposinistro.idTipo");
            rs = stmt.executeQuery();
            while (rs.next()) {
                codSinistro = rs.getInt("idSinistro");
                codTipoSinitro = rs.getInt("idTipo");
                parecerAvaliador = rs.getString("parecerAvaliador");
                dataSinistro = rs.getDate("dataSinistro");
                descricaoSinistro = rs.getString("descricaoSinistro");
                valorSinistro = rs.getFloat("valorSinistro");
                tipoSinistro = rs.getString("descricaoTipoSinistro");
                Sinistro sinistro = new Sinistro(codSinistro, dataSinistro, descricaoSinistro, valorSinistro, autorizadoSinistro, parecerAvaliador, codTipoSinitro, tipoSinistro);
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
