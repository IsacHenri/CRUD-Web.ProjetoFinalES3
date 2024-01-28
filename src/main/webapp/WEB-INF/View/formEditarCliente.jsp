<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/controle" var="linkController" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editagem de Cliente</title>
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


		<h1>Editagem de cliente</h1>

		<fieldset>

			<legend>Dados do Cliente</legend>
			<div>
				<label for="nome">Nome do cliente:*</label> <input type="text"
					id="nome" name="nome" placeholder="Digite o nome do cliente"
					required value="${cliente.nome}">
			</div>

			<div>
				<label for="cpf">CPF:</label> <input type="text" id="cpf" name="cpf"
					placeholder="Digite o cpf" required value="${cliente.cpf}">
			</div>

			<div>
				<label for="genero">Genêro:</label> <input type="text" id="genero"
					name="genero" placeholder="Digite o genero" required
					value="${cliente.genero}">
			</div>

			<div>
				<label for="senha">Senha:</label> <input type="password" id="senha"
					name="senha" placeholder="Digite a senha" required
					value="${cliente.login.senha}">
			</div>
			<p id="mensagemErro" style="color: red;"></p>
			
			<div>
				<label for="confirmaSenha">Confirmação Senha:</label> <input type="password" id="confirmaSenha"
					name="confirmaSenha" placeholder="Digite a senha novamente" required>
			</div>
			

		</fieldset>


		<br>
		
		<input type="hidden" name="acao" value="AlterarCliente"> 
		<input type="hidden" name="idCliente" value="${cliente.id}"> 
		<input type="submit" /> 
		<a href="/projeto/controle?acao=ListarCliente"
			class="botao-pesquisar">Pesquisar Cliente</a>

	</form>

</body>
</html>