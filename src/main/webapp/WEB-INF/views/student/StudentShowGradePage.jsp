<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/incl/DeepHead.jsp" />
<title>studentShowScore</title>
</head>
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
								<div class="active-member">
									<h4 class="card-title">최종학점보기</h4>
									<div class="table-responsive">
										<table class="table table-xs mb-0">
											<thead>
												<tr>
													<th>강좌번호</th>
													<th>강좌이름</th>
													<th>최종학점</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="studentScoreVO" items="${studentScoreVOList}">
													<tr>
														<td>${studentScoreVO.ScoreVO.classNO}</td>
														<td>${studentScoreVO.ClassVO.className}</td>
														<td>${studentScoreVO.ScoreVO.grade}</td>																												
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
	</div>
	<jsp:include page="/incl/DeepFooter.jsp" />

</body>
</html>