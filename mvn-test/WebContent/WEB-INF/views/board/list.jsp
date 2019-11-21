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
		<h1>PhotoList</h1>
		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>이미지1</th>
				<th>이미지2</th>
				<th>조회수</th>
			</tr>
			<tbody id="tBody">

			</tbody>
		</table>
	</div>
	<script>
	window.onload = function(){
		var xhr = new XMLHttpRequest();
		xhr.open('GET','/board/list');
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					var board = JSON.parse(xhr.responseText);
					console.log(board);
					var html='';
					for(var b of board){
						html += '<tr>';
						html += '<td>' + b.pbNum + '</td>';
						html += '<td>' + b.pbTitle + '</td>';
						html += '<td>' + b.pbContent + '</td>';
						html += '<td>' + b.pbImg1 + '</td>';
						html += '<td>' + b.pbImg2 + '</td>';
						html += '<td>' + b.pbCnt + '</td>';
						html += '</tr>';
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