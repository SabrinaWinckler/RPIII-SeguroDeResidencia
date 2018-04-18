public class Candidato extends Pessoa {

	private long cep;

	private Date dataNascimento;

	private char sexo;

	private Residencia residencia;

	private ControleDeSeguro solicitacoesCandidato;

	private Local local;

	public void registraEndereco(String endereco, long cep) {

	}

	public void registraDadosPessoais(Date dataNascimento, char sexo) {

	}

	public void setResidencia(Residencia residencia) {

	}

	public Residencia getResidencia() {
		return null;
	}

	public void contratarSeguro(Residencia residencia, String email, int telefone) {

	}

	public void setLocal(String bairro, String cidade, String uf) {

	}

}
