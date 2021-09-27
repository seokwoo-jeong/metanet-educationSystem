<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<jsp:include page="/incl/DeepHead.jsp" />
<title>Main</title>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(document)
			.ready(
					function() {
						var noticeNO = $
						{
							param.no
						}
						var result = "";
						sendData = {
							"no" : noticeNO
						}
						console.log("doc들어옴");
						$
								.ajax({
									url : "/notice/getCommentsList",
									type : "get",
									data : sendData,
									success : function(resp) {
										console.log("success들어옴");
										$
												.each(
														resp,
														function(index, item) {
															result += '<div class="d-sm-flex justify-content-between mb-2"><h5 class="mb-sm-0">'
															result += item.memberNO
																	+ '<small class="text-muted ml-3">'
																	+ item.commentDate
																	+ '</small></h5>'
															result += '<div class="media-reply__link"><button class="btn btn-transparent p-0 mr-3"></button><button class="btn btn-transparent p-0 mr-3"><i class="fa fa-thumbs-down"></i></button><button class="btn btn-transparent text-dark font-weight-bold p-0 ml-2">Reply</button></div></div><p>여기에는 본문이 쓰일 예정입니다.여기에는 본문이 쓰일 예정입니다.여기에는 본문이 쓰일 예정입니다.여기에는 본문이 쓰일 예정입니다.여기에는 본문이 쓰일 예정입니다.</p><hr>'
															console.log(index);
															console.log(item);
															console.log(result);
														})
										console.log(result);
										$("#media-body").html(result)
									}
								})
					})
</script>
</head>


<body>

	<!--*******************
        Preloader start
    ********************-->
	<jsp:include page="/incl/Header.jsp" />
	<jsp:include page="/incl/Sidebar.jsp" />
	<div id="main-wrapper">
		<div class="content-body">
			<div class="container-fluid">
				<div class="d-flex justify-content-center">
					<div class="row">
						<div class="col-lg-12">
							<div class="card">
								<div class="card-body">

									<div class="read-content">
										<div class="media pt-5">
											<div class="media-body">
												<h5 class="m-b-3">공지사항 ${noticeVO.noticeNO}${param.no }번</h5>
												<p class="m-b-2">${noticeVO.noticeDate}</p>
											</div>

										</div>
										<hr>
										<div class="media mb-4 mt-1">
											<div class="media-body">
												<span class="float-right">${noticeVO.noticeDate}</span>
												<h4 class="m-0 text-primary">${noticeVO.noticeSubject}</h4>
											</div>
										</div>
										${noticeVO.noticeContent }
										<!-- 본문 부분 -->
										<!-- <h5 class="m-b-15">Hi,Ingredia,</h5>
										<p>
											<strong>Ingredia Nutrisha,</strong> A collection of textile samples lay spread out on the table - Samsa was a travelling salesman - and above it there hung a picture
										</p>
										<p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided
											to leave for the far World of Grammar.</p>
										<p>Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus
											viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus,
											tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar,</p>
										<h5 class="m-b-5 p-t-15">Kind Regards</h5>
										<p>Mr Smith</p> -->

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
							</div>
							<div class="card-body">
								<div class="media media-reply">
									<div class="media-body">

										<div class="d-sm-flex justify-content-between mb-2">
											<h5 class="mb-sm-0">
												댓글 작성자 이름 <small class="text-muted ml-3">날짜</small>
											</h5>
											<div class="media-reply__link">
												<button class="btn btn-transparent p-0 mr-3">
													<i class="fa fa-thumbs-up"></i>
												</button>
												<button class="btn btn-transparent p-0 mr-3">
													<i class="fa fa-thumbs-down"></i>
												</button>
												<button class="btn btn-transparent text-dark font-weight-bold p-0 ml-2">Reply</button>
											</div>
										</div>
										<p>여기에는 본문이 쓰일 예정입니다.여기에는 본문이 쓰일 예정입니다.여기에는 본문이 쓰일 예정입니다.여기에는 본문이 쓰일 예정입니다.여기에는 본문이 쓰일 예정입니다.</p>
										<hr>

										<div class="d-sm-flex justify-content-between mb-2">
											<h5 class="mb-sm-0">
												댓글 작성자 이름 <small class="text-muted ml-3">날짜</small>
											</h5>
											<div class="media-reply__link">
												<button class="btn btn-transparent p-0 mr-3">
													<i class="fa fa-thumbs-up"></i>
												</button>
												<button class="btn btn-transparent p-0 mr-3">
													<i class="fa fa-thumbs-down"></i>
												</button>
												<button class="btn btn-transparent text-dark font-weight-bold p-0 ml-2">Reply</button>
											</div>
										</div>
										<p>여기에는 본문이 쓰일 예정입니다.여기에는 본문이 쓰일 예정입니다.여기에는 본문이 쓰일 예정입니다.여기에는 본문이 쓰일 예정입니다.여기에는 본문이 쓰일 예정입니다.</p>
										<hr>

										<div class="media mt-3">
											<div class="media-body">
												<div class="d-sm-flex justify-content-between mb-2">
													<h5 class="mb-sm-0">
														Milan Gbah <small class="text-muted ml-3">about 3 days ago</small>
													</h5>
													<div class="media-reply__link">
														<button class="btn btn-transparent p-0 mr-3">
															<i class="fa fa-thumbs-up"></i>
														</button>
														<button class="btn btn-transparent p-0 mr-3">
															<i class="fa fa-thumbs-down"></i>
														</button>
														<button class="btn btn-transparent p-0 ml-3 font-weight-bold">Reply</button>
													</div>
												</div>
												<p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<form action="#" class="form-profile">
									<div class="form-group">
										<textarea class="form-control" name="textarea" id="textarea" cols="30" rows="2" placeholder="Post a new message"></textarea>
									</div>
									<div class="d-flex align-items-center">
										<ul class="mb-0 form-profile__icons">
											<li class="d-inline-block">
												<button class="btn btn-transparent p-0 mr-3">
													<i class="fa fa-user"></i>
												</button>
											</li>
											<li class="d-inline-block">
												<button class="btn btn-transparent p-0 mr-3">
													<i class="fa fa-paper-plane"></i>
												</button>
											</li>
											<li class="d-inline-block">
												<button class="btn btn-transparent p-0 mr-3">
													<i class="fa fa-camera"></i>
												</button>
											</li>
											<li class="d-inline-block">
												<button class="btn btn-transparent p-0 mr-3">
													<i class="fa fa-smile"></i>
												</button>
											</li>
										</ul>
										<button class="btn btn-primary px-3 ml-4">Send</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<jsp:include page="/incl/DeepFooter.jsp" />
</body>

</html>