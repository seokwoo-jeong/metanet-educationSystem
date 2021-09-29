<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/incl/DeepHead.jsp" />
<title>studentShowClass</title>
</head>
<body>
	<div id="main-wrapper">
		<jsp:include page="/incl/Header.jsp" />
		<jsp:include page="/incl/Sidebar.jsp" />
		<jsp:include page="ClassSyllabusModal.jsp" />
		<div class="content-body">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<div class="active-member">
									<h4 class="card-title">내 수업 리스트</h4>
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
													<th>강의계획서</th>
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
														<td><button  class="btn mb-1 btn-primary btn-sm" data-toggle="modal" data-target=".bd-example-modal-lg" onclick="getClassSyllabus('${studentClassVO.classNO}');">계획서 보기</button></td>
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