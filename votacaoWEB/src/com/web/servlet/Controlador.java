package com.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acao = request.getParameter("acao");
		
		if(acao.contentEquals("inicio_eleitor")) {
			request.getRequestDispatcher("urna.jsp").forward(request, response);
		} else if(acao.contentEquals("inicio_mesario")) {
			request.getRequestDispatcher("mesario.jsp").forward(request, response);
		} else if(acao.contentEquals("liberar_eleitor")) {
			request.getRequestDispatcher("mesario.jsp").forward(request, response);
		} else if(acao.contentEquals("liberar_cabine")) {
			request.getRequestDispatcher("mesario.jsp").forward(request, response);
		} else if(acao.contentEquals("encerrar_cabine")) {
			request.getRequestDispatcher("mesario.jsp").forward(request, response);
		} else if(acao.contentEquals("rel")) {
			request.getRequestDispatcher("relatorio.jsp").forward(request, response);
		} else if(acao.contentEquals("voto_val")) {
			request.getRequestDispatcher("fim.jsp").forward(request, response);
		}
	}

}
