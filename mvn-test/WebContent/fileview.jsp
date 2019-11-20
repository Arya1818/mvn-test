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
		<h1>FileList</h1>
		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<td data-id="ftNum"><input type="hidden" value="${param.ftNum}"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td data-id="ftId"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" id="uiName"></td>
			</tr>
			<tr>
				<th>이미지</th>
				<td data-id="ftFile"></td>
			</tr>
			<th colspan="2">
				<button onclick="update()">수정</button> <bitton onclick="deleteFile()">삭제</bitton>
			</th>
			</tr>
		</table>
	</div>
	<script>
		window.onload = function(){
			var xhr = new XMLHttpRequest();
			xhr.open('GET','/file2?ftNum=${param.ftNum}');
			xhr.setRequestHeader('Content-Type', 'application/json');
			xhr.onreadystatechange = function(){
				if(xhr.readyState==xhr.DONE){
					if(xhr.status==200){
						var fileList = JSON.parse(xhr.responseText);
						if (file == null){
							alert('존재하지않는파일');
						}else{
							document.querySelector('input[id=uiName]').value = file.ftName;
							var tds = document.querySelectorAll('td[data-id]');
							for(var t=0; t<tds.length; t++){
								var td = tds[t];
								var att = td.getAttribute('data-id');
								td.innerHTML = file[att];
							}
						}
					}
				}
			}	
			xhr.send();
		}
		
	</script>
</body>
</html>