/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dominio.Servico;
import Dominio.Bem;
import Dominio.ItemServico;
import Dominio.Segurado;
import com.sun.javafx.geom.Quat4f;
import com.sun.javafx.scene.control.skin.VirtualFlow;
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

    public void create(Servico servico) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            stm = conexao.prepareStatement("INSERT INTO servico(descricaoServico, "
                    + "quantidadeServico, dataDeSolicitacao, dataVisita)VALUES(?,?,?,?)");
            stm.setString(1, servico.getDesc());
            stm.setFloat(2, servico.getQnt());
            stm.setDate(3, java.sql.Date.valueOf(sdf.format(servico.getDataDeSolitacao())));
            stm.setDate(4, java.sql.Date.valueOf(sdf.format(servico.getDataDeVisita())));
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm);
        }
    }

    public Servico read() {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Servico servico = new Servico();
        try {
            stmt = conexao.prepareStatement("SELECT * FROM bem");
            rs = stmt.executeQuery();

            //servico.setCodServico(rs.getInt("idServico"));
            //servico.setCodResidenciaPertencente(rs.getInt("idResidenciaPertencente"));
            servico.setDesc(rs.getString("desc"));
            servico.setQnt(rs.getInt("qnt"));

        } catch (SQLException e) {
            Logger.getLogger(Bem.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return servico;
    }

    public List<ItemServico> servicosSegurados(Segurado segurado) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ItemServico> listaDeServico = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("select * from servico inner join itemservico on "
                    + "itemservico.idServico = servico.idServico inner join seguradosolicitaservico on "
                    + "seguradosolicitaservico.idServico = itemservico.idServico and "
                    + "seguradosolicitaservico.idSegurado =" + segurado.getCodPessoa());
            rs = stmt.executeQuery();
            while (rs.next()) {
                ItemServico itemServico = new ItemServico();
                itemServico.setDesc(rs.getString("descricaoServico"));
                itemServico.setIdCodServico(rs.getInt("idServico"));
                itemServico.setQnt(rs.getInt("quantidadeServico"));
                itemServico.setDescricaoRecusa(rs.getString("descricaoRecusa"));
                itemServico.setDescricaoAtendimento(rs.getString("descricaoAtendimento"));
                itemServico.setDataDeAtendimento(rs.getDate("dataAtendimento"));
                itemServico.setAtendidaSolicitacaoServico(rs.getString("atendidaSolicitacao"));
                itemServico.setAceitaSolicitacao(rs.getString("aceitaSolicitacao"));
                itemServico.setDescricaoSolicitacao(rs.getString("descricaoSolicitacao"));
                itemServico.setDataSolicitacaoServico(rs.getDate("dataSolicitacao"));
                itemServico.setIdItemServico(rs.getInt("idServico"));
                listaDeServico.add(itemServico);
            }
        } catch (SQLException e) {
            Logger.getLogger(Bem.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }

        return listaDeServico;

    }
}
