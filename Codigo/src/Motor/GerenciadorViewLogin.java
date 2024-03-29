/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motor;

import DAO.CandidatoDAO;
import DAO.CorretorDAO;
import DAO.SeguradoDAO;
import entity.Candidato;
import entity.Corretor;
import entity.Segurado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus Montanha
 */
public final class GerenciadorViewLogin {

    private static final GerenciadorViewLogin INSTANCE = new GerenciadorViewLogin();
    private final SeguradoDAO daoSegurado = new SeguradoDAO();
    private final CandidatoDAO daoCandidato = new CandidatoDAO();
    private final CorretorDAO daoCorretor = new CorretorDAO();
    private static Candidato candidatoOnline;
    private Segurado seguradoOnline;
    private Corretor corretorOnline;

    public List<String> esqueciASenha() {
        return daoCandidato.readUserNames();
    }

    public static GerenciadorViewLogin getInstance() {
        return INSTANCE;
    }

    public void updatePassword(String userName, String password) {

    }

    public void setCandidatoOnline(Candidato pessoa) {
        GerenciadorViewLogin.candidatoOnline = pessoa;
    }

    public Candidato getUsuarioOnline() {
        return GerenciadorViewLogin.candidatoOnline;
    }

    public void setSeguradoOnline(Segurado segurado) {
        seguradoOnline = segurado;
    }

    public Segurado getSeguradoOnline() {
        return seguradoOnline;
    }

    public void setCorretorOnline(Corretor corretor) {
        corretorOnline = corretor;
    }

    public Corretor getCorretorOnline() {
        return corretorOnline;
    }

    public List<Segurado> retornaSegurados() {
        return daoSegurado.read();
    }

    public List<Candidato> retornaCliente() {
        return daoCandidato.read();
    }

    public List<Corretor> retornarCorretor() {
        return daoCorretor.read();
    }

    public List<String> listDeUserName() {
        List<String> listaComUserName = new ArrayList<>();
        daoCandidato.readUserNames().forEach((string) -> {
            listaComUserName.add(string);
        });
        daoCorretor.readUserNames().forEach((string) -> {
            listaComUserName.add(string);
        });
        return listaComUserName;
    }
}
