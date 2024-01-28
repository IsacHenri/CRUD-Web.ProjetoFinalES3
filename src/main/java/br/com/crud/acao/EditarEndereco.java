package br.com.crud.acao;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.fachada.Fachada;
import br.com.crud.modelo.Cliente;
import br.com.crud.modelo.Endereco;
import br.com.crud.modelo.EntidadeDominio;

public class EditarEndereco implements IAcao{

	@Override
	public String getEntidade(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		Integer idInt = Integer.valueOf(request.getParameter("id"));
		Cliente cli = new Cliente(idInt);
		Endereco end = new Endereco();
		end.setCliente(cli);
		// Consulta o cliente pelo ID
		Fachada fac = new Fachada();
		List<EntidadeDominio> enderecosConsultados = fac.consultar(end);
		for(EntidadeDominio cli1 : enderecosConsultados) {
            if(cli1.getId() == idInt) {
                end = (Endereco) cli1;
            }
        }
		request.setAttribute("end", end);
		return "";
	}

}
