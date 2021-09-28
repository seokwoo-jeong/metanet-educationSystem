<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<jsp:include page="/incl/DeepHead.jsp" />

<title>수업등록</title>
<body>
	<jsp:include page="/incl/Header.jsp" />
	<jsp:include page="/incl/Sidebar.jsp" />

	<div id="main-wrapper">
		<div class="content-body">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<h4 class="card-title">수업 등록</h4>
								<br>
								<div class="basic-form">
									<form action="/admin/classInsertCheck" id="classInsertCheck" method="Post">
										<div class="form-row">
											<div class="form-group col-md-6">
												<label>수업번호</label> <input type="text" class="form-control" id="classNO" name="classNO" placeholder="수업번호를 입력해주세요">
											</div>
										</div>
										<p>
										<div class="form-row">
											<div class="form-group col-md-6">
												<label>수업명</label> <input type="text" class="form-control" id="className" name="className" placeholder="수업명을 입력해주세요">

											</div>
										</div>
										<p>
										<div class="form-row">
											<div class="form-group col-md-6">
												<label>수업목표</label> <input type="text" class="form-control" id="classGoal" name="classGoal" placeholder="수업목표를 입력해주세요">
											</div>
										</div>
										<p>
										<div class="form-row">
											<div class="form-group col-md-6">
												<label>수업내용</label> <input type="text" class="form-control" id="classSummary" name="classSummary" placeholder="수업내용을 입력해주세요">
											</div>
										</div>
										<p>
										<div class="form-row">
											<div class="form-group col-md-6">

												<label>수업인원</label><input type="number" class="form-control" id="classPersonnel" name="classPersonnel" placeholder="수업인원을 입력해주세요">
											</div>
										</div>
										<p>
										<div class="form-row">
											<div class="form-group col-md-6">
												<label>수업학점</label> <input type="number" class="form-control" id="classCredit" name="classCredit" placeholder="수업학점을 입력해주세요">
											</div>
										</div>
										<p>
										
										<div class="form-row">
											<div class="form-group col-md-6">
												<label>교수번호</label> <select id="memberNO" class="form-control" name="memberNO">
												<c:forEach var="professorNO" items="${professorNOList}">
												
													<option value="${professorNO}">${professorNO}</option>
												</c:forEach>
												
												</select>
											</div>
										</div>
										

										<button class="btn mb-1 btn-primary btn-sm" onclick="return classInsert();">수업 등록</button>
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

</html>