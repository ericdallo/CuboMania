package com.cubomania.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cubomania.cubo.Item;
import com.cubomania.cubo.CubeType;

@WebServlet("/adicionar")
public class AddCube extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException ,IOException {
		
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession(); //para passar ao AlterarCarrinho
		
		ArrayList<Item> carrinho = (ArrayList<Item>) session.getAttribute("carrinho");
		if (carrinho == null)
			carrinho = new ArrayList<Item>();
		
		CubeType tipo = new CubeType();
		
		Enumeration<String> params = req.getParameterNames();
		while(params.hasMoreElements()) {
			String id = params.nextElement();
			
			int quantidade = 0;
			if(!req.getParameter(id).equalsIgnoreCase("")){
				quantidade = Integer.parseInt(req.getParameter(id));
			}
			if(quantidade > 0){
				tipo.adicionar(carrinho, id, quantidade);
			}
		}
		
		double precoTotal = 0.0;
		for (Item it : carrinho) {
			precoTotal += it.getCubo().getPreco() * it.getQuantidade();
		}
		
		session.setAttribute("total",precoTotal);
		session.setAttribute("carrinho", carrinho);
		
		RequestDispatcher view = req.getRequestDispatcher("WEB-INF/carrinho.jsp");
		view.forward(req, res);
	}

}