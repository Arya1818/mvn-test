<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<table class="table table-bordered">
	<tr>
		<th>이름</th>
		<td><input type="text" id="uiName">
	</tr>
	<tr>
		<th>아이디</th>
		<td><input type="text" id="uiId">
	</tr>
	<tr>
		<th>패스워드</th>
		<td><input type="text" id="uiPwd">
	</tr>
	<tr>
		<th colspan="2"><button onclick="save()">저장</button>
	</tr>
</table>

<script>


	function save(){
		var xhr = new XMLHttpRequest();
		xhr.open('POST','/user/signup');
		xhr.setRequestHeader('Content-Type','application/json');
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					var res = JSON.parse(xhr.responseText); //return받은rMap
					alert(res.msg); 
					if(res.result=='true'){
						goPage('/user/list');
					}
				}
			}
		}
		var param = {
				uiName : document.querySelector('#uiName').value,
				uiId : document.querySelector('#uiId').value,				
				uiPwd : document.querySelector('#uiPwd').value
		}
		console.log(param);
		param = JSON.stringify(param)
		xhr.send(param);
	}
</script>
</div>
</body>
</html>