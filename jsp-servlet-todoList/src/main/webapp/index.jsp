<%@page import="java.util.List"%>
<%@page import="br.com.zherro.domain.Card"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="templates/header.jsp"%>
<%@include file="templates/menu.html"%>

<div class="container">
	<div class="row">
		<div class="col-12">		
			<div class="card mt-5">
				<div class="card-body">
					<h2>
						<a href="<%= request.getContextPath() %>/form-card.jsp"  class="">Add New Card</a>
					</h2>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<%
			List<Card> cards = (List) request.getAttribute("cards");
		
			for(Card card : cards) {
		%>
			<div class="col-sm-12 col-md-3 py-3" >
				<div class="card">
					<div class="card-body">
						<h5 class="card-title"><%= card.getTitle() %></h5>
						<p class="card-text"><%= card.getDescription() %></p>
						<div class="d-flex">
							<a  href="<%= request.getContextPath() + "/editCard.jsp?id=" + card.getId()  %>" class="btn btn-primary w-50 rounded-0">Edit</a>
							<a onclick="deletePost(<%= card.getId() %>)" href="#" class="btn btn-danger w-50 rounded-0">Delete</a>
						</div>
					</div>
				</div>
			</div>	
		<%
			}
		%>
		
	</div>


</div>

	<script type="text/javascript">
	
	 const deletePost = (id) => {
		 console.log('teste');
		 $.ajax({
	         url: <%= '"' + "http://" + request.getRemoteHost() + ":" + request.getLocalPort() + request.getContextPath() + '"' %> + "/deleteCard?id=" + id,
	         type: 'DELETE',
	         success: () => { window.location.reload(); },
	         error: () => {}
	     });
	 }

	</script>

<%@include file="templates/footer.html"%>



