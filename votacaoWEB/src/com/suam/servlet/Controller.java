package com.suam.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int acao = Integer.parseInt(request.getParameter("acao"));
		
		switch (acao) {
		
		case 0:
			response.sendRedirect("Pagina Inicial.html");
			break;
			
		case 1:
			response.sendRedirect("index.html");
			break;
		
		case 2:
			response.sendRedirect("confirma.html");
			break;
			
		case 3:
			response.sendRedirect("relatorio.jsp");
			break;
			
		case 4:
			response.sendRedirect("jonh relatorio.jsp");
			break;
			
		case 5:
			response.sendRedirect("my relatorio.jsp");
			break;
			
		case 6:
			response.sendRedirect("nil relatorio.jsp");
			break;
			
		default:
			break;
		}
	}

}