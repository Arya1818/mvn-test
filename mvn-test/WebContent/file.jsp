<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/file" enctype="multipart/form-data"> 
	파일 : <input type="file" name="f1"> <br>
	아이디 : <input type="text" name="id"> <br>
	<button>파일전송</button>
</form>
</body>
</html>

<!-- 
우리가 기본적인 스트링이 아니라 '파일'을 보내는거니까 file.jsp의 enctype이 multipart/form-data여야 한다. (파일 확장자)
form method가 post여야하고 enctype이 multipart/form-data여야 한다.

 -->