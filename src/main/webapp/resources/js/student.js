
function studentApplyClass(){
	if(!confirm("해당 과목을 수강 신청 하시겠습니까?")){
		return false;
	}else{
		document.getElementById('studentApplyClassCheck').submit();
	}
}

function studentDeleteClass(){
	if(!confirm("해당 과목을 삭제 하시겠습니까?")){
		return false;
	}else{
		document.getElementById('studentDeleteClass').submit();
	}
}
