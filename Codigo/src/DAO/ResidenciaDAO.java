/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dominio.Residencia;
import Dominio.Solicitacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SABRINA
 */
public class ResidenciaDAO {

    BemDAO daoBem = new BemDAO();

    public void create(Residencia residencia, String cpf) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        ResultSet rs;
        int idCandidato = -9;
        try {
            stm = conexao.prepareStatement("select idPessoa from pessoa where pessoa.Cpf =" + cpf);
            rs = stm.executeQuery();
            while (rs.next()) {
                idCandidato = rs.getInt("idPessoa");
            }
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

    public Residencia read(Solicitacao solicitacao) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Residencia residencia = new Residencia();
        try {
            stmt = conexao.prepareStatement("select * from residencia where residencia.idResidencia = "
                    + solicitacao.getIdResidencia());
            rs = stmt.executeQuery();
            while (rs.next()) {
                residencia.setCodResidencia(rs.getInt("idResidencia"));
                residencia.setQntGaragens(rs.getInt("quantidadeGaragens"));
                residencia.setAnoConstrucao(rs.getInt("anoConstrucao"));
                residencia.setufResidencia(rs.getString("ufResidencia"));
                residencia.setQntComodos(rs.getInt("quantidadeComodos"));
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
                residencia.setBens(daoBem.bensPorResidencia(residencia));;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResidenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return residencia;
    }

    public void updateStatusResidencia(Residencia solicitacao) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement("update residencia set ufResidencia = '" + solicitacao.getUfResidencia() + "',"
                    + " cidade ='" + solicitacao.getCidade() + "',bairro ='" + solicitacao.getBairro() + "',descricaoResidencia ='" + solicitacao.getDescricaoRes()
                    + "',cepResidencia ='" + solicitacao.getCepRes() + "',enderecoResidencia ='" + solicitacao.getRuaRes()
                    + "',areaTotal ='" + solicitacao.getAreaTotal() + "',areaContruida ='" + solicitacao.getAreaConstruida()
                    + "',anoConstrucao ='" + solicitacao.getAnoConstrucao() + "',estruturaAmeacada ='" + solicitacao.getEstruturaAmeacada()
                    + "',localizacaoPeridgoas ='" + solicitacao.getLocalizacaoPerigosa() + "',terrenoPerigoso ='" + solicitacao.getTerrenoPerigoso()
                    + "',quantidadeComodos ='" + solicitacao.getQntComodos() + "',quantidadeBanheiros ='" + solicitacao.getQntBanheiros()
                    + "',quantidadeGaragens ='" + solicitacao.getQntGaragens() + "',numeroAndares ='" + solicitacao.getNumAndares() + "'  "
                    + "where residencia.idProprietario =" + solicitacao.getCandidato().getCodPessoa()
                    + " and residencia.idResidencia =" + solicitacao.getCodResidencia());
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao);
        }
    }

    public void deleteResidencia(Residencia residencia) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement("DELETE FROM residencia WHERE residencia.idProprietario =" + residencia.getCandidato().getCodPessoa()
                    + " and residencia.idResidencia =" + residencia.getCodResidencia());
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao);
        }

    }
}
