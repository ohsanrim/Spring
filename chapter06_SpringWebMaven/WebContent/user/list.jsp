<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
th{
width:100px;
}
</style>
</head>
<body>
<table id="table" border="1">
 <tr>
  <th width="100">이름</th>
  <th width="100">아이디</th>
  <th width="100">비밀번호</th>
 </tr> 
</table>
<br><br>

<div class="search">
	<select name="searchOption" id="searchOption">
		<option value="">선택
		<option value="name">이름
		<option value="id">아이디
	</select>
	<input type="text" id="searchText" name="searchText">
	<button id="searchBtn">검색</button>
</div>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		type: 'post',
		url: '/chapter06_SpringWebMaven/user/getUserList',
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			$.each(data.list, function(index, items){
				
				$('<tr/>').append($('<td/>',{
					align: 'center',
					text: items.name
				})).append($('<td/>',{
					align: 'center',
					text: items.id
				})).append($('<td/>',{
					align: 'center',
					text: items.pwd
				})).appendTo($('#table'));            
			});
		}
	});
});

$('#searchBtn').click(function(){
	$('#table').empty();
	$('<tr/>').append($('<th/>',{
		align: 'center',
		text: '이름'
	})).append($('<th/>',{
		align: 'center',
		text: '아이디'
	})).append($('<th/>',{
		align: 'center',
		text: '비밀번호'
	})).appendTo($('#table')); 
	
	
 	let searchOption=$('#searchOption').val();
	let searchText=$('#searchText').val();
	
	$.ajax({
		type: 'post',
		url: '/chapter06_SpringWebMaven/user/getSearchUserList',
		data:"searchOption="+searchOption+"&searchText="+searchText,
		/*data:JSON.stringify({
			'searchOption':$('#searchOption').val(),
			'searchText':$('#searchText').val()
		})*/
		contentType:'application/json;charset=UTF-8',
		dataType: 'json',
		success: function(data){
				$.each(data.list, function(index, items){
				$('<tr/>').append($('<td/>',{
					align: 'center',
					text: items.name
				})).append($('<td/>',{
					align: 'center',
					text: items.id
				})).append($('<td/>',{
					align: 'center',
					text: items.pwd
				})).appendTo($('#table'));            
			}); 
		}
	}); 
});
</script>
</body>
</html>









