<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<jsp:include page="/incl/DeepHead.jsp" />

<title>NoticeInsert</title>
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
								<form action="/admin/noticeInsertCheck" id="noticeInsertCheck" method="post" enctype="multipart/form-data">

									<input type="text" id="noticeSubject" name="noticeSubject" class="form-control mt-4 mb-2" placeholder="제목을 입력해주세요." required>

									<div class="form-group">
										<textarea class="form-control" rows="10" id="noticeContent" name="noticeContent" placeholder="내용을 입력해주세요" required></textarea>
									</div>

									<div class="form-group">

										<div class="fallback">
											<input class="l-border-1" id="files" name="files" type="file" multiple="multiple">
										</div>
									</div>

									<button class="btn mb-1 btn-primary btn-sm" onclick="return noticeInsert();">공지사항 등록</button>

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

	$(".checkClassNO").click(
			function() {
				var query = {
					classNO : $("#classNO").val()
				};
				var a = $("#classNO").val();

				//console.log($("#classNO").val());
				if (userIdCheck.test($('#classNO').val())) {
					$(".result .msg").text("학생번호는 숫자로만 입력할 수 있습니다.");
					$(".result .msg").attr("style", "color:#f00");
					$("#submit").attr("disabled", "disabled");
				} else if ($("#classNO").val() == "") {
					$(".result .msg").text("학생번호를 입력해주세요.");
					$(".result .msg").attr("style", "color:#f00");
					$("#submit").attr("disabled", "disabled");
				} else if (a.length != 10) {
					$(".result .msg").text("학생번호는 10자리의 숫자로만 입력할 수 있습니다.");
					$(".result .msg").attr("style", "color:#f00");
					$("#submit").attr("disabled", "disabled");
				} else {
					$.ajax({
						url : "/admin/checkClassNO",
						type : "post",
						data : query,
						success : function(data) {

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
								$("#zbCheckPassButton").focus(this).css(
										"background-color", "#7B68EE");
								$("#zbCheckPassButton").focus(this).css(
										"border-color", "#7B68EE");
								$("#classNO").focus(this).css(
										"background-color", "white");
							}
						}
					});
				}
			});
	$("#checkClassNO").keyup(function() {
		$(".result .msg").text("중복확인을 해주세요");
		$(".result .msg").attr("style", "color:#000");
		$("#submit").attr("disabled", "disabled");
	});
</script>

</html>