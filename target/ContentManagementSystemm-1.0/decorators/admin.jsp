<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta name="viewport" content="width=device-width" />
		<link rel="stylesheet" href="<c:url values='template/css/bootstrap.min.css'/>" >
		<link rel="stylesheet" href="<c:url values='template/css/style.css'/>" >
		<link rel="stylesheet" href="<c:url values='template/css/all.min.css'/>" >
		<title>addcontent</title>
	</head>
	<body class="bg-white">
		<!-- header -->
		<%@ include file="/common/admin/header.jsp" %>
		<!-- header -->
		<section>
			<div class="main-content container-fluid">
				<div class="row">
					<!-- menu -->
					<%@ include file="/common/admin/menu.jsp" %>
					<!-- menu -->
					
					<dec:body/>
					
				</div>
			</div>
		</section>
	</body>
	<script src="<c:url values='template/js/jquery-3.4.1.min.js'/>"></script>
	<script src="<c:url values='template/js/popper.min.js'/>"></script>
	<script src="<c:url values='template/js/bootstrap.min.js'/>"></script>
</html>