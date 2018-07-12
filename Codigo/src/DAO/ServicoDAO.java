/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dominio.Apolice;
import Dominio.Servico;
import Dominio.Bem;
import Dominio.Candidato;
import Dominio.ItemServico;
import Dominio.Segurado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SABRINA
 */
public class ServicoDAO {

    public void create(Servico servico) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            stm = conexao.prepareStatement("INSERT INTO servico(descricaoServico)VALUES(?)");
            stm.setString(1, servico.getDesc());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm);
        }
    }

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
                itemServico.setDataDeSolitacao(rs.getDate("dataDeSolicitacao"));
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

    public List<ItemServico> servicosSegurados(Segurado segurado) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ItemServico> listaDeServico = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("select * from servico inner join itemservico on "
                    + "servico.idServico = itemservico.idServico inner join seguradosolicitaservico on "
                    + "seguradosolicitaservico.idServico = servico.idServico and "
                    + "seguradosolicitaservico.idSegurado = " + segurado.getIdSegurado());
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
                itemServico.setDataDeSolitacao(rs.getDate("dataDeSolicitacao"));
                listaDeServico.add(itemServico);
            }
        } catch (SQLException e) {
            Logger.getLogger(Bem.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }

        return listaDeServico;

    }

    public List<Servico> servicosCadastrados() {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Servico> listaDeServico = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("select * from servico");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Servico servico = new Servico();
                servico.setDesc(rs.getString("descricaoServico"));
                servico.setIdCodServico(rs.getInt("idServico"));
                listaDeServico.add(servico);
            }
        } catch (SQLException e) {
            Logger.getLogger(Bem.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }

        return listaDeServico;

    }

    public void registrarServicoNaApolice(int idApolice, int idServico, Date dataSolicitacao) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        ResultSet rs = null;
        java.sql.Date dataSql = new java.sql.Date(dataSolicitacao.getTime());
        try {
            stm = conexao.prepareStatement("insert into apoliceservico(idApolice, idServico, dataEHoraSolicitacao)"
                    + "values(?,?,?)");
            stm.setInt(1, idApolice);
            stm.setInt(2, idServico);
            stm.setDate(3, dataSql);
        } catch (SQLException e) {
            Logger.getLogger(BemDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm, rs);

        }
    }
}
