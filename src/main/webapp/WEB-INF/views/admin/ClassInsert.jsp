<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<jsp:include page="/incl/DeepHead.jsp" />

<title>수업등록</title>
<body>
	<jsp:include page="/incl/Header.jsp" />
	<jsp:include page="/incl/Sidebar.jsp" />
<body>

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
			<div class="row justify-content-center">
				<div class="col-lg-12">
					<div class="card">
						<div class="card-body">
							<div class="form-validation">
								<form action="/admin/classInsertCheck" id="classInsertCheck" method="Post">

									<div class="form-group row">
										<label class="col-lg-4 col-form-label">수업번호</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" id="classNO" name="classNO" placeholder="수업번호를 입력해주세요">
										</div>
									</div>

									<div class="form-group row">
										<label class="col-lg-4 col-form-label">수업명</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" id="className" name="className" placeholder="수업명을 입력해주세요">
										</div>
									</div>

									<div class="form-group row">
										<label class="col-lg-4 col-form-label">수업목표</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" id="classGoal" name="classGoal" placeholder="수업목표를 입력해주세요">
										</div>
									</div>

									<div class="form-group row">
										<label class="col-lg-4 col-form-label">수업요약</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" id="classSummary" name="classSummary" placeholder="수업요약을 입력해주세요">
										</div>
									</div>

									<div class="form-group row">
										<label class="col-lg-4 col-form-label">수업인원</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" id="classPersonnel" name="classPersonnel" placeholder="수업인원을 입력해주세요">
										</div>
									</div>

									<div class="form-group row">
										<label class="col-lg-4 col-form-label">수업학점</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" id="classCredit" name="classCredit" placeholder="수업학점을 입력해주세요">
										</div>
									</div>

									<div class="form-group row">
										<label class="col-lg-4 col-form-label">교수번호</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" id="memberNO" name="memberNO" placeholder="교수번호를 입력해주세요">
												<br><br>
												<p class="result">
												<button type="button" id="zbCheckPassButton" class="checkMemberNO btn mb-1 btn-primary btn-sm">교수번호 확인</button>
	                                   			<span class="msg">교수번호 확인을 해주세요.</span>
	                               				</p>
										</div>
									</div>

									<button class="btn mb-1 btn-primary btn-sm" onclick="return classInsert();">수업 등록</button>
									
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

<jsp:include page="/incl/DeepFooter.jsp" />

</body>

<script>
	var zbCheckPass = false; //중복 확인 여부
	var userIdCheck = RegExp(/[^0-9]$/);

	$(".checkClassNO").click(function () {
        var query = {classNO: $("#classNO").val()};
        var a =$("#classNO").val();
        
        //console.log($("#classNO").val());
        if (userIdCheck.test($('#classNO').val())){
        	$(".result .msg").text("학생번호는 숫자로만 입력할 수 있습니다.");
            $(".result .msg").attr("style", "color:#f00");
            $("#submit").attr("disabled", "disabled");
        }else if($("#classNO").val() == ""){
        	$(".result .msg").text("학생번호를 입력해주세요.");
            $(".result .msg").attr("style", "color:#f00");
            $("#submit").attr("disabled", "disabled");
        }else if(a.length != 10){
        	$(".result .msg").text("학생번호는 10자리의 숫자로만 입력할 수 있습니다.");
            $(".result .msg").attr("style", "color:#f00");
            $("#submit").attr("disabled", "disabled");    
        } else {		
	        $.ajax({
	            url: "/admin/checkClassNO",
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
	            		$("#classNO").focus(this).css("background-color","white");
	                }
	            }
	        });
        }
    });
    $("#checkClassNO").keyup(function () {
        $(".result .msg").text("중복확인을 해주세요");
        $(".result .msg").attr("style", "color:#000");
        $("#submit").attr("disabled", "disabled");
    });
</script>

</html>