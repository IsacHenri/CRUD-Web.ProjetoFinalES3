package br.com.crud.modelo;

import java.util.List;

public class Endereco extends EntidadeDominio {

	private String logradouro;
	private String cep;
	private String numero;
	private String tipoEndereco;
	private String tipoResidencia;
	private String tipoLogradouro;
	private Cidade cidade;
	private String bairro;
	private List<Endereco> enderecos;
	private Cliente cliente;
	
	
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco endereco) {
		this.enderecos.add(endereco);
	}


	public Endereco() {
		super();
	}

	public String getTipoResidencia() {
		return tipoResidencia;
	}


	public void setTipoResidencia(String tipoResidencia) {
		this.tipoResidencia = tipoResidencia;
	}


	public String getTipoLogradouro() {
		return tipoLogradouro;
	}


	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getNumero() {
		return numero;
	}
	

	public String getTipoEndereco() {
		return tipoEndereco;
	}


	public void setTipoEndereco(String tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Endereco(String logradouro, String cep, Cidade cidade, String numero, String tipoEndereco,String tipoResidencia,String tipoLogradouro, String bairro) {
		super();
		this.logradouro = logradouro;
		this.cep = cep;
		this.cidade = cidade;
		this.numero = numero;
		this.tipoEndereco = tipoEndereco;
		this.tipoResidencia = tipoResidencia;
		this.tipoLogradouro = tipoLogradouro;
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}


	
	
		
}
