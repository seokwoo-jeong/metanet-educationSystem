<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="/incl/DeepHead.jsp" />
<title>noticeList</title>
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
								<h4 class="card-title">공지사항</h4>
								<div class="table-responsive">
									<table class="table table-striped table-bordered zero-configuration">
										<thead>
											<tr>
												<th>공지번호</th>
												<th>제 목</th>
												<th>작성일</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="noticeVO" items="${noticeVOList}">
												<tr>
													<td>${noticeVO.noticeNO}</td>
													<td><a href="/notice/detail?no=${noticeVO.noticeNO}">${noticeVO.noticeSubject}</a></td>
													<td>${noticeVO.noticeDate }</td>
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