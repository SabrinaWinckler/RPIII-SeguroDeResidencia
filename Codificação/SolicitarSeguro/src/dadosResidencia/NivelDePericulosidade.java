package dadosResidencia;

public class NivelDePericulosidade {

	private int localizacaoPerigosa;

	private int terrenoPerigoso;

	private int estruturaAmeacada;

    public NivelDePericulosidade(int localizacaoPerigosa, int terrenoPerigoso, int estruturaAmeacada) {
        this.localizacaoPerigosa = localizacaoPerigosa;
        this.terrenoPerigoso = terrenoPerigoso;
        this.estruturaAmeacada = estruturaAmeacada;
    }

        
	public void atualizaInfo(int localizacaoP, int terrenoP, int estruturaP) {
            this.localizacaoPerigosa = localizacaoPerigosa;
            this.terrenoPerigoso = terrenoPerigoso;
            this.estruturaAmeacada = estruturaAmeacada;
	}

}
