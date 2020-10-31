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
		<section class="container pt-5 mt-5">
			<div class="row justify-content-center">
				<div class="col-md-5">
					<div class="card">
						<div class="card-header"><p class="card-title m-0">Please Sign In</p></div>
						<div class="card-body">
							<form action="" >
								<div>
									<input type="text" name="E-mail" class="form-control " placeholder="E-mail">
								</div>
								<div class="pt-3">
									<input type="password"  name="password" class="form-control" placeholder="Password">
								</div>
								<div class="pt-3">
									<input type="checkbox" name="checkbox" id="checkbox">
									<label for="coding" class="card-text text-dark m-0">Remenber Me</label>
								</div>
								<div class="pt-2"><a href="" class="btn btn-success w-100"> Login</a></div>
								<div class="pt-4"><a href="" class="m-0 "> Click here to Register</a></div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>