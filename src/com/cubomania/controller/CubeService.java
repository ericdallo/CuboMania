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
	private final static String IMAGES_URL = "http://ec2-52-24-4-97.us-west-2.compute.amazonaws.com:8080/CuboMania/img/";
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		res.setCharacterEncoding("utf-8");
		
		PrintWriter out = res.getWriter();
		JSONObject json = new JSONObject();
		
		CubeDAO cubeDAO = new CubeDAO();
		List<Cube> cubesList = cubeDAO.carregarAll();
		setImagesUrl(cubesList);
		
		try {
			json.put("cubes", cubesList);
			out.println(json);
		} catch (JSONException e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}
	}

	private void setImagesUrl(List<Cube> cubesList) {
		for (Cube cube : cubesList) {
			cube.setImagem(IMAGES_URL+cube.getImagem());
		}
	}

}
