package br.com.crud.strategy;

import br.com.crud.modelo.Cliente;
import br.com.crud.modelo.EntidadeDominio;

public class ValidarCpf implements IStrategy {


	public String processar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente)entidade;
		
		if(cliente.getCpf().length() != 11) {
			return "\n CPF precisa ter 11 digitos";
		}
		//if(cliente.getCredito()<1000) {
		//	return "Crédito deve ser no minimo 1000";
		//}
		return null;
	}

}
