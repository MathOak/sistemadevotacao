package com.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.bean.Candidato;
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
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(300);
				session.setAttribute("user", eleitor);
				request.getRequestDispatcher("urna.jsp").forward(request, response);
			}else {
				/*request.setAttribute("erro1", "Eleitor não autenticado");
				  RequestDispatcher rd = request.getRequestDispatcher("/inicio.jsp");
				  rd.forward(request, response);*/
				request.setAttribute("erro", "1");
				request.getRequestDispatcher("inicio.jsp").forward(request, response);
			}
			
		//---------------------------------------------------------
		} else if(acao.equals("inicio_mesario")) {
			String titulo = request.getParameter("titulo");
			String senha = request.getParameter("senha");
			User mesario = new User(titulo, senha);
			if(mesario.autenticouMesario(mesario.getTitulo(), mesario.getSenha())) {
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(600);
				session.setAttribute("user", mesario);
				request.setAttribute("list", mesario.getConsulta(titulo));
				session.setAttribute("texto", "bacon");
				request.getRequestDispatcher("mesario.jsp").forward(request, response);
			}else {
				request.setAttribute("erro", "2");
				request.getRequestDispatcher("inicio.jsp").forward(request, response);
			}
			
		//------------------------------------------------------
		} else if(acao.equals("liberar_eleitor")) {
			String titulo = request.getParameter("titulo");
			User usuario = new User();
			Eleitor modEleitor = new Eleitor();
			usuario = (User) request.getSession().getAttribute("user");
			if(usuario.autenticouEleitorLiberar(titulo)) {//mudar para variavel de sessão ou checar por que ta errado
				modEleitor = usuario.getEleitor();
				request.setAttribute("banco", usuario.getEleitor().getStatus());
				request.setAttribute("servlet", modEleitor.getStatus());
				modEleitor.setStatus("aguardando");
				usuario.salvarEleitor(modEleitor);
				request.setAttribute("retorno", "Eleitor Liberado");
				request.getRequestDispatcher("mesario.jsp").forward(request, response);
			
			}else {
				request.setAttribute("erro", "3");
				request.getRequestDispatcher("mesario.jsp").forward(request, response);
			}
			//request.getRequestDispatcher("mesario.jsp").forward(request, response);
		
		//------------------------------------------------------
		} else if(acao.equals("liberar_cabine")) {
			User usuario = new User();
			usuario = (User) request.getSession().getAttribute("user");
			request.getRequestDispatcher("mesario.jsp").forward(request, response);
		
		//------------------------------------------------------
		} else if(acao.equals("encerrar_cabine")) {
			User usuario = new User();
			usuario = (User) request.getSession().getAttribute("user");
			request.getRequestDispatcher("mesario.jsp").forward(request, response);
		
		//------------------------------------------------------
		} else if(acao.equals("rel")) {
			User usuario = new User();
			usuario = (User) request.getSession().getAttribute("user");
			if(usuario.autenticouCandidatoRel("11")) 
				request.setAttribute("candidato11", usuario.getCandidato());
			if(usuario.autenticouCandidatoRel("22"))
				request.setAttribute("candidato22", usuario.getCandidato());
			if(usuario.autenticouCandidatoRel("33"))
				request.setAttribute("candidato33", usuario.getCandidato());
			if(usuario.autenticouCandidatoRel("44"))
				request.setAttribute("candidato44", usuario.getCandidato());
			if(usuario.autenticouCandidatoRel("55"))
				request.setAttribute("candidato55", usuario.getCandidato());
			request.getRequestDispatcher("relatorio.jsp").forward(request, response);
		
		//------------------------------------------------------
		} else if(acao.equals("voto_val")) {
			User usuario = new User();
			Candidato cand = new Candidato();
			Eleitor lei = new Eleitor();
			usuario = (User) request.getSession().getAttribute("user");
			String idCandidato = request.getParameter("candidato");
			if(idCandidato.equals("NULO")) {
				request.getRequestDispatcher("fim.jsp").forward(request, response);
			}else {
				if(usuario.autenticouCandidatoRel(idCandidato)) {
					cand = usuario.getCandidato();
					cand.setVotos(cand.getVotos()+1);
					usuario.salvarCandidato(cand);
					System.out.println(usuario.getTitulo());
					if(usuario.autenticouEleitorLiberar(usuario.getTitulo())) {
						lei = usuario.getEleitor();
						System.out.println(lei.getNome_eleitor());
						lei.setStatus("votou");
						usuario.salvarEleitor(lei);
					}
				}
			}
			request.getRequestDispatcher("fim.jsp").forward(request, response);
		}
	}

}
