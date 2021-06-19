package br.com.zherro.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.zherro.domain.Card;
import br.com.zherro.model.TodoFactory;

public class PostCardServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Long id = req.getParameter("id") != null ? Long.valueOf(  req.getParameter("id")  ) : 0L ;
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		
		Card card = new Card();
		card.setTitle(title);
		card.setDescription(description);
		card.setDate( LocalDateTime.now() );

		HttpSession session = req.getSession(false);
		String todoKey = (String) session.getAttribute("todoKey");
		
		TodoFactory.addCard(todoKey, card );
		
		resp.sendRedirect(req.getContextPath() + "/");
	}
}
