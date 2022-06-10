	function validateForm (form){
		if(form.title.value == "" || form.title.value.length==0){
			alert("제목을 입력하세요");
			form.title.focus();
			return false;
		}
		if(form.content.value == "" || form.content.value.length==0){
			alert("내용을 입력하세요");
			form.content.focus();
			return false;
		}
	}
