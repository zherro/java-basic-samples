package br.com.zherro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.zherro.model.TodoFactory;

public class ServletInit extends HttpServlet {

	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
		String todoKey = req.getParameter("todoKey");
		
		if(todoKey == null || todoKey.isEmpty()) {
			// TODO implemenar erro
		}
		
		HttpSession session = req.getSession(false);
		session.setAttribute("todoKey", todoKey);
		
		resp.sendRedirect(req.getContextPath() + "/");
	}
}
