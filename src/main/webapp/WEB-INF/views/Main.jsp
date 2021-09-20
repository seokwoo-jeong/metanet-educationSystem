<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<head>
<jsp:include page="/incl/Head.jsp" />
<title>Main</title>
</head>


<body>
<jsp:include page="/incl/Header.jsp" />
<jsp:include page="/incl/Sidebar.jsp" />

	<div class="content-body">
		<div class="row page-titles mx-0">
			<div class="col p-md-0">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="/student/studentShowClass">Dashboard</a></li>
					<li class="breadcrumb-item active"><a href="/student/studentApplyClass">Home</a></li>
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
	<jsp:include page="/incl/Footer.jsp" />
</body>
</html>