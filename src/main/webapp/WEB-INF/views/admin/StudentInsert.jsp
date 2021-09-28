<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<jsp:include page="/incl/DeepHead.jsp" />

<title>학생등록</title>
<body>
	<jsp:include page="/incl/Header.jsp" />
	<jsp:include page="/incl/Sidebar.jsp" />
	<script>
		var message = "${message}";
		if (message != "") {
			alert(message);
		}
	</script>
	<div id="main-wrapper">
		<div class="content-body">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<h4 class="card-title">학생 등록</h4>
								<br>
								<div class="basic-form">
									<form action="/admin/studentInsertCheck" id="studentInsertCheck" method="Post">
										 <input type="hidden" id="memberDistinct" name="memberDistinct" value="0">
										<div class="form-row">
											<div class="form-group col-md-6">
												<label>학생번호</label> 
												<input type="text" class="form-control" id="memberNO" name="memberNO" placeholder="Student Number">
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
												<input type="password" id="memberPassword" name="memberPassword" class="form-control"  placeholder="Password">	
											</div>
										</div>	
											
										<div class="form-row">	
											<div class="form-group col-md-6">
												<label>이름</label> 
												<input type="text" id="memberName" name="memberName" class="form-control" placeholder="이름을 입력하세요">
												
											</div>
										</div>
										
										<div class="form-row">	
											<div class="form-group col-md-6">
												<label>이메일</label> 
												<input type="text" id="memberEmail" name="memberEmail" class="form-control" placeholder="이메일을 입력하세요">
												<p>
											</div>
										</div>
										
										<div class="form-row">
											<div class="form-group col-md-6">
												<label>핸드폰번호</label> 
												<input type="text" id="memberPhoneNO" name="memberPhoneNO" class="form-control"  placeholder="핸드폰 번호를 입력하세요">
												<p>
											</div>
										</div>
										
										<div class="form-row">
											<div class="form-group col-md-6">
												<label>전공</label> 
												<input type="text" id="studentMajor" name="studentMajor" class="form-control"  placeholder="전공을 입력하세요">
												<p>
											</div>
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
	var zbCheckPass = false; //중복 확인 여부
	var userIdCheck = RegExp(/[^0-9]$/);

	$(".checkMemberNO").click(function () {
        var query = {memberNO: $("#memberNO").val()};
        var a =$("#memberNO").val();
        
        //console.log($("#memberNO").val());
        if (userIdCheck.test($('#memberNO').val())){
        	$(".result .msg").text("학생번호는 숫자로만 입력할 수 있습니다.");
            $(".result .msg").attr("style", "color:#f00");
            $("#submit").attr("disabled", "disabled");
        }else if($("#memberNO").val() == ""){
        	$(".result .msg").text("학생번호를 입력해주세요.");
            $(".result .msg").attr("style", "color:#f00");
            $("#submit").attr("disabled", "disabled");
        }else if(a.length != 10){
        	$(".result .msg").text("학생번호는 10자리의 숫자로만 입력할 수 있습니다.");
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
	                    $(".result .msg").text("이미 존재하는 학생번호입니다.");
	                    $(".result .msg").attr("style", "color:#f00");
	                    $("#submit").attr("disabled", "disabled");
	                } else {
	                	zbCheckPass = true;
	                    $(".result .msg").text("사용 가능한 학생번호입니다.");
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