<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function Read(){
		location.href="list";
		}
</script>
</head>
<body>
<c:forEach items="${info }" var="modifyinfo">
	<form name="modifrm" method="post">
	제목
	<br>
	<input type="text" name="title" id="title" value="${modifyinfo.title }">
	<br>
	내용
	<br>
	<textarea name="content" rows="3" id="content">${modifyinfo.content}</textarea>
	<br>
	작성자
	<br>
	<input type="text" name="name" id="name" value="${modifyinfo.name }" readonly="readonly">
	<br>
	<input type="submit" value="수정">
	<input type="button" onclick="Read()" value="닫기">
	</form>
</c:forEach>
</body>
</html>