<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<jsp:include page="/incl/Head.jsp" />
<!DOCTYPE html>
<html class="h-100" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Quixlab - Bootstrap Admin Dashboard Template by Themefisher.com</title>
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16" href="../../assets/images/favicon.png">

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
window.onload = function() {
	if(${param.error}=="401")
		alert("로그인이 필요한 기능입니다.");
	};

</script>
</head>

<body class="h-100">

	<!--*******************
        Preloader start
    ********************-->
	<div id="preloader">
		<div class="loader">
			<svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10" />
            </svg>
		</div>
	</div>
	<!--*******************
        Preloader end
    ********************-->





	<div class="login-form-bg h-100">
		<div class="container h-100">
			<div class="row justify-content-center h-100">
				<div class="col-xl-6">
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
									<button class="btn login-form__btn submit w-100" type="submit" onclick="doLogin();">Sign In</button>
								</form>
								<p class="mt-5 login-form__footer" align="center" style="color:blue;">${requestScope.loginFailMsg}</p>
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
