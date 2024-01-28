package br.com.crud.controle;

import java.util.HashMap;
import java.util.Map;

import br.com.crud.modelo.Cliente;

public class Teste {

	public static void main(String[] args) {
			
		
		System.out.println(Cliente.class.getName());
		
		Map<String, String> mapEstado = new HashMap<String, String>();
		mapEstado.put("SP", "SÃO PAULO");
		mapEstado.put("MG", "MINAS GERAIS");
		
		
		for(String s: mapEstado.values()) {
			System.out.println(s);
		}
		
		for(String s: mapEstado.keySet()) {
			System.out.println(s);
		}

	}

}
