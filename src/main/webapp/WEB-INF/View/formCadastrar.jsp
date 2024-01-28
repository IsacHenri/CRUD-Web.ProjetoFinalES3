<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/controle" var="linkController" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Cliente</title>
</head>
<style>
form {
    max-width: 600px;
    margin: 0 auto;
    padding: 30px;
    border: 2px solid #000;
    border-radius: 10px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    font-family: 'Arial', sans-serif;
}

h1 {
	text-align: center;
}

input[type="text"], select {
	display: block;
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
	font-size: 16px;
}

div {
    margin-bottom: 20px;
}
input[type="password"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
    font-size: 16px;
    margin-bottom: 10px; 
}

input[type="password"]:focus {
    border-color: #007bff; 
    box-shadow: 0 0 5px rgba(0, 123, 255, 0.7); 
}

#confirmaSenha {
    border-color: #6c757d; 
}

input[type="date"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
    font-size: 16px;
}

input[type="date"]:focus {
    border-color: #007bff; 
    box-shadow: 0 0 5px rgba(0, 123, 255, 0.7);
}

label {
	display: block;
	font-weight: bold;
	margin-bottom: 10px;
}

select {
	height: 40px;
}

input[type="submit"] {
    display: block;
    margin: 20px auto 0;
    padding: 10px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
    text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.5); 
}

