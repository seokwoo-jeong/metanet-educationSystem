<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 실패</h1>
	${param }
	memberNO = ${param.memberNO}
	memberPassword = ${param.memberPassword}
	errormsg = ${errormsgname}
</body>
</html>