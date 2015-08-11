<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guia de Cubos Mágicos</title>
<link rel="stylesheet" href="./css/main.css" />
<link rel="stylesheet" href="./css/imagens.css" />
</head>
<body>

	<div class='tit'>
		
		<h2 class='titulo'><img src="./img/blackCube.png"/> CuboMania</h2>
	</div>
	<form method="post" action="<c:url value='lista' />" class='formSelect'>
		<h3>Selecione uma ou mais caracteristicas dos cubos</h3>
		<fieldset>
			<div>
				<label>Tamanho:</label> <select name="tamanho" size="1">
					<option value=""></option>
					<option value="2">2 camadas</option>
					<option value="3">3 camadas</option>
					<option value="4">4 camadas</option>
					<option value="5">5 camadas</option>
					<option value="7">7 camadas</option>
				</select>
			</div>
			<div>
				<label>Tipo:</label> <select name="tipo" size="1">
					<option value=""></option>
					<option value="normal">normal</option>
					<option value="personalizado">personalizado</option>
				</select>
			</div>
			<div>
				<label>Dificuldade:</label> <select name="dificuldade" size="1">
					<option value=""></option>
					<option value="facil">facil</option>
					<option value="medio">medio</option>
					<option value="dificil">dificil</option>
				</select>
			</div>
		</fieldset>
		<div>
			<input type="submit" value="Enviar">
		</div>
	</form>
</body>
</html>