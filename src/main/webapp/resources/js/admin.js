
//student//////////////////////////////////////////////////////////////////////////////////////////////////

/*
	memberName varchar2(10),
	memberPassword varchar2(30),
	memberEmail varchar2(30),
	memberPhoneNO varchar2(30),
	memberDistinct number(1),
	constraint pk_member primary key (memberNO)
);
*/

//학생 등록 버튼, 유효성 검사

function studentInsert() {

	if (!zbCheckPass) {
		alert('중복체크를 해주세요');
		$("#zbCheckPassButton").focus();
		return false;
	}

	var memberNOstr = $("#memberNO");
	var memberPasswordstr = $("#memberPassword");
	var memberNamestr = $("#memberName");
	var memberEmailstr = $("#memberEmail");
	var memberPhoneNOstr = $("#memberPhoneNO");
	
	var reg_memberName = /^[가-힣]{2,4}$/;

	if (memberNOstr.val() == '') {
		alert('학번을 입력해주세요');
		return false;
	}

	if (memberPasswordstr.val() == '') {
		alert('비밀번호를 입력해주세요');
		return false;
	}

	if (memberNamestr.val() == '') {
		alert('이름을 입력해주세요');
		return false;
	}
	
	if (!reg_memberName.test(memberNamestr.val())) {
		alert('이름은 2~4자의 한글로 입력해주세요');
		alert(memberNamestr.val());
		return false;
	}

	if (memberEmailstr.val() == '') {
		alert('이메일을 입력해주세요');
		return false;
	}

	if (memberPhoneNOstr.val() == '') {
		alert('핸드폰 번호를 입력해주세요');
		return false;
	}

	if (!confirm("해당 정보로 학생을 등록 하시겠습니까?")) {
		return false;
	} else {
		document.getElementById('studentInsertCheck').submit();
	}
}

//professor///////////////////////////////////////////////////////////////////////////////////////////////////////

function professorInsert() {
	if (!confirm("해당 정보로 교수를 등록 하시겠습니까?")) {
		return false;
	} else {
		document.getElementById('professorInsertCheck').submit();
	}
}

