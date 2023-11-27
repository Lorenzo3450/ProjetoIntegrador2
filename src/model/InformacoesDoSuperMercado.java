package model;

public class InformacoesDoSuperMercado {

	private String Email;
	
	private String Senha;
	
	private String Nome;
	
	
	public InformacoesDoSuperMercado(String email, String senha, String nome) {

		Email = email;
		Senha = senha;
		Nome = nome;
	}
	
	
	public String getNome() {
		return Nome;
	}


	public void setNome(String nome) {
		Nome = nome;
	}


	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	
	
	
	
}
