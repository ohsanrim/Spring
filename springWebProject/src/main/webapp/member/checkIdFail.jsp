<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>
${requestScope.id} 아이디는 사용 불가능
<form name="checkId" method="post" action="checkId.do">
<table>
<tr>
<td>아이디</td>
<td><input type="text" name="id"></td>
<td><input type="submit" value="검색"></td>
</tr>
</table>
</form>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="../js/member.js?ver=1"></script>

