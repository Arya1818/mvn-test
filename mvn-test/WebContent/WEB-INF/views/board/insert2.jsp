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
				<th>유저</th>
				<td><input type="number" id="creusr"></td>
			</tr>
			<tr>
				<th>이미지1</th>
				<td><input type="file" id="pbImg1"></td>
			</tr>
			<tr>
				<th>이미지2</th>
				<td><input type="file" id="pbImg2"></td>
			</tr>
			<tr>
				<th colspan="2"><button onclick="submit()">등록</button></th>
			</tr>
		</table>
		<script>
			
			function submit() {
				var formData = makeFormData();
				var conf = {
						method:'POST',
						url:'/board/insert2',
						func:function(res){
							console.log(res);
						},
						//data : '' //데이터없을때
						data:formData
				}
				send(conf);
			}
		</script>
	</div>
</body>
</html>