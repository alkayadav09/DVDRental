<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="resources/css/main.css" rel="stylesheet"type="text/css">
	
	
</head>

<body>
	<%@include file="../../index.jsp" %>
	<div class="container-fluid">
	
		<form:form  id="search-form" commandName="movieFilter" >
			<div class="form-group">
				Movie Title <form:input path="title" id="title"/>
				Year <form:select path="year" id="year">
						<form:option value="-1" label="--Select--"/>
						<form:options  items="${allYears}" /> 
					  </form:select>
				Actor <form:select path="actor" >
						<form:option value="-1" label="--Select--"/>
						<form:options  items="${allActors}" itemValue="id" itemLabel="fullName"/> 
					  </form:select> 
				<input type="submit" value="Search Movie" id="btn-search">
			</div>
		</form:form> 
		<%-- <%@include file="pagination.jsp" %> --%>
		<c:if test="${noOfPages > 1}">
			<ul class="pagination">
				<c:if test="${currentPage > 1}">
					<li class="page-item"><a class="page-link" href="getPaginatedFilm.html?currentPage=${currentPage-1}">&laquo;</a></li>
				</c:if>
				
				<c:forEach var="i" begin="1" end="${noOfPages}">
					<li class="page-item"><a class="page-link" href="getPaginatedFilm.html?currentPage=${i}" name="currentPage">${i}</a></li>
				</c:forEach>
				<c:if test="${noOfPages > 10}">
					<li class="page-item"><a class="page-link" href="getPaginatedFilm.html?currentPage=${currentPage+1}">&raquo;</a></li>
				</c:if>	
			</ul>
		</c:if>
		<table class="table" id="table" >
		</table>
		<%-- <table class="table table-striped" id="table1" >
			<thead>
				<tr>
					<th data-field="id"><a href="getSortedMovies.html?columnName=id"> Id </a></th>
					<th data-field="title"><a href="getSortedMovies.html?columnName=title"> Movie Name </a></th>
					<th data-field="description"><a href="getSortedMovies.html?columnName=description"> Description </a></th>
					<th data-field="releaseYear"><a href="getSortedMovies.html?columnName=releaseYear"> Release Year </a></th> 
					<th data-field="rentalDuration"><a href="getSortedMovies.html?columnName=rentalDuration"> Rental Duration </a></th>
				</tr>
			</thead>
			<tbody>
			
			</tbody>
			<c:forEach items="${data}" var="film">
				<tr>
					<td>${film.id}</td>
					<td>${film.title}</td>
					<td>${film.description}</td>
					<td>${film.releaseYear}</td>
					<td>${film.rentalDuration}</td>
				</tr>
			</c:forEach>
		</table> --%>
	</div>
	
	<script>
	jQuery(document).ready(function($) {

		$("#search-form").submit(function(event) {

			// Disble the search button
			//enableSearchButton(false);

			// Prevent the form from submitting via the browser.
			event.preventDefault();

			searchViaAjax();

		});

	});
	
	function searchViaAjax(){
		
		var movieFilter = {}
		movieFilter["title"] = $("#title").val();
		movieFilter["year"] = $("#year").val();

		var dataJson= JSON.stringify(movieFilter);
		$.ajax({
			type: "POST",
			contentType: "application/json",
			//accepts: "application/json",
			url: "searchRequestedMovies.html",
			data: dataJson,
			dataType: 'json',
			timeout: 100000,
			success : function(data){
				console.log("Success :" , data);
				display(data);
			},
		   error : function(e){
			   console.log("Error :" , e);
			   display(e);
		   },
		   done : function(e){
				console.log("Done");
				//enableSearchButton(true);
			}
		});
		
		
		function enableSearchButton(flag){
				$("#btn-search").prop(disable , flag);
			}
		
		function display(data) {
				/* for (var i = 0; i < data.length; i++) {
					$('#table').bootstrapTable({
				        data: data[i]
				    });
					console.log(data);
				} */
				 
			$('#table').bootstrapTable({
				 columns: [{
				        field: 'id',
				        title: 'ID'
				    }, {
				        field: 'title',
				        title: 'Title'
				    }, {
				        field: 'description',
				        title: 'Description'
				    },{
				        field: 'releaseYear',
				        title: 'Release Year'
				    },{
				        field: 'rentalDuration',
				        title: 'Rental Duration'
				    }], 
				    data: data
				});
		}
		
	}
	</script>
</body>
</html>