<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>

<body>
	<!-- Nav header start -->
	<div class="nav-header">
		<div class="brand-logo">
			<a href="/"> <b class="logo-abbr"><img src="${pageContext.request.contextPath }/resources/images/logo.png" alt=""> </b> <span class="brand-title"> <img src="${pageContext.request.contextPath }/resources/images/meta.png"
					width="200" height="50" alt="">
			</span>
			</a>
		</div>
	</div>
	<!-- Nav header end -->

	<!-- Header start -->
	<div class="header">
		<div class="header-content clearfix">
			<div class="header-left">
				<div class="input-group icons">
					 <h3 class="mb-0">
					<c:choose>
						<c:when test="${member.memberDistinct eq 0}"> ${member.memberName}(${member.memberNO}) 학생님, 안녕하세요.</c:when>
						<c:when test="${member.memberDistinct eq 1}"> ${member.memberName}(${member.memberNO}) 교수님, 안녕하세요.</c:when>
						<c:when test="${member.memberDistinct eq 2}"> ${member.memberName}(${member.memberNO}) 관리자님, 안녕하세요.</c:when>
					</c:choose>
					</h3>
					
				</div>
			</div>
			<div class="header-right">
				<div class="input-group icons">
				
				
					<div class="col-12 text-center">
						<c:if test="${empty member}">
							<a href="/checkLogin">
								<button class="btn login-form__btn submit w-70">login</button>
							</a>
						</c:if>
						<c:if test="${!empty member}">
							<form action="/doLogout" method="post">
								<button class="btn login-form__btn submit w-70">logout</button>
							</form>
						</c:if>
					</div>


				</div>
			</div>
		</div>
	</div>


</body>
</html>