<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="header">
	<div class="logo">
		<img class="logoImg" src="../image/iu.jpg"/ onclick="location.href='../main/index.do'">
		<h3 style="font-family: 'Bebas Neue', cursive;">MINI PROJECT</h3>
	</div>
	<div class="navBar" >
		<c:if test="${sessionScope.memName==null }">
			<div class="navBarA">
				<a class="nav-link" href="../member/writeForm">회원가입</a><br>
			</div>
		</c:if>
		<c:if test="${sessionScope.memName!=null }">
			<div class="navBarA">
				<a class="nav-link" href="../member/logout">로그아웃</a><br>
			</div>
			<div class="navBarA">
				<a class="nav-link" href="../member/modifyForm">회원정보수정</a><br>
			</div>
			<div class="navBarA">
				<a class="nav-link" href="../board/boardWriteForm">글쓰기</a><br>
			</div>
		</c:if>
		<c:if test="${sessionScope.memId=='admin' }">
			<div class="navBarA">
				<a class="nav-link" href="../imageBoard/imageBoardWriteForm">이미지 등록</a>
			</div>
		</c:if>
		
		<div class="navBarA">
			<a class="nav-link" href="../board/boardList?pg=1">목록</a><br>
		</div>
		<div class="navBarA">
			<a class="nav-link" href="../imageBoard/imageBoardList?pg=1">이미지목록</a><br>
		</div>
	</div>
</div>
