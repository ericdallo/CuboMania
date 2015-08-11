package com.cubomania.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cubomania.cubo.Item;
import com.cubomania.cubo.TipoCubos;

@WebServlet("/adicionar")
public class AdicionarCubo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException ,IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		
		List<Item> carrinho = (ArrayList<Item>) req.getAttribute("carrinho");
		if (carrinho == null)
			carrinho = new ArrayList<Item>();
		
		TipoCubos tipo = new TipoCubos();
		
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
		
		req.setAttribute("total",precoTotal);
		req.setAttribute("carrinho", carrinho);
		
		RequestDispatcher view = req.getRequestDispatcher("WEB-INF/carrinho.jsp");
		view.forward(req, res);
	}

}