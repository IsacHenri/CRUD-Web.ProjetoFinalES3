package br.com.crud.strategy;

import br.com.crud.modelo.Cliente;
import br.com.crud.modelo.EntidadeDominio;

public class ValidarCliente implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		//ValidarEndereco vEnd = new ValidarEndereco();
		Cliente cliente = (Cliente)entidade;
//		//String validacaoCliente = vEnd.processar(cliente.getEndereco());
//		StringBuilder sb = new StringBuilder();
		//if( validacaoCliente!= null) {
		//	sb.append(validacaoCliente);
		//}
		
		
		if(cliente.getCpf() == null) {
			return "\n CPF é um campo obrigatório";
		}
		
		return null;
	}

}
