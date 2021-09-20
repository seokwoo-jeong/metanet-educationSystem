<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">강의계획서</h5>
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="modal-body">
						<label> 수업번호: </label> <input type="text" id="classNO" name="classNO" readonly> 
						<label> 수업이름: </label> <input type="text" id="className" name="className" readonly>
						<hr>
						<label> 정원 수: </label> <input type="text" id="classPersonnel" name="classPersonnel" readonly> 
						<label> 학점: </label> <input type="text" id="classCredit" name="classCredit" readonly>
						<hr>
						<label> 수업목표: </label> <input type="text" id="classGoal" name="classGoal" readonly>
						<hr>
						<label> 수업내용: </label> <input type="text" id="classSummary" name="classSummary" readonly>
						<hr>
						<label> 교수이름: </label> <input type="text" id="memberName" name="memberName" readonly> 
						<label> 교수이메일: </label> <input type="text" id="memberEmail" name="memberEmail" readonly>
						<label> 교수번호: </label> <input type="text" id="memberPhoneNO" name="memberPhoneNO" readonly>
						<hr>
						<label> 교수전공: </label> <input type="text" id="professorMajor" name="professorMajor" readonly>
						<label> 교수신분:</label> <input type="text" id="professorRank" name="professorRank" readonly>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>
</body>
<jsp:include page="/incl/DeepFooter.jsp" />
</html>