package br.com.crud.modelo;

public class Telefone extends EntidadeDominio{
	private String numero;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Telefone(String numero) {
		super();
		this.numero = numero;
	}
	
}
