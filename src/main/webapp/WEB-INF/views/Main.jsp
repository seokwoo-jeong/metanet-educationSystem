<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>main</title>
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16" href="resources/images/favicon.png">
<!-- Custom Stylesheet -->
<link rel="stylesheet" href="./resources/plugins/chartist/css/chartist.min.css">
<link rel="stylesheet" href="./resources/plugins/chartist-plugin-tooltips/css/chartist-plugin-tooltip.css">
<link href="resources/css/style.css" rel="stylesheet">
</head>


<body>
	<!--**********************************
        Main wrapper start
    ***********************************-->
	<div id="main-wrapper">

		<!--**********************************
            Nav header start
        ***********************************-->
		<div class="nav-header">
			<div class="brand-logo">
				<a href="/">
					<h1 class="card-title text-white">학사정보시스템</h1>
				</a>
			</div>
		</div>
		<!--**********************************
            Nav header end
        ***********************************-->

		<!--**********************************
            Header start
        ***********************************-->
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

							<form action="/checkLogin">
								<c:if test="${empty member}">
									<button class="btn btn-primary px-3 ml-4">로그인</button>
								</c:if>
							</form>

							<c:if test="${!empty member}">
								<form action="${ pageContext.request.contextPath }/doLogout" method="post">
									<button class="btn btn-primary px-3 ml-4">로그아웃</button>
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
								</form>

							</c:if>


						</div>
					</div>
				</div>
			</div>
		</div>
		<!--**********************************
            Header end ti-comment-alt
        ***********************************-->

		<!--**********************************
            Sidebar start
        ***********************************-->
		<div class="nk-sidebar">
			<div class="nk-nav-scroll">
				<ul class="metismenu" id="menu">
					<li class="nav-label"><c:choose>
							<c:when test="${member.memberDistinct eq 0}"> ${member.memberName} 학생님 반갑습니다.</c:when>
							<c:when test="${member.memberDistinct eq 1}"> ${member.memberName} 교수님 반갑습니다.</c:when>
							<c:when test="${member.memberDistinct eq 2}"> ${member.memberName} 관리자님 반갑습니다.</c:when>
						</c:choose></li>
					<li class="nav-label">Dashboard</li>
					<li><a class="has-arrow" href="javascript:void()" aria-expanded="false"> <i class="icon-speedometer menu-icon"></i><span class="nav-text">Dashboard</span>
					</a>
						<ul aria-expanded="false">
							<li><a href="./index.html">Home 1</a></li>
							<!-- <li><a href="./index-2.html">Home 2</a></li> -->
						</ul></li>
					<li class="mega-menu mega-menu-sm"><a class="has-arrow" href="javascript:void()" aria-expanded="false"> <i class="icon-globe-alt menu-icon"></i><span class="nav-text">Layouts</span>
					</a>
						<ul aria-expanded="false">
							<li><a href="./layout-blank.html">Blank</a></li>
							<li><a href="./layout-one-column.html">One Column</a></li>

						</ul></li>
					<li class="nav-label">Apps</li>
					<li><a class="has-arrow" href="javascript:void()" aria-expanded="false"> <i class="icon-envelope menu-icon"></i> <span class="nav-text">Email</span>
					</a>
						<ul aria-expanded="false">
							<li><a href="./email-inbox.html">Inbox</a></li>
							<li><a href="./email-read.html">Read</a></li>

						</ul></li>
					<li><a class="has-arrow" href="javascript:void()" aria-expanded="false"> <i class="icon-screen-tablet menu-icon"></i><span class="nav-text">Apps</span>
					</a>
						<ul aria-expanded="false">
							<li><a href="./app-profile.html">Profile</a></li>
							<li><a href="./app-calender.html">Calender</a></li>
						</ul></li>
					<li><a class="has-arrow" href="javascript:void()" aria-expanded="false"> <i class="icon-graph menu-icon"></i> <span class="nav-text">Charts</span>
					</a>
						<ul aria-expanded="false">
							<li><a href="./chart-flot.html">Flot</a></li>
							<li><a href="./chart-morris.html">Morris</a></li> <
						</ul></li>

					<li><a href="widgets.html" aria-expanded="false"> <i class="icon-badge menu-icon"></i><span class="nav-text">Widget</span>
					</a></li>
				</ul>
			</div>
		</div>
		<!--**********************************
            Sidebar end
        ***********************************-->

		<!--**********************************
            Content body start
        ***********************************-->
		<div class="content-body">

			<div class="row page-titles mx-0">
				<div class="col p-md-0">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
						<li class="breadcrumb-item active"><a href="/">Home</a></li>
					</ol>
				</div>
			</div>
			<!-- row -->

			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-6">
						<div class="card">
							<div class="card-body">
								<div class="active-member">
									<div class="table-responsive">
										<table class="table table-xs mb-0">
											<thead>
												<tr>
													<th>공지사항</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>header, footer, sidebar 정확하게 정의해서 incl 파일로 이동</td>
												</tr>
												<tr>
													<td>head의 import 정의해서 incl로 이동 (header에 있어야 하나?...)</td>
												</tr>
												<tr>
													<td>탬플릿 적용 안될 때: css, js, images, plugins etc... 앞에 'resources/' 붙여야 탬플릿 적용 됨</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="col-lg-6">
						<div class="card">
							<div class="card-body">
								<div class="active-member">
									<div class="table-responsive">
										<table class="table table-xs mb-0">
											<thead>
												<tr>
													<th>수강조회</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>로그인x : 문구 띄우기 (ex-로그인해서 이용바람..)</td>

												</tr>
												<tr>

													<td>로그인 시: 과목 리스트 띄우기 + 버튼</td>
												</tr>
											</tbody>
										</table>
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
	<!-- #/ container -->
	</div>
	<!--**********************************
            Content body end
        ***********************************-->


	<!--**********************************
            Footer start
        ***********************************-->
	<div class="footer">
		<div class="copyright">
			<p>
				Copyright &copy; Designed & Developed by <a href="https://themeforest.net/user/quixlab">Quixlab</a> 2018
			</p>
		</div>
	</div>
	<!--**********************************
            Footer end
        ***********************************-->
	</div>
	<!--**********************************
        Main wrapper end
    ***********************************-->

	<!--**********************************
        Scripts
    ***********************************-->
	<script src="resources/plugins/common/common.min.js"></script>
	<script src="resources/js/custom.min.js"></script>
	<script src="resources/js/settings.js"></script>
	<script src="resources/js/gleek.js"></script>
	<script src="resources/js/styleSwitcher.js"></script>

	<script src="./resources/plugins/chartist/js/chartist.min.js"></script>
	<script src="./resources/plugins/chartist-plugin-tooltips/js/chartist-plugin-tooltip.min.js"></script>
	<script src="./resources/js/plugins-init/chartist.init.js"></script>

</body>
</html>