<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<!--**********************************
            Sidebar start
        ***********************************-->
	<div class="nk-sidebar">
		<div class="nk-nav-scroll">
			<ul class="metismenu" id="menu">
				<li class="nav-label">Quick Menu</li>

				<c:choose>

					<c:when test="${empty member}">
						<li><a href="/checkLogin" aria-expanded="false"> <i class="icon-globe-alt menu-icon"></i> <span class="nav-text">로그인 후 이용가능 </span>
						</a></li>
					</c:when>
					<c:when test="${member.memberDistinct eq 0}">
						<li><a href="javascript:void()" aria-expanded="false"> <i class="icon-globe-alt menu-icon"></i> <span class="nav-text">학생 </span>
						</a></li>
						<ul aria-expanded="false">
							<li><a class="has-arrow" href="/notice">공지사항</a></li>
							<li><a class="has-arrow" href="/student/studentApplyClass">수강신청</a></li>
							<li><a class="has-arrow" href="/student/studentShowClass">내 수업보기</a></li>
							<li><a class="has-arrow" href="/student/studentShowScore">성적보기</a></li>
							<li><a class="has-arrow" href="/student/studentShowGrade">학점보기</a></li>
						</ul>
					</c:when>
					<c:when test="${member.memberDistinct eq 1}">
						<li><a href="javascript:void()" aria-expanded="false"> <i class="icon-globe-alt menu-icon"></i> <span class="nav-text">교수</span>
						</a></li>
						<ul aria-expanded="false">
							<li><a class="has-arrow" href="/notice">공지사항</a></li>
							<li><a class="has-arrow" href="/professor/professorShowMyclass?professorID=${member.memberNO}">내 수업보기</a></li>
						</ul>
					</c:when>
					<c:when test="${member.memberDistinct eq 2}">
						<li><a class="has-arrow" href="javascript:void()" aria-expanded="false"> <i class="icon-globe-alt menu-icon"></i><span class="nav-text">공지사항</span>
						</a>
							<ul aria-expanded="false">
								<li><a class="has-arrow" href="/notice">공지사항 보기</a></li>
								<li><a class="has-arrow" href="/admin/noticeInsert">공지사항 등록</a></li>

							</ul></li>

						<li><a class="has-arrow" href="javascript:void()" aria-expanded="false"> <i class="icon-globe-alt menu-icon"></i><span class="nav-text">수업</span>
						</a>
							<ul aria-expanded="false">
								<li><a class="has-arrow" href="/admin/classInsert">수업 등록</a></li>
								<li><a class="has-arrow" href="/admin/classPage">수업 목록</a></li>
							</ul></li>

						<li><a class="has-arrow" href="javascript:void()" aria-expanded="false"> <i class="icon-globe-alt menu-icon"></i><span class="nav-text">인원 등록</span>
						</a>
							<ul aria-expanded="false">
								<li><a class="has-arrow" href="/admin/studentInsert">학생 등록</a></li>
							<li><a class="has-arrow" href="/admin/professorInsert">교수 등록</a></li>
							</ul></li>
					</c:when>
				</c:choose>

			</ul>
		</div>
	</div>
</body>
</html>