<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<head>
<jsp:include page="/incl/Head.jsp" />
<title>Main</title>
</head>


<body>
	<jsp:include page="/incl/Header.jsp" />
	<jsp:include page="/incl/Sidebar.jsp" />
	

	<div class="content-body">

		<div class="row page-titles mx-0">
			<div class="col p-md-0">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">Dashboard</a></li>

					<li class="breadcrumb-item active"><a href="#">Home</a></li>

				</ol>
			</div>
		</div>

		<!-- row -->

		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-6">
					<div class="card">
						<div class="card-body">
							<div class="active-member">
								<div class="table-responsive">
									<table class="table table-xs mb-0">
										<thead>
											<tr>
												<th>��������</th>
											</tr>
										</thead>

										<tbody>
											<c:choose>
												<c:when test="${empty member.memberDistinct}">
													<tr>
														<td>�α��� �� �̿� �����մϴ�.</td>
													</tr>
												</c:when>
												<c:when test="${not empty member.memberDistinct}">
													<c:forEach var="noticeVO" items="${noticeVOList}" end="5">
														<tr>
															<td>${noticeVO.noticeNO}</td>

															<td><a href="/notice/detail?no=${noticeVO.noticeNO}">${noticeVO.noticeSubject}</a></td>

															<td>${noticeVO.noticeDate}</td>
															<td>${noticeVO.noticeNO}</td>
															<td>${noticeVO.noticeNO}</td>
														</tr>
													</c:forEach>
												</c:when>
											</c:choose>

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
										<c:choose>
											<c:when test="${member.memberDistinct eq 0}">
												<thead>
													<tr>
														<th>���¹�ȣ</th>
														<th>�����̸�</th>
														<th>����</th>
														<th>�����̸�</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="studentClassVO" items="${studentClassVOList}">
														<tr>
															<td>${studentClassVO.classNO}</td>
															<td>${studentClassVO.className}</td>
															<td>${studentClassVO.classCredit}</td>
															<td>${studentClassVO.MemberVO.memberName}</td>
														</tr>
													</c:forEach>
												</tbody>
												<tfoot>
													<tr>
														<a href="/student/studentShowClass">
															<button type="submit" class="btn mb-1 btn-primary ">�� ��������</button>
														</a>
													</tr>
												</tfoot>
											</c:when>
											<c:when test="${member.memberDistinct eq 1}">

												<thead>
													<tr>
														<th>���¹�ȣ</th>
														<th>�����̸�</th>
														<th>����</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="classVO" items="${classVOList}">
														<tr>
															<td>${classVO.classNO}</td>
															<td>${classVO.className}</td>
															<td>${classVO.classCredit}</td>
														</tr>
													</c:forEach>
												</tbody>
												<tfoot>
													<tr>
														<a href="/professor/professorShowMyclass?professorID=${member.memberNO}">
															<button type="submit" class="btn mb-1 btn-primary ">�� ��������</button>
														</a>
													</tr>
												</tfoot>

											</c:when>
											<c:when test="${member.memberDistinct eq 2}">
												<thead>
													<tr>
														<th>����ϱ�</th>

													</tr>
												</thead>
												<tbody>
													<tr>
														<td>�л� ����ϱ�</td>
														<td><a href="/admin/studentInsert">
																<button type="submit" class="btn mb-1 btn-primary ">�̵�</button>
														</a></td>

													</tr>

													<tr>
														<td>���� ����ϱ�</td>
														<td><a href="/admin/professorInsert">
																<button type="submit" class="btn mb-1 btn-primary ">�̵�</button>
														</a></td>

													</tr>
													<tr>
														<td>���� ����ϱ�</td>
														<td><a href="/admin/classInsert">
																<button type="submit" class="btn mb-1 btn-primary ">�̵�</button>
														</a></td>

													</tr>
													<tr>
														<td>�������� ����ϱ�</td>
														<td><a href="/admin/noticeInsert">
																<button type="submit" class="btn mb-1 btn-primary ">�̵�</button>
														</a></td>

													</tr>


												</tbody>
											</c:when>
											<c:when test="${empty member.memberDistinct}">
												<thead>
													<tr>
														<th>���� ���</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>�α��� �� �̿� �����մϴ�.</td>
													</tr>
												</tbody>
											</c:when>

										</c:choose>
									</table>
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