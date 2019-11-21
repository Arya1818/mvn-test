<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<input type="text"  id="name">
<button onclick="submit()">전송</button>
<script>
function submit(){
	var name = document.querySelector('#name');
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/getForm?name=' + name.value);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == xhr.DONE){
			if(xhr.status==200){
				alert(xhr.responseText);
			}
		}
	}
	xhr.send();
}


</script>
</body>
</html>

<!-- 비동기 페이지에서는 ajax가 좋음 
보통 common.js로 뺌 -->