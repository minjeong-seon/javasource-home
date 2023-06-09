<%@page import="user.domain.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/include/header.jsp" %>
<%
//UserDTO dto =(UserDTO)request.getAttribute("dto");
%>
<h1>회원 상세 조회</h1>
<form action="" method="post">
  <div class="mb-3">
    <label for="username" class="form-label">name</label>
<%--     <input type="text" class="form-control" id="username" readonly value="<%=dto.getUsername()%>"> --%>
    <input type="text" class="form-control" id="username" readonly value="${dto.username}">
  </div>
   <div class="mb-3">
    <label for="birthYear" class="form-label">birthYear</label>
   <%--  <input type="text" class="form-control" id="birthYear" readonly value=<%=dto.getBirthYear() %>> --%>
    <input type="text" class="form-control" id="birthYear" readonly value="${dto.birthYear }">
  </div>
     <div class="mb-3">
    <label for="addr" class="form-label">addr</label>
<%--     <input type="text" class="form-control" id="addr" readonly value=<%=dto.getAddr() %>> --%>
    <input type="text" class="form-control" id="addr" readonly value="${dto.addr }">
  </div>
  <div class="mb-3">
    <label for="mobile" class="form-label">mobile</label>
<%--     <input type="text" class="form-control" id="mobile" readonly value=<%=dto.getMobile() %>> --%>
    <input type="text" class="form-control" id="mobile" readonly value="${dto.mobile }">
  </div>
<%--   <input type="hidden" name="no" value="<%=dto.getNo()%>" id="no"/> --%>
  <input type="hidden" name="no" value="${dto.no }" id="no"/>
  <button type="button" class="btn btn-primary">목록으로</button>
  <button type="button" class="btn btn-success">수정</button>
  <button type="button" class="btn btn-danger">삭제</button>
</form>	
<script>
//자바 변수에 담긴 값 사용
<%-- const no = <%=dto.getNo()%> --%>
const no = ${dto.no};
</script>
<script src="js/get.js"></script>
<%@ include file = "/include/footer.jsp" %>