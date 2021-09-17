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
								<h4 class="card-title">������û����Ʈ</h4>
								<div class="table-responsive">
									<table class="table table-striped table-bordered zero-configuration">
										<thead>
											<tr>
												<th>���¹�ȣ</th>
												<th>�����̸�</th>
												<th>�����ο�</th>
												<th>��ü�ο�</th>
												<th>����</th>
												<th>�����̸�</th>
												<th>������û</th>
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
													<td><button class="btn mb-1 btn-primary btn-sm">������û</button></td>
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
														<th>��������</th>
													</tr>
												</thead>
												<tbody>



													<tr>
														<td>static layout: Head, Header, Sidebar, Footer�� ����</td>
													</tr>
													<tr>
														<td>Head: css link</td>
													</tr>
													<tr>
														<td>Header: ��� layout</td>
													</tr>
													<tr>
														<td>Sidebar: ���� sidebar</td>
													</tr>
													<tr>
														<td>Footer: �� �ϴ� �Ͼ� �κ� + js(javascript)</td>
													</tr>
													<tr>
														<td>���ø� ���� �ȵ� ��: css, js, images, plugins etc... �տ� 'resources/' �ٿ��� ���ø� ���� ��</td>
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
														<th>������ȸ</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>�α���x : ���� ���� (ex-�α����ؼ� �̿�ٶ�..)</td>

													</tr>
													<tr>

														<td>�α��� ��: ���� ����Ʈ ���� + ��ư</td>
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