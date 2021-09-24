<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<head>
<jsp:include page="/incl/DeepHead.jsp" />
<title>Main</title>
</head>


<body>

	<!--*******************
        Preloader start
    ********************-->
	<div id="main-wrapper">
		<jsp:include page="/incl/Header.jsp" />
		<jsp:include page="/incl/Sidebar.jsp" />
		<div class="content-body">
			<div class="container-fluid">
				<div class="d-flex justify-content-center">
					<div class="col-lg-8">
						<div class="card">
							<div class="card-body">
								
									<div class="read-content">
										<div class="media pt-5">
											<img class="mr-3 rounded-circle" src="images/avatar/1.jpg">
											<div class="media-body">
												<h5 class="m-b-3">공지사항 ${noticeVO.noticeNO}번</h5>
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
											<i class="fa fa-download mb-2"></i> 첨부파일 <span>(3)</span>
										</h6>
										<div class="row m-b-30">
											<div class="col-auto">
												<a href="#" class="text-muted">My-Photo.png</a>
											</div>
											<div class="col-auto">
												<a href="#" class="text-muted">My-File.docx</a>
											</div>
											<div class="col-auto">
												<a href="#" class="text-muted">My-Resume.pdf</a>
											</div>
										</div>
										<hr>
										<div class="form-group p-t-15">
											<textarea class="w-100 p-20 l-border-1" name="" id="" cols="30" rows="5" placeholder="It's really an amazing.I want to know more about it..!"></textarea>
										</div>
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