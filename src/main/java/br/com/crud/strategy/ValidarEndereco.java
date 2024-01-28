package br.com.crud.strategy;

import br.com.crud.modelo.Endereco;
import br.com.crud.modelo.EntidadeDominio;

public class ValidarEndereco implements IStrategy{

	public String processar(EntidadeDominio entidade) {
		Endereco end = (Endereco)entidade;
		StringBuilder sb = new StringBuilder();
		if(end.getCidade() == null) {
			sb.append("Cidade é um campo obrigatório");
		}
		
		if(end.getCidade().getEstado() == null) {
			sb.append("\nEstado é um campo obrigatório");
		}
		
		
		if(end.getLogradouro() == null || end.getLogradouro().trim().equals("")) {
			sb.append("\\nLogradouro é um campo obrigatório");
		}
		String msg = sb.toString();
		
		if(msg.length() == 0) {
			return null;
		}else {
			return null;
		}
		
	}

}
