<%@page import="com.jdc.payroll.db.entity.Leave"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leave Management</title>

<link href="/jsp-sample/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/jsp-sample/resources/css/common.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="/view/common/menu.jsp"></jsp:include>

	<div class="container col-md-offset-4 col-md-4">

		<div class="base-panel">
		
			<div class="page-header">
				<h1>Leave Management</h1>
			</div>


			<form class="form-horizontal jumbotron" method="post" action="/jsp-sample/leave-add">
		
				<div class="form-group">
					<label for="leave_type" class="col-sm-5 control-label">Leave Type</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" id="leave_type" name="leave_type"
							placeholder="Leave Type">
					</div>
				</div>
				<div class="form-group">
					<label for="leave_days" class="col-sm-5 control-label">Leave Days</label>
					<div class="col-sm-7">
						<input type="number" class="form-control" id="leave_days" name="leave_days"
							placeholder="Leave Days">
					</div>
				</div>
				<div class="form-group">
					<label for="description" class="col-sm-5 control-label">Description</label>
					<div class="col-sm-7">
						<textarea name="description" class="form-control" id="description" rows="4" cols="20"></textarea>
					</div>
				</div>
		
				<div class="form-group">
					<div class="col-sm-offset-5	 col-sm-7">
						<button type="reset" class="btn btn-default">Clear</button>
						<button type="submit" class="btn btn-primary">Save</button>
					</div>
				</div>
				
			</form>
			
		</div>
	</div>
			
			<hr/>
		<div class="col-md-offset-2 col-md-8">
			
			<%
				List<Leave> list = (List<Leave>)request.getAttribute("list");
				if(null != list) {
			%>
			
			<table class="table table-striped table-bordered">
				<tr>
					<th>Leave Type</th>
					<th>Leave Days</th>
					<th>Description</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				
				<% for(Leave l : list) { %>
				<tr>
					<td><%= l.getLeave_type() %></td>
					<td><%= l.getLeave_days() %></td>
					<td><%= l.getDescription() %></td>
					<td><a href="/jsp-sample/leave-edit?id=<%= l.getId() %>"><i class="glyphicon glyphicon-pencil"></i></a></td>
					<td><a href="/jsp-sample/leave-delete?id=<%= l.getId() %>"><i class="glyphicon glyphicon-trash"></i></a></td>
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

	<script src="/jsp-sample/resources/js/jquery-2.1.3.min.js"></script>
	<script src="/jsp-sample/resources/js/bootstrap.min.js"></script>

</body>
</html>