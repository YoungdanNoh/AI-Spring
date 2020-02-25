<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function List(){
		location.href="list";
		}
</script>
</head>
<body>
	<form name="regifrm" method="post">
	제목
	<br/>
	<input type="text" name="title" id="title">
	<br/>
	내용
	<br/>
	<textarea name="content" rows="3" id="content"></textarea>
	<br/>
	작성자
	<br/>
	<input type="text" name="name" id="name">
	<br><br>
	<input type="submit" value="작성"><!-- submit때문에 디비에 작성이 된다. -->
	<input type="button" value="목록" onclick="List()">
	</form>
</body>
</html>