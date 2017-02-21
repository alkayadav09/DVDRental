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
	
	 <form:form commandName="film" action="getMovie.html">
		<table>
			<tr>
				<td>Enter the movie to be searched :</td>
				<td><form:input path="title"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search Movie"></td>
			</tr>
		</table>
	</form:form> 
	
	
		<table>
			<tr>
				<th>Id</th>
				<th>Movie Name </th>
				<th>Description </th>
				<!-- <th>Release Year</th> -->
				<th>Rental Date</th>
			</tr>
			<c:forEach items="${films}" var="film">
				<tr>
					<td>${film.film_id}</td>
					<td>${film.title}</td>
					<td>${film.description}</td>
					<%-- <td>${movie.release_year}</td> --%>
					<td>${film.rental_rate}</td>
				</tr>
			</c:forEach>
		</table>
	
</body>
</html>