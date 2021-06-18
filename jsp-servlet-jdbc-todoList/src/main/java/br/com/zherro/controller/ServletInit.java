package br.com.zherro.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import br.com.zherro.model.TodoFactory;

public class ServletInit extends HttpServlet {

	@Override
	public void init() throws ServletException {
		super.init();
		TodoFactory.createCards();
	}
}
