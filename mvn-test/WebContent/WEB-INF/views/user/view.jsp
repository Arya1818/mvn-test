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
		<table class="table table bordered">
			<tr>
				<th>번호</th>
				<td data-id="uiNum"><input type="hidden" value="${param.uiNum}"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td data-id="uiId"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" id="uiName"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="uiPwd"></td>
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
				<button onclick="update()">수정</button>
				<button onclick="deleteUser()">삭제</button>
				<button onclick="goPage('/user/list')">리스트가기</button>
			</th>
			</tr>
		</table>
	</div>

	<script>
		var user;
		window.onload = function() {
			var xhr = new XMLHttpRequest();
			xhr.open('GET', '/user/view?uiNum=${param.uiNum}');
			xhr.setRequestHeader('Content-Type', 'application/json');
			xhr.onreadystatechange = function() {
				if (xhr.readyState == xhr.DONE) {
					if (xhr.status == 200) {
						user = JSON.parse(xhr.responseText);
						if (user == null) {
							alert('존재하지 않는 회원..');
						} else {
							document.querySelector('input[id=uiName]').value = user.uiName;
							document.querySelector('input[id=uiPwd]').value = user.uiPwd;
							var tds = document.querySelectorAll('td[data-id]');
							for (var t = 0; t < tds.length; t++) {
								var td = tds[t];
								var att = td.getAttribute('data-id');
								td.innerHTML = user[att];
							}
						}
					}
				}
			}
			xhr.send();
		}

		function update() {
			var xhr = new XMLHttpRequest();
			xhr.open('POST', '/user/update');
			xhr.onreadystatechange = function() {
				if (xhr.readyState == xhr.DONE) {
					if (xhr.status == 200) {
						var res = JSON.parse(xhr.responseText);
						alert(res.msg);
						if (res.result == 'true') {
							goPage('/user/list');
						}
					}
				}
			}
			var param = {
				uiName : document.querySelector('input[id=uiName]').value,
				uiPwd : document.querySelector('input[id=uiPwd]').value,
				uiNum : user.uiNum
			}
			param = JSON.stringify(param)
			xhr.send(param);
		}

		function deleteUser() {
			var xhr = new XMLHttpRequest();
			xhr.open('POST', '/user/delete');
			xhr.onreadystatechange = function() {
				if (xhr.readyState == xhr.DONE) {
					if (xhr.status == 200) {
						var res = JSON.parse(xhr.responseText);
						alert(res.msg);
						if (res.result == 'true') {
							goPage('/user/list');
						}
					}
				}
			}
			var param = {
				uiNum : user.uiNum
			}
			param = JSON.stringify(param)
			xhr.send(param);
		}
	</script>
</body>
</html>