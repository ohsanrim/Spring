<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>글쓰기</h4><br>
	<form name="boardForm" method="post" action="boardWrite">
		<table class="boardFormTable">
			<tr>
				<td class="tableHeader" style="width: 80px; height: 30px;" align="center"><font
					color='red'>*</font>제목</td>
				<td><input type="text" name="subject" id="subject"
					placeholder="제목 입력"></td>
			</tr>
			<tr>
				<td  class="tableHeader" style="width: 80px; height: 30px;" align="center"><font
					color='red'>*</font>내용</td>
				<td style="" word_wrap:break-word;  word-break:break-all;><textarea
						name="content" id="content" rows="12" cols="52"
						placeholder="내용을 입력"></textarea></td>
			</tr>
			</table>
			<div style="margin-top:10px;">
				<input class="btn btn-outline-warning" type="button" value="글작성"
					onclick="checkBoardWriteForm()"> &emsp; 
				<input class="btn btn-outline-warning" type="reset"
					value="다시작성"> &emsp; 
				<input class="btn btn-outline-warning" type="button" value="글목록"
					onclick="javascript:checkListForm()">
			</div>
	</form>
</body>
<!-- JQuery -->
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<Script src="../js/board.js?ver=2"></Script>
</html>