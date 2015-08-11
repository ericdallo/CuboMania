package com.cubomania.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cubomania.cubo.Cubo;
import com.cubomania.cubo.TipoCubos;

@WebServlet("/lista")
public class CubosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		TipoCubos tipos = new TipoCubos();
		List<Cubo> lista = tipos.todos();
		
		req.setAttribute("listaCubos", lista);
		
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/resultado.jsp");
		rd.forward(req, res);

	}
}