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
</head>
<body>
<body>

	<form action="${linkController}" method="post">


		<h1>Editagem de endereco</h1>
		
		
			<fieldset>
				<legend>Endereço </legend><b>${end.tipoEndereco}</b>
				<div>
					<label for="pais">País:</label> <input type="text" id="pais"
						name="pais" placeholder="Digite o Pais" 
						required value="${end.cidade.estado.pais.nome}">
				</div>

				<div>
					<label for="estado">Estado:</label> <select id="estado"
						name="estado" required >
						<option value="${end.cidade.estado.nome}" >${end.cidade.estado.nome}</option>
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
						name="cidade" placeholder="Digite a cidade" 
						required value="${end.cidade.nome}">
				</div>

				<div>
					<label for="cep">CEP:</label> <input type="text" id="cep"
						name="cep" pattern="\d{5}-\d{3}" maxlength="9"
						placeholder="Digite o CEP (00000-000)" 
						required value="${end.cep}">
				</div>

				<div>
					<label for="logradouro">Logradouro:</label> <input type="text"
						id="logradouro" name="logradouro" placeholder="Digite o logradouro" 
						required value="${end.logradouro}">
				</div>
				
				<div>
					<label for="tipoLogradouro">Tipo Logradouro:</label> <input type="text" id="tipoLogradouro"
						name="tipoLogradouro" placeholder="Digite o tipo Logradouro" 
						required value="${end.tipoLogradouro}">
				</div>
				
				<div>
					<label for="tipoResidencia">Tipo Residencia:</label> <input type="text" id="tipoResidencia"
						name="tipoResidencia" placeholder="Digite o Tipo Residencia" 
						required value="${end.tipoResidencia}">
				</div>

				<div>
					<label for="numero">Número:</label> <input type="text" id="numero"
						name="numero" placeholder="Digite o número" 
						required value="${end.numero}">
				</div>

				<div>
					<label for="bairro">Bairro:</label> <input type="text" id="bairro"
						name="bairro" placeholder="Digite o bairro" 
						required value="${end.bairro}">
				</div>
				
			</fieldset>
			
		

		<br> 
		<input type="hidden" name="tipoEndereco" value="${end.tipoEndereco }"> 
		<input type="hidden" name="acao" value="AlterarEndereco"> 
		<input type="hidden" name="id" value="${end.id}"> 
		<input type="submit" /> 
		<a href="/projeto/controle?acao=ListarCliente"
			class="botao-pesquisar">Pesquisar Cliente</a>

	</form>

</body>
</html>