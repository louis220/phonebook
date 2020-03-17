<%@page import="phonebook.vo.PhoneBookVO"%>
<%@page import="java.util.List"%>
<%@page import="phonebook.dao.PhoneBookDAOImpl"%>
<%@page import="phonebook.dao.PhoneBookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 Servlet</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/includes/header.jsp"/>

<%
      String result = request.getParameter("name");
      if(result == "" || result ==null){
      %>
      <h3>목록</h3>
      <%} else {%>
      <h3>목록 (검색어 :<%=result %>)</h3>
      <%} %>

		<form action="<%= request.getContextPath() %>/">
		<input type ="hidden" name = "a" value="search">
		<label for="name">검색어</label>
		<input type="text" name="name">
		<button type="submit">검색</button>
		</form>
	
	


<table border = "1">
		<tr>
			<th>이름</th>
			<th>휴대전화</th>
			<th>전화번호</th>
			<th>도구</th>
			
		</tr>
	<%
	List<PhoneBookVO> list = (List<PhoneBookVO>)request.getAttribute("phone_book");	
	for(PhoneBookVO vo : list) {
	
	%>
	
		<tr>
			<td><%=vo.getPhoneName() %></td>
			<td><%=vo.getPhoneHp() %></td>
			<td><%=vo.getPhoneTel() %></td>
			<td>
			
			<form
					method="POST"
					action="<%= request.getContextPath() %>/a?=delete">
					<input type="hidden" name="a" value="delete">
					<input type="hidden" name="id" value="<%=vo.getPhoneId()%>">
					<button type="submit">삭제</button>
				</form>
			
			</td>
		</tr>
	<%} %>
	</table>
	
		


 <jsp:include page="/WEB-INF/views/includes/footer.jsp"/> 
</body>
</html>