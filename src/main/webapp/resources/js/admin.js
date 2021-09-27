
//student//////////////////////////////////////////////////////////////////////////////////////////////////

//학생 등록 버튼, 유효성 검사
function studentInsert() {

	if (!zbCheckPass) {
		alert('중복체크를 해주세요');
		$("#memberNO").focus(this).css("background-color","#CCE1FF");
		$("#memberNO").focus();
		$("#zbCheckPassButton").focus(this).css("background-color","#FF5675");
		$("#zbCheckPassButton").focus(this).css("border-color","#FF5675");
		return false;
	}
	
	//객체 string 변환
	var memberNOstr = $("#memberNO");
	var memberPasswordstr = $("#memberPassword");
	var memberNamestr = $("#memberName");
	var memberEmailstr = $("#memberEmail");
	var memberPhoneNOstr = $("#memberPhoneNO");
	
	//이름 정규식 
	var reg_memberName = /^[가-힣]{2,4}$/;
	//메일 정규식
	var reg_memberEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	//핸드폰 번호 정규식
	var reg_memberPhoneNO = /^\d{3}\d{3,4}\d{4}$/;
	
	if (memberNOstr.val() == '') {
		alert('학생번호를 입력해주세요');
		return false;
	}

	if (memberPasswordstr.val() == '') {
		alert('비밀번호를 입력해주세요');
		$("#memberPassword").focus(this).css("background-color","#EBFBFF");
		return false;
	}

	if (memberNamestr.val() == '') {
		alert('이름을 입력해주세요');
		$("#memberName").focus(this).css("background-color","#CCE1FF");
		$("#memberName").focus();
		return false;
	} else{
		$("#memberName").focus(this).css("background-color","white");
	}
	
	if (!reg_memberName.test(memberNamestr.val())) {
		alert('이름은 2~4자의 한글로 입력해주세요');
		$("#memberName").focus(this).css("background-color","#CCE1FF");
		$("#memberName").focus();
		return false;
	} else{
		$("#memberName").focus(this).css("background-color","white");
	}

	if (memberEmailstr.val() == '') {
		alert('이메일을 입력해주세요');
		$("#memberEmail").focus(this).css("background-color","#CCE1FF");
		$("#memberEmail").focus();
		return false;
	} else{
		$("#memberEmail").focus(this).css("background-color","white");
	}
	
	if (!reg_memberEmail.test(memberEmailstr.val())) {
		alert('이메일을 형식에 맞게 입력해주세요');
		$("#memberEmail").focus(this).css("background-color","#CCE1FF");
		$("#memberEmail").focus();
		return false;
	} else{
		$("#memberEmail").focus(this).css("background-color","white");
	}

	if (memberPhoneNOstr.val() == '') {
		alert('핸드폰 번호를 입력해주세요');
		$("#memberPhoneNO").focus(this).css("background-color","#CCE1FF");
		$("#memberPhoneNO").focus();
		return false;
	} else{
		$("#memberPhoneNO").focus(this).css("background-color","white");
	}
	
	if (!reg_memberPhoneNO.test(memberPhoneNOstr.val())) {
		alert('핸드폰 번호를 형식에 맞게 입력해주세요');
		$("#memberPhoneNO").focus(this).css("background-color","#CCE1FF");
		$("#memberPhoneNO").focus();
		return false;
	} else{
		$("#memberPhoneNO").focus(this).css("background-color","white");
	}

	if (!confirm("해당 정보로 학생을 등록 하시겠습니까?")) {
		return false;
	} else {
		document.getElementById('studentInsertCheck').submit();
	}
}

//professor///////////////////////////////////////////////////////////////////////////////////////////////////////

