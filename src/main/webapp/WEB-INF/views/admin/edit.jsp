<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<%@ page import="com.cms.utils.SecurityUtil" %>
<c:url var="updateAPI" value="/api-member"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit Profile</title>
	</head>
	<body>
		<div class="col-md-10 ">
			<div class="p-4">
				<h1 class="border-bottom py-3">Edit Profile</h1>
				<div class="card">
				<c:if test="${param.message eq 'update_success'}">
					<div class="alert alert-success">Update Success</div>
				</c:if>
				<c:if test="${param.message eq 'error_system'}">
					<div class="alert alert-danger">Update fail</div>
				</c:if>
				<div class="card-header"> <p class="m-0">Profile Form Element</p></div>
					<div class="card-body">
					<form:form class="form-horizontal" role="form" id="formSubmit">
						<div class="w-75">
							<label class="font-weight-bold">First Name</label>
							<input type="text" name="firstName" class="form-control" value="${model.firstName}" placeholder="Enter the first name">
						</div>
						<div class="w-75 pt-3">
							<label class="font-weight-bold">Last Name</label>
							<input type="text" name="lastName" class="form-control" value="${model.lastName}" placeholder="Enter the last name">
						</div>
						<div class="w-75 pt-3">
							<label class="font-weight-bold">Email</label>
							<p><%=SecurityUtil.getPrincipal().getEmail()%></p>
							<input type="hidden" name="email" class="form-control" value="${model.email}">
						</div>
						<div class="w-75 pt-3">
							<label class="font-weight-bold">Phone</label>
							<input type="text" name="phone" class="form-control" value="${model.phone}" placeholder="Enter the phone number">
						</div>
						<div class="w-75 pt-3">
							<label class="font-weight-bold">Description</label>
							<textarea type="text" name="description" class="form-control">${model.description}</textarea>
						</div>
						<div class="pt-3">
							<button type="button" class="btn btn-success border" id="btnUpdate">Submit Button</button>
							<button type="reset" class="btn btn-success border">Reset Button</button>
						</div>
						<input type="hidden" name="id" class="form-control" value="<%=SecurityUtil.getPrincipal().getId()%>">
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<script>
			$('#btnUpdate').click(function (e) {
					e.preventDefault();
					var data = {};
					var formData = $('#formSubmit').serializeArray();
					$.each(formData, function (i, v) {
						data[""+v.name+""] = v.value;
					});
					updateMember(data);
			});
			function updateMember(data) {
				$.ajax({
					url: '${updateAPI}',
					type: 'PUT',
					contentType: 'application/json',
					data: JSON.stringify(data),
					dataType: 'json',
					success: function (result) {
						window.location.href = "/admin-edit?message=update_success";
					},
					error: function (error) {
						window.location.href = "/admin-edit?message=error_system";
					}
				});
			}
		</script>
	</body>
</html>