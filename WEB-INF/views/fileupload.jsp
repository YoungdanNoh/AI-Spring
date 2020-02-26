<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function Analysis(){
		location.href="register";
	}
</script>
</head>
<body>
	<h1>파일 업로드</h1>
	<form action="fileupload" method="post" enctype="multipart/form-data">
	    <input type="file" name="uploadfile" placeholder="파일 선택" /><br/>
	    <input type="submit" value="업로드">
	</form>
	<!-- <input type="button" value="분석" onclick="Analysis()"> -->
	<%-- <%=request.getAttribute("fileName")+"  업로드 완료" %> --%>
	<%
		if(request.getAttribute("fileName")==null){
			
		}else{
			String fileName = request.getAttribute("fileName").toString();
			%><%=fileName%> 업로드 완료
				<br>
				<input type="button" value="분석" onclick="Analysis()">
			<%
			System.out.print(fileName+" 업로드 완료");
		}
	%>
</body>
</html>