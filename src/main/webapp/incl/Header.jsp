<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>
	<!-- Nav header start -->
	<div class="nav-header">
		<div class="brand-logo">
			<a href="/"> <b class="logo-abbr"><img src="resources/images/logo.png" alt=""> </b> <span class="brand-title"> <img src="resources/images/metanetUniversityLogo.png" width="200" height="50" alt="">
			</span>
			</a>
		</div>
	</div>
	<!-- Nav header end -->

	<!-- Header start -->
	<div class="header">
		<div class="header-content clearfix">

			<div class="nav-control">
				<div class="hamburger">
					<span class="toggle-icon"><i class="icon-menu"></i></span>
				</div>
			</div>
			<div class="header-left">
				<div class="input-group icons">
					<div class="input-group-prepend">
						<span class="input-group-text bg-transparent border-0 pr-2 pr-sm-3" id="basic-addon1"><i class="mdi mdi-magnify"></i></span>
					</div>
					<input type="search" class="form-control" placeholder="Search Dashboard" aria-label="Search Dashboard">
					<div class="drop-down   d-md-none">
						<form action="#">
							<input type="text" class="form-control" placeholder="Search">
						</form>
					</div>
				</div>
			</div>
			<div class="header-right">
				<div class="input-group icons">
					<div class="col-12 text-center">
						<form action="/checkLogin" method="post">
							<button class="btn btn-primary px-3 ml-4">login</button>
						</form>
					</div>


				</div>
			</div>
		</div>
	</div>


</body>
</html>