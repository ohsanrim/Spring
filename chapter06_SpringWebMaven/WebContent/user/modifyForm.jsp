<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="modifyForm" id="modifyForm" method="post">
<table >
<tr>
<td>수정할 아이디 입력</td><td><input type="text" id="searchId"></td><td><input type="button" id="searchBtn" value="검색"></td>
</tr>
<tr>
<td><div id="resultDiv"></div></td>
</tr>
</table><br>
<table id="modifyTable">
<tr>
<td>이름</td><td><input type="text" id="name"></td>
<tr>
<tr>
<td>아이디</td><td><input type="text" id="id" readonly></td>
</tr>
<tr>
<td>비밀번호</td><td><input type="password" id="pwd"></td>
</tr>
<tr>
<td colspan="2"><input type="button" id="modifyBtn" value="수정"><input type="button" id="resetBtn" value="취소"></td>
</tr>
</table>
</form>

</body>
 <script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
 <script type="text/javascript">
 $(document).ready(function(){
	 $('#modifyTable').hide();
 });
 $('#searchBtn').click(function(){
	 if($('#searchId').val()==''){
		 $('#resultDiv').text('먼저 아이디를 입력해주세요!');
	 } else {
		  $.ajax({
			  type: 'post',
			  url: '/chapter06_SpringWebMaven/user/checkId',
			  data: 'id='+$('#searchId').val(),
			  dataType: 'text',
			  success: function(data){
				  if(data == '사용 가능'){
					  $('#resultDiv').text('아이디가 존재하지 않습니다.');
					  $('#resultDiv').css('font-size','10pt');
					  $('#resultDiv').css('font-weight','bold');
					  $('#resultDiv').css('color','red');
				  }else{
					  $('#modifyTable').show();
						$.ajax({
							type: 'post',

						url: '/chapter06_SpringWebMaven/user/getUserListOne',
							data:"id="+$('#searchId').val(),
							dataType: 'json',
							success: function(data){
								$.each(data, function(index, items){
									$('#name').val(items.name);
									$('#id').val(items.id);
								});
							}
						});
				  }
			  },
			  error: function(err){
				  console.log(err);
			  }
		  });
	 }
 });
 $('#modifyBtn').click(function(){
	if($('#name').val()==''){
		  $('#resultDiv').text('이름을 입력해주세요.');
		  $('#resultDiv').css('font-size','10pt');
		  $('#resultDiv').css('font-weight','bold');
		  $('#resultDiv').css('color','red');
	} else if($('#pwd').val()==''){
		  $('#resultDiv').text('비밀번호가 존재하지 않습니다.');
		  $('#resultDiv').css('font-size','10pt');
		  $('#resultDiv').css('font-weight','bold');
		  $('#resultDiv').css('color','red');
	} else{
		  $('#modifyTable').show();
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringWebMaven/user/modify',
				data:"id="+$('#id').val()+"&pwd="+$('#pwd').val()+"&name="+$('#name').val(),
				success: function(){
					alert("수정 완료");
				}
			});
	}
 });
 $('#resetBtn').click(function(){
	$('#pwd').val('');
	$('#searchBtn').trigger('click');  
 });
 
 </script>
</html>