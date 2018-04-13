package seguroderesidencia.dadosusuario;

import seguroderesidencia.dadosresidencia.Residencia;

public class Candidato {

	private String nome;

	private String endereco;

	private long cep;

	private String bairro;

	private String cidade;

	private String uf;

	private int dataNascimento;

	private char sexo;

	private int telefone;

	private String email;

	private long cpf;

	private String nomeLogin;

	private String senha;

	public void registraEndereco(String endereco, long cep, String bairro, String cidade, String uf) {

	}

	public void registraDadosPessoais(String nome, String dataNascimento, char sexo, long cpf) {

	}

	public void resgitraContato(int telefone, String email) {

	}

	public void setDadosCadastrais(String nomeLogin, String senha) {

	}

	public void setResidencia(Residencia residencia) {

	}

	public Residencia getResidencia() {
		return null;
	}

	public void contratarSeguro(Residencia residencia, String email, int telefone) {

	}

}
