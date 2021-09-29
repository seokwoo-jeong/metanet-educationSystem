<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<jsp:include page="/incl/DeepHead.jsp" />
<title>ProfessorInputStudentScore</title>
<body>
	<div id="main-wrapper">
		<jsp:include page="/incl/Header.jsp" />
		<jsp:include page="/incl/Sidebar.jsp" />
		<div class="content-body">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<h4 class="card-title">학생 성적 입력</h4>
								<div class="basic-form">

									<form action="/professor/professorshowStudent" id=professorInputScoreCheck method="post">
										<div class="form-row">
											<div class="form-group col-md-6">
												<%
												request.setCharacterEncoding("UTF-8");
												String classNO = request.getParameter("classNO");
												String memberNO = request.getParameter("memberNO");
												%>
												<label>학수번호</label> <input type="text" class="form-control" id="classNO" name="classNO" value="<%=classNO%>" readonly>
											</div>
											<div class="form-group col-md-6">
												<label>학생 학번</label> <input type="text" class="form-control" id="memberNO" name="memberNO" value="<%=memberNO%>" readonly>
											</div>

										</div>
										<c:forEach var="getstudentScore" items="${getstudentScore}">
											<div class="form-group">
												<label>중간고사</label> <input type="number" class="form-control" placeholder="중간고사 점수 입력" id="midtermScore" name="midtermScore" value="${getstudentScore.midtermScore}">
											</div>
											<div class="form-group">
												<label>기말고사</label> <input type="number" class="form-control" id="finalsScore" name="finalsScore" placeholder="기말고사 점수입력" value="${getstudentScore.finalsScore}">
											</div>
											<div class="form-group">
												<label>과제</label> <input type="number" class="form-control" id="assignmentScore" name="assignmentScore" placeholder="과제 점수 입력" value="${getstudentScore.assignmentScore}">
											</div>
											<div class="form-group">
												<label>출석</label> <input type="number" class="form-control" id="attendanceScore" name="attendanceScore" placeholder="출석 점수 입력" value="${getstudentScore.attendanceScore}">
											</div>
											<div class="form-row">

												<div class="form-group col-md-6">
													<label>최종 성적</label> <select id="grade" class="form-control" name="grade">
														<option selected="selected">${getstudentScore.grade}</option>
														<option value="A+">A+</option>
														<option value="A0">A0</option>
														<option value="B+">B+</option>
														<option value="B0">B0</option>
														<option value="C+">C+</option>
														<option value="C0">C0</option>
														<option value="D">D</option>
														<option value="F">F</option>
													</select>
												</div>
												<div class="form-group col-md-2">
													<label>현재 입력된 성적</label> <input type="text" class="form-control" id="curgrade" name="curgrades" value="${getstudentScore.grade}">
												</div>
											</div>
										</c:forEach>
										<button class="btn mb-1 btn-primary btn-sm" onclick="return InputScore()">성적 입력</button>
									</form>
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
<script>
	function InputScore() {
		var classNO = $("#classNO");
		var memberNO = $("#memberNO");
		var midtermScore = $("#midtermScore");
		var finalsScore = $("#finalsScore");
		var assignmentScore = $("#assignmentScore");
		var attendanceScore = $("#attendanceScore");
		if (classNO.val() == '') {
			alert('학수번호를 입력해주세요');
			return false;
		}
		if (memberNO.val() == '') {
			alert('학번을 입력해주세요');
			return false;
		}
		if (midtermScore.val() == '') {
			alert('중간고사 성적 입력! 성적 미공개 시 0점으로 입력 해주세요.');
			return false;
		}
		if (finalsScore.val() == '') {
			alert('기말고사 성적 입력! 성적 미공개 시 0점으로 입력 해주세요.');
			return false;
		}
		if (assignmentScore.val() == '') {
			alert('과제 성적 입력! 성적 미공개 시 0점으로 입력 해주세요.');
			return false;
		}
		if (attendanceScore.val() == '') {
			alert('출석 성적 입력! 성적 미공개 시 0점으로 입력 해주세요.');
			return false;
		}

		if (!confirm("해당 정보로 학생을 등록 하시겠습니까?")) {
			return false;
		} else {
			alert("성적 입력이 완료되었습니다.");
			document.getElementById('professorInputScoreCheck').submit();

		}
	}
</script>
</html>


