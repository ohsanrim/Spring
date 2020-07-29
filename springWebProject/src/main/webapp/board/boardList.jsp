<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<h4>글 목록</h4><br>
	
	<input type="hidden" id="pg" value="${pg}">
		<table class="boardListTable" id="boardListTable" cellspacing="0" cellpadding="3" frame="hsides"
			rules="rows">
			<tr>
				<td class="listTh" style='width: 40px; font-size: 10px;' align='center'>글번호</td>
				<td class="listTh" style='width: 80px;' align='center'>아이디</tdh>
				<td class="listTh" style='width: 300px;' align='center'>제목</a></td>
				<td class="listTh" style='width: 100px;' align='center'>작성시간</td>
				<td class="listTh" style='width: 40px; font-size: 10px;' align='center'>조회수</td>
			</tr>
		</table>
		 <div id="boardPagingDiv" style="width: 650px; text-align: center;"></div>
<br>
		<form name="listForm" >
		<input type="hidden" name="pg" value="1">
		<div style="width: 600px; text-align: center; margin:10px;">
			<select id="searchOption" name="searchOption">
				<option value="제목">제목</option>
				<option value="작성자">작성자</option>
			</select> 
			 	<input type="search" name="keyword" id="keyword" value="${requestScope.keyword }">
			<input type="button" id="boardSearchBtn" value="검색" onclick="boardPaging(${pg})">
		</div>
</form>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="../js/member.js?ver=1"></script>
<Script src="../js/board.js?ver=1"></Script>
<script>
window.onload = function () {
 	if ("${searchOption }" != "") {
 		document.getElementById("searchOption").value = "${searchOption }";
 	}
 }
function boardPaging(pg){
	var keyword = document.getElementById("keyword").value;
	if(keyword == ""){
		location.href="boardList?pg="+pg;
	}else{
		//location.href="getBoardSearch?pg="+pg
		//	+"&searchOption=${searchOption}&keyword="+encodeURIComponent("${keyword}");
		
		$('input[name=pg]').val(pg);
		$('#boardSearchBtn').trigger('click');
	}
	
}
$(document).ready(function(){
	$.ajax({
		type : 'post',
		url : '/springWebProject/board/getBoardList',
		data: 'pg='+$('#pg').val(),
		dataType: 'json',
		success : function(data){
			//alert(JSON.stringify(data));
			
			$.each(data.list, function(index, items){
				$('<tr/>').append($('<td/>',{
					align: 'center',
					text: items.seq
				})).append($('<td/>',{
					align: 'center',
					text: items.id
				})).append($('<td/>',{
					align: 'center',
					text: items.subject
				})).append($('<td/>',{
					align: 'center',
					text: items.logtime
				})).append($('<td/>',{
					align: 'center',
					text: items.hit
				})).appendTo($('#boardListTable'));         
			});
			//페이징 처리
			$('#boardPagingDiv').html(data.boardPaging.pagingHTML);
		},
		error: function(err){
			console.log(err);
		}
	});
});
//검색
$('#boardSearchBtn').click(function(){
	if($('#keyword').val() == ''){
		alert('검색어를 입력하세요');
	}else{
		$.ajax({
			type : 'get',
			url : '/springWebProject/board/boardSearch',
			data: {'pg': $('input[name=pg]').val(),
				   'searchOption': $('#searchOption').val(),
				   'keyword': $('#keyword').val()},
			dataType: 'json',
			success : function(data){
				alert(JSON.stringify(data));
				
				$('#boardListTable tr:gt(0)').remove();
					
				$.each(data.list, function(index, items){
					$('<tr/>').append($('<td/>',{
						align: 'center',
						text: items.seq
					})).append($('<td/>',{
						align: 'center',
						text: items.id
					})).append($('<td/>',{
						align: 'center',
						text: items.subject
					})).append($('<td/>',{
						align: 'center',
						text: items.logtime
					})).append($('<td/>',{
						align: 'center',
						text: items.hit
					})).appendTo($('#boardListTable'));         
				}); //each
				
				//페이징 처리
				$('#boardPagingDiv').html(data.boardPaging.pagingHTML);
			
			},
			error: function(err){
				console.log(err);
			}
		});
	}
});



 /*
 function checkBoardLogin(seq,pg){
	 var memName = ${memName};
		if(memName==null) {
				alert("권한이 없습니다. 로그인을 먼저 해주세요!");
				location.href = "../main/index";
			} else {
				location.href = "boardView?seq=" + seq + "&pg=" + pg;
			}
	}
*/
</script>