//교수 등록 버튼, 유효성 검사
function professorInsert() {

	if (!zbCheckPass) {
		alert('중복체크를 해주세요');
		$("#memberNO").focus(this).css("background-color","#CCE1FF");
		$("#memberNO").focus();
		$("#zbCheckPassButton").focus(this).css("background-color","#FF5675");
		$("#zbCheckPassButton").focus(this).css("border-color","#FF5675");
		return false;
	}
	
	//객체 string 변환
	var memberNOstr = $("#memberNO");
	var memberPasswordstr = $("#memberPassword");
	var memberNamestr = $("#memberName");
	var memberEmailstr = $("#memberEmail");
	var memberPhoneNOstr = $("#memberPhoneNO");
	
	//이름 정규식 
	var reg_memberName = /^[가-힣]{2,4}$/;
	//메일 정규식
	var reg_memberEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	//핸드폰 번호 정규식
	var reg_memberPhoneNO = /^\d{3}\d{3,4}\d{4}$/;
	
	if (memberNOstr.val() == '') {
		alert('교수번호를 입력해주세요');
		return false;
	}

	if (memberPasswordstr.val() == '') {
		alert('비밀번호를 입력해주세요');
		$("#memberPassword").focus(this).css("background-color","#EBFBFF");
		return false;
	}

	if (memberNamestr.val() == '') {
		alert('이름을 입력해주세요');
		$("#memberName").focus(this).css("background-color","#CCE1FF");
		$("#memberName").focus();
		return false;
	} else{
		$("#memberName").focus(this).css("background-color","white");
	}
	
	if (!reg_memberName.test(memberNamestr.val())) {
		alert('이름은 2~4자의 한글로 입력해주세요');
		$("#memberName").focus(this).css("background-color","#CCE1FF");
		$("#memberName").focus();
		return false;
	} else{
		$("#memberName").focus(this).css("background-color","white");
	}

	if (memberEmailstr.val() == '') {
		alert('이메일을 입력해주세요');
		$("#memberEmail").focus(this).css("background-color","#CCE1FF");
		$("#memberEmail").focus();
		return false;
	} else{
		$("#memberEmail").focus(this).css("background-color","white");
	}
	
	if (!reg_memberEmail.test(memberEmailstr.val())) {
		alert('이메일을 형식에 맞게 입력해주세요');
		$("#memberEmail").focus(this).css("background-color","#CCE1FF");
		$("#memberEmail").focus();
		return false;
	} else{
		$("#memberEmail").focus(this).css("background-color","white");
	}

	if (memberPhoneNOstr.val() == '') {
		alert('핸드폰 번호를 입력해주세요');
		$("#memberPhoneNO").focus(this).css("background-color","#CCE1FF");
		$("#memberPhoneNO").focus();
		return false;
	} else{
		$("#memberPhoneNO").focus(this).css("background-color","white");
	}
	
	if (!reg_memberPhoneNO.test(memberPhoneNOstr.val())) {
		alert('핸드폰 번호를 형식에 맞게 입력해주세요');
		$("#memberPhoneNO").focus(this).css("background-color","#CCE1FF");
		$("#memberPhoneNO").focus();
		return false;
	} else{
		$("#memberPhoneNO").focus(this).css("background-color","white");
	}

	if (!confirm("해당 정보로 교수를 등록 하시겠습니까?")) {
		return false;
	} else {
		document.getElementById('professorInsertCheck').submit();
	}
}

//class///////////////////////////////////////////////////////////////////////////////////////////////////////////

function classInsert() {
	
	//객체 string 변환
	var classNOstr = $("#classNO");
	var classNamestr = $("#className");
	var classGoalstr = $("#classGoal");
	var classSummarystr = $("#classSummary");
	var classPersonalstr = $("#classPersonal");
	var classCreditstr = $("#classCredit");
	var memberNOstr = $("#memberNO");
	
	if (classNOstr.val() == '') {
		alert('수업번호를 입력해주세요');
		return false;
	}
	
	if (classNamestr.val() == '') {
		alert('수업명을 입력해주세요');
		return false;
	}	

	if (classGoalstr.val() == '') {
		alert('수업목표를 입력해주세요');
		return false;
	}

	if (classSummarystr.val() == '') {
		alert('수업요약을 입력해주세요');
		return false;
	}

	if (classPersonalstr.val() == '') {
		alert('수업인원을 입력해주세요');
		return false;
	}

	if (classCreditstr.val() == '') {
		alert('수업학점을 입력해주세요');
		return false;
	}
	
	if (memberNOstr.val() == '') {
		alert('교수번호를 입력해주세요');
		return false;
	}

	if (!confirm("해당 정보로 수업을 등록 하시겠습니까?")) {
		return false;
	} else {
		document.getElementById('classInsertCheck').submit();
	}
}

//notice///////////////////////////////////////////////////////////////////////////////////////////////////////////

function noticeInsert() {
	
	//객체 string 변환
	var noticeSubjectstr = $("#noticeSubject");
	var noticeContentstr = $("#noticeContent");
	
	var reg_noticeSubject = /^.{5,20}$/     //모든 글자 5글자이상 20글자 이하
	var reg_noticeContent = /^.{10,500}$/     //모든 글자 10글자이상 20글자 이하
	
	if (noticeSubjectstr.val() == '') {
		alert('제목을 입력해주세요');
		return false;
	}
	
	if (!reg_noticeSubject.test(noticeSubjectstr.val())) {
		alert('제목은 5글자 이상, 20글자 이하로 입력해주세요');
		$("#noticeSubject").focus(this).css("background-color","#CCE1FF");
		$("#noticeSubject").focus();
		return false;
	} else{
		$("#noticeSubject").focus(this).css("background-color","white");
	}
	
	if (noticeContentstr.val() == '') {
		alert('공지사항 내용을 입력해주세요');
		return false;
	}
	
	if (!reg_noticeContent.test(noticeContentstr.val())) {
		alert('공지사항 내용은 10글자 이상, 500글자 이내로 입력해주세요');
		$("#noticeContent").focus(this).css("background-color","#CCE1FF");
		$("#noticeContent").focus();
		return false;
	} else{
		$("#noticeContent").focus(this).css("background-color","white");
	}

	if (!confirm("공지사항을 등록 하시겠습니까?")) {
		return false;
	} else {
		document.getElementById('noticeInsertCheck').submit();
	}
}
