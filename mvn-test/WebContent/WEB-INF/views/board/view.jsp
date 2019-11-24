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
		<table class="table table bordered">
			<thread class="thread">
			<tr>
				<th>번호</th>
				<td data-id="pbNum"><input type="hidden" value="${param.pbNum}"></td>
			</tr>	
			<tr>
				<th>제목</th>
				<td data-id="pbTitle"></td>
			</tr>	
			<tr>
				<th>내용</th>
				<td data-id="pbContent"></td>
			</tr>
			<tr>
				<th>이미지1</th>
				<td data-id="pbImg1"></td>
			</tr>
			<tr>
				<th>이미지2</th>
				<td data-id="pbImg2"></td>
			</tr>	
			<tr>
				<th>가입일자</th>
				<td data-id="credat"></td>
			</tr>
			<tr>
				<th>가입시각</th>
				<td data-id="cretim"></td>
			</tr>		
			<th colspan="2">
				<button onclick="goPage('/board/update?pbNum=${param.pbNum}')">수정</button>
				<button onclick="deleteContent()">삭제</button>
				<button onclick="goPage('/board/list')">리스트가기</button>
			</th>
			</thread>				
		</table>
	</div>
	
	<script>
	
	var conf={
			method : 'GET',
			url : '/board/view?pbNum=${param.pbNum}',
			callback : function(res){
				var pView = JSON.parse(res);
				console.log(pView);
				var tds = document.querySelectorAll('td[data-id]');
				for(var i=0; i<tds.length; i++){
					var td = tds[i];
					var att = td.getAttribute('data-id');
					if(att == 'pbImg1' || att =='pbImg2'){
						if(pView[att]){
							td.innerHTML = '<img src="'+pView[att]+'" width="200">';
						}else if(!pView[att]){
							td.innerHTML = 'No Image';
						}
						
					}else {
						td.innerHTML = pView[att];
					}
				}	
			}
	}
	window.onload = ajax(conf);
	
	

			
	</script>
</body>
</html>