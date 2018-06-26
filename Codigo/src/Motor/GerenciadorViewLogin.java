/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motor;

import DAO.CandidatoDAO;
import DAO.CorretorDAO;
import DAO.PessoaDAO;
import DAO.SeguradoDAO;
import Dominio.Candidato;
import Dominio.Corretor;
import Dominio.Pessoa;
import Dominio.Segurado;
import java.util.List;

/**
 *
 * @author Matheus Montanha
 */
public final class GerenciadorViewLogin {

    private static final GerenciadorViewLogin INSTANCE = new GerenciadorViewLogin();
    private final PessoaDAO daoPessoa = new PessoaDAO();
    private final SeguradoDAO daoSegurado = new SeguradoDAO();
    private Candidato candidatoOnline;
    private Segurado seguradoOnline;
    private Corretor corretorOnline;

    public List<String> esqueciASenha() {
        return daoPessoa.readUserName();
    }

    public static GerenciadorViewLogin getInstance() {
        return INSTANCE;
    }

    public void updatePassword(String userName, String password) {
        daoPessoa.updatePassword(userName, password);
    }

    public void setCandidatoOnline(Candidato pessoa) {
        this.candidatoOnline = pessoa;
    }

    public Candidato getUsuarioOnline() {
        return this.candidatoOnline;
    }

    public void setSeguradoOnline(Segurado segurado) {
        this.seguradoOnline = segurado;
    }

    public Segurado getSeguradoOnline() {
        return seguradoOnline;
    }

    public void setCorretorOnline(Corretor corretor) {
        this.corretorOnline = corretor;
    }

    public Corretor getCorretorOnline() {
        return this.corretorOnline;
    }

    public List<Segurado> retornaSegurados() {
        return daoSegurado.read();
    }

    public List<Candidato> retornaCliente() {
        CandidatoDAO daoCandidato = new CandidatoDAO();
        return daoCandidato.read();
    }

    public List<Corretor> retornarCorretor() {
        CorretorDAO daoCorretor = new CorretorDAO();
        return daoCorretor.read();
    }
}
