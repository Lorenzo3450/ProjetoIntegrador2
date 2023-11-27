package model;

public class InformacoesPessoais {

	private int idFuncionario;
	private String EmailDeTrabalho;
	private String senha;
	
	
	
	public InformacoesPessoais(int idFuncionario, String emailDeTrabalho, String senha) {
		this.idFuncionario = idFuncionario;
		EmailDeTrabalho = emailDeTrabalho;
		this.senha = senha;
	}
	
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getEmailDeTrabalho() {
		return EmailDeTrabalho;
	}
	public void setEmailDeTrabalho(String emailDeTrabalho) {
		EmailDeTrabalho = emailDeTrabalho;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
