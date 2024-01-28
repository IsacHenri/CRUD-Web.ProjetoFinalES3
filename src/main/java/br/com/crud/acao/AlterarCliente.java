package br.com.crud.acao;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.fachada.Fachada;
import br.com.crud.modelo.Cartao;
import br.com.crud.modelo.Cidade;
import br.com.crud.modelo.Cliente;
import br.com.crud.modelo.Endereco;
import br.com.crud.modelo.EntidadeDominio;
import br.com.crud.modelo.Estado;
import br.com.crud.modelo.Login;
import br.com.crud.modelo.Pais;
import br.com.crud.modelo.Telefone;

public class AlterarCliente implements IAcao {

	@Override
	public String getEntidade(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
			Integer idInt = Integer.valueOf(request.getParameter("idCliente"));
			Cliente cli = new Cliente(idInt);

			// Consulta o cliente pelo ID
			Fachada fac = new Fachada();
			List<EntidadeDominio> clientes = fac.consultar(cli);
			Cliente clienteExistente = new Cliente(0);

			for (EntidadeDominio cliFor : clientes) {
				if (cliFor.getId() == idInt) {
					clienteExistente = (Cliente) cliFor;
				}
			}

			Cartao cartao = new Cartao(request.getParameter("numero"), request.getParameter("nomeImpresso"),
					request.getParameter("bandeira"), request.getParameter("codigo"));
			// Configura os novos valores
			Pais pais = new Pais(request.getParameter("pais"));
			Estado estado = new Estado(request.getParameter("estado"), pais);
			Cidade cidade = new Cidade(request.getParameter("cidade"), estado);
			Endereco endereco = new Endereco(request.getParameter("logradouro"), request.getParameter("cep"), cidade,
					request.getParameter("numero"), "Entrega", request.getParameter("tipoResidencia"),
					request.getParameter("tipoLogradouro"), request.getParameter("bairro"));

			Pais paisCobranca = new Pais(request.getParameter("paisCobranca"));
			Estado estadoCobranca = new Estado(request.getParameter("estadoCobranca"), paisCobranca);
			Cidade cidadeCobranca = new Cidade(request.getParameter("cidadeCobranca"), estadoCobranca);
			Endereco enderecoCobranca = new Endereco(request.getParameter("logradouroCobranca"),
					request.getParameter("cepCobranca"), cidadeCobranca, request.getParameter("numeroCobranca"),
					"Cobranca", request.getParameter("tipoResidenciaCobranca"),
					request.getParameter("tipoLogradouroCobranca"), request.getParameter("bairroCobranca"));
			Telefone telefone = new Telefone(request.getParameter("telefone"));
			Login login = new Login(request.getParameter("email"), request.getParameter("senha"));

			clienteExistente.getEndereco().clear(); // Limpa a lista existente
			clienteExistente.getEndereco().add(endereco);
			clienteExistente.getEndereco().add(enderecoCobranca);

			clienteExistente.setNome(request.getParameter("nome"));
			clienteExistente.setGenero(request.getParameter("genero"));
			clienteExistente.setCpf(request.getParameter("cpf"));
			clienteExistente.setEndereco(endereco);
			clienteExistente.setCartao(cartao);
			clienteExistente.setTelefone(telefone);
			clienteExistente.setDataNasc(request.getParameter("dataNasc"));
			clienteExistente.setLogin(login);

			Fachada fac2 = new Fachada();
			return fac2.alterar(clienteExistente);
	}

}
