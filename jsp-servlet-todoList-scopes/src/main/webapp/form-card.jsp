<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="templates/header.jsp"%>
<%@include file="templates/menu.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col">

				<form  method="post" action="<%= request.getContextPath() %>/sendCard">
				
					<div class="mb-3">
					    <label for="title" class="form-label">Title:</label>
					    <input type="text" class="form-control" id="title" name="title">
				  	</div>
				
					<div class="mb-3">
					    <label for="description" class="form-label">Description:</label>
					    <textarea  class="form-control" id="description" name="description"></textarea>
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