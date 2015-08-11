package com.cubomania.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cubomania.cubo.Item;
import com.cubomania.cubo.TipoCubos;

/**
 * Servlet implementation class AlterarCaririnho
 */
@WebServlet("/alterar.do")
public class AlterarCarrinho extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarCarrinho() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**

     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**

     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher view;

        TreeSet<Item> carrinho = (TreeSet<Item>) request.getSession().getAttribute("carrinho");

        Enumeration<String> param = request.getParameterNames();
        while(param.hasMoreElements()){
            String name = param.nextElement();
            if(name.indexOf("btMenos") == 0){
                boolean menos = request.getParameter(name) != null;
                if(menos){
                    TipoCubos tip = new TipoCubos();

                    tip.diminuirQtd(carrinho,name.substring( 7,(name.length()) ));
                    session.setAttribute("carrinho", carrinho);
                    view = request.getRequestDispatcher("carrinho.jsp");
                    view.forward(request, response);
                    return;
                }
            }else if(name.indexOf("btMais") == 0){
                boolean mais = request.getParameter(name) != null;
                if(mais){
                    TipoCubos tip = new TipoCubos();
                    tip.aumentarQtd(carrinho,name.substring( 6,(name.length()) ));
                    session.setAttribute("carrinho", carrinho);
                    view = request.getRequestDispatcher("carrinho.jsp");
                    view.forward(request, response);
                    return;
                }
            }
        }

        String acao = request.getParameter("acao");
        switch (acao){
            case "Esvaziar Carrinho":
                session.removeAttribute("carrinho");
                break;
            case "Remover Selecionados":
                Enumeration<String> parametros = request.getParameterNames();
                while(parametros.hasMoreElements()){
                    String name = parametros.nextElement();
                    if(name.indexOf("del") == 0){
                        boolean todelete = request.getParameter(name) != null;
                        if(todelete){
                            TipoCubos tip = new TipoCubos();
                            tip.alterar(carrinho,name.substring( 3,(name.length()) ));
                        }


                    }
                }

                session.setAttribute("carrinho", carrinho);
                break;
            case "Finalizar Compra":
                view = request.getRequestDispatcher("compra.jsp");
                view.forward(request, response);
                return;
        }
        view = request.getRequestDispatcher("carrinho.jsp");
        view.forward(request, response);

    }

}
