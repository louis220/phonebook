<%@page import="phonebook.dao.PhoneBookDAOImpl"%>
<%@page import="phonebook.dao.PhoneBookDAO"%>
<%@page import="phonebook.vo.PhoneBookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>

<h3>새 주소 등록</h3>
<form name = "form"
			method="POST"
			action="<%= request.getContextPath() %>/">
			
		<input type ="hidden" name = "a" value="insert">
		<label for="name">이름</label><br/>
		<input type="text" name="name"><br/>
		<label for="hp">휴대전화</label><br/>
		<input type="text" name="hp"><br/>
		<label for="tel">전화번호</label><br/>
		<input type="text" name="tel"><br/>	
		
			
			<button type="submit">주소등록</button>
			<br/>
	
	
<a href="<%=request.getContextPath() %>/home">
목록 보기
</a>
</form>
</body>
</html>