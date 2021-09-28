<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<!--**********************************
            Sidebar start
        ***********************************-->
	<div class="nk-sidebar" style="background-color: rgb(150, 103, 243);">
		<div class="nk-nav-scroll">
			<ul class="metismenu" id="menu">
				<li class="nav-label" style="background-color: rgb(150, 103, 243); color: white; font-weight: bold ;">Quick Menu</li>
				<!-- 
				<li><a class="has-arrow" href="javascript:void()"
					aria-expanded="false"> <i class="icon-speedometer menu-icon"></i><span
						class="nav-text">학생</span>
				</a>
					<ul aria-expanded="false">
						<li><a href="/student/studentApplyClass">수강신청</a></li>
						<li><a href="/student/studentShowClass">내 수업보기</a></li>
						<li><a href="/student/studentShowScore">성적보기</a></li>
						<li><a href="/student/studentShowGrade">학점보기</a></li>
						
					</ul></li>
				<li class="mega-menu mega-menu-sm"><a class="has-arrow"
					href="javascript:void()" aria-expanded="false"> <i
						class="icon-globe-alt menu-icon"></i><span class="nav-text">Layouts</span>
				</a>
					<ul aria-expanded="false">
						<li><a href="/student/fileTemp">Blank</a></li>
						<li><a href="./layout-one-column.html">One Column</a></li>

					</ul></li>
				<li class="nav-label">Apps</li>
				<li><a class="has-arrow" href="javascript:void()"
					aria-expanded="false"> <i class="icon-envelope menu-icon"></i>
						<span class="nav-text">Email</span>
				</a>
					<ul aria-expanded="false">
						<li><a href="./email-inbox.html">Inbox</a></li>
						<li><a href="./email-read.html">Read</a></li>

					</ul></li>
				<li><a class="has-arrow" href="javascript:void()"
					aria-expanded="false"> <i class="icon-screen-tablet menu-icon"></i><span
						class="nav-text">Apps</span>
				</a>
					<ul aria-expanded="false">
						<li><a href="./app-profile.html">Profile</a></li>
						<li><a href="./app-calender.html">Calender</a></li>
					</ul></li>
-->

				<c:choose>

					<c:when test="${empty member}">
						<li style="background-color: rgb(150, 103, 243);"><a href="/checkLogin" aria-expanded="false"> <i
								class="icon-globe-alt menu-icon" style="color: white;"></i> <span class="nav-text" style="color: white; font-weight: bold ;">로그인
									후 이용가능 </span>
						</a></li>



					</c:when>
					<c:when test="${member.memberDistinct eq 0}">
						<li style="background-color: rgb(150, 103, 243);"><a href="javascript:void()" aria-expanded="false"> <i
								class="icon-globe-alt menu-icon" style="color: white;"></i> <span class="nav-text" style="color: white;">학생
							</span>
						</a></li>
						<ul aria-expanded="false"  style="background-color: rgb(150, 103, 243); color: white;">
							<li><a class="has-arrow" href="/notice" style="color: white;">공지사항</a></li>
							<li><a class="has-arrow" href="/student/studentApplyClass" style="color: white;">수강신청</a></li>
							<li><a class="has-arrow" href="/student/studentShowClass" style="color: white;">내
									수업보기</a></li>
							<li><a class="has-arrow" href="/student/studentShowScore" style="color: white;">성적보기</a></li>
							<li><a class="has-arrow" href="/student/studentShowGrade" style="color: white;">학점보기</a></li>

						</ul>
					</c:when>
					<c:when test="${member.memberDistinct eq 1}">
						<li style="background-color: rgb(150, 103, 243);"><a href="javascript:void()" aria-expanded="false"> <i
								class="icon-globe-alt menu-icon"></i> <span class="nav-text" style="color: white;">교수</span>
						</a></li>
						<ul aria-expanded="false" style="background-color: rgb(150, 103, 243); color: white;">
							<li><a class="has-arrow" href="/notice" style="color: white;">공지사항</a></li>
							<li><a class="has-arrow"
								href="/professor/professorShowMyclass?professorID=${member.memberNO}" style="color: white;">내
									수업보기</a></li>


						</ul>
					</c:when>
					<c:when test="${member.memberDistinct eq 2}">
						<li style="background-color: rgb(150, 103, 243);"><a href="javascript:void()" aria-expanded="false"> <i
								class="icon-globe-alt menu-icon"></i> <span class="nav-text" style="color: white;">관리자</span>
						</a></li>
						<ul aria-expanded="false" style="background-color: rgb(150, 103, 243); color: white;">
							<li><a class="has-arrow" href="/notice" style="color: white;">공지사항</a></li>
							<li><a class="has-arrow" href="/admin/studentInsert" style="color: white;">학생
									등록</a></li>
							<li><a class="has-arrow" href="/admin/professorInsert" style="color: white;">교수
									등록</a></li>
							<li><a class="has-arrow" href="/admin/classInsert" style="color: white;">수업 등록</a></li>
							<li><a class="has-arrow" href="/admin/noticeInsert" style="color: white;">공지사항
									등록</a></li>

						</ul>
					</c:when>
				</c:choose>

			</ul>
		</div>
	</div>
	<!--**********************************
            Sidebar end
        ***********************************-->

</body>
</html>