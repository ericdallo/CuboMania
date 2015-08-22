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

@WebServlet("/alterar")
public class ChangeCart extends HttpServlet {
	
    private static final String DEL = "del";
	private static final long serialVersionUID = 1L;
    private static final int MENOS_LENGTH = 7;
    private static final int MAIS_LENGTH = 6;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher view;

        HttpSession session = req.getSession();
        List<Item> carrinho = (ArrayList<Item>) session.getAttribute("carrinho");

        Enumeration<String> param = req.getParameterNames();
        while(param.hasMoreElements()){
            String name = param.nextElement();
            
            if(name.indexOf("btMenos") == 0){
                boolean menos = req.getParameter(name) != null;
                if(menos){
                    CubeType tipo = new CubeType();
                    String substring = name.substring( MENOS_LENGTH,(name.length()) );
                    
                    tipo.diminuirQtd(carrinho,substring);
                    session.setAttribute("carrinho", carrinho);
                    
                    view = req.getRequestDispatcher("WEB-INF/carrinho.jsp");
                    view.forward(req, res);
                    return;
                }
            }else if(name.indexOf("btMais") == 0){
                boolean mais = req.getParameter(name) != null;
                if(mais){
                    String substring = name.substring( MAIS_LENGTH,(name.length()) );
                    CubeType tipo = new CubeType();
                    tipo.aumentarQtd(carrinho,substring);
                    
                    session.setAttribute("carrinho", carrinho);
                    
                    view = req.getRequestDispatcher("WEB-INF/carrinho.jsp");
                    view.forward(req, res);
                    return;
                }
            }
        }

        String acao = req.getParameter("acao");
        switch (acao){
            case "Esvaziar Carrinho":
                session.removeAttribute("carrinho");
                break;
            case "Remover Selecionados":
            	
                Enumeration<String> parametros = req.getParameterNames();
                while(parametros.hasMoreElements()){
                    String name = parametros.nextElement();
                    if(name.indexOf(DEL) == 0){
                        boolean toDelete = req.getParameter(name) != null;
                        if(toDelete){
                            CubeType tipo = new CubeType();
                            String substring = name.substring( 3,(name.length()) );
							tipo.alterar(carrinho,substring);
                        }


                    }
                }

                session.setAttribute("carrinho", carrinho);
                break;
            case "Finalizar Compra":
                view = req.getRequestDispatcher("WEB-INF/compra.jsp");
                view.forward(req, res);
                return;
        }
        view = req.getRequestDispatcher("WEB-INF/carrinho.jsp");
        view.forward(req, res);

    }

}
