package com.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.bean.Eleitor;
import com.web.bean.User;
import com.web.service.EleitorService;

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
		
		if(acao.equals("inicio_eleitor")) {
			//chama user> do user chamar eleitor
			String titulo = request.getParameter("titulo");
			User eleitor = new User(titulo);
			if(eleitor.autenticouEleitor()) {
				request.getSession().setMaxInactiveInterval(300);
				request.setAttribute("usuario", eleitor.getEleitor());
				request.getRequestDispatcher("urna.jsp").forward(request, response);
			}else {
				request.setAttribute("erro", "1");
				request.getRequestDispatcher("inicio.jsp").forward(request, response);
			}
			
		} else if(acao.equals("inicio_mesario")) {
			String titulo = request.getParameter("titulo");
			String senha = request.getParameter("senha");
			User mesario = new User(titulo, senha);
			if(mesario.autenticouMesario()) {
				request.setAttribute("usuario", mesario.getEleitor());
				request.getRequestDispatcher("mesario.jsp").forward(request, response);
			}else {
				request.setAttribute("erro", "2");
				request.getRequestDispatcher("inicio.jsp").forward(request, response);
			}
			
		} else if(acao.equals("liberar_eleitor")) {
			String titulo = request.getParameter("titulo");
			User usuario = new User();
			Eleitor modEleitor = new Eleitor();
			usuario = (User) request.getAttribute("usuario");
			if(usuario.autenticouEleitorLiberar(titulo)) {
				modEleitor = usuario.getEleitor();
				modEleitor.setStatus("aguardando");
			}else {
				
			}
			request.getRequestDispatcher("mesario.jsp").forward(request, response);
		} else if(acao.equals("liberar_cabine")) {
			request.getRequestDispatcher("mesario.jsp").forward(request, response);
		} else if(acao.equals("encerrar_cabine")) {
			request.getRequestDispatcher("mesario.jsp").forward(request, response);
		} else if(acao.equals("rel")) {
			request.getRequestDispatcher("relatorio.jsp").forward(request, response);
		} else if(acao.equals("voto_val")) {
			String idCandidato = request.getParameter("");
			request.getRequestDispatcher("fim.jsp").forward(request, response);
		}
	}

}
