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
				<h1 class="border-bottom py-3">Add Content</h1>
				<div class="card">
					<div class="card-header"> <p class="m-0">Profile Edit Element</p></div>
					<div class="card-body">
						<div class="w-75">
							<label class="font-weight-bold">Title</label>
							<input type="text" name="firstname" class="form-control" placeholder="Enter the Title">
						</div>
						<div class="w-75 pt-3">
							<label class="font-weight-bold">Brief</label>
							<textarea type="text" name="firstname" class="form-control" placeholder="Enter the first name"></textarea>
						</div>
						<div class="w-75 pt-3">
							<label class="font-weight-bold">Content</label>
							<textarea type="text" rows="5" name="firstname" class="form-control"></textarea>
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