<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/imagens.css">
<link rel="stylesheet" href="./css/main.css">
<title>Guia de Cubos</title>
</head>
<body>
	<div class='top'>
		<div class='image'>
			<a href="index.jsp"><img src="./img/back.png" /></a>
		</div>
		<div class='image'>
			<a href="carrinho.jsp"><img src="./img/shop.png" /></a>
		</div>
	</div>
	<div class='titResultado'>
		<h2 class='titulo'>
			<img src="./img/blackCube.png" /> Cubos Recomendados
		</h2>
	</div>
	<form action="adicionar" method="POST" class="formres">
		<c:forEach items="${listaCubos}" var="c">
			<div class="img">
				<div class="nome">${c.nome}</div>
				<a target='_blank' href="">
					<img alt="${c.nome}" src='<c:url value="img/${c.imagem}.jpg"/>' width="210" height="210"/>
				</a>
				<div class='desc'>Tamanho: ${c.tamanho}</div>
				<div class='desc'>Dificuldade: ${c.dificuldade}</div>
				<div class='desc'>Tipo: ${c.tipo}</div>
				<div class='desc'>Preço: ${c.preco}</div>
				<div class='descQtd'>Quantidade: 
					<input type="number" class='descInput' name='${c.id}' value=""/>
				</div>
				<div><input class='descAdd' type='submit' value='Adicionar'/></div>
			</div>
		</c:forEach>
	</form>
</body>
</html>