/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dominio.Corretor;
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
public class CorretorDAO {

    public void create(Corretor corretor) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            stm = conexao.prepareStatement("INSERT INTO corretor(Nome, Endereco, Telefone, Cpf, nomeLogin,"
                    + " senha, email, ativoCorretor, dataContratacao)VALUES(?,?,?,?,?,?,?,?,?)");
            stm.setString(1, corretor.getNomePessoa());
            stm.setString(2, corretor.getEndereco());
            stm.setString(3, corretor.getTelefone());
            stm.setString(4, corretor.getCpf());
            stm.setString(5, corretor.getUsuarioCliente());
            stm.setString(6, corretor.getSenhaCliente());
            stm.setString(7, corretor.getEmail());
            stm.setString(8, corretor.getAtivoCorretor());
            stm.setDate(9, (java.sql.Date.valueOf(sdf.format(corretor.getDataConstratacao()))));
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(CorretorDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm);
        }
    }

    public List<Corretor> read() {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt;
        ResultSet rs;
        List<Corretor> listaDeCorretores = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT * FROM corretor");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Corretor corretor = new Corretor();
                corretor.setCodPessoa(rs.getInt("idCorretor"));
                corretor.setAtivoCorretor(rs.getString("ativoCorretor"));
                corretor.setDataConstratacao(rs.getDate("dataContratacao"));
                corretor.setNomePessoa(rs.getString("Nome"));
                corretor.setEndereco(rs.getString("Endereco"));
                corretor.setTelefone(rs.getString("Telefone"));
                corretor.setCpf(rs.getString("Cpf"));
                corretor.setUsuarioCliente(rs.getString("nomeLogin"));
                corretor.setSenhaCliente(rs.getString("senha"));
                corretor.setEmail(rs.getString("email"));
                listaDeCorretores.add(corretor);
            }
        } catch (SQLException e) {
            Logger.getLogger(CorretorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaDeCorretores;
    }
}
