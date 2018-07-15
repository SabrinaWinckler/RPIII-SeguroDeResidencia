/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Segurado;
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
 * @author Matheus Montanha
 */
public class SeguradoDAO {

    public void create(String cpf) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        ResultSet rs;
        int idPessoa = -1;
        try {
            stm = conexao.prepareStatement("select idCandidato from pessoa where candidato.Cpf = " + cpf);
            rs = stm.executeQuery();
            while (rs.next()) {
                idPessoa = rs.getInt(1);
            }
            stm = conexao.prepareStatement("insert into segurado(idCandidato)value(?)");
            stm.setInt(1, idPessoa);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SeguradoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm);
        }
    }

    public List<Segurado> read() {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Segurado> listaDePessoa = new ArrayList<>();
        long cep;
        String dataNescimento, endereco, sexo, nome, cpf;
        String uf, cidade, bairro, telefone, email, usuarioCliente, senhaCliente;
        int codPessoa;
        try {
            stmt = conexao.prepareStatement("select * from candidato inner join "
                    + "segurado on segurado.idSegurado = candidato.idCandidato");
            rs = stmt.executeQuery();
            while (rs.next()) {
                codPessoa = rs.getInt("idSegurado");
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
                Segurado segurado = new Segurado(codPessoa, sexo, cep,
                        dataNescimento, uf, cidade, bairro, nome, cpf,
                        endereco, telefone, email, usuarioCliente, senhaCliente);
                listaDePessoa.add(segurado);
            }
        } catch (SQLException e) {
            Logger.getLogger(SeguradoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return listaDePessoa;
    }
}
