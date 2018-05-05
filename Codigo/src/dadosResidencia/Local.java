package dadosResidencia;

//import dadosUsuario.Candidato;

public class Local {

	private String uf;

	private String cidade;

	private String bairro;

    public Local(String uf, String cidade, String bairro) {
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
        
	public void registraDados(String uf, String cidade, String bairro) {

	}

}
