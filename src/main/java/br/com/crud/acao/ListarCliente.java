package br.com.crud.acao;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.fachada.Fachada;
import br.com.crud.modelo.Cliente;
import br.com.crud.modelo.EntidadeDominio;


public class ListarCliente implements IAcao  {

	@Override
	public String getEntidade(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		String nome = request.getParameter("pesquisaNome");

		Cliente cli = new Cliente(nome);
		Fachada fac = new Fachada();
		List<EntidadeDominio> EntidadeDominio = fac.consultar(cli);
		request.setAttribute("EntidadeDominio", EntidadeDominio);
		System.out.println(EntidadeDominio);
		return "<html></html>";
//		Fachada fac = new Fachada();
//		
//		List<EntidadeDominio> lista = fac.consultar(entidade);
//		request.setAttribute("lista", lista);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/View/listaCliente.jsp");
//		try {
//			dispatcher.forward(request, response);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
