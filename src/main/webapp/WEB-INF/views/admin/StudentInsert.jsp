<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<jsp:include page="/incl/DeepHead.jsp" />

<title>StudentInsert</title>
<body>
	<jsp:include page="/incl/Header.jsp" />
	<jsp:include page="/incl/Sidebar.jsp" />
	<script>
		var message = "${message}";
		if (message != "") {
			alert(message);
		}
	</script>

	<div id="preloader">
		<div class="loader">
			<svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10" />
            </svg>
		</div>
	</div>

	<div id="main-wrapper">
		<div class="content-body">

			<div class="row page-titles mx-0">
				<div class="col p-md-0">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="javascript:void(0)">Dashboard</a></li>
						<li class="breadcrumb-item active"><a href="javascript:void(0)">Home</a></li>
					</ol>
				</div>
			</div>

			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<h4 class="card-title">학생 등록 페이지</h4>
								<br>
								<div class="basic-form">
									<form action="/admin/studentInsertCheck" id="studentInsertCheck" method="Post">
										<div class="form-row">
											<div class="form-group col-md-6">
												<label>학번</label> 
												<input type="text" class="form-control" id="memberNO" name="memberNO" placeholder="Student Number">
											</div>	
											<div class="form-group col-md-6">	
												<br><br>
												<p class="result">
												<button type="button" class="checkMemberNO btn mb-1 btn-primary btn-sm">중복확인</button>
	                                   			<span class="msg">중복확인을 해주세요.</span>
	                               				</p>
											</div>
										</div>	

											<%-- 이름
											<div class="form-group mb-5">
												<label class="label mb-0" for="userName">
												<h5>NAME</h5></label> 
												<input type="text" id="userName" class="form-control" onpaste="return false;" placeholder="이름(한글만 입력가능)" name="userName"
													onkeypress="koreanCheck()">
											</div>
 											--%>
 										<div class="form-row">	
											<div class="form-group col-md-6">
												<label>비밀번호</label> <input type="password" class="form-control" name="memberPassword" placeholder="Password">
											</div>
											<div class="form-group col-md-6">
												<label>이름</label> <input type="text" class="form-control" placeholder="이름을 입력하세요" name="memberName">
											</div>
											<div class="form-group col-md-6">
												<label>이메일</label> <input type="text" class="form-control" name="memberEmail" placeholder="이메일을 입력하세요">
											</div>
											<div class="form-group col-md-6">
												<label>핸드폰번호</label> <input type="text" class="form-control" name="memberPhoneNO" placeholder="핸드폰 번호를 입력하세요">
											</div>
											<div class="form-group col-md-6">
												<label>구분</label> <select id="inputState" class="form-control" name="memberDistinct">
													<option selected="selected">선택하세요</option>
													<option value="0">학생</option>
													<option value="1">교수</option>
												</select>
											</div>

										</div>
										<div class="form-group">
											<!-- 
												<div class="form-check">
															<input class="form-check-input" type="checkbox"> 
															<label class="form-check-label">Check me out</label>
												</div> 
											-->
										</div>
										<button class="btn mb-1 btn-primary btn-sm" onclick="return studentInsert();">학생 등록</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- container fluid -->
		</div>
		<!-- contentbody -->
	</div>
	<!-- mainwrapper -->
	<jsp:include page="/incl/DeepFooter.jsp" />

</body>

<script>
    $(".checkMemberNO").click(function () {
        var query = {memberNO: $("#memberNO").val()};
        
        $.ajax({
            url: "/admin/checkMemberNO",
            type: "post",
            data: query,
            success: function (data) {
                if (data == 1) {
                    $(".result .msg").text("사용불가");
                    $(".result .msg").attr("style", "color:#f00");
                    $("#submit").attr("disabled", "disabled");
                } else {
                    $(".result .msg").text("사용가능");
                    $(".result .msg").attr("style", "color:#00f");
                    $("#submit").removeAttr("disabled");
                }
            }
        });  // ajax ��
    });
    $("#memberNO").keyup(function () {
        $(".result .msg").text("중복확인을 해주세요");
        $(".result .msg").attr("style", "color:#000");
        $("#submit").attr("disabled", "disabled");
    });
</script>

</html>