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
				<th>아이디</th>
				<th>이름</th>
				<th>이미지</th>
			</tr>
			<tbody id="tBody">
			
			</tbody>	
		</table>
	</div>
	<script>
		window.onload = function(){
			var xhr = new XMLHttpRequest();
			xhr.open('GET','/file2/fileList');
			xhr.onreadystatechange = function(){
				if(xhr.status==200){
					var fileList = JSON.parse(xhr.responseText);
					console.log(fileList);
					var html = '';
					for(var file of fileList){
						html += '<tr onclick="goGo(\'/fileview.jsp?ftNum=' + file.FT_NUM + '\')">';
						html += '<td>' + file.FT_NUM + '</td>';
						html += '<td>' + file.FT_ID + '</td>';
						html += '<td>' + file.FT_NAME + '</td>';
						html += '<td><img src="' + file.FT_FILE + '" width=150></td>';
						html += '</tr>';
					}
					document.querySelector('#tBody').innerHTML = html;
				}
			}
			xhr.send();
		}
		
	</script>
</body>
</html>