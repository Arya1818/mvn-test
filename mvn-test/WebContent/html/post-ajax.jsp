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
	param = encodeURIComponent(JSON.stringify(param))
	xhr.open('post','/postForm');
	xhr.onreadystatechange = function(){
		if(xhr.readyState == xhr.DONE){
			if(xhr.status==200){
				alert(xhr.responseText);
			}
		}
	}
	var param = {
			name : name.value
	}
	xhr.send(JSON.stringify(param));
}
</script>

</body>
</html>


<!-- post는 바디영역에 들어감
1.폼데이터형식
2.페이로드형식(기본적으로)
자바,js 도 알기쉽게 하는 형태 json
get parameter로 못 읽으니 request.getReader가 payload 영역안에 있는걸 읽어냄
 -->