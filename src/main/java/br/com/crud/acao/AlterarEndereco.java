package br.com.crud.acao;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.fachada.Fachada;
import br.com.crud.modelo.Cidade;
import br.com.crud.modelo.Endereco;
import br.com.crud.modelo.Estado;
import br.com.crud.modelo.Pais;

public class AlterarEndereco implements IAcao{
	@Override
	public String getEntidade(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
			Integer idInt = Integer.valueOf(request.getParameter("id"));
			
			Pais pais = new Pais(request.getParameter("pais"));
			Estado estado = new Estado(request.getParameter("estado"), pais);
			Cidade cidade = new Cidade(request.getParameter("cidade"), estado);
			Endereco endereco = new Endereco(request.getParameter("logradouro"), request.getParameter("cep"), cidade,
					request.getParameter("numero"), request.getParameter("tipoEndereco"), request.getParameter("tipoResidencia"),
					request.getParameter("tipoLogradouro"), request.getParameter("bairro"));
		
			endereco.setId(idInt);
			Fachada fac2 = new Fachada();
			return fac2.alterar(endereco);
	}
}
