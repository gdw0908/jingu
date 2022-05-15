<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/lib/js/jquery-1.7.1.min.js"></script>
<meta charset="UTF-8">
<title>진구야 비밀번호 찾자!!!</title>
</head>
<script type="text/javascript">
function goPwChk(){
	$("#frm").submit();
}
</script>
<body>
<form id="frm" name="frm" action="/jingu/findCalcPw">
	<input type="hidden" name="sessionId" id="sessionId" value="${sessionId}">
	<input type="text" name = "word1" id="word1" class="box">
	<input type="text" name = "word2" id="word2" class="box">
	<input type="text" name = "word3" id="word3" class="box"><br/>
	<input type="text" name = "word4" id="word4" class="box">
	<input type="text" name = "word5" id="word5" class="box">
	<input type="text" name = "word6" id="word6" class="box"><br/>
	<input type="text" name = "word7" id="word7" class="box">
	<input type="text" name = "word8" id="word8" class="box">
	<input type="text" name = "word9" id="word9" class="box"><br/>
	<input type="text" name = "word10" id="word10" class="box">
	<input type="text" name = "word11" id="word11" class="box">
	<input type="text" name = "word12" id="word12" class="box"><br/>
	<button onclick="goPwChk()">경우의 수 만들기</button>
</form>
</body>
</html>