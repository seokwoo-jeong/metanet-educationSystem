<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

	<div id="preloader">
		<div class="loader">
			<svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10" />
            </svg>
		</div>
	</div>

	<div id="main-wrapper">

		<!--**********************************
            Content body start
        ***********************************-->
		<div class="content-body">

			<div class="row page-titles mx-0">
				<div class="col p-md-0">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="javascript:void(0)">Dashboard</a></li>
						<li class="breadcrumb-item active"><a href="javascript:void(0)">Home</a></li>
					</ol>
				</div>
			</div>
			<!-- row -->

			<div class="container-fluid">
				<div class="row">

					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<h4 class="card-title">Vertical Form</h4>
								<div class="basic-form">
									<form action="/studentInsert" method="post">
										<div class="form-row">
											<div class="form-group col-md-6">
												<label>학번</label> <input type="text" class="form-control" id="memberNO" name="memberNO" placeholder="학번">
											</div>
											<div class="form-group col-md-6">
												<label>비밀번호</label> <input type="password" class="form-control" name="memberPassword" placeholder="Password">
											</div>
										</div>
										<div class="form-group">
											<label>이름</label> <input type="text" class="form-control" placeholder="이름을 입력하세요." name="memberName">
										</div>
										<div class="form-group">
											<label>이메일</label> <input type="text" class="form-control" name="memberEmail" placeholder="이메일 입력">
										</div>
										<div class="form-row">
											<div class="form-group col-md-6">
												<label>핸드폰번호</label> <input type="text" class="form-control" name="memberPhoneNO">
											</div>
											<div class="form-group col-md-4">
												<label>구분</label> <select id="inputState" class="form-control" name="memberDistinct">
													<option selected="selected">선택하세요</option>
													<option value="0">학생</option>
													<option value="1">교수</option>
												</select>
											</div>
										</div>
										<div class="form-group">
											<!-- <div class="form-check">
														<input class="form-check-input" type="checkbox"> <label
															class="form-check-label">Check me out</label>
													</div> -->
										</div>
										<button type="submit" class="btn btn-dark">Sign in</button>
									</form>
								</div>
							</div>
						</div>
					</div>


					<jsp:include page="/incl/Footer.jsp" />
</body>
</html>