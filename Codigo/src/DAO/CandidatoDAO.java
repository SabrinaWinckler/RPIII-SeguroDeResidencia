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
public class CandidatoDAO {

    public void create(Candidato candidato) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        ResultSet rs;
        int idPessoa = -1;
        try {
            stm = conexao.prepareStatement("select max(pessoa.idPessoa) from pessoa");
            rs = stm.executeQuery();
            while (rs.next()) {
                idPessoa = rs.getInt(1);
            }
            stm = conexao.prepareStatement("INSERT INTO candidato(cep, sexo, idPessoa, "
                    + "ufCandidato, cidadeCandidato,"
                    + " bairroCandidato, dataNascimento)VALUES(?,?,?,?,?,?,?)");
            stm.setLong(1, candidato.getCep());
            stm.setString(2, candidato.getSexo());
            stm.setInt(3, idPessoa);
            stm.setString(4, candidato.getUf());
            stm.setString(5, candidato.getCidade());
            stm.setString(6, candidato.getBairro());
            stm.setString(7, candidato.getDataNescimento());
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm);
        }
    }

    public List<Candidato> read() {
        long cep;
        String dataNescimento, endereco, sexo, nome, cpf;
        String uf, cidade, bairro, telefone, email, usuarioCliente, senhaCliente;
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Candidato> listaDeCandidato = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT * FROM candidato inner join pessoa on "
                    + "candidato.idPessoa = pessoa.idPessoa");
            rs = stmt.executeQuery();
            while (rs.next()) {
                cep = rs.getLong("cep");
                sexo = rs.getString("sexo");
                uf = rs.getString("ufCandidato");
                bairro = rs.getString("bairroCandidato");
                cidade = rs.getString("cidadeCandidato");
                dataNescimento = rs.getString("dataNascimento");
                cpf = rs.getString("Cpf");
                endereco = rs.getString("Endereco");
                telefone = rs.getString("Telefone");
                email = rs.getString("email");
                usuarioCliente = rs.getString("nomeLogin");
                senhaCliente = rs.getString("senha");
                nome = rs.getString("Nome");
                Candidato candidato = new Candidato(sexo, cep, dataNescimento,
                        nome, cpf, endereco, telefone, email, usuarioCliente,
                        senhaCliente, uf, cidade, bairro);
                listaDeCandidato.add(candidato);
            }
        } catch (SQLException e) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return listaDeCandidato;
    }
}
