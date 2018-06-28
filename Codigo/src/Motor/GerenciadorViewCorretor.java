/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motor;

import DAO.ServicoDAO;
import DAO.SinistroDAO;
import DAO.SolicitacaoDAO;
import Dominio.ItemServico;
import Dominio.Residencia;
import Dominio.Segurado;
import Dominio.Servico;
import Dominio.Sinistro;
import Dominio.Solicitacao;
import java.util.ArrayList;
import java.util.List;
import service.WebServiceCep;

/**
 *
 * @author Matheus Montanha
 */
public class GerenciadorViewCorretor {

    List<Solicitacao> listaDeSolicitacao;
    List<Sinistro> listaDeSinistro;
    SolicitacaoDAO daoSolicitacao = new SolicitacaoDAO();
    SinistroDAO daoSinistro = new SinistroDAO();
    ServicoDAO daoServico = new ServicoDAO();

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
        //listaDeSolicitacao = organizarListaDeSolicitacoes();
        List<Solicitacao> listaDeSolicitacoesPendendes = new ArrayList<>();
        listaDeSolicitacao.stream().filter((solicitacao) -> (solicitacao.getDataVisitaResidencia() == null && solicitacao.getMotivoReprovacao() == null)).forEachOrdered((solicitacao) -> {
            listaDeSolicitacoesPendendes.add(solicitacao);
        });
        return listaDeSolicitacoesPendendes;
    }

    public List<Solicitacao> listaDeResidenciasPendentes() {
        listaDeSolicitacao = daoSolicitacao.read();
        List<Solicitacao> listaDeResidenciasPendentes = new ArrayList<>();
        if (listaDeSolicitacao.size() > 0) {
            listaDeSolicitacao.stream().filter((solicitacao)
                    -> (solicitacao.getDataVisitaResidencia() != null
                    && (solicitacao.getMotivoAlteracao() == null || solicitacao.getMotivoAlteracao().equalsIgnoreCase("null"))
                    && (solicitacao.getMotivoReprovacao() == null || solicitacao.getMotivoReprovacao().equalsIgnoreCase("null")))).forEachOrdered((solicitacao) -> {
                listaDeResidenciasPendentes.add(solicitacao);
            });
            return listaDeResidenciasPendentes;
        } else {
            return listaDeResidenciasPendentes;
        }
    }

    public void updateStatusSolicitacao(Solicitacao solicitacao) {
        daoSolicitacao.updateStatusSolicitacao(solicitacao);
    }

    public List<Sinistro> listaDeSinistrosPendentes() {
        listaDeSinistro = daoSinistro.read();
        List<Sinistro> listaDeSinistrosParaAvaliar = new ArrayList<>();
        if (listaDeSinistro.size() > 0) {
            listaDeSinistro.stream().filter((sinistro) -> (sinistro.getAutorizadoSinistro() == null
                    || sinistro.getAutorizadoSinistro().equalsIgnoreCase("null") || sinistro.getAutorizadoSinistro().isEmpty())).forEachOrdered((sinistro) -> {
                listaDeSinistrosParaAvaliar.add(sinistro);
            });
            return listaDeSinistrosParaAvaliar;
        } else {
            return listaDeSinistrosParaAvaliar;
        }
    }

    public void registrarDateVisitaResidencia(Solicitacao solicitacao) {
        daoSolicitacao.registrarDataVisita(solicitacao);
    }

    public void updateStatusSinistro(Sinistro sinistro) {
        daoSinistro.updateStatusSinistro(sinistro);
    }

    public double RecalcularValorSolicitacao(Residencia residencia) {
        double valorBaseSolicitacao = 0, valorComTaxas;
        WebServiceCep webServiceCep = WebServiceCep.searchCep("" + residencia.getCepRes());
        String Uf = webServiceCep.getUf();
        if (Uf.equalsIgnoreCase("RS") || Uf.equalsIgnoreCase("SC") || Uf.equalsIgnoreCase("PR")) {
            valorBaseSolicitacao = 346.00;
            valorComTaxas = valorBaseSolicitacao * 3 / 100 * residencia.getQntComodos();
            valorComTaxas += residencia.getAreaConstruida() * 8.54;
            valorComTaxas += valorBaseSolicitacao * 3 / 100 * residencia.getBens().size();
            valorComTaxas += valorBaseSolicitacao * residencia.getLocalizacaoPerigosa() / 100;
            valorComTaxas += valorBaseSolicitacao * residencia.getEstruturaAmeacada() / 100;
            valorComTaxas += valorBaseSolicitacao * residencia.getTerrenoPerigoso() / 100;
            valorComTaxas += valorBaseSolicitacao;
            return valorComTaxas;
        } else if (Uf.equalsIgnoreCase("SP") || Uf.equalsIgnoreCase("RJ")
                || Uf.equalsIgnoreCase("ES") || Uf.equalsIgnoreCase("MG")) {
            valorBaseSolicitacao = 394.80;
            valorComTaxas = valorBaseSolicitacao * 3 / 100 * residencia.getQntComodos();
            valorComTaxas += residencia.getAreaConstruida() * 8.54;
            valorComTaxas += valorBaseSolicitacao * 3 / 100 * residencia.getBens().size();
            valorComTaxas += valorBaseSolicitacao * residencia.getLocalizacaoPerigosa() / 100;
            valorComTaxas += valorBaseSolicitacao * residencia.getEstruturaAmeacada() / 100;
            valorComTaxas += valorBaseSolicitacao * residencia.getTerrenoPerigoso() / 100;
            valorComTaxas += valorBaseSolicitacao;
            return valorComTaxas;
        } else if (Uf.equalsIgnoreCase("AC") || Uf.equalsIgnoreCase("AM")
                || Uf.equalsIgnoreCase("RO") || Uf.equalsIgnoreCase("RR")
                || Uf.equalsIgnoreCase("PA") || Uf.equalsIgnoreCase("AP")
                || Uf.equalsIgnoreCase("TO")) {
            valorBaseSolicitacao = 302.00;
            valorComTaxas = valorBaseSolicitacao * 3 / 100 * residencia.getQntComodos();
            valorComTaxas += residencia.getAreaConstruida() * 8.54;
            valorComTaxas += valorBaseSolicitacao * 3 / 100 * residencia.getBens().size();
            valorComTaxas += valorBaseSolicitacao * residencia.getLocalizacaoPerigosa() / 100;
            valorComTaxas += valorBaseSolicitacao * residencia.getEstruturaAmeacada() / 100;
            valorComTaxas += valorBaseSolicitacao * residencia.getTerrenoPerigoso() / 100;
            valorComTaxas += valorBaseSolicitacao;
            return valorComTaxas;
        } else if (Uf.equalsIgnoreCase("MA") || Uf.equalsIgnoreCase("PI")
                || Uf.equalsIgnoreCase("BA") || Uf.equalsIgnoreCase("CE")
                || Uf.equalsIgnoreCase("PE") || Uf.equalsIgnoreCase("SE")
                || Uf.equalsIgnoreCase("AL") || Uf.equalsIgnoreCase("PB")
                || Uf.equalsIgnoreCase("RN")) {
            valorBaseSolicitacao = 327.90;
            valorComTaxas = valorBaseSolicitacao * 3 / 100 * residencia.getQntComodos();
            valorComTaxas += residencia.getAreaConstruida() * 8.54;
            valorComTaxas += valorBaseSolicitacao * 3 / 100 * residencia.getBens().size();
            valorComTaxas += valorBaseSolicitacao * residencia.getLocalizacaoPerigosa() / 100;
            valorComTaxas += valorBaseSolicitacao * residencia.getEstruturaAmeacada() / 100;
            valorComTaxas += valorBaseSolicitacao * residencia.getTerrenoPerigoso() / 100;
            valorComTaxas += valorBaseSolicitacao;
            return valorComTaxas;
        } else if (Uf.equalsIgnoreCase("MT") || Uf.equalsIgnoreCase("GO")
                || Uf.equalsIgnoreCase("MS")) {
            valorBaseSolicitacao = 341.55;
            valorComTaxas = valorBaseSolicitacao * 3 / 100 * residencia.getQntComodos();
            valorComTaxas += residencia.getAreaConstruida() * 8.54;
            valorComTaxas += valorBaseSolicitacao * 3 / 100 * residencia.getBens().size();
            valorComTaxas += valorBaseSolicitacao * residencia.getLocalizacaoPerigosa() / 100;
            valorComTaxas += valorBaseSolicitacao * residencia.getEstruturaAmeacada() / 100;
            valorComTaxas += valorBaseSolicitacao * residencia.getTerrenoPerigoso() / 100;
            valorComTaxas += valorBaseSolicitacao;
            return valorComTaxas;
        }

        return valorBaseSolicitacao;
    }

    public void editarSolicitacao(Solicitacao solicitacao) {
        daoSolicitacao.editarSolicitacao(solicitacao);
    }

    public List<Segurado> servicosPendentes() {
        return daoServico.read();
    }
}
