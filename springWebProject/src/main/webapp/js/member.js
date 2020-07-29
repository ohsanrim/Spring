function checkWriteForm(){
	// -------------------회원가입 폼--------------------
	//checkIdOk.jsp 와 checkIdFail.jsp 안에 제이쿼리 링크 넣어줘야 실행됨
	//loginform의 id, pwd 와 writeForm의 id,pwd 가 충돌하는 문제 발생(pwd 값이 안읽혀짐)
	//때문에 writeForm의 pwd 부분에 id="writePwd" 값 추가
	let name=$('[name=writeForm] [name=name]').val();
	let id=$('[name=writeForm] [name=id]').val();
	let idCheck= $('[name=writeForm] [name=idcheck]').val();
	let pwd=$('[name=writeForm] #writePwd').val();
	let repwd=$('[name=writeForm] [name=repwd]').val();
	
	if(name==""){
		$('#nameValueCheck').text('이름을 입력해주세요');
	} else if( id =="" ){
		$('#idValueCheck').text('아이디를 입력해주세요');
	} else if( idCheck == "false" ){
		$('#idValueCheck').text('중복체크를 해주세요');
	} else if ( pwd == "") {
		$("#pwdValueCheck").text('비밀번호를 입력해주세요');
	}  else if ( repwd == "") {
		$("#repwdValueCheck").text('재확인비밀번호를 입력해주세요');
	} else if ( pwd != repwd ) {
		$("#repwdValueCheck").text('비밀번호가 일치하지 않습니다.');
	} else {
		$('[name=writeForm]').submit();
		//alert('로그인중');
	}
	
	//오류 메세지 제거
	if(name!="") $('#nameValueCheck').empty();
	if( id != "" && idCheck != "false" ) $('idValueCheck').empty();
	if( pwd != "" ) $("#pwdValueCheck").empty();
	if( repwd != "" && pwd ==repwd ) $("#repwdValueCheck").empty();
	
}
$('[name=writeForm] [name=id]').focusout(function(){
	let id=$('[name=writeForm] [name=id]').val();
	if(id ==''){
		  $('#idValueCheck').text("먼저 아이디를 입력하세요");
	      $('#idValueCheck').css('color','magenta');
	      $('#pwd').focus();
	} else {
		window.open("checkId.do?id="+id,"","width=300 height=100 location=yes");
	}
	
});
$('[name=checkPostForm] #searchPostBtn').click(function(){
	$.ajax({
		type: 'post',
		url: '/springWebProject/member/checkPostSearch',
		data: 'sido='+$('#sido').val()+'&sigungu='+$('#sigungu').val()+'&roadname='+$('#roadname').val(),
		dataType: 'json',
		success: function(data){
			let zipcode;
			let address;
			$.each(data.ziplist, function(index, post) {
				zipcode = post[0];
				address = post[1];
				address = address.replace(/null/g, '');
				
				$('<tr/>').append(
				$('<td/>', { align : 'center', text : zipcode })).append(
				$('<td/>', { colspan : 3 }).append(
				$('<a/>', {align : 'center', id : 'addressA', href : '#', text : address}))).appendTo('#post');
			});
			
			$('a').click(function() {
				//opener.document.getElementById("zipcode").value = $(this).parent().prev().text();
				//opener.document.getElementById("addr1").value = $(this).parent().text();
				//opener.document.getElementById("addr2").addr2.focus();
				$('#zipcode', opener.document).val($(this).parent().prev().text());
				$('#addr1', opener.document).val($(this).parent().text());
				$('#addr2', opener.document).focus();
				window.close();
			});
		},
		error: function(err){
			console.log(err);
		}
	});
    	/*$('#checkPostForm').submit();*/
});

function checkIdClose(id) {
	$('[name=writeForm] [name=idcheck]',opener.document).val("true");
	$('[name=writeForm] [name=id]',opener.document).val(id);
	opener.writeForm.pwd.focus();
	window.close();
}
function checkPost() {
	window.open("checkPost", "", "width=500 height=500 scrollbars=yes");
}

function changeId() {
	$('[name=writeForm] [name=idcheck]').val("false");
}

function checkPostClose(zipcode, address) {
	opener.document.getElementById("zipcode").value = zipcode;
	opener.document.getElementById("addr1").value = address;
	opener.document.getElementById("addr2").focus();
	window.close();
}
/*
function checkModifyForm() {
	alert('asdf');
	if (document.modifyForm.name.value == "") {
		alert("이름을 입력하세요.");
		document.modifyForm.name.focus();
	} else if (document.modifyForm.id.value == "") {
		alert("아이디를 입력하세요.");
		document.modifyForm.id.focus();
	} else if (document.modifyForm.pwd.value == "") {
		alert("비밀번호를 입력하세요.");
		document.modifyForm.pwd.focus();
	} else if (document.modifyForm.repwd.value == "") {
		alert("재확인비밀번호를 입력하세요.");
		document.modifyForm.repwd.focus();
	} else if (document.modifyForm.pwd.value != document.modifyForm.repwd.value) {
		alert("비밀번호가 일치하지 않습니다.");
		document.modifyForm.pwd.focus();
	} else {
		document.modifyForm.submit();
	}
}
*/
$('#modifyBtn').click(function(){
let name = $('[name=modifyForm] [name=name]').val();
let id = $('[name=modifyForm] [name=id]').val();
let pwd = $('[name=modifyForm] [name=pwd]').val();
let repwd = $('[name=modifyForm] [name=repwd]').val();
 	if (name =='') {
		alert("이름을 입력하세요.");
		document.modifyForm.name.focus();
	} else if (id =='') {
		alert("아이디를 입력하세요.");
		document.modifyForm.id.focus();
	} else if ( pwd =='') {
		alert("비밀번호를 입력하세요.");
		document.modifyForm.pwd.focus();
	} else if ( repwd =='') {
		alert("재확인비밀번호를 입력하세요.");
		document.modifyForm.repwd.focus();
	} else if (pwd != repwd) {
		alert("비밀번호가 일치하지 않습니다.");
		document.modifyForm.pwd.focus();
	} else {
		$('[name=modifyForm]').submit();
	}
});



  function checkLogin(){ 
		let id = $('[name=loginForm] [name=id]').val();
		let pwd = $('[name=loginForm] [name="pwd"]').val();

		if(id == "") {
			$('#idCheck').text('아이디를 입력해주세요');
		} else {
			$('#idCheck').empty();
		}
						
		if(pwd==""){
			$('#pwdCheck').text('비밀번호를 입력해주세요');
		} else {
			$('pwdCheck').empty();
		}
						
		if(id !="" && pwd != ""){
			$('[name=loginForm]').submit();
		}
  }
  
  function checkId(){
		let id=document.writeForm.id.value;
		if(id==""){
			alert("먼저 아이디를 입력해주세요")
		} else {
			window.open("checkId.do?id="+id,"","width=300 height=100 location=yes");
		}
	}
 