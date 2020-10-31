<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="col-md-10 ">
			<div class="p-4">
				<h1 class="border-bottom py-3">Edit Profile</h1>
				<div class="card">
					<div class="card-header"> <p class="m-0">Profile Edit Element</p></div>
					<div class="card-body">
						<div class="w-75">
							<label class="font-weight-bold">First Name</label>
							<input type="text" name="firstname" class="form-control" placeholder="Enter the first name">
						</div>
						<div class="w-75 pt-3">
							<label class="font-weight-bold">Last Name</label>
							<input type="text" name="firstname" class="form-control" placeholder="Enter the last name">
						</div>
						<div class="w-75 pt-3">
							<label class="font-weight-bold">Email</label>
							<p>yourrmail@exenple.com</p>
						</div>
						<div class="w-75 pt-3">
							<label class="font-weight-bold">Phone</label>
							<input type="text" name="firstname" class="form-control" placeholder="Enter the phone number">
						</div>
						<div class="w-75 pt-3">
							<label class="font-weight-bold">Desciption</label>
							<textarea type="text" name="firstname" class="form-control"></textarea>
						</div>
						<div class="pt-3">
							<button class="btn bg-white border">Submit Button</button>
							<button class="btn bg-white border">Reset Button</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>