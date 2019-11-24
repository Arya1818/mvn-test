<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
<style>
h2 {
	display: block;
	font-size: 1.5em;
	font-weight: bold;
	margin-bottom: 1.5em;
}
body {
	display: block;
	margin-top: 2em;
	margin-bottom: 2em;
	margin-left: 2em;
	margin-right: 2em;
}
</style>
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
			<tr>
				<button onclick="goPage('/board/insert2')">등록하기</button>
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
						html += '<tr onclick="goPage(\'/board/view?pbNum=' + b.pbNum + '\')">';
						html += '<td>' + b.pbNum + '</td>';
						html += '<td>' + b.pbTitle + '</td>';
						html += '<td>' + b.pbContent + '</td>';
						html += '<td><img src="/img/' + b.pbImg1 + '" width=150></td>';
						html += '<td><img src="/img/' + b.pbImg2 + '" width=150></td>';
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