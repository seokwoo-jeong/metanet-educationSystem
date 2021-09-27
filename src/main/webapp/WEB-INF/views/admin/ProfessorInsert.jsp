<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<jsp:include page="/incl/DeepHead.jsp" />

<title>교수등록</title>
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
								<h4 class="card-title">교수 등록 페이지</h4>
								<br>
								<div class="basic-form">
									<form action="/admin/professorInsertCheck" id="professorInsertCheck" method="Post">
										<div class="form-row">
											<div class="form-group col-md-6">
												<label>교수번호</label> 
												<input type="text" class="form-control" id="memberNO" name="memberNO" placeholder="Professor Number">
											</div>	
											<div class="form-group col-md-6">	
												<br><br>
												<p class="result">
												<button type="button" id="zbCheckPassButton" class="checkMemberNO btn mb-1 btn-primary btn-sm">중복확인</button>
	                                   			<span class="msg">중복확인을 해주세요.</span>
	                               				</p>
											</div>
										</div>	

 										<div class="form-row">	
											<div class="form-group col-md-6">
												<label>비밀번호</label> 
												<input type="password" id="memberPassword" name="memberPassword" class="form-control" name="memberPassword" placeholder="Password">
											</div>
											<p>
										</div>	
											
										<div class="form-row">	
											<div class="form-group col-md-6">
												<label>이름</label> 
												<input type="text" id="memberName" name="memberName" class="form-control" placeholder="이름을 입력하세요" name="memberName">
												<p>
											</div>
										</div>
											
										<div class="form-row">	
											<div class="form-group col-md-6">
												<label>이메일</label> 
												<input type="text" id="memberEmail" name="memberEmail" class="form-control" name="memberEmail" placeholder="이메일을 입력하세요">
												<p>
											</div>
											<p>
										</div>
											
										<div class="form-row">	
											<div class="form-group col-md-6">
												<label>핸드폰번호</label> 
												<input type="text" id="memberPhoneNO" name="memberPhoneNO" class="form-control" name="memberPhoneNO" placeholder="핸드폰 번호를 입력하세요">
											</div>
											<p>
										</div>
										
										<div class="form-row">	
											<div class="form-group col-md-6">
												<label>구분</label>
												<select id="inputState" class="form-control" name="memberDistinct">
													<option selected="selected" value="1">교수</option>
												</select>
											</div>
										</div>
										
										<button class="btn mb-1 btn-primary btn-sm" onclick="return professorInsert();">교수 등록</button>
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
	var zbCheckPass = false; //중복 확인 여부
	var userIdCheck = RegExp(/[^0-9]$/);

	$(".checkMemberNO").click(function () {
        var query = {memberNO: $("#memberNO").val()};
        var a =$("#memberNO").val();
        
        //console.log($("#memberNO").val());
        if (userIdCheck.test($('#memberNO').val())){
        	$(".result .msg").text("교수번호는 숫자로만 입력할 수 있습니다.");
            $(".result .msg").attr("style", "color:#f00");
            $("#submit").attr("disabled", "disabled");
        }else if($("#memberNO").val() == ""){
        	$(".result .msg").text("교수번호를 입력해주세요.");
            $(".result .msg").attr("style", "color:#f00");
            $("#submit").attr("disabled", "disabled");
        }else if(a.length != 10){
        	$(".result .msg").text("교수번호는 10자리의 숫자로만 입력할 수 있습니다.");
            $(".result .msg").attr("style", "color:#f00");
            $("#submit").attr("disabled", "disabled");    
        } else {		
	        $.ajax({
	            url: "/admin/checkMemberNO",
	            type: "post",
	            data: query,
	            success: function (data) { 
	            	
	            	if (data == 1) { 
	                	zbCheckPass = false;
	                    $(".result .msg").text("이미 존재하는 교수번호입니다.");
	                    $(".result .msg").attr("style", "color:#f00");
	                    $("#submit").attr("disabled", "disabled");
	                } else {
	                	zbCheckPass = true;
	                    $(".result .msg").text("사용 가능한 교수번호입니다.");
	                    $(".result .msg").attr("style", "color:#00f");
	                    $("#submit").removeAttr("disabled");
	                    $("#zbCheckPassButton").focus(this).css("background-color","#7B68EE");
	                    $("#zbCheckPassButton").focus(this).css("border-color","#7B68EE");
	            		$("#memberNO").focus(this).css("background-color","white");
	                }
	            }
	        });
        }
    });
    $("#checkMemberNO").keyup(function () {
        $(".result .msg").text("중복확인을 해주세요");
        $(".result .msg").attr("style", "color:#000");
        $("#submit").attr("disabled", "disabled");
    });
</script>



</html>