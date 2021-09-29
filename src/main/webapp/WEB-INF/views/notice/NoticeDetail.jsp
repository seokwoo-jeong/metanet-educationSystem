<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<jsp:include page="/incl/DeepHead.jsp" />
<title>NoticeDetail</title>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function() {
	$.ajax({
		url : "/notice/getCommentsList",
		type : "get",
		data : {'noticeNO':${param.no}},
		success : function(resp) {
			var result='';
			$.each(resp, function(index, item) {
			result+='<div id=del'+item.commentNO+'>';
				result+='<div class="d-sm-flex justify-content-between mb-2">'+'<h5 class="mb-sm-0">';
				if (item.MEMBERDISTINCT == 0){
					result+=item.memberName+' (학생)'
				}else if(item.MEMBERDISTINCT == 1){
					result+=item.memberName+' (교수)'
				}else if(item.MEMBERDISTINCT == 2){
					result+=item.memberName+' (관리자)'
				}
				result+='<small class="text-muted ml-3">'+item.commentDate+'</small>'+'</h5>'+'<div class="media-reply__link">'+'<button class="btn btn-transparent p-0 mr-3"></button>';
				if(item.MEMBERNO == '${member.memberNO}'){
					result+='<button class="btn btn-transparent text-dark font-weight-bold p-0 ml-2" onclick="deleteComment('+item.commentNO+');">삭제</button>';
				}
				result+='</div>'+'</div>'+'<p>'+item.commentContent+'</p>'+'<hr>'+'</div>' 
			})
			$("#comment").html(result);
			$("#commentContent").val('');
		}
	})
})
	function insertComment(){
		if( !$("#commentContent").val() ){
			alert("댓글을 입력해주세요");
			$("#commentContent").focus();
			return false;
			}
			
		var formData = {
				'commentContent':$("#commentContent").val(),
				'noticeNO':${param.no},
				'memberNO':'${member.memberNO}'
				}

		$.ajax({
			url : "/notice/insertComment",
			type : "post",
			data : formData,
			success : function(resp) {
				var result='';
				$.each(resp, function(index, item) {
				result+='<div id=del'+item.commentNO+'>';
					result+='<div class="d-sm-flex justify-content-between mb-2">'+'<h5 class="mb-sm-0">';
					if (item.MEMBERDISTINCT == 0){
						result+=item.memberName+' (학생)'
					}else if(item.MEMBERDISTINCT == 1){
						result+=item.memberName+' (교수)'
					}else if(item.MEMBERDISTINCT == 2){
						result+=item.memberName+' (관리자)'
					}
					result+='<small class="text-muted ml-3">'+item.commentDate+'</small>'+'</h5>'+'<div class="media-reply__link">'+'<button class="btn btn-transparent p-0 mr-3"></button>';
					if(item.MEMBERNO == '${member.memberNO}'){
						result+='<button class="btn btn-transparent text-dark font-weight-bold p-0 ml-2" onclick="deleteComment('+item.commentNO+');">삭제</button>';
					}
					result+='</div>'+'</div>'+'<p>'+item.commentContent+'</p>'+'<hr>'+'</div>' 
				})
				$("#comment").html(result);
				$("#commentContent").val('');
			}
		})
	}
	function Enter_Check(){
	    if(event.keyCode == 13){
	    	insertComment(); 
	    }   
	}
	
    function deleteComment(commentNO){
    	if (!confirm("삭제 하시겠습니까??")) {
            return;
        }
    	$.ajax({
			url : "/notice/deleteComment",
			type : "post",
			data : {'commentNO':commentNO},
			success : function(resp) {
				if (resp=="success") {
	                $("#del"+commentNO).remove();
	                alert("댓글이 삭제되었습니다");
	            }
			}
		})
    }
    
    function deleteNotice(noticeNO){
    	if(!confirm("공지사항을 삭제하시겠습니까?")){
    		return false;
    	}else{
    		$("#deleteNotice").submit();
    	}
    }
</script>
</head>
<body>
	<div id="main-wrapper">
		<jsp:include page="/incl/Header.jsp" />
		<jsp:include page="/incl/Sidebar.jsp" />
		<div class="content-body">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<div class="read-content">
									<div class="media pt-5">
										<div class="media-body">
										<h4 class="m-0 text-primary">${noticeVO.noticeSubject}</h4>
											<c:if test="${member.memberDistinct eq 2}">
											<form id="deleteNotice" method="post" action="/notice/delete">
												<input type="hidden" id="noticeNO" name="noticeNO" value="${param.no}" /> <span class="float-right"><button class="btn btn-primary px-3 ml-4" onclick="deleteNotice()">삭제</button></span>
											</form>
											</c:if>
											<span class="float-right"><a href="/notice"><button class="btn btn-primary px-3 ml-4">목록</button></a></span>
										</div>
									</div>
									<hr>
									<div class="media mb-4 mt-1">
										<div class="media-body">
											<span class="float-right">${noticeVO.noticeDate}</span>
										</div>
									</div>
									${noticeVO.noticeContent }
									<hr>
									<h6 class="p-t-15">
										<i class="fa fa-download mb-2"></i> 첨부파일 <span>(${noticeFileList.size()})</span>
									</h6>
									<div class="row m-b-30">
										<c:forEach var="noticeFileList" items="${noticeFileList}">
											<div class="col-auto">
												<a href="/notice/downloadNoticeFile?fileNO=${noticeFileList.fileNO}&noticeNO=${noticeFileList.noticeNO}">${noticeFileList.originFileName}(${noticeFileList.fileSize} kb)</a>
											</div>
										</c:forEach>
									</div>
									<hr>

								</div>
								<div class="card-body">
									<div class="media media-reply">

										<div class="media-body" id="comment"></div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-12">
							<div class="card">
								<div class="card-body">
									<div class="form-group">
										<h4 class="m-0 text-primary">댓글 입력</h4>
										<br>
										<c:if test="${empty member}">
											<input type="text" class="form-control" name="commentContent" id="commentContent" placeholder="로그인이 필요한 기능입니다" readonly></input>
										</c:if>
										<c:if test="${!empty member}">
											<input type="text" class="form-control" name="commentContent" id="commentContent" placeholder="댓글을 입력해주세요" onkeydown="JavaScript:Enter_Check();"></input>
										</c:if>
									</div>
									<div class="form-group">
										<button class="btn btn-primary" onclick=insertComment();>입력</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
<jsp:include page="/incl/DeepFooter.jsp" />
</html>