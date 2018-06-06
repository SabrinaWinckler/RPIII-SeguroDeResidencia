/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectionFactory;
import DadosUsuarios.Candidato;
import DadosUsuarios.Pessoa;
import dadosResidencia.Residencia;
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
 * @author Débora Siqueira
 */
public class PessoaDAO {

    public void create(Pessoa pessoa) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        try {
            stm = conexao.prepareStatement("INSERT INTO pessoa(Nome, Endereco, Telefone,"
                    + " Cpf, nomeLogin, senha, email)"
                    + "VALUE(?,?,?,?,?,?,?)");
            stm.setString(1, pessoa.getNomePessoa());
            stm.setString(2, pessoa.getEndereco());
            stm.setString(3, pessoa.getTelefone());
            stm.setString(4, pessoa.getCpf());
            stm.setString(5, pessoa.getUsuarioCliente());
            stm.setString(6, pessoa.getSenhaCliente());
            stm.setString(7, pessoa.getEmail());
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm);
        }
    }

    public List<Pessoa> read() {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Pessoa> listaDePessoa = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT * FROM pessoa");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setNomePessoa(rs.getString("Nome"));
                pessoa.setEndereco(rs.getString("Endereco"));
                pessoa.setTelefone(rs.getString("Telefone"));
                pessoa.setCpf(rs.getString("Cpf"));
                pessoa.setUsuarioCliente(rs.getString("NomeLogin"));
                pessoa.setSenhaCliente(rs.getString("senha"));
                pessoa.setEmail(rs.getString("email"));
                listaDePessoa.add(pessoa);
            }
        } catch (SQLException e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return listaDePessoa;
    }
}
