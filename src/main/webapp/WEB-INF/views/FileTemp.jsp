<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form id="frm" name="frm" action="/student/insertNotice" method="post" enctype="multipart/form-data">
		<input type="file" id="files" name="files" multiple="multiple"> <input type="submit" id="submit" value="저장" class="btn">


	<input type="text">
	<input type="text">
	<input type = "text">
	
	</form>
	<table>
	
		<c:forEach var="fileList" items="${fileList}">
		
			<a href="/student/downloadNoticeFile?fileNO=${fileList.fileNO}&noticeNO=${fileList.noticeNO}">${fileList.originFileName}(${fileList.fileSize} kb)</a>
		<th>
		</c:forEach>
	
	
	</table>
</body>
</html>