<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title >회원가입</title>
<style>
#writeForm div{
font-size:8pt;
font-weight:bold;
color:red;
}
</style>
</head>
<body>
<div border="1">

<h4>회원가입</h4>
<br>
<form name="writeForm" id="writeForm" method="post" action="writeResult">
<table class="writeFormTable" border="1" >
		<tr>
			<td style="width:80px; height:30px;" align="center"><font color='red'>*</font>이 름</td>
			<td><input type="text" name='name' id="name" placeholder="이름입력"><div id="nameValueCheck"/></td>
		</tr>
		<tr>
		<td align="center"><font color='red'>*</font>아이디</td>
		<td ><input type="text" name='id' id="id" size="10" placeholder="아이디입력" onkeypress="changeId()">
		<!-- <input type="button" value="중복체크" onclick="checkId()"> --><div id="idValueCheck"/>
		<input type="hidden" name="idcheck" value="false" ></td>
		</tr>
		<tr>
		<td align="center" ><font color='red'>*</font>비밀번호</td>
		<td ><input type="password" name="pwd" id="writePwd" size="10"><div id="pwdValueCheck"/></td>
		</tr>
		<tr>
		<td align="center" ><font color='red'>*</font>재확인</td>
		<td ><input type="password" name='repwd' id="repwd" size="10"><div id="repwdValueCheck"/></td>
		</tr>
		<tr>
			<td align="center"style="height:30px;">성 별</td>
			<td>
			<input type='radio' name='gender' value="0" checked>남
			<input type='radio' name='gender' value="1">여
			</td>
		</tr>
		<tr>
            <td align="center">이 메 일</td>
            <td><input type="email" name="email1" size="7">@<input type="text" name="email2" list="defaultEmails"><datalist
                  id="defaultEmails">
                  <option value="naver.com">
                  <option value="gmail.com">
               </datalist></td>
         </tr>
		<tr>
		<td align="center" >핸드폰</td>
		<td>
		 <select name="tel1">
		  <option value="010">010</option>
		  <option value="010">011</option>
		 </select>-<input type="text" name="tel2" style="width:50px;">-<input type="text" name="tel3" style="width:50px;" >
		</td>
		</tr>
		<tr>
		<td>주소</td>
		<td>
		<input type="text" name="zipcode" id="zipcode" size="7" readonly>
		<input type="button" value="우편번호검색" onclick="checkPost()" ><br>
		<input type="text" name="addr1" id="addr1" style="width:350px;" placeholder="주소" readonly><br>
		<input type="text" name="addr2" id ="addr2" style="width:350px;" placeholder="나머지주소" >
		
		</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="회원가입" id="signUp" onClick="checkWriteForm()">
   				<input type="reset" value="다시작성">
   			</td>
		</tr>
	</table>
</form>
</div>
</body>

<script src="../js/member.js?ver=2"></script>

</html>