package Motor;

import DAO.BemDAO;
import DAO.ResidenciaDAO;
import DAO.SolicitacaoDAO;
import Operacoes.Solicitacao;
import dadosResidencia.Bem;
import dadosResidencia.Residencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControleSolicitacao {

    private Date dataSolicitacao;

    private Residencia residencia;
    
    private ArrayList<Bem> bens;
    
    private Solicitacao solicitacao;

    public ControleSolicitacao() {
        bens = new ArrayList<Bem>();
    }
    public ResidenciaDAO geraDAOResidencia(){
        ResidenciaDAO residenciaDados = new ResidenciaDAO();
        return residenciaDados;
    }
    public boolean registraBemLista(float valor, String descB){
        return bens.add(construirBem(valor, descB));
    }
    public Bem removeBemLista(float valor, String descB){
        
        return null;
    }
    public BemDAO geraDAOBem(){
        BemDAO bemDao = new BemDAO();
        return bemDao;
    }
    
    public SolicitacaoDAO geraDAOSolicitacao(){
        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
        return solicitacaoDAO;
    }
    public Residencia construirResidencia(String uf, String cidade, String bairro, 
            String desc, List bens, int numRes, long cepRes, int qntComodos, 
            int qntBanheiros, int qntGaragens, float areaTotal, double areaC, int numAndares,
            int anoConstrucao, String ruaRes, int localizacao,
            int terreno, int estrutura){
        
      Residencia residencia = new Residencia(uf, cidade, bairro, desc, bens, numRes, cepRes, qntComodos, qntBanheiros, qntGaragens, areaTotal, 
              areaC, numAndares, anoConstrucao, ruaRes, localizacao, terreno, estrutura);
      return residencia;
    }
    public Bem construirBem(float valorEstimado, String desc){
        Bem bem = new Bem(valorEstimado, desc);
        return bem;
    }
    public Solicitacao construirSolicitacao(){
        Solicitacao temp  = new Solicitacao( this.dataSolicitacao, this.residencia);
        return temp;
    }
    
    public void registrarSolicitacao(String uf, String cidade, String bairro, 
            String desc, int numRes, long cepRes, int qntComodos, 
            int qntBanheiros, int qntGaragens, float areaTotal, double areaC, int numAndares,
            int anoConstrucao, String ruaRes, int localizacao,
            int terreno, int estrutura) {
        
        Residencia temp = this.construirResidencia(uf, cidade, bairro, desc, bens, numRes, cepRes, qntComodos, qntBanheiros, qntGaragens, areaTotal, 
              areaC, numAndares, anoConstrucao, ruaRes, localizacao, terreno, estrutura);
        this.setResidencia(temp);
         geraDAOResidencia().create(temp);
         
        Date data = new Date();
        this.setDataSolicitacao(data);
       
        BemDAO daoBem = geraDAOBem();
        for(int i = 0; i< bens.size(); i++ ){ 
            daoBem.create((Bem)bens.get(i));
        }
        Solicitacao tempS = this.construirSolicitacao();
        geraDAOSolicitacao().create(tempS);
    }

    @Override
    public String toString() {
        return "Solicitaçâo:" + "dataSolicitacao=" + dataSolicitacao + ", residencias=" + residencia + '}';
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
    
   

}
