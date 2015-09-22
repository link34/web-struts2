<%@page import="com.jdc.payroll.db.entity.Position"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Position</title>

<link href="/jsp-sample/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/jsp-sample/resources/css/common.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="/view/common/menu.jsp"></jsp:include>

	<div class="container">

		<div class="base-panel">
			<div class="page-header">
				<h1>Edit Position</h1>
			</div>

			<%
				Position p = (Position)request.getAttribute("position");
			%>

			<form class="form-horizontal" method="post" action="/jsp-sample/position-save">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Position Code</label>
					<div class="col-sm-10">
						<input type="date" class="form-control" id="inputEmail3" name="postion-code"
							placeholder="Position Code" disabled="disabled" value="<%=p.getPosition_cd() %>">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Description</label>
					<div class="col-sm-10">
						<textarea name="description" class="form-control" rows="4" cols="20"><%=p.getDescription() %></textarea>
					</div>
				</div>
		
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="reset" class="btn btn-default">Clear</button>
						<button type="submit" class="btn btn-primary">Save</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<script src="/jsp-sample/resources/js/jquery-2.1.3.min.js"></script>
	<script src="/jsp-sample/resources/js/bootstrap.min.js"></script>

</body>
</html>