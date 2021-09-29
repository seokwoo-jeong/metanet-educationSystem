<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	function LoginSubmit() {
		alert($("#memberNO").val());
		alert($("#memberPassword").val());
	}
</script>
</head>
<body>
	<div class="bootstrap-modal">
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" style="display: none;" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-body">
						<div class="login-form-bg h-100">
							<div class="container h-100">
								<div class="row justify-content-center h-100">
									<div class="col-xl-12">
										<div class="form-input-content">
											<div class="card login-form mb-0">
												<div class="card-body pt-5">
													<a class="text-center">
														<h4>로그인</h4>
													</a>
													<form class="mt-5 mb-5 login-input" action="/doLogin" method="post">
														<div class="form-group">
															<input type="text" class="form-control" placeholder="Id" name="memberNO">
														</div>
														<div class="form-group">
															<input type="password" class="form-control" placeholder="Password" name="memberPassword">
														</div>
														<button class="btn login-form__btn submit w-100" type="submit">Sign In</button>
													</form>
													<p class="mt-5 login-form__footer" align="center" style="color: blue;">${requestScope.loginFailMsg}</p>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<jsp:include page="/incl/DeepFooter.jsp" />
</html>