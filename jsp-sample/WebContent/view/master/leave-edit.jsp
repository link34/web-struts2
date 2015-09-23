<%@page import="com.jdc.payroll.db.entity.Leave"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Leave</title>

<link href="/jsp-sample/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/jsp-sample/resources/css/common.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="/view/common/menu.jsp"></jsp:include>

	<div class="container col-md-offset-4 col-md-4">

		<div class="base-panel">

			<div class="page-header">
				<h1>Edit Leave</h1>
			</div>

			<%
				Leave l = (Leave) request.getAttribute("leave");
			%>

			<form class="form-horizontal jumbotron" method="post"
				action="/jsp-sample/leave-save">

				<input type="hidden" name="postion-code" value="<%=l.getId()%>>" />

				<div class="form-group">
					<label for="leave_type" class="col-sm-5 control-label">Leave
						Type</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" id="leave_type"
							name="leave_type" placeholder="Leave Type"
							value="<%=l.getLeave_type()%>">
					</div>
				</div>
				<div class="form-group">
					<label for="leave_days" class="col-sm-5 control-label">Leave
						Days</label>
					<div class="col-sm-7">
						<input type="number" class="form-control" id="leave_days"
							name="leave_days" placeholder="Leave Days"
							value="<%=l.getLeave_days()%>">
					</div>
				</div>
				<div class="form-group">
					<label for="description" class="col-sm-5 control-label">Description</label>
					<div class="col-sm-7">
						<textarea name="description" class="form-control" id="description"
							rows="4" cols="20"><%=l.getDescription()%></textarea>
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

	<script src="/jsp-sample/resources/js/jquery-2.1.3.min.js"></script>
	<script src="/jsp-sample/resources/js/bootstrap.min.js"></script>

</body>
</html>