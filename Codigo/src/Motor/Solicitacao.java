package Motor;


import DAO.ResidenciaDAO;
import dadosResidencia.Bem;
import dadosResidencia.Residencia;
import java.util.Date;
import java.util.List;

public class Solicitacao {

	private Date dataSolicitacao;

	private double valorSolicitacao;

	private Date dataVisitaResidencia;

	private boolean aprovadaSolicitacao;

	private String motivoReprovacao;

	private Residencia residencia;
        
        private ResidenciaDAO daoResidencia;
    
    public Solicitacao() {
        this.dataSolicitacao = null;
        this.residencia = new Residencia();
        this.daoResidencia = new ResidenciaDAO();
    }
   @Override
    public String toString() {
        return "Solicitacao{" + "dataSolicitacao=" + dataSolicitacao + ", residencias=" + residencia +'}';
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public Residencia getResidencia(){
        
        return residencia;
    }

//    public ArrayList<Residencia> getResidencias() {
//        return residencias;
//    }
    public ResidenciaDAO getDaoResidencia() {
        return daoResidencia;
    }

    public void registrarSolicitacao(Residencia residencia, Date dataSolicitacao) {
        this.residencia = residencia;
        System.out.println(residencia.toString());
        residencia.registraResidencia(residencia, daoResidencia);
//        for(int i = 0; i< bens.size(); i++ ){
//            Bem bem = new Bem();
//            bem = (Bem)bens.get(i);
//            bem.registraBem(bem);
//        }
        this.dataSolicitacao = dataSolicitacao;
    }

}
