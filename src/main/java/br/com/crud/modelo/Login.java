package br.com.crud.modelo;

public class Login extends EntidadeDominio{
	private String email;
	private String senha;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Login(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}
	public Login( String senha) {
		super();
		this.senha = senha;
	}
	
}
