package br.com.myquimica.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.myquimica.dao.AlunoDAO;

/**
 * Servlet implementation class AlunoServlet
 */
public class AlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LISTAR_ALUNOS = "/alunos.jsp";
	private AlunoDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlunoServlet() {
        super();
        dao = new AlunoDAO();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("listarAlunos")){
			forward = LISTAR_ALUNOS;
			request.setAttribute("alunos", dao.getAllAlunos());
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
