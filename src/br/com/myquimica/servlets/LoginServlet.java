package br.com.myquimica.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.myquimica.dao.UsuarioDAO;
import br.com.myquimica.model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO dao;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		dao = new UsuarioDAO();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	/**
	 * Vai processar a validação do usuário e senha
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "login.jsp?erro=1";	
				
		if(request.getParameter("acao").equals("login")) {
			//openshift
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			Usuario usuario = dao.getUsuarioByLogin(login);
			if(usuario != null){
				if(usuario.getLogin().equals(login) && (usuario.getSenha().equals(senha))){
					HttpSession sessao = request.getSession();
					sessao.setAttribute("login", request.getParameter("login"));
					pagina = "principal.jsp";
				}
			}
			
			
			
		} else if(request.getParameter("acao").equals("logout")) {
			// no logout invalido a sessao
			HttpSession sessao = request.getSession();
			sessao.invalidate();
			// chamo novamente a pagina principal, que deve chamar a página index
			// que ira mostrar o formulario para o usuário logar
			pagina = "principal.jsp";
		}

		response.sendRedirect(pagina);

	}
	
}
