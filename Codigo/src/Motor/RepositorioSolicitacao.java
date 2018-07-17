package Motor;

import DAO.BemDAO;
import DAO.ResidenciaDAO;
import DAO.ServicoDAO;
import DAO.SinistroDAO;
import DAO.SolicitacaoDAO;
import DAO.TipoSinistroDAO;
import entity.Solicitacao;
import entity.Servico;
import entity.Bem;
import entity.ItemServico;
import entity.Residencia;
import entity.Sinistro;
import entity.TipoSinistro;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class RepositorioSolicitacao {

    private Date dataSolicitacao;

    private Residencia residencia;

    private double valorSolicitacao;

    private ArrayList<Bem> bens;

    private Solicitacao solicitacao = new Solicitacao();

    private Servico servico;

    private ArrayList<TipoSinistro> sinistros;

    private Gerenciador gerenciador = new Gerenciador();

    private ServicoDAO daoServico = new ServicoDAO();

    public RepositorioSolicitacao() {
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
            int terreno, int estrutura, int id) {

        Residencia temp = this.construirResidencia(uf, cidade, bairro, desc, bens, numRes, cepRes, qntComodos, qntBanheiros, qntGaragens, areaTotal,
                areaC, numAndares, anoConstrucao, ruaRes, localizacao, terreno, estrutura);
        //this.setResidencia(temp);
        geraDAOResidencia().updateStatusResidencia(temp, id);
    }

    public Residencia deletarResidencia() {
        geraDAOResidencia().deleteResidencia(this.residencia);
        return this.residencia;
    }

    public void registrarSolicitacao(String descricaoRes, int numRes,
            long cepRes, int qntComodos, int qntBanheiros, int qntGaragens,
            float areaTotal, int numAndares, int anoConstrucao, String ruaRes,
            String ufResidencia, String cidade, String bairro, double areaConstruida,
            int localizacaoPerigosa, int terrenoPerigoso, int estruturaAmeacada, int id) {

        Residencia temp = new Residencia(descricaoRes,
                numRes, cepRes, qntComodos, qntBanheiros,
                qntGaragens, areaTotal, numAndares, anoConstrucao,
                ruaRes, ufResidencia, cidade, bairro, areaConstruida,
                bens, localizacaoPerigosa, terrenoPerigoso, estruturaAmeacada);
        Date data = new Date();
        geraDAOResidencia().create(temp, id);
        BemDAO daoBem = new BemDAO();
        for (int i = 0; i < bens.size(); i++) {
            daoBem.create(bens.get(i));
        }
        valorSolicitacao = gerenciador.calculaValorSolicitacao(temp);
        Solicitacao tempS = new Solicitacao(data, residencia, valorSolicitacao);
        try {
            if (GerenciadorViewLogin.getInstance().getSeguradoOnline() != null) {
                geraDAOSolicitacao().create(tempS, GerenciadorViewLogin.getInstance().getSeguradoOnline().getIdSegurado());
            }
        } catch (Exception ex) {
            geraDAOSolicitacao().create(tempS, GerenciadorViewLogin.getInstance().getUsuarioOnline().getCodPessoa());
        }
    }

    public ServicoDAO geraDAOServico() {
        ServicoDAO solicitacaoDAO = new ServicoDAO();
        return solicitacaoDAO;
    }

    public Servico construirServico(String desc) {
        Servico temp = new Servico(desc);
        return temp;
    }

    public void registrarServico(String desc, int qnt, Date data, Date visitaResidencia) {
        Servico temp = new Servico(desc);
        this.setServico(temp);
        //eraDAOServico().create(temp);
    }

    public SinistroDAO geraDAOSinistro() {
        SinistroDAO sinistro = new SinistroDAO();
        return sinistro;
    }

    public TipoSinistroDAO geraDAOTipoSinistro() {
        TipoSinistroDAO tipo = new TipoSinistroDAO();
        return tipo;
    }

    public void registrarSinistro(String tipo, float valor, String descricao, int idApolice) {
        Date dataSinistro = new Date();
        Sinistro temp = new Sinistro(dataSinistro, descricao, valor, tipo);
        geraDAOSinistro().create(temp, idApolice);
    }

    public void cadastrarTipoDeSinistro(String nome) {
        TipoSinistro sinistro = new TipoSinistro(nome);
        sinistros.add(sinistro);
    }

    public List<TipoSinistro> lerTipoSinistro() {
        return geraDAOTipoSinistro().read();
    }

    public void tabelaBens(DefaultTableModel tabela) {
        for (Bem string : getBens()) {
            tabela.addRow(new Object[]{
                string.getDescricaoBem(),
                String.valueOf(string.getValorEstimadoBem())
            });
        }
    }

    @Override
    public String toString() {
        return "Solicitaçâo:" + "dataSolicitacao=" + dataSolicitacao + ", residencias=" + residencia + '}';
    }

    public void setBens(ArrayList<Bem> bens) {
        this.bens = bens;
    }

    public void setSinistros(ArrayList<TipoSinistro> sinistros) {
        this.sinistros = sinistros;
    }

    public ArrayList<TipoSinistro> getSinistros() {
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

    public void registrarItemServico(ItemServico item) {
        daoServico.registrarItemServico(item);
    }

    public void resgistrarSolicitacaoServico(int idApolice, String servico) {
        daoServico.registrarSolicitacaoServico(idApolice, servico);
    }
}
