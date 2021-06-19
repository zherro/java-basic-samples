<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="navbar navbar-light bg-light">
	<div class="container">
		<span class="navbar-brand mb-0 h1">JSP & JDBC sample</span>

		<div class="d-flex">

			<div class="nav">
				<a class="nav-link active" aria-current="page" href="servlet-todolist/">Home</a>
				 <a
					class="nav-link" href="#">Features</a> 
					<a class="nav-link" href="#">Pricing</a>
			</div>
		</div>
	</div>
</nav>
<div class="container">
	<div class="row" >
		<div class="col">			
			<% 
				if ( session.getAttribute("todoKey") != null ) {
				
			%>
				<div class="btn btn-dark float-end my-3" ><%= session.getAttribute("todoKey") %></div>
			<% 
				}
			%>			
		</div>
	</div>
</div>