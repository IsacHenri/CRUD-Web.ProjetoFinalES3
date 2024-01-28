package br.com.crud.modelo;

public class Cartao extends EntidadeDominio{
	private String numero;
	private String nomeImpresso;
	private String bandeira;
	private String codigo;
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNomeImpresso() {
		return nomeImpresso;
	}
	public void setNomeImpresso(String nomeImpresso) {
		this.nomeImpresso = nomeImpresso;
	}
	public String getBandeira() {
		return bandeira;
	}
	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Cartao(String numero, String nomeImpresso, String bandeira, String codigo) {
		super();
		this.numero = numero;
		this.nomeImpresso = nomeImpresso;
		this.bandeira = bandeira;
		this.codigo = codigo;
	}
	
	
}
