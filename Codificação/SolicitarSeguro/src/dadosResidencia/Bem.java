package dadosResidencia;

public class Bem {

	private float valorEstimadoBem;

	private String descricaoBem;

    public Bem() {
        this.valorEstimadoBem = 0;
        this.descricaoBem = null;
    }
    public void resgitraBem(String descricao, float valor){
        this.valorEstimadoBem = valor;
        this.descricaoBem = descricao;
    }
}
