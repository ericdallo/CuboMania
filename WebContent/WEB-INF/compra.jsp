<%@ page import="java.util.*"%>
<%@page import="com.cubomania.cubo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Compra Finalizada</title>
<link rel="stylesheet" href="./css/carrinho.css"/>
</head>
<body>
	<%
		out.println("<div class='principal'>");
			out.println("<h2>Compra Finalizada</h2>");

			TreeSet<Item> lista =(TreeSet<Item>) request.getSession().getAttribute("carrinho");
			
			if(lista == null)
				lista = new TreeSet<Item>();
			
			double precoTotal = 0.0;
			
			if(lista.size() != 0){
				
				out.println("<form action='alterar.do' method='POST'>");
				out.println("<table>");
					out.println("<tr class='titulo'>");
						out.println("<th>Nome do Produto</th>");
						out.println("<th>Quantidade</th>");
						out.println("<th>Preço</th>");
					out.println("</tr>");
			
					for(Item item : lista){
						Cubo cubo = item.getCubo();
						
						out.println("<tr class='itens'>");
							out.println("<td>" + cubo.getNome() + "</td>");
							out.println("<td>"+ item.getQuantidade() + "</td>");
							out.println("<td>" + cubo.getPreco() + "</td>");
						out.println("</tr>");
						precoTotal += item.getQuantidade()*cubo.getPreco();
						
					}
				out.println("</table>");
			
				 
			out.println("<h4> Quantidade de Itens : " + lista.size() + "</h4>");
			out.println("<h3> Preço Total : R$ "+ precoTotal + "</h3>");
			
			out.println("</div>");
			out.println("</form>");
			
		}else{
			out.println("<h1>Carrinho Vazio!</h1>");
			out.println("<a class='add' href='selecao.do'>Adicionar Itens</a>");
			out.println("</div>");
		}
		
		request.getSession().removeAttribute("total");
		request.getSession().removeAttribute("carrinho");
		
		%>
	
	<div class='image'><a href="selecao.do"><img src="./img/back.png"/></a></div>
</body>
</html>