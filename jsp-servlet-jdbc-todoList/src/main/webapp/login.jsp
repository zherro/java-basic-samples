<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

    <%@include file="templates/header.jsp" %>
	<%@include file="templates/menu.html %>

		<form post="actions/validateLogin.jsp" >
			<div>
				<label>Login:</label>
				<input type="text" id="login" name="login" >			
			</div>
			
			<div>
				<button type="submit">
					Login
				</button>
			</div>
		</form>
	
	<%@include file="templates/footer.html" %>