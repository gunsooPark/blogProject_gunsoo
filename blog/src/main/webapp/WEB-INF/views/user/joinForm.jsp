<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>

<div class="container">

	<form action="/action_page.php">
		<div class="form-group">
			<label for="username">Username</label> <input type="text" class="form-control" placeholder="ex) 홍길동" id="username">
		</div>

		<div class="form-group">
			<label for="email">Email</label> <input type="email" class="form-control" placeholder="ex) hong@naver.com" id="email">
		</div>

		<div class="form-group">
			<label for="password">Password</label> <input type="password" class="form-control" placeholder="비밀번호 입력" id="password">
		</div>

		<button type="submit" class="btn btn-primary">회원가입완료</button>
	</form>

</div>

<%@include file="../layout/footer.jsp"%>

