<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Carrinho</title>
<link rel="stylesheet" href="./css/carrinho.css" />
</head>
<body>
	<div class='principal'>
		<h2>Carrinho de Compras</h2>
		<c:if test="${empty carrinho}">
			<h1>Carrinho Vazio!</h1>
			<a class='add' href='lista'>Adicionar Itens</a>
		</c:if>
		<c:if test="${not empty carrinho}">
		<form action="alterar" method="POST">
			<table>
				<tr class='titulo'>
					<th>Nome do Produto</th>
					<th>Quantidade</th>
					<th>Preço</th>
					<th>X</th>
				</tr>
				
				<c:forEach items="${carrinho}" var="it">
					<tr class='itens'>
						<td>${it.cubo.nome}</td>
						<td>
							<input type='submit' class='bt' name='btMenos${it.cubo.id}' value='-'/>
							${it.quantidade}
							<input type='submit' class='bt' name='btMais${it.cubo.id}' value='+'/>
						</td>
						<td> ${it.cubo.preco * it.quantidade}</td>
						<td><input type='checkbox' name='del${it.cubo.id}'/></td>
					</tr>
						
				</c:forEach>
			</table>
			
			<h4>Quantidade de Itens: ${ fn:length(carrinho) }</h4>
			<h3>Preço Total: R$ ${total}</h3>
			
			<input type="submit" class='add' name='acao' value="Esvaziar Carrinho"/>
			<input type="submit" class='add' name='acao' value="Remover Selecionados"/>
			<div class='fin'>
				<input type='submit' class='finalizar' name='acao' value='Finalizar Compra' />
			</div>
			
		</form>
		</c:if>

	</div>
	<div class='image'>
		<a href="lista"><img src="./img/back.png" /></a>
	</div>
</body>
</html>