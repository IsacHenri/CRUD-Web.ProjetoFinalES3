package br.com.crud.modelo;

import java.util.Date;

public class EntidadeDominio {
	private Integer id;
	private Date dtCadastro;
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	@Override
	public String toString() {
		return "EntidadeDominio [id=" + id + ", dtCadastro=" + dtCadastro + "]";
	}
	
}
