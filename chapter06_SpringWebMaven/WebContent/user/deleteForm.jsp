<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteForm.jsp</title>
</head>
<body>
  <form name="deleteForm">
  	<table>  	 
  	  <tr>
  	    <td>삭제할 아이디 입력 : 
  	  	    <input type="text" id="id">
  	  	    <input type="button" id="searchBtn" value="검색"><br><br>
  	  	    <div id="resultDiv"></div>
  	    </td>
  	  </tr>
    </table>
  </form>
  <script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script type="text/javascript">
  $('#searchBtn').click(function(){
	  $('#resultDiv').empty();
	  
	  if($('#id').val()==''){		
			$('#resultDiv').text('먼저 아이디를 입력하세요.');
			$('#resultDiv').css('font-size','10pt');
			$('#resultDiv').css('font-weight','bold');
			$('#resultDiv').css('color','red');
			
	  }else{
		  $.ajax({
			  type: 'post',
			  url: '/chapter06_SpringWebMaven/user/checkId',
			  data: 'id='+$('#id').val(),
			  dataType: 'text',
			  success: function(data){
				  if(data == '사용 가능'){
					  $('#resultDiv').text('삭제할 아이디가 존재하지 않습니다.');
					  $('#resultDiv').css('font-size','10pt');
					  $('#resultDiv').css('font-weight','bold');
					  $('#resultDiv').css('color','red');
					  
				  }else{
					  if(confirm('삭제할까요?'));
						  $.ajax({
							  type: 'post',
							  url: '/chapter06_SpringWebMaven/user/delete',
							  data: {'id': $('#id').val()},
							  success: function(){
								  alert('회원정보를 삭제하였습니다.');
								  location.href='/chapter06_SpringWebMaven/main/index';
							  },
							  error: function(){
							  }
						  });
					  }
				  }
			  },
			  error: function(err){
				  console.log(err);
			  }
		  });
	  }
  });
  </script> 
</body>
</html>














