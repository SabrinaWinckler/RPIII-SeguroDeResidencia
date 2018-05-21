/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectionFactory;
import Motor.Solicitacao;
import com.mysql.jdbc.SQLError;
import dadosResidencia.Residencia;
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
public class SolicitacaoDAO {

    public void create(Solicitacao solicitacao) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        ResultSet rs = null;
        int idResidencia = 27;
        try {
            stm = conexao.prepareStatement("SELECT idResidencia from residencia");
            //idResidencia = rs.getInt("idResidencia");
            stm = conexao.prepareStatement("INSERT INTO solicitacaoseguro(dataSolicitacao, dataVisitaResidenciia,"
                    + "valorSolicitacao, "
                    + "aprovada, motivoReprovacao, motivoAlterecao, idResidencia, idPessoa)VALUES(?,?,?,?,?,?,?,?)");
            stm.setDate(1, (Date.valueOf("2018-06-20")));
            stm.setDate(2, (Date.valueOf("2018-06-20")));
            stm.setDouble(3, solicitacao.getValorSolicitacao());
            stm.setString(4, solicitacao.getAprovadaSolicitacao());
            stm.setString(5, solicitacao.getMotivoReprovacao());
            stm.setString(6, solicitacao.getMotivoAlteracao());
            stm.setInt(7, idResidencia);
            stm.setInt(8, 24);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(BemDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm);
        }
    }

    public List<Solicitacao> read() {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Solicitacao> listDeSolicitacoes = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT * FROM solicitacaoseguro");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Solicitacao solicitacao = new Solicitacao();
                solicitacao.setDataSolicitacao(rs.getDate("dataSolicitacao"));
                solicitacao.setValorSolicitacao(rs.getFloat("valorSolicitacao"));
                solicitacao.setDataVisitaResidencia(rs.getDate("dataVisitaResidencia"));
                solicitacao.setAprovadaSolicitacao(rs.getString("aprovadaSolicitacao"));
                solicitacao.setMotivoReprovacao(rs.getString("motivoReprovacao"));
                solicitacao.setMotivoAlteracao(rs.getString("motivoAlteracao"));

                stmt = conexao.prepareStatement("SELECT * FROM residencia inner join solicitacaoseguro on "
                        + "residencia.idResidencia=solicitacaoseguro.idResidencia");
                rs = stmt.executeQuery();

                solicitacao.getResidencia().setufResidencia(rs.getString("ufResidencia"));
                solicitacao.getResidencia().setCidade(rs.getString("cidade"));
                solicitacao.getResidencia().setBairro(rs.getString("bairro"));
                solicitacao.getResidencia().setDescricaoRes(rs.getString("descricaoResidencia"));
                solicitacao.getResidencia().setCepRes(rs.getLong("cepResidencia"));
                solicitacao.getResidencia().setRuaRes(rs.getString("enderecoResidencia"));
                solicitacao.getResidencia().setAreaTotal(rs.getFloat("areaTotal"));
                solicitacao.getResidencia().setAreaConstruida(rs.getDouble("areaConstruida"));
                solicitacao.getResidencia().setAnoConstrucao(rs.getInt("anoConstrucao"));
                solicitacao.getResidencia().setEstruturaAmeacada(rs.getInt("estruturaAmeacada"));
                solicitacao.getResidencia().setLocalizacaoPerigosa(rs.getInt("localizacaoPerigosa"));
                solicitacao.getResidencia().setTerrenoPerigoso(rs.getInt("terrenoPerigoso"));
                solicitacao.getResidencia().setQntComodos(rs.getInt("quantidadeComodos"));
                solicitacao.getResidencia().setQntBanheiros(rs.getInt("quantidadeBanheiros"));
                solicitacao.getResidencia().setQntGaragens(rs.getInt("quantidadeGaragens"));
                solicitacao.getResidencia().setNumAndares(rs.getInt("numeroAndares"));
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
