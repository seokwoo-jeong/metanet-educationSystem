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
			$("#syllabusClassNO").val(classNO);
			$("#syllabusClassName").val(className);
			$("#syllabusClassGoal").val(classGoal);
			$("#syllabusClassSummary").val(classSummary);
			$("#syllabusClassPersonnel").val(classPersonnel);
			$("#syllabusClassCredit").val(classCredit);
			$("#syllabusMemberName").val(memberName);
			$("#syllabusMemberEmail").val(memberEmail);
			$("#syllabusMemberPhoneNO").val(memberPhoneNO);
			$("#syllabusProfessorMajor").val(professorMajor);
			$("#syllabusProfessorRank").val(professorRank);
		}
	});
}