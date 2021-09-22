<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<jsp:include page="/incl/Head.jsp" />
<title>loginPage</title>
<script type="text/javascript">
		$("#doLogin").click(function(){
		
			$.ajax({
				url: "doLogin",
				type: "post",
				data: {name:"홍길동"},
				success: function(result){
					$("body")
				},
				error: function(xhr, status, error){
					alert("통신 에러")
				}
			
			})
		})
	}
</script>

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

								<form class="mt-5 mb-5 login-input" action="doLogin" method="post">
									<div class="form-group">
										<input type="text" class="form-control" placeholder="Id" name="memberNO">
									</div>
									<div class="form-group">
										<input type="password" class="form-control" placeholder="Password" name="memberPassword">
									</div>
									<button onclick="return doLogin();" class="btn login-form__btn submit w-100" id="doLogin">Sign In</button>
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