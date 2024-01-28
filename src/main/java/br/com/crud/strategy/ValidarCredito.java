package br.com.crud.strategy;

import br.com.crud.modelo.Cliente;
import br.com.crud.modelo.EntidadeDominio;


/**
 * 
 * @author Fatec
 * Implementação da RN 01 
 */
public class ValidarCredito implements IStrategy {


	public String processar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente)entidade;
		int numeroCartao = Integer.parseInt(cliente.getCartao().getNumero());
		if( numeroCartao <= 0) {
			return  "/n é necessario ter um numero maior que zero!";
		}
		return null;
		//if(cliente.getCredito()<1000) {
		//	return "Crédito deve ser no minimo 1000";
		//}
		
	}

}
