
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<meta charset="UTF-8">
<body>
	<div  border="1">
		<h4>회원정보수정</h4><br>
		<form name="modifyForm"  method="post" action="modify">
			<table class="modifyFormTable">
				<tr>
					<td class="tableHeader" style="width: 80px; height: 30px;" align="center"><font
						color='red'>*</font>이 름</td>
					<td><input type="text" name='name' value="${memberDTO.getName() }" ></td>
				</tr>
				<tr>
					<td class="tableHeader" align="center"><font color='red'>*</font>아이디</td>
					<td><input type="text" name='id' value="${memberDTO.getId() }" size="10"
						onkeypress="changeId();" readonly></td>
				</tr>
				<tr>
					<td class="tableHeader" align="center"><font color='red'>*</font>비밀번호</td>
					<td><input type="password" name='pwd' size="10"></td>
				</tr>
				<tr>
					<td class="tableHeader" align="center"><font color='red'>*</font>재확인</td>
					<td><input type="password" name='repwd' size="10"></td>
				</tr>
				<tr>
					<td class="tableHeader" align="center" style="height: 30px;">성 별</td>
					<td><input type='radio' id='man' name="gender" value="0">남
					<input type='radio' id="woman" name="gender" value="1">여</td>
				</tr>
				<tr>
					<td class="tableHeader" align="center">이 메 일</td>
					<td><input type="email" name="email1" size="7"
						value="${memberDTO.getEmail1() }">@<input type="text" id="email2"
						name="email2" list="defaultEmails"> <datalist
							id="defaultEmails">
							<option value="naver.com">
							<option value="gmail.com">
						</datalist></td>
				</tr>
				<tr>
					<td class="tableHeader" align="center">핸드폰</td>
					<td><select id="tel1" name="tel1">
							<option value="010">010</option>
							<option value="011">011</option>
					</select>-<input type="text" value="${memberDTO.getTel2() }" name="tel2"
						style="width: 50px;">-<input type="text" value="${memberDTO.getTel3() }"
						name="tel3" style="width: 50px;"></td>
				</tr>
				<tr>
					<td class="tableHeader" align="center">주소</td>
					<td><input type="text" name="zipcode" value="${memberDTO.getZipcode() }"
						id="zipcode" size="7" readonly> <input type="button"
						value="우편번호검색" onclick="checkPost()"><br> <input
						type="text" name="addr1" id="addr1" value="${memberDTO.getAddr1() }"
						style="width: 350px;" placeholder="주소" readonly><br>
						<input type="text" name="addr2" id="addr2" value="${memberDTO.getAddr2() }"
						style="width: 350px;" placeholder="나머지주소"></td>
				</tr>
			</table>
			<div style="margin:10px;">
				<input class="btn btn-outline-warning" type="button" id="modifyBtn" value="회원정보수정" > 
				<input class="btn btn-outline-warning" type="reset" value="다시작성">
			</div>
		</form>
	</div>
</body>
<!-- JQuery -->
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="../js/member.js?ver=2"></script>
<script>
window.onload = function () {
	document.modifyForm.gender['${memberDTO.getGender() }'].checked = true;
	if ("${memberDTO.getEmail1() }" != "") {
    document.getElementById("email2").value = "${memberDTO.getEmail1() }";
	}
	if ("${memberDTO.getTel1() }" != "") {
	document.getElementById("tel1").value = "${memberDTO.getTel1() }";
	}
}
</script>
<!-- onclick="checkModifyForm()" -->
