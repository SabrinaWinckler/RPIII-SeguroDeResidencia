/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectionFactory;
import DadosUsuarios.Candidato;
import Operacoes.Solicitacao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void create(Solicitacao solicitacao) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm = null;
        ResultSet rs;
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        int idResidencia = -1;
        int idPessoa = -1;
        try {
            stm = conexao.prepareStatement("SELECT max(residencia.idResidencia) from residencia");
            rs = stm.executeQuery();
            while (rs.next()) {
                idResidencia = rs.getInt(1);
            }
            stm = conexao.prepareStatement("SELECT max(pessoa.idPessoa) from pessoa");
            rs = stm.executeQuery();
            while (rs.next()) {
                idPessoa = rs.getInt(1);
            }
            stm = conexao.prepareStatement("INSERT INTO solicitacaoseguro(dataSolicitacao, dataVisitaResidenciia,"
                    + "valorSolicitacao, "
                    + "aprovada, motivoReprovacao, motivoAlterecao, idResidencia, idPessoa)VALUES(?,?,?,?,?,?,?,?)");
            stm.setDate(1, (Date.valueOf(dataFormatada.format(solicitacao.getDataSolicitacao()))));
            stm.setDate(2, (Date.valueOf(dataFormatada.format(solicitacao.getDataSolicitacao()))));
            stm.setDouble(3, solicitacao.getValorSolicitacao());
            stm.setString(4, solicitacao.getAprovadaSolicitacao());
            stm.setString(5, solicitacao.getMotivoReprovacao());
            stm.setString(6, solicitacao.getMotivoAlteracao());
            stm.setInt(7, idResidencia);
            stm.setInt(8, idPessoa);
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
                    + "solicitacaoseguro.idResidencia = residencia.idResidencia inner join pessoa on "
                    + "pessoa.idPessoa = solicitacaoseguro.idPessoa inner join candidato on "
                    + "candidato.idPessoa = pessoa.idPessoa");
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
                solicitacao.getResidencia().setCodResidencia(rs.getInt("idResidencia"));
                solicitacao.getResidencia().setufResidencia(rs.getString("ufResidencia"));
                solicitacao.getResidencia().setCidade(rs.getString("cidade"));
                solicitacao.getResidencia().setBairro(rs.getString("bairro"));
                solicitacao.getResidencia().setDescricaoRes(rs.getString("descricaoResidencia"));
                solicitacao.getResidencia().setCepRes(rs.getLong("cepResidencia"));
                solicitacao.getResidencia().setRuaRes(rs.getString("enderecoResidencia"));
                solicitacao.getResidencia().setAreaTotal(rs.getFloat("areaTotal"));
                solicitacao.getResidencia().setAreaConstruida(rs.getDouble("areaConstruida"));
                solicitacao.getResidencia().setAnoConstrucao(rs.getInt("anoConstrucao"));
                solicitacao.getResidencia().setEstruturaAmeacada(rs.getInt("estruturaAmeacada"));
                solicitacao.getResidencia().setLocalizacaoPerigosa(rs.getInt("localizacaoPerigosa"));
                solicitacao.getResidencia().setTerrenoPerigoso(rs.getInt("terrenoPerigoso"));
                solicitacao.getResidencia().setQntComodos(rs.getInt("quantidadeComodos"));
                solicitacao.getResidencia().setQntBanheiros(rs.getInt("quantidadeBanheiros"));
                solicitacao.getResidencia().setQntGaragens(rs.getInt("quantidadeGaragens"));
                solicitacao.getResidencia().setNumAndares(rs.getInt("numeroAndares"));
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
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        String data = dataFormatada.format(solicitacao.getDataVisitaResidencia());
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

    public void updateStatusSolicitacao(String resultado, String motivoReprovacao, String motivoAlteracao, String data, int codCandidato, int codSolicitacao) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement("update solicitacaoseguro set aprovada=" + resultado + ","
                    + " motivoReprovacao=" + motivoReprovacao + ", motivoAlterecao =" + motivoAlteracao + ","
                    + "dataVisitaResidencia =" + data + "where solicitacaoseguro.idSolicitacao =" + codSolicitacao + "and "
                    + "solicitacao.idPessoa = " + codCandidato);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public List<Solicitacao> listaSolicitacaoCliente(Candidato candidato) {
        Connection conexao = ConnectionFactory.realizarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Solicitacao> listDeSolicitacoes = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT * FROM solicitacaoseguro INNER JOIN RESIDENCIA ON "
                    + "solicitacaoseguro.idResidencia = residencia.idResidencia AND solicitacaoseguro.idPessoa = " + candidato.getCodPessoa());
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
                solicitacao.getResidencia().setCodResidencia(rs.getInt("idResidencia"));
                solicitacao.getResidencia().setufResidencia(rs.getString("ufResidencia"));
                solicitacao.getResidencia().setCidade(rs.getString("cidade"));
                solicitacao.getResidencia().setBairro(rs.getString("bairro"));
                solicitacao.getResidencia().setDescricaoRes(rs.getString("descricaoResidencia"));
                solicitacao.getResidencia().setCepRes(rs.getLong("cepResidencia"));
                solicitacao.getResidencia().setRuaRes(rs.getString("enderecoResidencia"));
                solicitacao.getResidencia().setAreaTotal(rs.getFloat("areaTotal"));
                solicitacao.getResidencia().setAreaConstruida(rs.getDouble("areaConstruida"));
                solicitacao.getResidencia().setAnoConstrucao(rs.getInt("anoConstrucao"));
                solicitacao.getResidencia().setEstruturaAmeacada(rs.getInt("estruturaAmeacada"));
                solicitacao.getResidencia().setLocalizacaoPerigosa(rs.getInt("localizacaoPerigosa"));
                solicitacao.getResidencia().setTerrenoPerigoso(rs.getInt("terrenoPerigoso"));
                solicitacao.getResidencia().setQntComodos(rs.getInt("quantidadeComodos"));
                solicitacao.getResidencia().setQntBanheiros(rs.getInt("quantidadeBanheiros"));
                solicitacao.getResidencia().setQntGaragens(rs.getInt("quantidadeGaragens"));
                solicitacao.getResidencia().setNumAndares(rs.getInt("numeroAndares"));
                listDeSolicitacoes.add(solicitacao);
            }

        } catch (SQLException e) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return listDeSolicitacoes;

    }
}
