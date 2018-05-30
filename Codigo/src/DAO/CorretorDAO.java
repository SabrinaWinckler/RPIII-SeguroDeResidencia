/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectionFactory;
import DadosUsuarios.Corretor;
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
public class CorretorDAO {

    public void create(Corretor corretor) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        ResultSet rs;
        int idPessoa = -1;
        try {
            stm = conexao.prepareStatement("SELECT max(pessoa.idPessoa) from pessoa");
            rs = stm.executeQuery();
            while (rs.next()) {
                idPessoa = rs.getInt(1);
            }
            stm = conexao.prepareStatement("INSERT INTO corretor(ativoCorretor, dataContratacao, idPessoa)VALUES"
                    + "(?,?,?)");
            stm.setString(1, corretor.getAtivoCorretor());
            stm.setDate(2, Date.valueOf("2018-05-26"));
            stm.setInt(3, idPessoa);
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
            stmt = conexao.prepareStatement("SELECT * FROM corretor inner join pessoa on "
                    + "corretor.idPessoa = pessoa.idPessoa");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Corretor corretor = new Corretor();
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
