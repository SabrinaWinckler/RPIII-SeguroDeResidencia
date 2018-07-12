/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dominio.Apolice;
import Dominio.Segurado;
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
 * @author Débora Siqueira
 */
public class ApoliceDAO {

    public void create(Apolice apolice, int codSolicitacao) {
        Connection conexao = ConnectionFactory.realizarConexao();
        DateFormat dataFormatada = new SimpleDateFormat("yyyy/MM/dd");
        PreparedStatement stm = null;
        ResultSet rs = null;
        String data = dataFormatada.format(apolice.getDataContratacaoApolice());
        try {
            stm = conexao.prepareStatement("INSERT INTO apolice(bandeiraCartao, numeroApolice, premioApolice,"
                    + " dataContratacaoApolice, cartaoCreditoPgto, vencimentoCartao, codSegurancaCartao, nomeNoCartao, idSegurado)"
                    + "VALUES(?,?,?,?,?,?,?,?,?)");
            stm.setString(1, apolice.getBandeiraCartão());
            stm.setLong(2, apolice.getNumeroApolice());
            stm.setFloat(3, apolice.getPremioApolice());
            stm.setString(4, data);
            stm.setString(5, apolice.getCartaoCreditoPagamento());
            stm.setString(6, apolice.getVencimentoCartao());
            stm.setLong(7, apolice.getCodSegurancaCartao());
            stm.setString(8, apolice.getNomeNoCartao());
            stm.setInt(9, codSolicitacao);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(BemDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm, rs);
        }
    }

    public void createParcela(int codApolice) {
    }

    public List<String> apolicePorSegurado(Segurado segurado) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<String> listApolicePorResidencia = new ArrayList<>();
        try {
            stm = conexao.prepareStatement("select residencia.enderecoResidencia "
                    + "from residencia inner join solicitacaoseguro on "
                    + "solicitacaoseguro.idResidencia = residencia.idResidencia inner join apolice on "
                    + "apolice.idSolicitacao = solicitacaoseguro.idSolicitacao inner join segurado on "
                    + "segurado.idPessoa = " + segurado.getIdSegurado());
            rs = stm.executeQuery();
            while (rs.next()) {
                listApolicePorResidencia.add(rs.getString("enderecoResidencia"));
            }
        } catch (SQLException e) {
            Logger.getLogger(ApoliceDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm, rs);

        }
        return listApolicePorResidencia;

    }

    public int qtdServicosSolicitacosPorApolice(int idApolice, int idServico) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        ResultSet rs = null;
        int quantidade = -1;
        try {
            stm = conexao.prepareStatement("select count(servico.idServico) from"
                    + " servico inner join solicitacaoservico on "
                    + "solicitacaoservico.idServico = servico.idServico inner join apolice on "
                    + "apolice.idApolice = solicitacaoservico.idApolice where servico.idServico = " + idServico
                    + " and apolice.idApolice = " + idApolice);
            rs = stm.executeQuery();
            while (rs.next()) {
                quantidade = rs.getInt("idServico");
            }
            return quantidade;
        } catch (SQLException e) {
            Logger.getLogger(ApoliceDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm, rs);

        }
        return quantidade;
    }
}
