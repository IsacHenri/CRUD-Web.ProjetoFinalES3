package br.com.crud.controle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.acao.AlterarCliente;
import br.com.crud.acao.AlterarEndereco;
import br.com.crud.acao.EditarCliente;
import br.com.crud.acao.EditarEndereco;
import br.com.crud.acao.IAcao;
import br.com.crud.acao.ListarCliente;
import br.com.crud.acao.RemoveCliente;
import br.com.crud.acao.SalvaCliente;

@WebServlet("/controle")
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Map<String, IAcao> acoes;
	private static Map<String, String> pages;

	public Controle() {
		super();
		acoes = new HashMap<>();
		pages = new HashMap<>();

		// Mapeando as acoes e as pages
		acoes.put("SalvarCliente", new SalvaCliente());
		acoes.put("RemoveCliente", new RemoveCliente());
		acoes.put("ListarCliente", new ListarCliente());
		acoes.put("EditarCliente", new EditarCliente());
//		acoes.put("EditarSenha", new EditarSenha());
//		acoes.put("AlterarSenha", new AlterarSenha());
		acoes.put("AlterarCliente", new AlterarCliente());
		acoes.put("AlterarEndereco", new AlterarEndereco());
		acoes.put("EditarEndereco", new EditarEndereco());

		pages.put("CadastrarClienteForm", "forward:formCadastrar.jsp");
		pages.put("ListarCliente", "forward:listarCliente.jsp");
		pages.put("SalvarCliente", "forward:controle?acao=ListarCliente");
		pages.put("EditarCliente", "forward:formEditarCliente.jsp");
//		pages.put("EditarSenha", "forward:formEditarSenha.jsp");
		pages.put("RemoveCliente", "forward:controle?acao=ListarCliente");
		pages.put("AlterarCliente", "forward:controle?acao=ListarCliente");
		pages.put("EditarEndereco", "forward:formEditarEndereco.jsp");
		pages.put("AlterarEndereco", "forward:controle?acao=ListarCliente");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");

		System.out.println(paramAcao);

		IAcao acao = acoes.get(paramAcao);

		if (acao != null) {
			String msg = acao.getEntidade(request, response);
			if (msg != null) {
				// Set the message as a request attribute
				request.setAttribute("message", msg);
			}
		}
//		if (paramAcao.equals("SalvarCliente")) {
//			// Forward the request to ListarCliente with the message attribute
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/controle?acao=ListarCliente");
//			dispatcher.forward(request, response);
//		} else if (paramAcao.equals("RemoveCliente")) {
//			// Forward the request to ListarCliente with the message attribute
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/controle?acao=ListarCliente");
//			dispatcher.forward(request, response);
//		} else if (paramAcao.equals("EditarCliente")) {
//			// Forward the request to formEditarCliente.jsp with the message attribute
//			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/View/formEditarCliente.jsp");
//			dispatcher.forward(request, response);
//		} else {
		String nextPage = pages.get(paramAcao);

		System.out.println("testeee");
		System.out.println(nextPage);

		if (nextPage.startsWith("forward:controle")) {
			String forwardPage = nextPage.substring("forward:".length());
			System.out.println(forwardPage);
			RequestDispatcher dp = request.getRequestDispatcher(forwardPage);
			dp.forward(request, response);
		} else if (nextPage.startsWith("forward:")) {
			String forwardPage = nextPage.substring("forward:".length());
			System.out.println(forwardPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/View/" + forwardPage);
			dispatcher.forward(request, response);
		} else if (nextPage.startsWith("redirect:")) {
			String redirectPage = nextPage.substring("redirect:".length());
			response.sendRedirect(redirectPage);
		}
		
		
	}

}
