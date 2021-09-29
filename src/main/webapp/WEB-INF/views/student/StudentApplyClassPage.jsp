<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<jsp:include page="/incl/DeepHead.jsp" />


<title>StudentApplyClass</title>
<body>
	<script>
		var message = "${message}";
		if (message != "") {
			alert(message);
		}
	</script>
	<div id="main-wrapper">
		<jsp:include page="/incl/Header.jsp" />
		<jsp:include page="/incl/Sidebar.jsp" />

		<div class="content-body">
			<div class="container-fluid">

				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<h3>개설 과목 조회</h3>
								<div class="table-responsive">
									<table class="table table-striped table-bordered zero-configuration">
										<thead>
											<tr>
												<th>강좌번호</th>
												<th>강좌이름</th>
												<th>현재인원</th>
												<th>전체인원</th>
												<th>학점</th>
												<th>교수이름</th>
												<th>수강신청</th>
											</tr>
										</thead>
										<tbody>

											<c:forEach var="classVO" items="${classVOList}">
												<tr>
													<td>${classVO.classNO}</td>
													<td>${classVO.className}</td>
													<td>${classVO.classCurrentPersonnel }</td>
													<td>${classVO.classPersonnel}</td>
													<td>${classVO.classCredit}</td>
													<td>${classVO.MemberVO.memberName}</td>
													<td>
														<form action="/student/studentApplyClassCheck" id="studentApplyClassCheck" method="Post">
															<input type="hidden" name="classNO" id="classNO" value="${classVO.classNO}" />
															<button class="btn mb-1 btn-primary btn-sm" onclick="return studentApplyClass();">수강신청</button>
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
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<div class="active-member">
									<h3>내 수강 목록</h3>
									<br>
									<div class="table-responsive">
										<table class="table table-xs mb-0">
											<thead>
												<tr>
													<th>강좌번호</th>
													<th>강좌이름</th>
													<th>현재인원</th>
													<th>전체인원</th>
													<th>학점</th>
													<th>교수이름</th>
													<th>수강취소</th>
												</tr>
											</thead>
											<tbody>

												<c:forEach var="studentClassVO" items="${studentClassVOList}">
													<tr>
														<td>${studentClassVO.classNO}</td>
														<td>${studentClassVO.className}</td>
														<td>${studentClassVO.classCurrentPersonnel}</td>
														<td>${studentClassVO.classPersonnel}</td>
														<td>${studentClassVO.classCredit}</td>
														<td>${studentClassVO.MemberVO.memberName}</td>
														<td>
															<form action="/student/studentDeleteClass" id="studentDeleteClass" method="Post">
																<input type="hidden" name="classNO" id="classNO" value="${studentClassVO.classNO}" />
																<button class="btn mb-1 btn-primary btn-sm" onclick="return studentDeleteClass();">수강취소</button>
															</form>
														</td>

													</tr>
												</c:forEach>
											</tbody>
											<tfoot>
												<tr>
													<td colspan="2">현재 신청학점: <font size="4em" color="black">${studentCurrentCredit} 학점</font></td>
													<td colspan="3">총 학점: <font size="4em" color="black">${studentAllowCredit} 학점</font></td>
												</tr>
											</tfoot>
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
	<jsp:include page="/incl/DeepFooter.jsp" />

</body>
</html>