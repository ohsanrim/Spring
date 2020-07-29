<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="google-signin-client_id" content="100669600759-q3shl0dlfs9admc4lsg3as00e4do86g9.apps.googleusercontent.com">
<title>miniProject</title>
<link rel="stylesheet" href="../css/member.css">
<!-- 구글 연동 로그인 -->
<script src="https://apis.google.com/js/platform.js" async defer></script>

<!-- JQuery -->
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>

<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<!--Font Awesome-->
<script src="https://kit.fontawesome.com/6c7d966087.js" crossorigin="anonymous"></script>

<!--GoogleFont-->
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Gamja+Flower&display=swap" rel="stylesheet">

</head>
<body>
<table class="mainTable" cellspacing="0" width="100%" >
<tr>
<th class="indexHeader" colspan="2" align="center" style="height:100px; padding:0px auto;">
<jsp:include page="../template/top.jsp"></jsp:include>
</th>

</tr>
<tr>
<td class="indexLeft" align="center" style="width:300px;px; height:500px;" valign=top>
<c:if test="${memId==null }">
<c:choose>
<c:when test="${loginCheckTry==null}"><jsp:include page="../member/loginForm.jsp"></jsp:include><c:set var="loginCheckTry" value="true"/></c:when>
<c:otherwise><c:set var="loginCheckTry" value="false"/><jsp:include page="../member/loginFail.jsp"></jsp:include></c:otherwise>
</c:choose>
</c:if>
<c:if test="${memId!=null }"><jsp:include page="../member/loginOk.jsp"></jsp:include></c:if>
</td> 

<td class="indexCenter" align="center">
<jsp:include page="${display }"/> 
</td>

</tr>
<tr>
<td colspan="2" align="center" style="height:50px;">
<jsp:include page="../template/bottom.jsp"></jsp:include>
</td>
</tr>
</table>
</body>
<script>
$(window).on("scroll",function(){
	  if($(window).scrollTop()){
	    $('th.indexHeader').addClass('black');
	    $('div.navBarA a').addClass('black');
	  } else {
	    $('th.indexHeader').removeClass('black');
	    $('div.navBarA a').removeClass('black');
	  }
});
function onSignIn(googleUser) {
	  var profile = googleUser.getBasicProfile();
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
	  location.href="../member/login.do?id="+profile.getId()+"&name="+profile.getName()+"&Image URL="+profile.getImageUrl()+"&email="+profile.getEmail();
	}
</script>
</html>