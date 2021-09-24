<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<jsp:include page="/incl/DeepHead.jsp" />


<title>ProfessorInputStudentScore</title>
<body>
	<jsp:include page="/incl/Header.jsp" />
	<jsp:include page="/incl/Sidebar.jsp" />
	<div id="preloader">
		<div class="loader">
			<svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none"
					stroke-width="3" stroke-miterlimit="10" />
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
						<li class="breadcrumb-item active"><a
							href="javascript:void(0)">Home</a></li>
					</ol>
				</div>
			</div>
			<!-- row -->

			<div class="container-fluid">
				<div class="row">

					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<h4 class="card-title">학생 성적 입력</h4>
								<div class="basic-form">

									<form action="/professor/professorInputScoreCheck"
										method="post">
										<div class="form-row">
											<div class="form-group col-md-6">
												<%
												request.setCharacterEncoding("UTF-8");
												String classNO = request.getParameter("classNO");
												String memberNO = request.getParameter("memberNO");
												%>
												<label>학수번호</label> <input type="text" class="form-control"
													id="classNO" name="classNO" value="<%=classNO%>">
											</div>
											<div class="form-group col-md-6">
												<label>학생 학번</label> <input type="text" class="form-control"
													id="memberNO" name="memberNO" value="<%=memberNO%>">
											</div>

										</div>
										<div class="form-group">
											<label>중간고사</label> <input type="number" class="form-control"
												placeholder="중간고사 점수 입력" id="midtermScore"
												name="midtermScore">
										</div>
										<div class="form-group">
											<label>기말고사</label> <input type="number" class="form-control"
												id="finalsScore" name="finalsScore" placeholder="기말고사 점수입력">
										</div>
										<div class="form-group">
											<label>과제</label> <input type="number" class="form-control"
												id="assignmentScore" name="assignmentScore"
												placeholder="과제 점수 입력">
										</div>
										<div class="form-group">
											<label>출석</label> <input type="number" class="form-control"
												id="attendanceScore" name="attendanceScore"
												placeholder="출석 점수 입력">
										</div>
										<!-- <div class="form-group">
											<label>최종학점</label> <input type="text" class="form-control"
												id="grade" name="grade" placeholder="최종 학점 입력">
										</div> -->


										<div class="form-group">
											<label>구분</label> <select id="grade" class="form-control"
												name="grade">
												<option selected="selected">최종 학점을 입력하세요</option>
												<option value="A+">A+</option>
												<option value="A0">A0</option>
												<option value="B+">B+</option>
												<option value="B0">B0</option>
												<option value="C+">C+</option>
												<option value="C0">C0</option>
												<option value="F">F</option>
											</select>
										</div>

										<!--  <button type="submit" class="btn btn-dark"
											onclick="return professorInputScore();">성적 입력</button>-->
										<script>
											function btn() {
												alert('등록되었습니다');
											}
										</script>
										<button class="btn mb-1 btn-primary btn-sm"
											onclick="javascript:btn()">성적 입력</button>
									
									</form>
									<form action="/professor/professorInputScoreCheck">	<input type="hidden" name="classID" value="${classNO}" /></form>
								</div>


							</div>
						</div>
					</div>
				</div>

				<jsp:include page="/incl/DeepFooter.jsp" />
</body>
</html>


