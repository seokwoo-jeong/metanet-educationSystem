<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
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
					<div class="col-12">
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
											<c:forEach var="classVOList" items="${classVOList}">
												<tr>
													<td>${classVOList.classNO}</td>
													<td>${classVOList.className}</td>
													<td>0</td>
													<td>${classVOList.classPersonnel}</td>
													<td>${classVOList.classCredit}</td>
													<td>${classVOList.MemberVO.memberName}</td>
													<td><button class="btn mb-1 btn-primary btn-sm">수강신청</button></td>
												</tr>
											</c:forEach>
										</tbody>

									</table>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="card">
								<div class="card-body">
									<div class="active-member">
										<div class="table-responsive">
											<table class="table table-xs mb-0">
												<thead>
													<tr>
														<th>공지사항</th>
													</tr>
												</thead>
												<tbody>



													<tr>
														<td>static layout: Head, Header, Sidebar, Footer로 나눔</td>
													</tr>
													<tr>
														<td>Head: css link</td>
													</tr>
													<tr>
														<td>Header: 상단 layout</td>
													</tr>
													<tr>
														<td>Sidebar: 좌측 sidebar</td>
													</tr>
													<tr>
														<td>Footer: 맨 하단 하얀 부분 + js(javascript)</td>
													</tr>
													<tr>
														<td>탬플릿 적용 안될 때: css, js, images, plugins etc... 앞에 'resources/' 붙여야 탬플릿 적용 됨</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="col-lg-6">
							<div class="card">
								<div class="card-body">
									<div class="active-member">
										<div class="table-responsive">
											<table class="table table-xs mb-0">
												<thead>
													<tr>
														<th>수강조회</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>로그인x : 문구 띄우기 (ex-로그인해서 이용바람..)</td>

													</tr>
													<tr>

														<td>로그인 시: 과목 리스트 띄우기 + 버튼</td>
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
	</div>
	<jsp:include page="/incl/Footer.jsp" />

</body>
</html>