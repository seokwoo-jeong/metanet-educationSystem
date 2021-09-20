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
											<tr>
												<td>header, footer, sidebar ��Ȯ�ϰ� �����ؼ� incl ���Ϸ� �̵�</td>
											</tr>
											<tr>
												<td>head�� import �����ؼ� incl�� �̵� (header�� �־�� �ϳ�?...)</td>
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
	<jsp:include page="/incl/Footer.jsp" />
</body>
</html>