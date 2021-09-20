function studentApplyClass(){
	if(confirm("Would you like to apply for a course?") == true){
		document.getElementById('studentApplyClassCheck').submit();
	}else{
		return;
	}
}