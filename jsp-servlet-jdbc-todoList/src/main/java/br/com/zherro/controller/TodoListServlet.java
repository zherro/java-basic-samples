package br.com.zherro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		List cards = TodoFactory.listCards();
		
		req.setAttribute("cards", cards);
		
		req.getRequestDispatcher("/index.jsp").include(req, resp);
	}
}
