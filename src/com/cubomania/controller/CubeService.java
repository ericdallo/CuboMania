package com.cubomania.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.cubomania.cubo.Cube;
import com.cubomania.dao.CubeDAO;

@WebServlet("/lista.json")
public class CubeService extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		res.setCharacterEncoding("utf-8");
		
		PrintWriter out = res.getWriter();
		JSONObject json = new JSONObject();
		
		CubeDAO cubeDAO = new CubeDAO();
		List<Cube> cubesList = cubeDAO.carregarAll();
		
		try {
			json.put("cubes", cubesList);
			out.println(json);
		} catch (JSONException e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}
	}

}
