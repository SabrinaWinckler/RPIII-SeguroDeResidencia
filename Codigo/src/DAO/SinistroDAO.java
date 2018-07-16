/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Sinistro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Montanha
 */
public class SinistroDAO {

    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public void create(Sinistro sinistro) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        ResultSet rs;
        int idTipo = -1;
        try {
            stm = conexao.prepareStatement("select tiposinistro.idTipo from "
                    + "tiposinistro where tiposinistro.descricaoTipoSinistro = '" + sinistro.getTipoSinistro() + "'");
            rs = stm.executeQuery();
            while (rs.next()) {
                idTipo = rs.getInt("idTipo");
            }
            stm = conexao.prepareStatement("INSERT INTO sinistro(parecerAvaliador, dataSinistro, descricaoSinistro,"
                    + "autorizadoSinistro, valorSinistro, idTipo)VALUES(?,?,?,?,?,?)");
            stm.setString(1, sinistro.getParecerAvaliador());
            stm.setDate(2, (java.sql.Date.valueOf(sdf.format(sinistro.getDataSinistro()))));
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

    public void solicitacaoSinistro(int idApolice) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        ResultSet rs;
        int idSinistro = -1;
        try {
            stm = conexao.prepareStatement("select max(idSinistro) from sinistro");
            rs = stm.executeQuery();
            while (rs.next()) {
                idSinistro = rs.getInt(1);
            }
            stm = conexao.prepareStatement("insert into solicitacaosinistro(idSinistro, idApolice)values(?,?)");
            stm.setInt(1, idSinistro);
            stm.setInt(2, idApolice);
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
        String autorizadoSinistro;
        String parecerAvaliador = null;
        int codSinistro, codTipoSinitro;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Sinistro> listaDeSinistros = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("select sinistro.idSinistro, autorizadoSinistro, dataSinistro, "
                    + "descricaoSinistro, valorSinistro, descricaoTipoSinistro, tiposinistro.idTipo from sinistro,"
                    + "tiposinistro where sinistro.idTipo = tiposinistro.idTipo;");
            rs = stmt.executeQuery();
            while (rs.next()) {
                codSinistro = rs.getInt("idSinistro");
                codTipoSinitro = rs.getInt("idTipo");
                dataSinistro = rs.getDate("dataSinistro");
                descricaoSinistro = rs.getString("descricaoSinistro");
                valorSinistro = rs.getFloat("valorSinistro");
                autorizadoSinistro = rs.getString("autorizadoSinistro");
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

    public void updateStatusSinistro(Sinistro sinistro) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement("update sinistro set autorizadoSinistro = '" + sinistro.getAutorizadoSinistro()
                    + "', motivoReprovacao = '" + sinistro.getMotivoReprovacao()
                    + "', parecerAvaliador = '" + sinistro.getParecerAvaliador() + "' where sinistro.idSinistro = " + sinistro.getCodSinistro());
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SinistroDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao);
        }
    }
}
