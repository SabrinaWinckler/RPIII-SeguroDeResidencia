/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Candidato;
import entity.Segurado;
import entity.Solicitacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Montanha
 */
public class SolicitacaoDAO {

    ResidenciaDAO daoResidencia = new ResidenciaDAO();
    CandidatoDAO daoCandidato = new CandidatoDAO();
    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public void create(Solicitacao solicitacao, String cpfPessoa) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        ResultSet rs;
        int idResidencia = -1;
        int idPessoa = -1;
        try {
            stm = conexao.prepareStatement("SELECT max(residencia.idResidencia) from residencia");
            rs = stm.executeQuery();
            while (rs.next()) {
                idResidencia = rs.getInt(1);
            }
            stm = conexao.prepareStatement("SELECT idPessoa from pessoa where pessoa.Cpf = "
                    + cpfPessoa);
            rs = stm.executeQuery();
            while (rs.next()) {
                idPessoa = rs.getInt(1);
            }
            stm = conexao.prepareStatement("INSERT INTO solicitacaoseguro(dataSolicitacao, "
                    + "valorSolicitacao, "
                    + "aprovada, motivoReprovacao, motivoAlterecao, idResidencia, idPessoa)VALUES(?,?,?,?,?,?,?)");
            stm.setDate(1, (java.sql.Date.valueOf(sdf.format(solicitacao.getDataSolicitacao()))));
            stm.setDouble(2, solicitacao.getValorSolicitacao());
            stm.setString(3, solicitacao.getAprovadaSolicitacao());
            stm.setString(4, solicitacao.getMotivoReprovacao());
            stm.setString(5, solicitacao.getMotivoAlteracao());
            stm.setInt(6, idResidencia);
            stm.setInt(7, idPessoa);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(BemDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stm);
        }
    }

    public List<Solicitacao> read() {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Solicitacao> listDeSolicitacoes = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT * FROM solicitacaoseguro inner join residencia on "
                    + "solicitacaoseguro.idResidencia = residencia.idResidencia inner join candidato on "
                    + "residencia.idProprietario = candidato.idCandidato");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Solicitacao solicitacao = new Solicitacao();
                solicitacao.setCodSolicitacao(rs.getInt("idSolicitacao"));
                solicitacao.setDataSolicitacao(rs.getDate("dataSolicitacao"));
                solicitacao.setDataVisitaResidencia(rs.getDate("dataVisitaResidenciia"));
                solicitacao.setValorSolicitacao(rs.getFloat("valorSolicitacao"));
                solicitacao.setAprovadaSolicitacao(rs.getString("aprovada"));
                solicitacao.setMotivoReprovacao(rs.getString("motivoReprovacao"));
                solicitacao.setMotivoAlteracao(rs.getString("motivoAlterecao"));
                solicitacao.setIdResidencia(rs.getInt("idResidencia"));
                solicitacao.setResidencia(daoResidencia.read(solicitacao));
                solicitacao.getResidencia().setCandidato(daoCandidato.readCandidato(rs.getInt("idCandidato")));
                /*
                solicitacao.getResidencia().getCandidato().setCodPessoa(rs.getInt("idPessoa"));
                solicitacao.getResidencia().getCandidato().setCep(rs.getLong("cep"));
                solicitacao.getResidencia().getCandidato().setSexo(rs.getString("sexo"));
                solicitacao.getResidencia().getCandidato().setUf(rs.getString("ufCandidato"));
                solicitacao.getResidencia().getCandidato().setCidade(rs.getString("cidadeCandidato"));
                solicitacao.getResidencia().getCandidato().setBairro(rs.getString("bairroCandidato"));
                solicitacao.getResidencia().getCandidato().setDataNescimento(rs.getString("dataNascimento"));
                solicitacao.getResidencia().getCandidato().setNomePessoa(rs.getString("Nome"));
                solicitacao.getResidencia().getCandidato().setEndereco(rs.getString("Endereco"));
                solicitacao.getResidencia().getCandidato().setTelefone(rs.getString("Telefone"));
                solicitacao.getResidencia().getCandidato().setCpf(rs.getString("Cpf"));
                solicitacao.getResidencia().getCandidato().setUsuarioCliente(rs.getString("nomeLogin"));
                solicitacao.getResidencia().getCandidato().setSenhaCliente(rs.getString("senha"));
                solicitacao.getResidencia().getCandidato().setEmail(rs.getString("email"));
                 */
                listDeSolicitacoes.add(solicitacao);
            }
        } catch (SQLException e) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return listDeSolicitacoes;
    }

    public void registrarDataVisita(Solicitacao solicitacao) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm;
        String data = sdf.format(solicitacao.getDataVisitaResidencia());
        try {
            stm = conexao.prepareStatement("update solicitacaoseguro set "
                    + "dataVisitaResidenciia = '" + data + "' where "
                    + "solicitacaoseguro.idSolicitacao = " + solicitacao.getCodSolicitacao());
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao);
        }
    }

    public void updateStatusSolicitacao(Solicitacao solicitacao) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement("update solicitacaoseguro set aprovada = '" + solicitacao.getAprovadaSolicitacao() + "',"
                    + " motivoReprovacao ='" + solicitacao.getMotivoReprovacao() + "' "
                    + "where solicitacaoseguro.idCandidato =" + solicitacao.getResidencia().getCandidato().getCodPessoa()
                    + " and solicitacaoseguro.idResidencia =" + solicitacao.getResidencia().getCodResidencia());
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao);
        }
    }

    public List<Solicitacao> listaSolicitacaoCliente(int idPessoa) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Solicitacao> listDeSolicitacoes = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("select * from solicitacaoseguro "
                    + "inner join residencia on "
                    + "solicitacaoseguro.idResidencia = residencia.idResidencia "
                    + "where solicitacaoseguro.idCandidato = " + idPessoa);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Solicitacao solicitacao = new Solicitacao();
                solicitacao.setCodSolicitacao(rs.getInt("idSolicitacao"));
                solicitacao.setDataSolicitacao(rs.getDate("dataSolicitacao"));
                solicitacao.setValorSolicitacao(rs.getFloat("valorSolicitacao"));
                solicitacao.setDataVisitaResidencia(rs.getDate("dataVisitaResidenciia"));
                solicitacao.setAprovadaSolicitacao(rs.getString("aprovada"));
                solicitacao.setMotivoReprovacao(rs.getString("motivoReprovacao"));
                solicitacao.setMotivoAlteracao(rs.getString("motivoAlterecao"));
                solicitacao.setIdResidencia(rs.getInt("idResidencia"));
                solicitacao.setResidencia(daoResidencia.read(solicitacao));
                listDeSolicitacoes.add(solicitacao);
            }

        } catch (SQLException e) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return listDeSolicitacoes;
    }

    public void editarSolicitacao(Solicitacao solicitacao) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm;
        PreparedStatement stmt;
        try {
            stm = conexao.prepareStatement("update residencia set quantidadeComodos = "
                    + solicitacao.getResidencia().getQntComodos() + ", quantidadeBanheiros = "
                    + solicitacao.getResidencia().getQntBanheiros() + ", "
                    + "quantidadeGaragens = " + solicitacao.getResidencia().getQntGaragens() + ","
                    + " anoConstrucao =" + solicitacao.getResidencia().getAnoConstrucao() + " ,"
                    + " areaConstruida = " + solicitacao.getResidencia().getAreaConstruida() + ", "
                    + "areaTotal = " + solicitacao.getResidencia().getAreaTotal() + ", "
                    + "terrenoPerigoso = " + solicitacao.getResidencia().getTerrenoPerigoso() + ", "
                    + "estruturaAmeacada = " + solicitacao.getResidencia().getEstruturaAmeacada() + ","
                    + " localizacaoPerigosa = " + solicitacao.getResidencia().getLocalizacaoPerigosa() + " "
                    + "where residencia.idResidencia = " + solicitacao.getResidencia().getCodResidencia());
            stmt = conexao.prepareStatement("update solicitacaoseguro set valorSolicitacao = "
                    + solicitacao.getValorSolicitacao() + ", motivoAlterecao = '"
                    + solicitacao.getMotivoAlteracao() + "' where solicitacaoseguro.idSolicitacao = "
                    + solicitacao.getCodSolicitacao());
            stm.executeUpdate();
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao);
        }
    }
}
