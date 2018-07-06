/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dominio.Candidato;
import Dominio.Solicitacao;
import dominio.Contato;
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
public class ContatoDAO {
    ResidenciaDAO daoResidencia = new ResidenciaDAO();
    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public void create(Contato mensagem, String cpfPessoa) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        ResultSet rs;
        int idResidencia = -1;
        int idPessoa = -1;
        try {
            stm = conexao.prepareStatement("SELECT max(residencia.idResidencia) from residencia");
            rs = stm.executeQuery();
            while (rs.next()) {
                idResidencia = rs.getInt(1);
            }
            stm = conexao.prepareStatement("SELECT idPessoa from pessoa where pessoa.Cpf = "
                    + cpfPessoa);
            rs = stm.executeQuery();
            while (rs.next()) {
                idPessoa = rs.getInt(1);
            }
            stm = conexao.prepareStatement("INSERT INTO contatoUsuario(email, "
                    + "mensagem, "
                    + "data, idPessoa)VALUES(?,?,?, ?)");
            
            stm.setString(1, mensagem.getEmail());
            stm.setString(2, mensagem.getMensagem());
            stm.setDate(3, (java.sql.Date.valueOf(sdf.format(mensagem.getData()))));
            stm.setInt(4, idPessoa);
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
        List<Contato> listDeMensagens = new ArrayList<>();
        return null;
    }

    public void updateContato(Solicitacao solicitacao) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm;
        
    }

    
    
}
