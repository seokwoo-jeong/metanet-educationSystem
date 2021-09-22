
//student//////////////////////////////////////////////////////////////////////////////////////////////////

//학생 등록 버튼, 유효성 검사
function studentInsert(){
	
	/*
	memberName varchar2(10),
	memberPassword varchar2(30),
	memberEmail varchar2(30),
	memberPhoneNO varchar2(30),
	memberDistinct number(1),
	constraint pk_member primary key (memberNO)
);
	*/
	
	var memberNOstr = document.getElementById('memberNO');

	if( memberNOstr.value == '' || memberNOstr.value == null ){
	    alert( '학번을 입력해주세요' );
	    return false;
	}
	
	//'빈칸을 채우시오' 학번까지 완료 
	//비밀번호 ~ 작업 중
/*	var memberPasswordstr = document.getElementById('memberPassword');

	if( memberPasswordstr.value == '' || memberPasswordstr.value == null ){
	    alert( '비밀번호를 입력해주세요' );
	    return false;
	}*/ 
	
		
	if(!confirm("해당 정보로 학생을 등록 하시겠습니까?")){
		return false;
	}else{
		document.getElementById('studentInsertCheck').submit();
	}
	
	
}

//professor///////////////////////////////////////////////////////////////////////////////////////////////////////

function professorInsert(){
	if(!confirm("해당 정보로 교수를 등록 하시겠습니까?")){
		return false;
	}else{
		document.getElementById('professorInsertCheck').submit();
	}
}	

