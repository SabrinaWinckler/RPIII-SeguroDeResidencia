/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectionFactory;
import dadosResidencia.Residencia;
import SevicosSeguradora.SolicitacaoSeguro;
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
public class SolicitacaoDAO {

    public void create(SolicitacaoSeguro solicitacao) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        try {
            stm = conexao.prepareStatement("INSERT INTO solicitacaoseguro(dataSolicitacao, valorSolicitacao, "
                    + "dataVisitaResidencia, "
                    + "aprovadaSolicitacao, motivoReprovacao, motivoAlteracao)VALUES(?,?,?,?,?,?)");
            stm.setString(1, solicitacao.getDataSolicitacao());
            stm.setFloat(2, solicitacao.getValorSolicitacao());
            stm.setString(3, solicitacao.getDataVisitaResidencia());
            stm.setString(4, solicitacao.getAprovadaSolicitacao());
            stm.setString(5, solicitacao.getMotivoReprovacao());
            stm.setString(6, solicitacao.getMotivoAlteracao());
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(BemDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm);
        }
    }

    public List<SolicitacaoSeguro> read() {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<SolicitacaoSeguro> listDeSolicitacoes = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT * FROM solicitacaoseguro");
            rs = stmt.executeQuery();
            while (rs.next()) {
                SolicitacaoSeguro solicitacao = new SolicitacaoSeguro();
                solicitacao.setDataSolicitacao(rs.getString("dataSolicitacao"));
                solicitacao.setValorSolicitacao(rs.getFloat("valorSolicitacao"));
                solicitacao.setDataVisitaResidencia(rs.getString("dataVisitaResidencia"));
                solicitacao.setAprovadaSolicitacao(rs.getString("aprovadaSolicitacao"));
                solicitacao.setMotivoReprovacao(rs.getString("motivoReprovacao"));
                solicitacao.setMotivoAlteracao(rs.getString("motivoAlteracao"));
                listDeSolicitacoes.add(solicitacao);
            }
        } catch (SQLException e) {
            Logger.getLogger(ResidenciaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return listDeSolicitacoes;
    }
}
