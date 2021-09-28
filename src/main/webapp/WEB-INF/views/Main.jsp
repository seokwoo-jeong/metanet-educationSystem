<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<head>
<jsp:include page="/incl/Head.jsp" />
<title>Main</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
window.onload = function() {
	if(${error}=="403")
		alert("권한이 없습니다");
	};
</script>
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
						<div class="col-lg-4 col-xl-3">
                        <div class="card">
                            <div class="card-body">
                                <div class="media align-items-center mb-4">
                                    <img class="mr-3" src="/resources/images/profile_sample.png" width="80" height="80" alt="">
                                    <div class="media-body">
                                        <h3 class="mb-0">${member.memberName}</h3>
                                        <p class="text-muted mb-0">${member.memberNO }</p>
                                    </div>
                                </div>
                                
                                <div class="row mb-3">
                                    <div class="col">
                                        <div class="card card-profile text-center">
                                            <span class="mb-1 text-primary"><i class="mdi mdi-file-document-box font-18 align-middle mr-2"></i>&nbsp;&nbsp;${studentClassCnt }&nbsp;개</span>
                                            <p class="text-muted px-3">내가 듣는 수업</p>
                                        </div>
                                    </div>
                                </div>
								<div class="row mb-3">
                                    <div class="col">
                                        <div class="card card-profile text-center">
                                            <span class="mb-1 text-primary"><i class="icon-people"></i>&nbsp;&nbsp;${getStudentInfo.studentSemester }&nbsp;학기</span>
                                            <p class="text-muted px-3">이수 학기</p>
                                        </div>
                                    </div>
                                </div>
                                <p class="text-muted"></p>
                                <ul class="card-profile__info">
                                    <li class="mb-1">&nbsp;<i class="fa fa-user"></i>&nbsp;&nbsp;&nbsp;<strong class="text-dark mr-4">Major&nbsp;&nbsp;</strong> <span>${getStudentInfo.studentMajor }</span></li>
                                    <li class="mb-1"><i class="fa fa-paper-plane"></i>&nbsp;&nbsp;<strong class="text-dark mr-4">Mobile</strong><span>${member.memberPhoneNO }</span></li>
                                    <li class="mb-1"><i class="fa fa-envelope gradient-4-text"></i>&nbsp;&nbsp;<strong class="text-dark mr-4">Email&nbsp;&nbsp;</strong> <span>${member.memberEmail }</span></li>
                                </ul>
                            </div>
                        </div>  
                    		</div>
				<div class="col-lg-8">
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
											<c:choose>
												<c:when test="${empty member.memberDistinct}">
													<tr>
														<td>로그인 후 이용 가능합니다.</td>
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

					<div class="card">
						<div class="card-body">
							<div class="active-member">
								<div class="table-responsive">
									<table class="table table-xs mb-0">
										<c:choose>
											<c:when test="${member.memberDistinct eq 0}">
												<thead>
													<tr>
														<th>강좌번호</th>
														<th>강좌이름</th>
														<th>학점</th>
														<th>교수이름</th>
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
															<button type="submit" class="btn mb-1 btn-primary ">내 수업보기</button>
														</a>
													</tr>
												</tfoot>
											</c:when>
											<c:when test="${member.memberDistinct eq 1}">

												<thead>
													<tr>
														<th>강좌번호</th>
														<th>강좌이름</th>
														<th>학점</th>
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
															<button type="submit" class="btn mb-1 btn-primary ">내 수업보기</button>
														</a>
													</tr>
												</tfoot>

											</c:when>
											<c:when test="${member.memberDistinct eq 2}">
												<thead>
													<tr>
														<th>등록하기</th>

													</tr>
												</thead>
												<tbody>
													<tr>
														<td>학생 등록하기</td>
														<td><a href="/admin/studentInsert">
																<button type="submit" class="btn mb-1 btn-primary ">이동</button>
														</a></td>

													</tr>

													<tr>
														<td>교수 등록하기</td>
														<td><a href="/admin/professorInsert">
																<button type="submit" class="btn mb-1 btn-primary ">이동</button>
														</a></td>

													</tr>
													<tr>
														<td>수업 등록하기</td>
														<td><a href="/admin/classInsert">
																<button type="submit" class="btn mb-1 btn-primary ">이동</button>
														</a></td>

													</tr>
													<tr>
														<td>공지사항 등록하기</td>
														<td><a href="/admin/noticeInsert">
																<button type="submit" class="btn mb-1 btn-primary ">이동</button>
														</a></td>

													</tr>


												</tbody>
											</c:when>
											<c:when test="${empty member.memberDistinct}">
												<thead>
													<tr>
														<th>수강 목록</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>로그인 후 이용 가능합니다.</td>
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