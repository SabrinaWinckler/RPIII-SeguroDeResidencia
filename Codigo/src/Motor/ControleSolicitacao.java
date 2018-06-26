package Motor;

import DAO.BemDAO;
import DAO.ResidenciaDAO;
import DAO.ServicoDAO;
import DAO.SinistroDAO;
import DAO.SolicitacaoDAO;
import Dominio.Solicitacao;
import Dominio.Servico;
import Dominio.Bem;
import Dominio.Residencia;
import Dominio.Sinistro;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControleSolicitacao {

    private Date dataSolicitacao;

    private Residencia residencia;

    private double valorSolicitacao;
    
    private ArrayList<Bem> bens;

    private Solicitacao solicitacao = new Solicitacao();

    private Servico servico;

    private ArrayList<Sinistro> sinistros;
    
    private Gerenciador gerenciador = new Gerenciador();

    public ControleSolicitacao() {
        bens = new ArrayList<Bem>();
        sinistros = new ArrayList();
    }

    public ResidenciaDAO geraDAOResidencia() {
        ResidenciaDAO residenciaDados = new ResidenciaDAO();
        return residenciaDados;
    }

    public Bem construirBem(float valorEstimado, String desc) {
        Bem bem = new Bem(valorEstimado, desc);
        return bem;
    }

    public boolean registraBemLista(float valor, String descB) {
        return bens.add(construirBem(valor, descB));
    }

    public Bem removeBemLista(float valor, String descB) {

        return null;
    }

    public BemDAO geraDAOBem() {
        BemDAO bemDao = new BemDAO();
        return bemDao;
    }

    public SolicitacaoDAO geraDAOSolicitacao() {
        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
        return solicitacaoDAO;
    }

    public Residencia construirResidencia(String uf, String cidade, String bairro,
            String desc, List bens, int numRes, long cepRes, int qntComodos,
            int qntBanheiros, int qntGaragens, float areaTotal, double areaC, int numAndares,
            int anoConstrucao, String ruaRes, int localizacao,
            int terreno, int estrutura) {
        Residencia residenciaTeste = new Residencia(ruaRes, numRes, cepRes, qntComodos, qntBanheiros, qntGaragens, areaTotal, numAndares, anoConstrucao, ruaRes, ruaRes, cidade, bairro, areaC, bens, localizacao, terreno, estrutura);
        //Residencia residencia = new Residencia(uf, cidade, bairro, desc, bens, numRes, cepRes, qntComodos, qntBanheiros, qntGaragens, areaTotal, 
        //areaC, numAndares, anoConstrucao, ruaRes, localizacao, terreno, estrutura);
        return residenciaTeste;
    }
    public void atualizarSolicitacaoResidenciaEditada(String uf, String cidade, String bairro,
            String desc, int numRes, long cepRes, int qntComodos,
            int qntBanheiros, int qntGaragens, float areaTotal, double areaC, int numAndares,
            int anoConstrucao, String ruaRes, int localizacao,
            int terreno, int estrutura) {

        Residencia temp = this.construirResidencia(uf, cidade, bairro, desc, bens, numRes, cepRes, qntComodos, qntBanheiros, qntGaragens, areaTotal,
                areaC, numAndares, anoConstrucao, ruaRes, localizacao, terreno, estrutura);
        //this.setResidencia(temp);
        geraDAOResidencia().updateStatusResidencia(temp);
    }

    public Residencia deletarResidencia() {
        geraDAOResidencia().deleteResidencia(this.residencia);
        return this.residencia;
    }

    public void registrarSolicitacao(String uf, String cidade, String bairro,
            String desc, int numRes, long cepRes, int qntComodos,
            int qntBanheiros, int qntGaragens, float areaTotal, double areaC, int numAndares,
            int anoConstrucao, String ruaRes, int localizacao,
            int terreno, int estrutura, long cpf) {
        
        Residencia temp = new Residencia(ruaRes, numRes, cepRes, qntComodos, qntBanheiros, qntGaragens, areaTotal, numAndares, anoConstrucao, ruaRes, ruaRes, cidade, bairro, areaC, bens, localizacao, terreno, estrutura);
        Date data = new Date();
        geraDAOResidencia().create(temp, String.valueOf(GerenciadorViewLogin.getInstance().getUsuarioOnline().getCpf()));
        BemDAO daoBem = new BemDAO();
        for (int i = 0; i < bens.size(); i++) {
            daoBem.create(bens.get(i));
        }
        valorSolicitacao = gerenciador.calcularValorSolicitacao(temp);
        Solicitacao tempS = new Solicitacao(data, residencia, valorSolicitacao);
        geraDAOSolicitacao().create(tempS, GerenciadorViewLogin.getInstance().getUsuarioOnline().getCpf());
    }

    public ServicoDAO geraDAOServico() {
        ServicoDAO solicitacaoDAO = new ServicoDAO();
        return solicitacaoDAO;
    }

    public Servico construirServico(String desc, int qnt, Date data, Date visitaResidencia) {
        Servico temp = new Servico(desc, qnt, data, visitaResidencia);
        return temp;
    }

    public void registrarServico(String desc, int qnt, Date data, Date visitaResidencia) {

        Servico temp = new Servico(desc, qnt, data, visitaResidencia);
        this.setServico(temp);
        geraDAOServico().create(temp);
    }

    public SinistroDAO geraDAOSinistro() {
        SinistroDAO sinistro = new SinistroDAO();
        return sinistro;
    }

    public void registrarSinistro(String tipo, float valor, String descricao) {
        Date dataSinistro = new Date();
        Sinistro temp = new Sinistro(dataSinistro, descricao, valor, tipo);
        geraDAOSinistro().create(temp);
    }

    public float valorSinistroEscolhido(String escolhido) {
        float valor = 0;
        for (int i = 0; i < sinistros.size(); i++) {
            if (sinistros.get(i).getTipoSinistro().equalsIgnoreCase(escolhido)) {
                valor = sinistros.get(i).getValorSinistro();
                break;
            }
        }
        return valor;
    }

    public void cadastrarTipoDeSinistro(String nome) {
        Sinistro sinistro = new Sinistro(nome);
        sinistros.add(sinistro);
    }

    public void verificarPacoteContratado() {

    }

    @Override
    public String toString() {
        return "Solicitaçâo:" + "dataSolicitacao=" + dataSolicitacao + ", residencias=" + residencia + '}';
    }

    public void setBens(ArrayList<Bem> bens) {
        this.bens = bens;
    }

    public void setSinistros(ArrayList<Sinistro> sinistros) {
        this.sinistros = sinistros;
    }

    public ArrayList<Sinistro> getSinistros() {
        return sinistros;
    }

    public ArrayList<Bem> getBens() {
        return bens;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public Residencia getResidencia() {

        return residencia;
    }

    /**
     * @param dataSolicitacao the dataSolicitacao to set
     */
    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    /**
     * @param residencia the residencia to set
     */
    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

}
