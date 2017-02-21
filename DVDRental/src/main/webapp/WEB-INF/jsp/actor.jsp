<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../../index.jsp" %>
	<div class="container-fluid">
		<table class="table table-striped">
			<tr>
				<th>Id</th>
				<th>Actor Name</th>
				
			</tr>
			<c:forEach items="${actors}" var="actor">
	 			<tr>
	 				<td>${actor.id}</td>
	 				<td>${actor.fullName}</td>
	 				
	 			</tr>
			</c:forEach>
		</table>
		
	</div>
	 

</body>
</html>