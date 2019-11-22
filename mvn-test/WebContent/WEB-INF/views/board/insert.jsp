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
		<table class="table table-bordered">
			<tr>
				<th>제목</th>
				<td><input type="text" id="pbTitle"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea id="pbContent" rows="7" cols="70"></textarea></td>
			</tr>
			<tr>
				<th>이미지1</th>
				<td><input type="file" id="pbImg1"> <progress id="pro1" value="0" max="100"></progress>
					<div id="pDiv1"></div></td>
			</tr>
			<tr>
				<th>이미지2</th>
				<td><input type="file" id="pbImg2"> <progress id="pro2" value="0" max="100"></progress>
					<div id="pDiv2"></div></td>
			</tr>
			<tr>
				<th colspan="2"><button onclick="submit()">등록</button></th>
			</tr>
		</table>
		<script>
		
			function submit() {
					
				var pbImg1 = document.querySelector('#pbImg1');
				var pbImg2 = document.querySelector('#pbImg2');
				console.log(pbImg1.files[0]);
				var pro1 = document.querySelector('#pro1');
				var pDiv1 = document.querySelector('#pDiv1');
				var pro2 = document.querySelector('#pro2');
				var pDiv2 = document.querySelector('#pDiv2');

				var fd = new FormData();
				fd.append('pbTitle', document.querySelector('#pbTitle').value);
				fd.append('pbContent', document.querySelector('#pbContent').value);
				fd.append('pbImg1', document.querySelector('#pbImg1').files[0]);
				fd.append('pbImg2', document.querySelector('#pbImg2').files[0]);

				var xhr = new XMLHttpRequest();

				xhr.upload.addEventListener('progress', function(evt) {
					var per1 = (evt.loaded / evt.total) * 100;
					pro1.value = per1;
					pDiv1.innerHTML = per1 + "%";
				})
				xhr.upload.addEventListener('progress', function(evt) {
					var per2 = (evt.loaded / evt.total) * 100;
					pro2.value = per2;
					pDiv2.innerHTML = per2 + "%";
				})
				xhr.open('POST', '/board/insert');
				xhr.onreadystatechange = function() {
					if (xhr.readyState == xhr.DONE) {
						if (xhr.status == 200) {
							
							var res = JSON.parse(xhr.responseText);
							console.log(res);
						}
					}
				}
				xhr.send(fd);
			}
		</script>
	</div>
</body>
</html>