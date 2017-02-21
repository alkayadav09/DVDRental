<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../../index.jsp" %>
	<div class="container-fluid">
		<form:form commandName="movie" action="saveMovies.html">
			<table>
				<tr>
					<td> Add a movie :</td>
					<td><form:input path="name"/></td>
				</tr>
				<tr>
					<td> Add Description :</td>
					<td><form:input path="description"/></td>
				</tr>
				<tr>
					<td> Add Release Date :</td>
					<td><form:input path="releaseYear"/></td>
				</tr>
				<tr>
					<td> Add Rental Rate :</td>
					<td><form:input path="rentalRate"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="Save Movie"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>