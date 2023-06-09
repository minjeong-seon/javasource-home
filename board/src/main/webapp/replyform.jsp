<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="include/header.jsp"%>
<main>
	<h2>Board Write</h2>
	<form action='<c:url value="/reply.do"  />'  method="post" enctype="multipart/form-data">
		<div class="row mb-3">
			<label for="inputName" class="col-sm-2 col-form-label">작성자</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputName"  name="name"  required>
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputTitle" class="col-sm-2 col-form-label">제목</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputTitle" name="title" required>
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputContent" class="col-sm-2 col-form-label">내용</label>
			<div class="col-sm-10">
				<textarea row="10" class="form-control" id="inputContent" name="content" required></textarea>
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputAttach" class="col-sm-2 col-form-label">파일첨부</label>
			<div class="col-sm-10">
				<input type="file" class="form-control" id="inputAttach" name="attach">
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputPassword" class="col-sm-2 col-form-label">비밀번호</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="inputPassword" name="password">
			</div>
		</div>
		<%-- 댓글 작성 시 원본글의 re_ref, re_lev, re_seq를 가지고 들어가야 함 --%>
		<input type="hidden" name="re_ref" value="${dto.reRef}"/>
		<input type="hidden" name="re_lev" value="${dto.reLev}"/>
		<input type="hidden" name="re_seq" value="${dto.reSeq}"/>
		
		<%-- 댓글 작성 시 페이지 나누기 정보 --%>
		<input type="hidden" name="criteria" value="${pageDto.criteria}" />
		<input type="hidden" name="keyword" value="${pageDto.keyword}" />
		<input type="hidden" name="page" value="${pageDto.page}" />
		<input type="hidden" name="amount" value="${pageDto.amount}" />
	
		<button type="submit" class="btn btn-success ">답변등록</button>
		<button type="reset" class="btn btn-danger">다시작성</button>
		<button type="button" class="btn btn-primary">목록보기</button>
	</form>
</main>
<form action="" id="replyform">
	<input type="hidden" name="criteria" value="${pageDto.criteria}" />
	<input type="hidden" name="keyword" value="${pageDto.keyword}" />
	<input type="hidden" name="page" value="${pageDto.page}" />
	<input type="hidden" name="amount" value="${pageDto.amount}" />
</form>
<script src="js/write.js"></script>
<%@ include file="include/footer.jsp"%>