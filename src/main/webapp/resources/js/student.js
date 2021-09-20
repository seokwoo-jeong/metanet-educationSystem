
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

function getClassSyllabus(classNO){
	var query = {classNO: classNO};
	
	$.ajax({
		url: "/student/getClassSyllabus",
		type : "post",
		data: query,
		success : function(data){
			var classNO = data.classNO;
			var className = data.className;
			var classGoal = data.classGoal;
			var classSummary = data.classSummary;
			var classPersonnel = data.classPersonnel;
			var classCredit = data.classCredit;
			var memberName = data.MemberVO.memberName;
			var memberEmail = data.MemberVO.memberEmail;
			var memberPhoneNO = data.MemberVO.memberPhoneNO;
			var professorMajor = data.ProfessorVO.professorMajor;
			var professorRank = data.ProfessorVO.professorRank;
			$("#classNO").val(classNO);
			$("#className").val(className);
			$("#classGoal").val(classGoal);
			$("#classSummary").val(classSummary);
			$("#classPersonnel").val(classPersonnel);
			$("#classCredit").val(classCredit);
			$("#memberName").val(memberName);
			$("#memberEmail").val(memberEmail);
			$("#memberPhoneNO").val(memberPhoneNO);
			$("#professorMajor").val(professorMajor);
			$("#professorRank").val(professorRank);
			
		}
	});
}