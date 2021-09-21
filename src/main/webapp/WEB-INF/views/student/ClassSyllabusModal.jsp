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
						<div class="col-lg-12">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">강의계획서</h4>
									<div class="basic-form">
										<div class="form-row">
											<div class="form-group col-md-6">
												<label>수업번호</label> <input type="text" class="form-control" id="syllabusClassNO" name="syllabusClassNO" readonly>
											</div>
											<div class="form-group col-md-6">
												<label>수업이름</label> <input type="text" class="form-control" id="syllabusClassName" name="syllabusClassName" readonly>
											</div>
										</div>
										<div class="form-row">
											<div class="form-group col-md-6">
												<label>정원 수</label> <input type="text" class="form-control" id="syllabusClassPersonnel" name="syllabusClassPersonnel" readonly>
											</div>
											<div class="form-group col-md-6">
												<label>학점</label> <input type="text" class="form-control" id="syllabusClassCredit" name="syllabusClassCredit" readonly>
											</div>
										</div>
										<div class="form-row">
											<div class="form-group col-md-6">
												<label>교수이름</label> <input type="text" class="form-control" id="syllabusMemberName" name="syllabusMemberName" readonly>
											</div>
											<div class="form-group col-md-6">
												<label>교수전공</label> <input type="text" class="form-control" id="syllabusProfessorMajor" name="syllabusProfessorMajor" readonly>
											</div>
											
										</div>
										<div class="form-row">
											<div class="form-group col-md-6">
												<label>이메일</label> <input type="text" class="form-control" id="syllabusMemberEmail" name="syllabusMemberEmail" readonly>
											</div>
											<div class="form-group col-md-6">
												<label>전화번호</label> <input type="text" class="form-control" id="syllabusMemberPhoneNO" name="syllabusMemberPhoneNO" readonly>
											</div>
										</div>
										<div class="form-row">
											<div class="form-group col-md-12">
												<label>수업목표</label> <input type="text" class="form-control" id="syllabusClassGoal" name="syllabusClassGoal" readonly>
											</div>
										</div>
										<div class="form-row">
											<div class="form-group col-md-12">
												<label>수업내용</label> <input type="text" class="form-control" id="syllabusClassSummary" name="syllabusClassSummary" readonly>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">닫기</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<jsp:include page="/incl/DeepFooter.jsp" />
</html>