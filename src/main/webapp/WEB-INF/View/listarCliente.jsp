<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.crud.modelo.Cliente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta de cadastros</title>

<style>
form {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-top: 20px;
	margin-bottom: 20px;
}

form input[type="text"] {
    width: 100%;
    padding: 5px;
    margin: 5px 0; 
    border: 2px solid #ccc;
    border-radius: 4px;
}

form input[type="submit"] {
    padding: 10px 20px;
    background-color: #ffbb27;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    margin-top: 5px; 
}

form a.botao-cadastrar {
    padding: 10px 20px;
    background-color: #007bff;
    color: #fff;
    text-decoration: none;
    border-radius: 4px;
    cursor: pointer;
    margin-top: 10px;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 15px;
	margin-bottom: 25px;
}

table th {
	background-color: #ffaf00;
	color: #fff;
	text-align: left;
	padding: 10px;
}

table td, table th {
	border: 1px solid #ddd;
	padding: 10px;
	border: none;
}

table tr:nth-child(even) {
	background-color: #f2f2f2;
}

table a.botao-editar {
	padding: 5px 10px;
	background-color: #ffbb27;
	color: #fff;
	text-decoration: none;
	border-radius: 4px;
	cursor: pointer;
	margin-right: 10px;
}

table a.botao-excluir {
	padding: 5px 10px;
	background-color: #f44336;
	color: #fff;
	text-decoration: none;
	border-radius: 4px;
	cursor: pointer;
	margin-right: 10px;
}
</style>
</head>

<body>

	<form>
		<br> <br> Insira o nome do cliente: <input type="text"
			name="pesquisaNome" required /> <input type="hidden" name="acao"
			value="ListarCliente"> <input type="submit" value="Pesquisar"/> <a href="/projeto/controle?acao=CadastrarClienteForm"
			class="botao-cadastrar">Cadastrar</a>
	</form>



	<table>

		<tr>
			<th colspan="5">Informações do Cliente</th>
		</tr>

		<c:forEach items="${EntidadeDominio}" var="cliente">
			<tr>
				<td>

					<p>
						<b>Nome:</b> ${cliente.nome}
					</p>

					<p>
						<b>CPF:</b><b>${cliente.cpf}</b>
					</p>

					<p>
						<b>Gênero:</b> ${cliente.genero}
					</p> 
					
					<p>
						<b>Telefone:</b> ${cliente.telefone.numero}<!-- ${telefone.tipo}</p> -->
					<p>
					<a href="/projeto/controle?acao=EditarCliente&id=${cliente.id}"
					class="botao-editar">Editar</a> <a
					href="/projeto/controle?acao=RemoveCliente&id=${cliente.id}"
					class="botao-excluir">Excluir</a>

				</td>

				<td>
					<p>
						<b>Endereços:</b>
					</p>
					<c:forEach items="${cliente.endereco}" var="end">
						<p>${end.logradouro},
							${end.numero} <b>Cep:</b> ${end.cep}, <b>Cidade:</b>
							${end.cidade.nome} - ${end.cidade.estado.nome}
						</p>
						<b>Tipo Endereço:</b> ${end.tipoEndereco}
						<a href="/projeto/controle?acao=EditarEndereco&id=${end.id}"
					class="botao-editar">Editar</a>
					</c:forEach>
					
				</td>

				<td>
					<p>
						<b>Informaçoes de Login:</b>
					<p>
						<b>E-mail:</b> ${cliente.login.email}
					</p>
					<p>
						<b>Senha:</b> ${cliente.login.senha}
					</p>
				</td>

				<td>
					<p>
						<b>Informaçoes do Cartão:</b>
					<p>
						<b>Numero:</b> ${cliente.cartao.numero}
					</p>
					<p>
						<b>Nome Impresso:</b> ${cliente.cartao.nomeImpresso}
					</p>
				</td>

			</tr>

		</c:forEach>

	</table>
</html>