.botao-pesquisar {
	background-color: #ffA500;
	color: white;
	padding: 8px 16px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 10px;
	text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.5);
}
</style>
<script>
    function validarSenha() {
    	var senha = document.getElementById("senha").value;
        var confirmaSenha = document.getElementById("confirmaSenha").value;
        var mensagemErro = document.getElementById("mensagemErro");

        // Verificar se a senha e a confirmação de senha correspondem
        if (senha !== confirmaSenha) {
            mensagemErro.textContent = "A senha e a confirmação de senha não correspondem. Por favor, tente novamente.";
            return false;
        }

        // Verificar se a senha atende aos requisitos
        if (senha.length < 8 || !/[a-z]/.test(senha) || !/[A-Z]/.test(senha) || !/[!@#$%^&*(),.?":{}|<>]/.test(senha)) {
            mensagemErro.textContent = "A senha deve ter pelo menos 8 caracteres, incluindo letras maiúsculas, minúsculas e caracteres especiais.";
            return false;
        }

        // Limpar mensagem de erro
        mensagemErro.textContent = "";
        return true;
    }
</script>
</head>
<body>
<body>

	<form action="${linkController}" method="post" onsubmit="return validarSenha();">


		<h1>Cadastro de cliente</h1>
		
		<fieldset>
			<legend>Dados do Cliente</legend>
			<div>
				<label for="nome">Nome do cliente:*</label> <input type="text"
					id="nome" name="nome" placeholder="Digite o nome do cliente"
					required>
			</div>
			
			<div>
				<label for="cpf">CPF:</label> <input type="text" id="cpf" name="cpf"
					placeholder="Digite a cidade" required>
			</div>
			
			<div>
				<label for="genero">Genêro:</label> <input type="text" id="genero"
					name="genero" placeholder="Digite o genero" required>
			</div>
			
			<div>
				<label for="dataNasc">Data Nascimento:</label> <input type="date"
					id="dataNasc" name="dataNasc"
					placeholder="Digite a Data de nascimento" required>
			</div>
		</fieldset>
		
		
		<br>
		
		
		<fieldset>
		<legend>Login:</legend>
			<div>
				<label for="email">Email:</label> <input type="text" id="email"
					name="email" placeholder="Digite o email" required>
			</div>
			<div>
				<label for="senha">Senha:</label> <input type="password" id="senha"
					name="senha" placeholder="Digite a senha" required>
			</div>
			<div>
				<label for="senha">Confirmação Senha:</label> <input type="password" id="confirmaSenha"
					name="confirmaSenha" placeholder="Digite a senha novamente" required>
			</div>
		</fieldset>
		
		
		<br>


		<fieldset>
			<legend>Endereço</legend>
			<div>
				<label for="pais">País:</label> <input type="text" id="pais"
					name="pais" placeholder="Digite o Pais" required>
			</div>
			
			<div>
				<label for="estado">Estado:</label> <select id="estado"
					name="estado" required>
					<option value="" disabled selected>Selecione um estado</option>
					<option value="AC">AC</option>
					<option value="AL">AL</option>
					<option value="AP">AP</option>
					<option value="AM">AM</option>
					<option value="BA">BA</option>
					<option value="CE">CE</option>
					<option value="DF">DF</option>
					<option value="ES">ES</option>
					<option value="GO">GO</option>
					<option value="MA">MA</option>
					<option value="MT">MT</option>
					<option value="MS">MS</option>
					<option value="MG">MG</option>
					<option value="PA">PA</option>
					<option value="PB">PB</option>
					<option value="PR">PR</option>
					<option value="PE">PE</option>
					<option value="PI">PI</option>
					<option value="RJ">RJ</option>
					<option value="RN">RN</option>
					<option value="RS">RS</option>
					<option value="RO">RO</option>
					<option value="RR">RR</option>
					<option value="SC">SC</option>
					<option value="SP">SP</option>
					<option value="SE">SE</option>
					<option value="TO">TO</option>
				</select>
			</div>


			<div>
				<label for="cidade">Cidade:</label> <input type="text" id="cidade"
					name="cidade" placeholder="Digite a cidade" required>
			</div>

			<div>
				<label for="cep">CEP:</label> <input type="text" id="cep" name="cep"
					pattern="\d{5}-\d{3}" maxlength="9"
					placeholder="Digite o CEP (00000-000)" required>
			</div>
			
			<div>
				<label for="tipoResidencia">Tipo Residencia:</label> <input type="text"
					id="tipoResidencia" name="tipoResidencia" placeholder="Digite o tipo de residencia"
					required>
			</div>

			<div>
				<label for="tipoLogradouro">Tipo Logradouro:</label> <input type="text"
					id="tipoLogradouro" name="tipoLogradouro" placeholder="Digite o tipo logradouro"
					required>
			</div>
			
			<div>
				<label for="logradouro">Logradouro:</label> <input type="text"
					id="logradouro" name="logradouro" placeholder="Digite o logradouro"
					required>
			</div>

			<div>
				<label for="numero">Número:</label> <input type="text" id="numero"
					name="numero" placeholder="Digite o número" required>
			</div>

			<div>
				<label for="complemento">Complemento:</label> <input type="text"
					id="complemento" name="complemento"
					placeholder="Digite o complemento">
			</div>
			
			<div>
				<label for="bairro">Bairro:</label> <input type="text" id="bairro"
					name="bairro" placeholder="Digite o bairro">
			</div>
			
		</fieldset>


		<br>
		
		
		<fieldset>
		
			<legend>Endereço Cobrança</legend>
			<div>
				<label for="paisCobranca">País:</label> <input type="text"
					id="paisCobranca" name="paisCobranca" placeholder="Digite o Pais"
					required>
			</div>
			
			<div>
				<label for="estadoCobranca">Estado:</label> <select
					id="estadoCobranca" name="estadoCobranca" required>
					<option value="" disabled selected>Selecione um estado</option>
					<option value="AC">AC</option>
					<option value="AL">AL</option>
					<option value="AP">AP</option>
					<option value="AM">AM</option>
					<option value="BA">BA</option>
					<option value="CE">CE</option>
					<option value="DF">DF</option>
					<option value="ES">ES</option>
					<option value="GO">GO</option>
					<option value="MA">MA</option>
					<option value="MT">MT</option>
					<option value="MS">MS</option>
					<option value="MG">MG</option>
					<option value="PA">PA</option>
					<option value="PB">PB</option>
					<option value="PR">PR</option>
					<option value="PE">PE</option>
					<option value="PI">PI</option>
					<option value="RJ">RJ</option>
					<option value="RN">RN</option>
					<option value="RS">RS</option>
					<option value="RO">RO</option>
					<option value="RR">RR</option>
					<option value="SC">SC</option>
					<option value="SP">SP</option>
					<option value="SE">SE</option>
					<option value="TO">TO</option>
				</select>
			</div>

			<div>
				<label for="cidadeCobranca">Cidade:</label> <input type="text"
					id="cidadeCobranca" name="cidadeCobranca"
					placeholder="Digite a cidade" required>
			</div>

			<div>
				<label for="cepCobranca">CEP:</label> <input type="text"
					id="cepCobranca" name="cepCobranca" pattern="\d{5}-\d{3}"
					maxlength="9" placeholder="Digite o CEP (00000-000)" required>
			</div>
			
			<div>
				<label for="tipoResidenciaCobranca">Tipo Residencia:</label> <input type="text"
					id="tipoResidenciaCobranca" name="tipoResidenciaCobranca" placeholder="Digite o tipo de residencia"
					required>
			</div>

			<div>
				<label for="tipoLogradouroCobranca">Tipo Logradouro:</label> <input type="text"
					id="tipoLogradouroCobranca" name="tipoLogradouroCobranca" placeholder="Digite o tipo logradouro"
					required>
			</div>

			<div>
				<label for="logradouroCobranca">Logradouro:</label> <input
					type="text" id="logradouroCobranca" name="logradouroCobranca"
					placeholder="Digite o logradouro" required>
			</div>

			<div>
				<label for="numeroCobranca">Número:</label> <input type="text"
					id="numeroCobranca" name="numeroCobranca"
					placeholder="Digite o número" required>
			</div>

			<div>
				<label for="complementoCobranca">Complemento:</label> <input
					type="text" id="complementoCobranca" name="complementoCobranca"
					placeholder="Digite o complemento">	
			</div>
			
			<div>
				<label for="bairroCobranca">Bairro:</label> <input type="text"
					id="bairroCobranca" name="bairroCobranca"
					placeholder="Digite o bairro">
			</div>
			
		</fieldset>


		<br>


		<fieldset>
		
			<legend>Telefone</legend>
			<div>
				<input type="text" id="telefone" name="telefone"
					placeholder="Digite um número de telefone (00 0000-0000)"
					pattern="\d{2} \d{4,5}-\d{4}" maxlength="15">
			</div>
			
		</fieldset>


		<br>


		<fieldset>
		
			<legend>Cartão: </legend>
			<div>
				<label for="c">Bandeira:</label> <select id="bandeira"
					name="bandeira" required>
					<option value="" disabled selected>Selecione uma bandeira</option>
					<option value="Visa">Visa</option>
					<option value="MasterCard">MasterCard</option>
					<option value="Elo">Elo</option>
				</select>
			</div>
			
			<legend>Numero:</legend>
			<div>
				<input type="text" id="numero" name="numero"
					placeholder="Digite um número">
			</div>
			
			<legend>Nome Impresso:</legend>
			<div>
				<input type="text" id="nomeImpresso" name="nomeImpresso"
					placeholder="Digite o nome impresso">
			</div>
			
			<legend>Codigo:</legend>
			<div>
				<input type="text" id="codigo" name="codigo"
					placeholder="Digite o codigo">
			</div>
			
		</fieldset>
		
		<br> <input type="hidden" name="acao" value="SalvarCliente">
		<input type="submit" /> 
		
		<!-- Mensagem de erro caso a senha não esteja passando nos testes -->
		<p id="mensagemErro" style="color: red;"></p>
		
		<a href="/projeto/controle?acao=ListarCliente" 
			class="botao-pesquisar">Pesquisar Cliente</a>
		
	</form>

</body>
</html>