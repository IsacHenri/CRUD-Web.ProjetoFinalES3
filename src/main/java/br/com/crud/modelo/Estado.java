package br.com.crud.modelo;

public class Estado extends EntidadeDominio {

	private String nome;
	private Pais pais;
	

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado(String nome, Pais pais) {
		super();
		this.nome = nome;
		this.pais = pais;
	}
	
	
}
