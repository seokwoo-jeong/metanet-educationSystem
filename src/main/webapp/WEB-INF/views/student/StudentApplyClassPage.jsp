<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<jsp:include page="/incl/Head.jsp" />
<title>StudentApplyClass</title>
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
								<h4 class="card-title">수강신청리스트</h4>
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
													<td>${memberVO.memberName }</td>
													<td>${classVO.classPersonnel}</td>
													<td>${classVO.classCredit}</td>
													<td>${classVO.MemberVO.memberName}</td>
													<td>
														<form action="/studentApplyClassCheck" id="studentApplyClassCheck" method="Post">
															<input type="hidden" name="classNO" id="classNO" value="${classVO.classNO}" />
															
															
															<button class="btn mb-1 btn-primary btn-sm" onclick="studentApplyClass();">수강신청</button>
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
									<div class="table-responsive">
										<table class="table table-xs mb-0">
											<thead>
												<tr>
													<th>수강과목</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>static layout: Head, Header, Sidebar, Footer로 나눔</td>
												</tr>
												<tr>
													<td>Head: css link</td>
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
	</div>
	<jsp:include page="/incl/Footer.jsp" />

</body>
</html>