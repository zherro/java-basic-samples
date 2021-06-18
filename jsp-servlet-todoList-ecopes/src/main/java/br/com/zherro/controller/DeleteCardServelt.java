package br.com.zherro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.zherro.model.TodoFactory;

public class DeleteCardServelt extends HttpServlet {

	 protected void doDelete(HttpServletRequest req, HttpServletResponse resp) 
			 throws ServletException, IOException {
		 
		 System.out.println(req.getParameter("id"));
		 
		final long id = Long.valueOf( req.getParameter("id") );
		
		HttpSession session = req.getSession(false);
		
		 TodoFactory.listCards( (String) session.getAttribute("todoKey") )
		 	.removeIf( c -> c.getId().equals(id));
		 
		 System.out.println("delete");
		 
		 // resp.setLocale( req.getContextPath() + "/");
	 }
}
