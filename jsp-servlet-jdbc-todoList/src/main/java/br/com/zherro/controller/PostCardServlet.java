package br.com.zherro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zherro.domain.Card;
import br.com.zherro.model.TodoFactory;

public class PostCardServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String title = req.getParameter("title");
		String description = req.getParameter("title");
		String date = req.getParameter("date");
		
		Card card = new Card();
		
		int max = Integer.MAX_VALUE;
		int min = 100;
		long id = (long)Math.floor(Math.random()*(max-min+1)+min);
		
		card.setId(id);
		card.setTitle(title);
		
		TodoFactory.cards.add(card);
		
		resp.sendRedirect(req.getContextPath() + "/");
	}
}
