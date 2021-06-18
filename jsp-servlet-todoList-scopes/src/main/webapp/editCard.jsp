<%@page import="br.com.zherro.model.TodoFactory"%>
<%@page import="br.com.zherro.domain.Card"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="templates/header.jsp"%>
<%@include file="templates/menu.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col">
			
				<%
					
					Card card = TodoFactory.getById( (String) session.getAttribute("todoKey"),   Long.valueOf( request.getParameter("id") ) );
				
				%>

				<form  method="post" action="<%= request.getContextPath() %>/sendCard">
				
					<div class="mb-3">
					    <label for="title" class="form-label">Title:</label>
					    <input type="text" class="form-control" id="title" name="title" value="<%= card.getTitle() %>" />
				  	</div>
				  	
				  	<input type="hidden" value="<%= card.getId() %>"  id="id" name="id" />
				
					<div class="mb-3">
					    <label for="description" class="form-label">Description:</label>
					    <textarea
					    	class="form-control"
					    	id="description"
					    	name="description"
					    ><%= card.getDescription() %></textarea>
				  	</div>
		 
					<div>
						<button type="submit" class="btn btn-primary">
							Submit
						</button>
					</div>
					
				</form>	
		
			</div> 
		</div>				
	</div>
		
<%@include file="templates/footer.html"%> 