/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectionFactory;
import DadosUsuarios.Segurado;
import SevicosSeguradora.Sinistro;
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
        int idPessoa = -1;
        int idSinistro = -1;
        ResultSet rs;
        try {
            stm = conexao.prepareStatement("select idPessoa, max(idSinistro) from pessoa, sinistro where pessoa.Cpf =" + "'" + cpfSegurado + "'");
            rs = stm.executeQuery();
            while (rs.next()) {
                idPessoa = rs.getInt("idPessoa");
                idSinistro = rs.getInt("idSinistro");
            }
            stm = conexao.prepareStatement("insert into relatasinistro");
            stm.setInt(1, idSinistro);
            stm.setInt(2, idPessoa);
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
                    + "and sinistro.idSinistro = relatasinistro.idSinistro and sinistro.idTipo = tiposinistro.idTipo;");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Segurado pessoa = new Segurado();
                pessoa.setNomePessoa(rs.getString("Nome"));
                pessoa.setEndereco(rs.getString("Endereco"));
                pessoa.setTelefone(rs.getString("Telefone"));
                pessoa.setCpf(rs.getLong("Cpf"));
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
