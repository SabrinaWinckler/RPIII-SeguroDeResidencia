/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motor;

import DAO.RelataSinistroDAO;
import DAO.SinistroDAO;
import DAO.SolicitacaoDAO;
import Dominio.Segurado;
import Dominio.Sinistro;
import Dominio.Solicitacao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus Montanha
 */
public class GerenciadorViewCorretor {

    List<Solicitacao> listaDeSolicitacao;
    List<Sinistro> listaDeSinistro;
    SolicitacaoDAO daoSolicitacao = new SolicitacaoDAO();
    SinistroDAO daoSinistro = new SinistroDAO();

    public GerenciadorViewCorretor(List lista) {
        listaDeSolicitacao = lista;
    }

    private List<Solicitacao> organizarListaDeSolicitacoes() {
        listaDeSolicitacao = daoSolicitacao.read();
        boolean houveTroca;
        if (listaDeSolicitacao.size() >= 2) {
            do {
                houveTroca = false;
                for (int i = 0; i < listaDeSolicitacao.size() - 2; i++) {
                    if (listaDeSolicitacao.get(i).getDataSolicitacao().after(listaDeSolicitacao.get(i + 1).getDataVisitaResidencia())) {
                        Solicitacao temp = listaDeSolicitacao.get(i);
                        listaDeSolicitacao.set(i, listaDeSolicitacao.get(i + 1));
                        listaDeSolicitacao.set(i + 1, temp);
                        houveTroca = true;
                    }
                }
                if (!houveTroca) {
                    break;
                }
                for (int i = listaDeSolicitacao.size() - 2; i >= 0; i--) {
                    if (listaDeSolicitacao.get(i).getDataSolicitacao().after(listaDeSolicitacao.get(i + 1).getDataVisitaResidencia())) {
                        Solicitacao temp = listaDeSolicitacao.get(i);
                        listaDeSolicitacao.set(i, listaDeSolicitacao.get(i + 1));
                        listaDeSolicitacao.set(i + 1, temp);
                        houveTroca = true;
                    }
                }
            } while (houveTroca);
            return listaDeSolicitacao;
        } else {
            return listaDeSolicitacao;
        }
    }

    public List<Solicitacao> listaDeSolicitacoesPendentes() {
        listaDeSolicitacao = daoSolicitacao.read();
        listaDeSolicitacao = organizarListaDeSolicitacoes();
        List<Solicitacao> listaDeSolicitacoesPendendes = new ArrayList<>();
        listaDeSolicitacao.stream().filter((solicitacao) -> (solicitacao.getDataVisitaResidencia() == null && solicitacao.getMotivoReprovacao() == null)).forEachOrdered((solicitacao) -> {
            listaDeSolicitacoesPendendes.add(solicitacao);
        });
        return listaDeSolicitacoesPendendes;
    }

    public List<Solicitacao> listaDeResidenciasPendentes() {
        listaDeSolicitacao = daoSolicitacao.read();
        List<Solicitacao> listaDeResidenciasPendentes = new ArrayList<>();
        listaDeSolicitacao.stream().filter((solicitacao)
                -> (solicitacao.getDataVisitaResidencia() != null
                && solicitacao.getMotivoReprovacao().equalsIgnoreCase("null"))).forEachOrdered((solicitacao) -> {
            listaDeResidenciasPendentes.add(solicitacao);
        });
        return listaDeResidenciasPendentes;
    }

    public void updateStatusSolicitacao(Solicitacao solicitacao) {
        daoSolicitacao.updateStatusSolicitacao(solicitacao);
    }

    public List<Sinistro> listaDeSinistrosPendentes() {
        listaDeSinistro = daoSinistro.read();
        List<Sinistro> listaDeSinistrosParaAvaliar = new ArrayList<>();
        for (Sinistro sinistro : listaDeSinistro) {
            if (!sinistro.getAutorizadoSinistro().equalsIgnoreCase("Autorizado")) {
                listaDeSinistrosParaAvaliar.add(sinistro);
            }
        }
        return listaDeSinistrosParaAvaliar;
    }

    public void registrarDateVisitaResidencia(Solicitacao solicitacao) {
        daoSolicitacao.registrarDataVisita(solicitacao);
    }

    public void updateStatusSinistro(Sinistro sinistro) {
        daoSinistro.updateStatusSinistro(sinistro);
    }
}
