<%@page import="com.jdc.payroll.db.entity.Position"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Request Information</title>
<link href="/jsp-sample/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/jsp-sample/resources/css/common.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="/view/common/menu.jsp"></jsp:include>
	<div class="container">

		<div class="base-panel">
			<div class="page-header">
				<h1>Request Information</h1>
			</div>
			<form class="form-horizontal" method="post"
				action="/jsp-sample/position-add">
				<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Request Name</label>					
					<div class="col-sm-10">
					<input type="text" class="form-control" id="inputEmail3"
							name="name" placeholder="Request Name">
				</div>	
				</div>
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Request Type
					</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							name="type" placeholder="Request Type">
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="reset" class="btn btn-default">Clear</button>
						<button type="submit" class="btn btn-primary">Save</button>
					</div>
				</div>
			</form>
			<hr/>
			
			<%
				List<Request> list = (List<Request>)request.getAttribute("list");
				if(null != list) {
			%>
			
			<table class="table table-striped">
				<tr>
					<th>Position Code</th>
					<th>Description</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				
				<% for(Position p : list) { %>
				<tr>
					<td><%= p.getPosition_cd() %></td>
					<td><%= p.getDescription() %></td>
					<td><a href="#"><i class="glyphicon glyphicon-pencil"></i></a></td>
					<td><a href="#"><i class="glyphicon glyphicon-trash"></i></a></td>
				</tr>
				
				<% } %>

			</table>
			
			<%
				} else {
			%>
				No data
			<%
				}
			%>
		</div>

	</div>
			
		
	<script src="/jsp-sample/resources/js/jquery-2.1.3.min.js"></script>
	<script src="/jsp-sample/resources/js/bootstrap.min.js"></script>
</body>
</html>