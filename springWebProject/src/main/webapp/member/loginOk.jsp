<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <meta charset="UTF-8">

<div class="myInfo">
<img id="loginOk"class="rounded-circle" src="../image/IU23.gif" onclick="location.href='index.jsp'"><br>
${memName } 님이 로그인 하셨습니다.<br>
<input class="btn btn-outline-warning" type="button" value="로그아웃" onclick="location.href='/springProject/member/logout'">
<input class="btn btn-outline-warning" type="button" value="회원정보수정" onclick="location.href='/miniProject/member/modifyForm.do'">
</div> 
