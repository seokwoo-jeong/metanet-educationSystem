<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<body>
	<!-- Nav header start -->
	<div class="nav-header">

		<div class="brand-logo" style="background-color: rgb(150, 103, 243);">
			<a href="/"> <b class="logo-abbr"><img src="${pageContext.request.contextPath }/resources/images/logo.png" alt=""> </b> <span class="brand-title"> <img
					src="${pageContext.request.contextPath }/resources/images/meta2.png" width="200" height="50" alt="">
			</span>
			</a>
		</div>
	</div>
	<!-- Nav header end -->

	<!-- Header start -->
	<div class="header">
		<div class="header-content clearfix">
			<div class="header-right">
				<div class="input-group icons">
					<c:choose>
						<c:when test="${member.memberDistinct eq 0}">
							<h3 class="mb-0">${member.memberName}학생님&nbsp;&nbsp;</h3>
							<h5 class="mb-0">(${member.memberNO})</h5>
						</c:when>
						<c:when test="${member.memberDistinct eq 1}">
							<h3 class="mb-0">${member.memberName}교수님&nbsp;&nbsp;</h3>
							<h5 class="mb-0">(${member.memberNO})</h5>
						</c:when>
						<c:when test="${member.memberDistinct eq 2}">
							<h3 class="mb-0">${member.memberName}관리자님&nbsp;&nbsp;</h3>
							<h5 class="mb-0">(${member.memberNO})</h5>
						</c:when>
					</c:choose>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
<%-- 					<c:if test="${empty member}">
						<a href="/checkLogin">
							<button class="btn login-form__btn submit w-70">로그인</button>

						</a>
					</c:if> --%>
					<c:if test="${!empty member}">
						<form action="/doLogout" method="post">
							<button class="btn login-form__btn submit w-70">
							로그아웃</button>
						</form>
					</c:if>
				</div>
			</div>
		</div>
	</div>


</body>
</html>