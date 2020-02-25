<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function regist(){
		location.href="register";
		}
</script>
</head>
<body>
	<table>
		<tr>
			<th style="width: 10px">NO</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
		</tr>
	<c:forEach items="${list }" var="boardModel">
		<tr>
			<td>${boardModel.NO }</td>
			<td><a href='/board/read?NO=${boardModel.NO }'>${boardModel.title}</a></td>
			<td>${boardModel.name }</td>
			<td><fmt:formatDate pattern="yyyy-mm-dd HH:mm" value="${boardModel.registtime }"/></td>
		</tr>
	</c:forEach>
	</table>
	<input type="button" value="등록" onclick="regist()">
</body>
</html>