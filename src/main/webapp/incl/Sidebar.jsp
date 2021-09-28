<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<!--**********************************
            Sidebar start
        ***********************************-->
	<div class="nk-sidebar" style="background-color: rgb(150, 103, 243); color: white;">
		<div class="nk-nav-scroll">
			<ul class="metismenu" id="menu">
				<li class="nav-label" style="background-color: rgb(150, 103, 243); color: white;">Quick Menu</li>

				<c:choose>

					<c:when test="${empty member}">
						<li style="background-color: rgb(202, 176, 253); color: white"><a href="/checkLogin"> <i class="icon-globe-alt menu-icon" style="color: white;"></i> <span class="nav-text" style="color: white;">로그인 후 이용가능 </span>
						</a></li>
					</c:when>
					<c:when test="${member.memberDistinct eq 0}">
						<li style="background-color: rgb(202, 176, 253); color: white;"><a href="javascript:void()"> 
						<i class="icon-globe-alt menu-icon" style="color: white;">
						</i> 
						<span class="nav-text" style="color: white;">학생 </span>
						</a></li>
						<ul>
							<li><a class="has-arrow" href="/notice" style="background-color: rgb(150, 103, 243); color: white;">공지사항</a></li>
							<li><a class="has-arrow" href="/student/studentApplyClass" style="background-color: rgb(150, 103, 243); color: white;">수강신청</a></li>
							<li><a class="has-arrow" href="/student/studentShowClass" style="background-color: rgb(150, 103, 243); color: white;">내 수업보기</a></li>
							<li><a class="has-arrow" href="/student/studentShowScore" style="background-color: rgb(150, 103, 243); color: white;">성적보기</a></li>
							<li><a class="has-arrow" href="/student/studentShowGrade" style="background-color: rgb(150, 103, 243); color: white;">학점보기</a></li>
						</ul>
					</c:when>
					<c:when test="${member.memberDistinct eq 1}">
						<li style="background-color: rgb(202, 176, 253); color: white">
						<a href="javascript:void()"  > <i class="icon-globe-alt menu-icon" style="color: white;"></i> <span class="nav-text" style="color: white;">교수</span>
						</a></li>
						<ul style="background-color: rgb(150, 103, 243);">
							<li><a class="has-arrow" href="/notice" style="background-color: rgb(150, 103, 243); color: white;">공지사항</a></li>
							<li><a class="has-arrow" href="/professor/professorShowMyclass?professorID=${member.memberNO}" style="background-color: rgb(150, 103, 243); color: white;">내 수업보기</a></li>
						</ul>
					</c:when>
					<c:when test="${member.memberDistinct eq 2}">
						<li style="background-color: rgb(150, 103, 243);">
						<a class="has-arrow" href="javascript:void()" style="background-color: rgb(202, 176, 253); color: white"> 
						<i class="icon-globe-alt menu-icon" style="color: white;">
						</i>
						<span class="nav-text" style="color: white;">공지사항</span>
						</a></li>
							<ul style="background-color: rgb(150, 103, 243);">
								<li><a class="has-arrow" href="/notice" style="background-color: rgb(150, 103, 243); color: white;">공지사항 보기</a></li>
								<li><a class="has-arrow" href="/admin/noticeInsert"  style="background-color: rgb(150, 103, 243); color: white;">공지사항 등록</a></li>

							</ul>

						<li style="background-color: rgb(150, 103, 243);">
						<a class="has-arrow" href="javascript:void()" style="background-color: rgb(202, 176, 253); color: white"> 
						<i class="icon-globe-alt menu-icon" style="color: white;">
						</i>
						<span class="nav-text" style="color: white">수업</span>
						</a></li>
							<ul style="background-color: rgb(150, 103, 243);">
								<li><a class="has-arrow" href="/admin/classInsert" style="color: white;">수업 등록</a></li>
								<li><a class="has-arrow" href="/admin/classPage" style="color: white;">수업 목록</a></li>
							</ul>

						<li style="background-color: rgb(150, 103, 243);">
						<a class="has-arrow" href="javascript:void()" style="background-color: rgb(202, 176, 253); color: white"> 
						<i class="icon-globe-alt menu-icon" style="color: white;"></i>
						<span class="nav-text" style="color: white;">인원 등록</span>
						</a></li>
							<ul style="background-color: rgb(150, 103, 243);">
								<li><a class="has-arrow" href="/admin/studentInsert" style="color: white;">학생 등록</a></li>
							<li><a class="has-arrow" href="/admin/professorInsert" style="color: white;">교수 등록</a></li>
							</ul>
					</c:when>
				</c:choose>

			</ul>
		</div>
	</div>
</body>
</html>