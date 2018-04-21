package dadosResidencia;


import dadosResidencia.Local;
import dadosResidencia.NivelDePericulosidade;
import dadosResidencia.Bem;
import dadosResidencia.Bem;
import dadosResidencia.Local;
import dadosResidencia.NivelDePericulosidade;

public class Residencia {

	private String descricaoRes;

	private int numRes;

	private long cepRes;

	private int qntComodos;

	private int qntBanheiros;

	private int qntGaragens;

	private float areaTotal;

	private int numAndares;

	private int anoConstrucao;

	private String ruaRes;

	private NivelDePericulosidade nivelDePericulosidade;

	private Bem bem;
        
	private Local local;

    public Residencia(String descricaoRes, int numRes, long cepRes, int qntComodos, int qntBanheiros, int qntGaragens, float areaTotal, int numAndares, int anoConstrucao, String ruaRes,NivelDePericulosidade nivelDePericulosidade, Local local) {
        this.descricaoRes = descricaoRes;
        this.numRes = numRes;
        this.cepRes = cepRes;
        this.qntComodos = qntComodos;
        this.qntBanheiros = qntBanheiros;
        this.qntGaragens = qntGaragens;
        this.areaTotal = areaTotal;
        this.numAndares = numAndares;
        this.anoConstrucao = anoConstrucao;
        this.ruaRes = ruaRes;
        this.nivelDePericulosidade = nivelDePericulosidade;
        this.local = local;
        this.bem = null;
    }
    public void setBem(Bem bem) {
        this.bem = bem;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Bem getBem() {
        return bem;
    }

    public Local getLocal() {
        return local;
    }


	public void registraResidencia() {

	}

	public void registraLocalizacao(String endereco, long cep) {

	}

	public void registraInfo(String descricao, int anoConstrucao) {

	}

	public void registraTamanho(float areaT, int numAndares, int qntGaragem, int qntComodo, int qntBanheiro) {

	}

	public void calculaNivelPericulosidade() {

	}

}
