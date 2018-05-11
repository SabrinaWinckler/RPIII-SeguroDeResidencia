package Motor;


import dadosResidencia.Residencia;
import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

public class Solicitacao {

	private Date dataSolicitacao;

	private double valorSolicitacao;

	private Date dataVisitaResidencia;

	private boolean aprovadaSolicitacao;

	private String motivoReprovacao;

	private ArrayList<Residencia> residencias;

    @Override
    public String toString() {
        return "Solicitacao{" + "dataSolicitacao=" + dataSolicitacao + ", residencias=" + residencias.toString() + '}';
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public ArrayList<Residencia> getResidencias() {
        return residencias;
    }

    public Solicitacao() {
        this.dataSolicitacao = null;
        this.residencias = new ArrayList<>();
    }
    public void registrarSolicitacao(Residencia residencia, Date dataSolicitacao){
        this.residencias.add(residencia);
        this.dataSolicitacao = dataSolicitacao;
    }

}
