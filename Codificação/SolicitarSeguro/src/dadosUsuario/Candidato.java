package dadosUsuario;


import dadosResidencia.Residencia;
import dadosResidencia.Local;
import java.util.Date;

public class Candidato extends Pessoa {

	private long cep;

	private Date dataNascimento;

	private char sexo;

	private Residencia residencia;

	private Local local;

    public Candidato(long cep, Date dataNascimento, char sexo, Local local) {
        this.cep = cep;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.local = local;
        this.residencia = null;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public long getCep() {
        return cep;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public Residencia getResidencia() {
        return residencia;
    }

    public Local getLocal() {
        return local;
    }

	public void registraEndereco(String endereco, long cep) {

	}

	public void registraDadosPessoais(Date dataNascimento, char sexo) {

	}

	public void contratarSeguro(Residencia residencia, String email, int telefone) {

	}

}
