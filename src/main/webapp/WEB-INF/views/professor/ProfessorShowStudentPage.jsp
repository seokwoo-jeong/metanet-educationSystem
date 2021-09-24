<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<jsp:include page="/incl/DeepHead.jsp" />

<title>StudentApplyClass</title>
<body>
	<div id="main-wrapper">
		<jsp:include page="/incl/Header.jsp" />
		<jsp:include page="/incl/Sidebar.jsp" />
		<jsp:include page="ProfessorInputScoreModal.jsp" />

		<div class="content-body">
			<div class="container-fluid">

				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<h4 class="card-title">수강생조회</h4>
								<div class="table-responsive">
									<table
										class="table table-striped table-bordered zero-configuration">
										<thead>
											<tr>
												<th>강좌번호</th>
												<th>강좌이름</th>
												<th>학생이름</th>
												<th>학생no</th>
												<th>학생email</th>
												<th>학생phoneno</th>


											</tr>
										</thead>
										<tbody>
											<c:forEach var="studentinfo" items="${studentVOList}">
												<tr>
													<td>${studentinfo.classNO}</td>
													<td>${studentinfo.ClassVO.className}</td>
													<td>${studentinfo.MemberVO.memberName}</td>
													<td>${studentinfo.MemberVO.memberNO}</td>
													<td>${studentinfo.MemberVO.memberEmail}</td>
													<td>${studentinfo.MemberVO.memberPhoneNO}</td>

													<!-- onclick="professorInputScore('${studentinfo.MemberVO.memberNO}'
													<a
														herf="/professor/professorInputScore?studentinfo=${studentinfo.MemberVO.memberNO}"> -->
													<!-- <td><a
														href="/professor/professorShowStudent?classID=${classVO.classNO}"><button
																class="btn mb-1 btn-primary btn-sm" data-toggle="modal" data-target=".bd-example-modal-lg">성적 입력</button></a></td> -->
													<!-- 				<td>
														<form action="/professor/professorInputScore">
															<input type="hidden" name="classNO"
																value="${studentinfo.classNO}" /> <input type="hidden"
																name="memberNO" value="${studentinfo.MemberVO.memberNO}" />
															<button class="btn mb-1 btn-primary btn-sm"
																data-toggle="modal" data-target=".bd-example-modal-lg"
																onclick="alert(1);professorInput($(this))">성적
																입력</button>
														</form>
													</td> /professor/professorInputScore-->

													<td>
														<form action=" /professor/professorInputScore">
														 <input type="hidden" name="classNO" value="${studentinfo.classNO}" /> 
															<input type="hidden" name="memberNO" value="${studentinfo.MemberVO.memberNO}" /> 
															
															<button class="btn mb-1 btn-primary btn-sm">성적
																입력</button>
														</form>
													</td>


												</tr>
											</c:forEach>
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
	<jsp:include page="/incl/DeepFooter.jsp" />

</body>
</html>