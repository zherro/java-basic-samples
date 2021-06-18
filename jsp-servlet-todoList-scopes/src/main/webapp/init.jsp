<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  %>


<%@include file="templates/header.jsp"%>
<%@include file="templates/menu.jsp"%>

	<h1 class="text-center mt-5">Welcome to todo list App!</h1>
	
	<div class="d-flex justify-content-center mt-5" >
		<div>
			<span class="mr-3 fs-4"><%= request.getContextPath()  %>/ </span>
		</div>
		<div>
			<form method="post"  action="servletInit" class="d-flex">
				<input class="mx-3 form-control" type="text" id="todoKey" name="todoKey" >
				<button class="btn btn-secondary shadow" type="submit">GO!</button>
			</form>
		</div>
	</div>

<%@include file="templates/footer.html"%>
