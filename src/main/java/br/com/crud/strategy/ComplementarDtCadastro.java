package br.com.crud.strategy;

import java.util.Date;

import br.com.crud.modelo.EntidadeDominio;
/**
 * 
 * @author Isac
 * 
 */
public class ComplementarDtCadastro implements IStrategy {


	public String processar(EntidadeDominio entidade) {
		entidade.setDtCadastro(new Date());
		return null;
	}

}
