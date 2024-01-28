package br.com.crud.modelo;


public class Pais extends EntidadeDominio{
	private String nome;

	public Pais(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
