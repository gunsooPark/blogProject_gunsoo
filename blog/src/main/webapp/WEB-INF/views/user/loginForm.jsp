<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>

<div class="container">

	<form>

		<div class="form-group">
			<label for="Username">Username</label> <input type="type" class="form-control" placeholder="아이디 입력" id="username">
		</div>

		<div class="form-group">
			<label for="password">Password</label> <input type="password" class="form-control" placeholder="비밀번호 입력" id="password">
		</div>


		<div class="form-group form-check">
			<label class="form-check-label"> <input class="form-check-input" type="checkbox"> Remember me
			</label>
		</div>
	</form>
	
	<button id="btn-login" class="btn btn-primary">로그인</button>
</div>

<script src="/blog/js/user.js"></script>
<%@include file="../layout/footer.jsp"%>

