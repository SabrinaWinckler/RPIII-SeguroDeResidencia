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

    public void create(Residencia residencia) {
        System.out.println(residencia.toString());
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;

        try {//falta bairro e cidade
            stm = conexao.prepareStatement("INSERT INTO residencia(quantidadeGaragens, anoConstrucao, ufResidencia,"
                    + "quantidadeComodos, descricaoResidencia, areaTotal, cepResidencia, areaConstruida,"
                    + "numeroAndares, enderecoResidencia, terrenoPerigoso, estruturaAmeacada, localizacaoPerigosa, quantidadeBanheiros)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stm.setInt(1, residencia.getQntGaragens());
            stm.setInt(2, residencia.getAnoConstrucao());
            stm.setString(3, residencia.getUfResidencia());
            stm.setLong(4, residencia.getQntComodos());
            stm.setString(5, residencia.getDescricaoRes());
            stm.setDouble(6, residencia.getAreaTotal());
            stm.setLong(7, residencia.getCepRes());
            stm.setDouble(8, residencia.getAreaConstrucao());
            stm.setInt(9, residencia.getNumAndares());
            stm.setString(10, residencia.getRuaRes());
            stm.setInt(11, residencia.getTerrenoPerigoso());
            stm.setInt(12, residencia.getEstruturaAmeacada());
            stm.setInt(13, residencia.getLocalizacaoPerigosa());
            stm.setInt(14, residencia.getQntBanheiros());
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
            stmt = conexao.prepareStatement("SELECT * FROM residência");
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
