<!DOCTYPE html>
<html class="h-100" lang="en">

<head>
<jsp:include page="/incl/Head.jsp" />
<title>loginPage</title>
</head>

<body class="h-100">
	<div class="login-form-bg h-100">
		<div class="container h-100">
			<div class="row justify-content-center h-100">
				<div class="col-xl-6">
					<div class="form-input-content">
						<div class="card login-form mb-0">
							<div class="card-body pt-5">
								<a class="text-center">
									<h4>Login</h4>
								</a>

								<form class="mt-5 mb-5 login-input" action="#">
									<div class="form-group">
										<input type="text" class="form-control" placeholder="UserNO">
									</div>
									<div class="form-group">
										<input type="password" class="form-control" placeholder="Password">
									</div>
									<button class="btn login-form__btn submit w-100">Sign In</button>
								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<footer>
		<jsp:include page="/incl/Footer.jsp" />
	</footer>
</body>
</html>