package br.com.crud.acao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.fachada.Fachada;
import br.com.crud.modelo.Cartao;
import br.com.crud.modelo.Cidade;
import br.com.crud.modelo.Cliente;
import br.com.crud.modelo.Endereco;
import br.com.crud.modelo.Estado;
import br.com.crud.modelo.Login;
import br.com.crud.modelo.Pais;
import br.com.crud.modelo.Telefone;

public class SalvaCliente implements IAcao {

	public String getEntidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		Pais pais = new Pais(request.getParameter("pais"));
		Estado estado = new Estado(request.getParameter("estado"), pais);
		Cidade cidade = new Cidade(request.getParameter("cidade"), estado);
		Endereco endereco = new Endereco(request.getParameter("logradouro"),request.getParameter("cep"),cidade, request.getParameter("numero"),"Entrega",request.getParameter("tipoResidencia"),request.getParameter("tipoLogradouro"),request.getParameter("bairro") );
		Cartao cartao = new Cartao(request.getParameter("numero"),request.getParameter("nomeImpresso"),request.getParameter("bandeira"),request.getParameter("codigo"));
		Pais paisCobranca = new Pais(request.getParameter("paisCobranca"));
		Estado estadoCobranca = new Estado(request.getParameter("estadoCobranca"), paisCobranca);
		Cidade cidadeCobranca = new Cidade(request.getParameter("cidadeCobranca"), estadoCobranca);
		Endereco enderecoCobranca = new Endereco(request.getParameter("logradouroCobranca"),request.getParameter("cepCobranca"),cidadeCobranca, request.getParameter("numeroCobranca"),"Cobranca",request.getParameter("tipoResidenciaCobranca"),request.getParameter("tipoLogradouroCobranca"),request.getParameter("bairroCobranca"));
		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(enderecoCobranca);
		enderecos.add(endereco);
		Telefone telefone = new Telefone(request.getParameter("telefone"));
		Login login = new Login(request.getParameter("email"), request.getParameter("senha"));
		
		Cliente cliente = new Cliente(request.getParameter("nome"),request.getParameter("genero"),request.getParameter("cpf"), enderecos,cartao, telefone,request.getParameter("dataNasc") , login );
		Fachada fac = new Fachada();
		
		return fac.salvar(cliente);
	}

}
