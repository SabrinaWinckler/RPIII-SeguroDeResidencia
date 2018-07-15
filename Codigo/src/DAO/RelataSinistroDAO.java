/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Segurado;
import entity.Sinistro;
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
public class RelataSinistroDAO {

    public void create(String cpfSegurado) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        int idSegurado = -1;
        int idSinistro = -1;
        ResultSet rs;
        try {
            stm = conexao.prepareStatement("select idSegurado, max(idSinistro) from segurado,"
                    + " sinistro where pessoa.Cpf =" + "'" + cpfSegurado + "'");
            rs = stm.executeQuery();
            while (rs.next()) {
                idSegurado = rs.getInt("idSegurado");
                idSinistro = rs.getInt("idSinistro");
            }
            stm = conexao.prepareStatement("insert into solicitacaosinistro(idSegurado, idSinistro)"
                    + "values(?,?)");
            stm.setInt(1, idSegurado);
            stm.setInt(2, idSinistro);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(RelataSinistroDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm);
        }
    }

    public List<Segurado> read() {
        List<Sinistro> listaDeSinistro = new ArrayList<>();
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Segurado> listaDeSegurados = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("select * from pessoa, sinistro, relatasinistro, tiposinistro "
                    + "where pessoa.idPessoa = relatasinistro.idPessoa \n"
                    + "and sinistro.idSinistro = relatasinistro.idSinistro and sinistro.idTipo = tiposinistro.idTipo");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Segurado pessoa = new Segurado();
                pessoa.setCodPessoa(rs.getInt("idPessoa"));
                pessoa.setNomePessoa(rs.getString("Nome"));
                pessoa.setEndereco(rs.getString("Endereco"));
                pessoa.setTelefone(rs.getString("Telefone"));
                pessoa.setCpf(rs.getString("Cpf"));
                pessoa.setUsuarioCliente(rs.getString("NomeLogin"));
                pessoa.setSenhaCliente(rs.getString("senha"));
                pessoa.setEmail(rs.getString("email"));
                Sinistro sinistro = new Sinistro();
                sinistro.setParecerAvaliador(rs.getString("parecerAvaliador"));
                sinistro.setDataSinistro(rs.getDate("dataSinistro"));
                sinistro.setDescricaoSinistro(rs.getString("descricaoSinistro"));
                sinistro.setAutorizadoSinistro(rs.getString("autorizadoSinistro"));
                sinistro.setValorSinistro(rs.getLong("valorSinistro"));
                sinistro.setTipoSinistro(rs.getString("descricaoTipoSinistro"));
                listaDeSinistro.add(sinistro);
                pessoa.setSinistros(listaDeSinistro);
                listaDeSegurados.add(pessoa);
            }
        } catch (SQLException e) {
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return listaDeSegurados;
    }
}
