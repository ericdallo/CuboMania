<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Compra Finalizada</title>
<link rel="stylesheet" href="./css/carrinho.css" />
</head>
<body>
	<div class="principal">
		<h2>Compra Finalizada</h2>

		<form action='alterar' method='POST'>
			<table>
				<tr class='titulo'>
					<th>Nome do Produto</th>
					<th>Quantidade</th>
					<th>Preço</th>
				</tr>
				<c:forEach items="${carrinho}" var="item">
					<tr class='itens'>
						<td>${item.cubo.nome}</td>
						<td>${item.quantidade}</td>
						<td>${item.cubo.preco}</td>
					</tr>
				</c:forEach>
			</table>

			<h4>Quantidade de Itens: ${ fn:length(carrinho) }</h4>
			<h3>Preço Total: R$ ${total}</h3>

		</form>


	</div>

	<div class='image'>
		<a href="lista"><img src="./img/back.png" /></a>
	</div>
</body>
</html>
