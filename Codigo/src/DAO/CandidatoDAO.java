/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Candidato;
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
        try {
            stm = conexao.prepareStatement("INSERT INTO candidato(Nome, Endereco, Telefone, Cpf, nomeLogin,"
                    + " senha, email, cep, sexo, ufCandidato, cidadeCandidato,"
                    + " bairroCandidato, dataNascimento)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stm.setString(1, candidato.getNomePessoa());
            stm.setString(2, candidato.getEndereco());
            stm.setString(3, candidato.getTelefone());
            stm.setString(4, candidato.getCpf());
            stm.setString(5, candidato.getUsuarioCliente());
            stm.setString(6, candidato.getSenhaCliente());
            stm.setString(7, candidato.getEmail());
            stm.setString(8, String.valueOf(candidato.getCep()));
            stm.setString(9, candidato.getSexo());
            stm.setString(11, candidato.getUf());
            stm.setString(12, candidato.getCidade());
            stm.setString(13, candidato.getBairro());
            stm.setString(14, candidato.getDataNescimento());
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
        int codPessoa;
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Candidato> listaDeCandidato = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT * FROM candidato");
            rs = stmt.executeQuery();
            while (rs.next()) {
                codPessoa = rs.getInt("idCandidato");
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
                Candidato candidato = new Candidato(sexo, cep, dataNescimento, uf, cidade, bairro,
                        codPessoa, nome, cpf, endereco, telefone, email, usuarioCliente, senhaCliente);
                listaDeCandidato.add(candidato);
            }
        } catch (SQLException e) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return listaDeCandidato;
    }

    public Candidato readCandidato(int codCandidato) {
        for (Candidato candidato : read()) {
            if (candidato.getCodPessoa() == codCandidato) {
                return candidato;
            }
        }
        return null;
    }

    public List<String> readUserNames() {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<String> listaDeUserNames = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT nomeLogin FROM candidato");
            rs = stmt.executeQuery();
            while (rs.next()) {
                listaDeUserNames.add(rs.getString("nomeLogin"));
            }
        } catch (SQLException e) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return listaDeUserNames;
    }
}
