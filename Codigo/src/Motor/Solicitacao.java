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

    public Solicitacao() {
        this.dataSolicitacao = null;
        this.residencias = new ArrayList<>();
    }
    public void registrarSolicitacao(Residencia residencia, Date dataSolicitacao){
        this.residencias.add(residencia);
        this.dataSolicitacao = dataSolicitacao;
    }

}