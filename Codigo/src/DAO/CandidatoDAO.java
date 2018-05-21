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

        try {
            stm = conexao.prepareStatement("INSERT INTO candidato(cep, sexo, idPessoa, "
                    + "ufCandidato, cidadeCandidato,"
                    + " bairroCandidato, dataNascimento)VALUES(?,?,?,?,?,?,?)");
            stm.setLong(1, candidato.getCep());
            stm.setString(2, candidato.getSexo());
            stm.setInt(3, 27);
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
        String sexo;
        long cep;
        String dataNescimento;
        String uf, cidade, bairro;
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Pessoa> listaDePessoas;
        listaDePessoas = pessoaDAO.read();
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Candidato> listaDeCandidato = new ArrayList<>();
        int i = 0;
        try {
            stmt = conexao.prepareStatement("SELECT * FROM candidato");
            rs = stmt.executeQuery();
            while (rs.next()) {
                cep = rs.getLong("cep");
                sexo = rs.getString("sexo");
                uf = rs.getString("uf");
                bairro = rs.getString("bairro");
                cidade = rs.getString("cidade");
                dataNescimento = rs.getString("dataNascimento");
                Candidato candidato = new Candidato(sexo, cep, dataNescimento,
                        listaDePessoas.get(i).getNomePessoa(),
                        listaDePessoas.get(i).getCpf(),
                        listaDePessoas.get(i).getEndereco(),
                        listaDePessoas.get(i).getTelefone(),
                        listaDePessoas.get(i).getEmail(),
                        listaDePessoas.get(i).getUsuarioCliente(),
                        listaDePessoas.get(i).getSenhaCliente(), uf, cidade, bairro);
                i++;
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
