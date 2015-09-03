<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<c:url value="resources/css/bootstrap.min.css" var="bootstrap_css" />
<c:url value="resources/js/jquery-2.1.4.min.js" var="jquery_js" />
<c:url value="resources/js/bootstrap.min.js" var="bootstrap_js" />

<link href="${ bootstrap_css }" rel="stylesheet">
<title>Skill DB</title>
</head>
<body>

	<div class="container">
	<jsp:include page="/views/navigation.jsp"></jsp:include>


	</div>

	<script src="${ jquery_js }"></script>
	<script src="${ bootstrap_js }"></script>
</body>
</html>