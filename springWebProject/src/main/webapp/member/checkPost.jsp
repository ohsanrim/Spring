<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="member.bean.ZipcodeDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:requestEncoding value="UTF-8" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/member.css">
<!-- JQuery -->
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<form name="checkPostForm" id="checkPostForm"action="checkPost">
		<table class="checkPostTable">
			<tr>
				<th style="width: 100px;">시도</th>
				<th style="width: 100px;">
				<select style="width: 100px;" id="sido" name="sido">
						<option value="">직접입력</option>
						<option value="서울">서울</option>
						<option value="인천">인천</option>
						<option value="대전">대전</option>
						<option value="대구">대구</option>
						<option value="울산">울산</option>
						<option value="세종">세종</option>
						<option value="광주">광주</option>
						<option value="경기">경기</option>
						<option value="강원">강원</option>
						<option value="전남">전남</option>
						<option value="전북">전북</option>
						<option value="경남">경남</option>
						<option value="경북">경북</option>
						<option value="충남">충남</option>
						<option value="충북">충북</option>
						<option value="부산">부산</option>
						<option value="제주">제주</option>
				</select></th>
				<th style="width: 100px;">시.군.구</th>
				<th><input type="text" name="sigungu" id="sigungu"></th>
			</tr>
			<tr>
				<th style="width: 100px;">도로명</th>
				<th align="left" colspan="3"><input type="text" name="roadname" id="roadname"><input
					type="button" id="searchPostBtn" value="검색"></th>
			</tr>
		
	<tr>
		<th>우편번호</th>
		<th colspan='3'>주소</th>
	</tr>
	
	<tbody id="post"></tbody>
		</table>
	</form>
</body>
<Script type="text/javascript" src="../js/member.js?ver=3"></Script>
</html>