<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
	<div class="container">
	<h1>UserList</h1>
	<table class="table table-border">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>가입일</th>
		</tr>
		<tbody id="tBody">
			
		</tbody>
	</table>
	</div>
	<script>
		window.onload = function(){
			var xhr = new XMLHttpRequest();
			xhr.open('GET','/user/list');
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4){
					if(xhr.status==200){
						console.log(xhr.responseText);
						var userList = JSON.parse(xhr.responseText);
						
						var html = '';
						for(var user of userList){
							html += '<tr>';
							html += '<td>' + user.uiNum + '</td>';
							html += '<td>' + user.uiName + '</td>';
							html += '<td>' + user.uiId + '</td>';
							html += '<td>' + user.credat + '</td>';
							html += '</tr>'
						}
						document.querySelector('#tBody').innerHTML = html;
					}
				}
			}
			xhr.send();
		}
	</script>
</body>
</html>