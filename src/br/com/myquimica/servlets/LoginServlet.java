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

import br.com.myquimica.database.ConexaoBD;
import br.com.myquimica.model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
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
		// por default chamarei a pagina index e passarei o parametro erro=1
		String pagina = "login.jsp?erro=1";	
				
		if(request.getParameter("acao").equals("login")) {
			//openshift
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			Usuario usuario = this.buscarUsuario(login);
			if(usuario != null){
				if(usuario.getLogin().equals(login) && (usuario.getSenha().equals(senha))){
					HttpSession sessao = request.getSession();
					sessao.setAttribute("login", request.getParameter("login"));
					pagina = "principal.jsp";
				}
			}
//			HttpSession sessao = request.getSession();
//			sessao.setAttribute("login", request.getParameter("login"));
//			pagina = "principal.jsp";
			
			
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

	private Usuario buscarUsuario(String login){
		Usuario usuario = null;
		try {
			//instancia classe de conexao
			ConexaoBD conexao = new ConexaoBD();
			//conecta no banco
			Connection connection = conexao.connect();

			//cria o statment e realiza a consulta
			Statement st = connection.createStatement();
			String sql = "SELECT * FROM usuario WHERE login LIKE '%" + login + "%';";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return usuario;
	}
	
	private void inserir(){
		try {
		    ConexaoBD conexao = new ConexaoBD();
		    Connection connection = conexao.connect();
		 

		    Statement st = connection.createStatement();
		    String sql = "INSERT INTO jogador (matJogador, nome) VALUES ('1111', 'diego')";
		    int res = st.executeUpdate(sql);
		 
		    if (res == 1) {
		        System.out.println("Cadastrado com sucesso!");
		    } else {
		        System.out.println("Falha no cadastro!");
		    }
		 
		    //fecha a conexao com o banco
		    connection.close();
		}
		catch(Exception e) {
		    System.out.println(e.toString());
		}
		 
	}

}
