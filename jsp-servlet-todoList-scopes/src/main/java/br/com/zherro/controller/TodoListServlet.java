package br.com.zherro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.zherro.model.TodoFactory;

@WebServlet()
public class TodoListServlet extends HttpServlet{
	
	public TodoListServlet() {
		super();
		System.out.println("TodoListServlet constructor called!");
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("TodoListServlet intialized!");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String page = "/init.jsp";
		HttpSession session = req.getSession(false);
		
		if(session != null
				&& session.getAttribute("todoKey") != null
					&& !( (String) session.getAttribute("todoKey") ).trim().isEmpty() ) {
			

			String todoKey = (String) session.getAttribute("todoKey");
			
			List cards = TodoFactory.listCards( todoKey );
			
			req.setAttribute("cards", cards);
			page = "/index.jsp";
		}
		
		req.getRequestDispatcher(page).include(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 
		 System.out.println(req.getParameter("id"));
		 
		final long id = Long.valueOf( req.getParameter("id") );
		
		HttpSession session = req.getSession(false);
		
		 TodoFactory.listCards( (String) session.getAttribute("todoKey") )
		 	.removeIf( c -> c.getId().equals(id));
		 
		 System.out.println("delete");
		 
		 resp.sendRedirect( req.getContextPath() + "/");
	}
	
	
}
