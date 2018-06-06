/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectionFactory;
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
 * @author SABRINA
 */
public class ResidenciaDAO {

    public void create(Residencia residencia, String cpf) {
        System.out.println(residencia.toString());
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        ResultSet rs;
        int idCandidato;
        try {
            stm = conexao.prepareStatement("select idPessoa from pessoa where pessoa.Cpf =" + cpf);
            rs = stm.executeQuery();
            idCandidato = rs.getInt(1);

            stm = conexao.prepareStatement("INSERT INTO residencia(idProprietario,ufResidencia,"
                    + " cidade, bairro, descricaoResidencia, "
                    + "cepResidencia, enderecoResidencia, areaTotal,"
                    + " areaConstruida, anoConstrucao, estruturaAmeacada, localizacaoPerigosa, "
                    + "terrenoPerigoso, quantidadeComodos, quantidadeBanheiros, quantidadeGaragens, "
                    + "numeroAndares)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stm.setInt(1, idCandidato);
            stm.setString(2, residencia.getUfResidencia());
            stm.setString(3, residencia.getCidade());
            stm.setString(4, residencia.getBairro());
            stm.setString(5, residencia.getDescricaoRes());
            stm.setLong(6, residencia.getCepRes());
            stm.setString(7, residencia.getRuaRes());
            stm.setFloat(8, residencia.getAreaTotal());
            stm.setDouble(9, residencia.getAreaConstruida());
            stm.setInt(10, residencia.getAnoConstrucao());
            stm.setInt(11, residencia.getEstruturaAmeacada());
            stm.setInt(12, residencia.getLocalizacaoPerigosa());
            stm.setInt(13, residencia.getTerrenoPerigoso());
            stm.setInt(14, residencia.getQntComodos());
            stm.setInt(15, residencia.getQntBanheiros());
            stm.setInt(16, residencia.getQntGaragens());
            stm.setInt(17, residencia.getNumAndares());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm);
        }
    }

    public List<Residencia> read() {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Residencia> listaDeResidecias = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT * FROM residencia");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Residencia residencia = new Residencia();
                residencia.setQntGaragens(rs.getInt("quantidadeGaragens"));
                residencia.setAnoConstrucao(rs.getInt("anoConstrucao"));
                residencia.setufResidencia(rs.getString("ufResidencia"));
                residencia.setQntGaragens(rs.getInt("quantidadeComodos"));
                residencia.setDescricaoRes(rs.getString("descricaoResidencia"));
                residencia.setAreaTotal(rs.getFloat("areaTotal"));
                residencia.setCepRes(rs.getLong("cepResidencia"));
                residencia.setAreaConstruida(rs.getDouble("areaConstruida"));
                residencia.setNumAndares(rs.getInt("numeroAndares"));
                residencia.setRuaRes(rs.getString("enderecoResidencia"));
                residencia.setTerrenoPerigoso(rs.getInt("terrenoPerigoso"));
                residencia.setEstruturaAmeacada(rs.getInt("estruturaAmeacada"));
                residencia.setLocalizacaoPerigosa(rs.getInt("localizacaoPerigosa"));
                residencia.setCidade(rs.getString("cidade"));
                residencia.setBairro(rs.getString("bairro"));
                residencia.setQntBanheiros(rs.getInt("quantidadeBanheiros"));
                listaDeResidecias.add(residencia);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResidenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return listaDeResidecias;
    }
}
