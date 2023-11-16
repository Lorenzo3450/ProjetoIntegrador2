package model;

public class LoginModel {

	private String email;
	private String senha;

	public LoginModel(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public String getNomeEmail() {
		return email;
	}
	public void setNomeEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
