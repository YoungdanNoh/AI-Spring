<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function Modify(){
		location.href="modify";
		}
	function List(){
		location.href="list";
		}
</script>
</head>
<body>
	<c:forEach items="${info }" var="selectinfo">
		<form name="readfrm" method="post">
		제목
		<br>
		<input type="text" name="title" id="title" value="${selectinfo.title }">
		<br>
		내용
		<br>
		<textarea name="content" rows="3" id="content">${selectinfo.content }</textarea>
		<br>
		작성자
		<br>
		<input type="text" name="name" id="name" value="${selectinfo.name }" readonly="readonly">
		<br>
		</form>
	<span class="btn delete"><a href='/board/modify?NO=${selectinfo.NO }'>수정</a></span>
	<span class="btn modify"><a href='/board/delete?NO=${selectinfo.NO }'>삭제</a></span>
	<span class="btn close"><button onclick="List()">닫기</button></span>
	</c:forEach>
</body>
</html>