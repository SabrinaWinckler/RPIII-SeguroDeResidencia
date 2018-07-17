/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Servico;
import entity.Bem;
import entity.ItemServico;
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
 * @author SABRINA
 */
public class ServicoDAO {

    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public List<Segurado> read() {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Segurado> listaDeSegurados = new ArrayList<>();
        List<ItemServico> listDeServicos = new ArrayList<>();
        Servico servico = new Servico();
        try {
            stmt = conexao.prepareStatement("select * from servico inner join itemservico on "
                    + "servico.idServico = itemservico.idServico inner join seguradosolicitaservico on "
                    + "seguradosolicitaservico.idServico = servico.idServico inner join pessoa on "
                    + "pessoa.idPessoa = seguradosolicitaservico.idSegurado inner join residencia on "
                    + "residencia.idProprietario = pessoa.idPessoa");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Segurado segurado = new Segurado();
                ItemServico itemServico = new ItemServico();
                itemServico.setDesc(rs.getString("descricaoServico"));
                itemServico.setIdCodServico(rs.getInt("idServico"));
                itemServico.setDescricaoRecusa(rs.getString("descricaoRecusa"));
                itemServico.setDescricaoAtendimento(rs.getString("descricaoAtendimento"));
                itemServico.setAtendidaSolicitacaoServico(rs.getString("atendidaSolicitacao"));
                itemServico.setAceitaSolicitacao(rs.getString("aceitaSolicitacao"));
                itemServico.setDescricaoSolicitacao(rs.getString("descricaoSolicitacao"));
                itemServico.setIdItemServico(rs.getInt("idItemServiço"));
                itemServico.setDataSolicitacaoServico(rs.getDate("dataDeSolicitacao"));
                listDeServicos.add(itemServico);
                segurado.setServicos(listDeServicos);
                listaDeSegurados.add(segurado);
            }
        } catch (SQLException e) {
            Logger.getLogger(Bem.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return listaDeSegurados;
    }

    /*
    public List<ItemServico> servicosSegurados(Segurado segurado) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ItemServico> listaDeServico = new ArrayList<>();
        try {
            
            stmt = conexao.prepareStatement("select * from servico inner join solicitacaoservico on "
                    + "servico.idServico = solicitacaoservico.idServico inner join itemservico on "
                    + "solicitacaoservico.iditemservico = itemservico.iditemservico"
                    + segurado.getIdSegurado());
             
            stmt = conexao.prepareStatement("select servico.descricaoServico from servico inner join solicitacaoservico on "
                    + " solicitacaoservico.idServico = servico.idServico inner join itemservico on "
                    + "itemservico.idItemServico = solicitacaoservico.idItemServico inner join apolice on "
                    + "apolice.idSegurado = " + segurado.getIdSegurado());
            rs = stmt.executeQuery();
            while (rs.next()) {
                ItemServico itemServico = new ItemServico();
                itemServico.setDesc(rs.getString("descricaoServico"));
                itemServico.setIdCodServico(rs.getInt("idServico"));
                //itemServico.setQnt(rs.getInt("quantidadeServico"));
                itemServico.setDescricaoRecusa(rs.getString("descricaoRecusa"));
                itemServico.setDescricaoAtendimento(rs.getString("descricaoAtendimento"));
                //itemServico.setDataDeAtendimento(rs.getDate("dataAtendimento"));
                itemServico.setAtendidaSolicitacaoServico(rs.getString("atendidaSolicitacao"));
                itemServico.setAceitaSolicitacao(rs.getString("aceitaSolicitacao"));
                itemServico.setDescricaoSolicitacao(rs.getString("descricaoSolicitacao"));
                //itemServico.setDataSolicitacaoServico(rs.getDate("dataSolicitacao"));
                itemServico.setIdItemServico(rs.getInt("idItemServiço"));
                itemServico.setDataSolicitacaoServico(rs.getDate("dataDeSolicitacao"));
                listaDeServico.add(itemServico);
            }
        } catch (SQLException e) {
            Logger.getLogger(Bem.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }

        return listaDeServico;

    }
    public void verificarQtdServicoDisponiveis(int idSegurado) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = conexao.prepareStatement("");
        } catch (Exception e) {
        }
    }
     */
    public void registrarItemServico(ItemServico itemServico) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        try {
            stm = conexao.prepareStatement("insert into itemservico(dataSolicitacao,"
                    + " quantidadeDeServicos, dataAgendada, descricaoSolicitacao)values(?,?,?,?)");
            stm.setDate(7, (java.sql.Date.valueOf(sdf.format(itemServico.getDataSolicitacaoServico()))));
            stm.setInt(8, itemServico.getQuantidadeServicos());
            stm.setDate(9, (java.sql.Date.valueOf(sdf.format(itemServico.getDataAgendada()))));
            stm.setString(5, itemServico.getDescricaoSolicitacao());
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(BemDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm);
        }
    }

    public void registrarSolicitacaoServico(int idApolice, String servico) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        ResultSet rs = null;
        int idItemServico = -1;
        int idServico = -1;
        try {
            stm = conexao.prepareStatement("select max(idItemServico) from itemservico");
            rs = stm.executeQuery();
            while (rs.next()) {
                idItemServico = rs.getInt("idItemServico");
            }
            stm = conexao.prepareStatement("select idServico from itemservico where servico.DescricaoServico = '" + servico + "'");
            rs = stm.executeQuery();
            while (rs.next()) {
                idServico = rs.getInt("idServico");
            }
            stm = conexao.prepareStatement("insert into solicitacaoservico(idServico,"
                    + " idItemServico, idApolice)values(?,?,?)");
            stm.setInt(1, idServico);
            stm.setInt(2, idItemServico);
            stm.setInt(3, idApolice);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(BemDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm);

        }
    }
}
