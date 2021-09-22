<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">성적입력</h5>
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="modal-body">
						<label> 학생 학번: </label> <input type="text" id="memberNO"
							name="memberNO" readonly>
						<hr>
						<label> 학수번호: </label> <input type="text" id="classNO"
							name="classNO" readonly>
						<hr>
						<label> 중간고사: </label> <input type="text" id="midtermScore"
							name="midtermScore">
						<hr>
						<label> 기말고사: </label> <input type="text" id="finalsScore"
							name="finalsScore">
						<hr>
						<label> 과제: </label> <input type="text" id="assignmentScore"
							name="assignmentScore">
						<hr>
						<label> 출석: </label> <input type="text" id="attendanceScore"
							name="attendanceScore">
						<hr>
						<label> GRADE: </label> <input type="text" id="grade" name="grade">
						<hr>

					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">입력하기</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>
</body>
<jsp:include page="/incl/DeepFooter.jsp" />
</html>