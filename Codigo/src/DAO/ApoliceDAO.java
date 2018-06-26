/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dominio.Apolice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Débora Siqueira
 */
public class ApoliceDAO {
    
    public void create(Apolice apolice, String cpf) {
        Connection conexao = ConnectionFactory.realizarConexao();
        DateFormat dataFormatada = new SimpleDateFormat("yyyy/MM/dd");
        PreparedStatement stm = null;
        ResultSet rs = null;
        int idPessoa = -1;
        String data = dataFormatada.format(apolice.getDataContratacaoApolice());
        try {
            stm = conexao.prepareStatement("select idPessoa from pessoa where pessoa.Cpf = " + cpf);
            rs = stm.executeQuery();
            while (rs.next()) {
                idPessoa = rs.getInt(1);
            }
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
            stm.setInt(9, idPessoa);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(BemDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm, rs);
        }
    }
    
    public void createParcela(int codApolice) {
    }
}
