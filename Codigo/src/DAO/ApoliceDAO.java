/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Apolice;
import entity.Segurado;
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

    public void create(Apolice apolice, int codSolicitacao, int codSegurado) {
        Connection conexao = ConnectionFactory.realizarConexao();
        DateFormat dataFormatada = new SimpleDateFormat("yyyy/MM/dd");
        PreparedStatement stm = null;
        ResultSet rs = null;
        String data = dataFormatada.format(apolice.getDataContratacaoApolice());
        try {
            stm = conexao.prepareStatement("INSERT INTO apolice(idSolicitacao, "
                    + "bandeiraCartao, numeroApolice, premioApolice, "
                    + "dataContratacaoApolice, cartaoCreditoPgto, "
                    + "vencimentoCartao, codSegurancaCartao, nomeNoCartao, "
                    + "quantidadeParcelas, valorParcela, idSegurado)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            stm.setInt(1, codSolicitacao);
            stm.setString(2, apolice.getBandeiraCartao());
            stm.setString(3, String.valueOf(apolice.getNumeroApolice()));
            stm.setFloat(4, apolice.getPremioApolice());
            stm.setString(5, data);
            stm.setString(6, apolice.getCartaoCreditoPagamento());
            stm.setString(7, apolice.getVencimentoCartao());
            stm.setInt(8, Integer.parseInt("" + apolice.getCodSegurancaCartao()));
            stm.setString(9, apolice.getNomeNoCartao());
            stm.setInt(10, apolice.getQuantidadeParcelas());
            stm.setFloat(11, apolice.getValorParcela());
            stm.setInt(12, codSegurado);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(BemDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm, rs);
        }
    }

    public void createParcela(int codApolice) {
    }

    public List<String> apolicePorSegurado(int idSegurado) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<String> listApolicePorResidencia = new ArrayList<>();
        try {
            stm = conexao.prepareStatement("select residencia.enderecoResidencia "
                    + "from residencia inner join solicitacaoseguro on "
                    + "solicitacaoseguro.idResidencia = residencia.idResidencia inner join apolice on "
                    + "apolice.idSolicitacao = solicitacaoseguro.idSolicitacao inner join segurado on "
                    + "segurado.idSegurado = " + idSegurado);
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
            stm = conexao.prepareStatement("select count(servico.idServico) "
                    + "from servico inner join solicitacaoservico on "
                    + "solicitacaoservico.idServico = " + idServico + " inner join itemservico on "
                    + "itemservico.idItemServico = solicitacaoservico.idItemServico inner join apolice on "
                    + "solicitacaoservico.idApolice = " + idApolice);
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

    public List<Apolice> listaDeApolicePorCliente(int idSegurado) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Apolice> listApolices = new ArrayList<>();
        try {
            stm = conexao.prepareStatement("select * from apolice where apolice.idSegurado = " + idSegurado);
            rs = stm.executeQuery();
            while (rs.next()) {
                Apolice apolice = new Apolice();
                apolice.setCodApolice(rs.getInt("idApolice"));
                apolice.setCodSolicitacao(rs.getInt("idSolicitacao"));
                apolice.setBandeiraCartao(rs.getString("bandeiraCartao"));
                apolice.setNumeroApolice(rs.getString("numeroApolice"));
                apolice.setDataContratacaoApolice(rs.getDate("dataContratacaoApolice"));
                apolice.setCartaoCreditoPagamento(rs.getString("cartaoCreditoPgto"));
                apolice.setVencimentoCartao(rs.getString("vencimentoCartao"));
                apolice.setCodSegurancaCartao(rs.getInt("codSegurancaCartao"));
                apolice.setNomeNoCartao(rs.getString("nomeNoCartao"));
                apolice.setQuantidadeParcelas(rs.getInt("quantidadeParcelas"));
                apolice.setValorParcela(rs.getFloat("valorParcela"));
                listApolices.add(apolice);
            }
            return listApolices;
        } catch (SQLException e) {
            Logger.getLogger(ApoliceDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm, rs);
        }
        return listApolices;
    }
}
