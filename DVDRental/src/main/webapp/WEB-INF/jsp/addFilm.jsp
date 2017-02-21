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
		<h3><label class="label label-primary col-sm-6 col-sm-offset-3 " > Add Movie Details</label></h3>
		<form:form class="" commandName="film" action="saveFilms.html">
			<div class="form-group col-sm-12">
				<form:label class="control-label col-sm-2 col-sm-offset-3" path=""/>
			</div>
			<div class="form-group col-sm-12">
				<form:label class="control-label col-sm-2 col-sm-offset-3" path="" >Movie Title</form:label>
				<div class="col-sm-4"> 
					<form:input class="form-control" path="title"/>
				</div>
			</div>
			<div class="form-group col-sm-12" >
				<form:label class="control-label col-sm-2 col-sm-offset-3" path="" >Description</form:label>
				<div class="col-sm-4">
					<form:input class="form-control" path="description"/>
				</div>
			</div>
			<div class="form-group col-sm-12" >
				<form:label class="control-label col-sm-offset-3 col-sm-2" path="" >Release Year</form:label>
				<div class="col-sm-4">
					<form:select  class="form-control col-sm-2" path="releaseYear" >
						<form:option value="NONE" label="---Select---" ></form:option>
						<form:option value="2000" label="2000" ></form:option>
						<form:option value="2001" label="2001" ></form:option>
						<form:option value="2002" label="2002" ></form:option>
						<form:option value="2003" label="2003" ></form:option>
						<form:option value="2004" label="2004" ></form:option>
						<form:option value="2005" label="2005" ></form:option>
						<form:option value="2006" label="2006" ></form:option>
						<form:option value="2007" label="2007" ></form:option>
						<form:option value="2008" label="2008" ></form:option>
						<form:option value="2009" label="2009" ></form:option>
						<form:option value="2010" label="2010" ></form:option>
						<form:option value="2011" label="2011" ></form:option>
						<form:option value="2012" label="2012" ></form:option>
						<form:option value="2013" label="2013" ></form:option>
						<form:option value="2014" label="2014" ></form:option>
						<form:option value="2015" label="2015" ></form:option>
						<form:option value="2016" label="2016" ></form:option>
					</form:select>
				</div>
			</div>
			<div class="form-group col-sm-12">
				<form:label class="control-label col-sm-offset-3 col-sm-2" path="" >Language</form:label>
				<div class="col-sm-4">
					<form:select  class="form-control col-sm-2" path="languageId" >
						<form:option value="NONE" label="---Select---" ></form:option>
						<form:option value="1" label="English" ></form:option>
						<form:option value="2" label="Italian" ></form:option>
						<form:option value="3" label="Japanese" ></form:option>
						<form:option value="4" label="Mandrain" ></form:option>
						<form:option value="5" label="French" ></form:option>
						<form:option value="6" label="German" ></form:option>
					</form:select>
				</div>
			</div>
			<div class="form-group col-sm-12" >
				<form:label class="control-label col-sm-offset-3 col-sm-2" path="" >Rental Rate</form:label>
				<div class="col-sm-4">
					<form:input class="form-control" path="rentalRate"/>
				</div>
			</div>
			<div class="form-group col-sm-12" >
				<form:label class="control-label col-sm-offset-3 col-sm-2" path="" >Rental Duration</form:label>
				<div class="col-sm-4">
					<form:input class="form-control" path="rentalDuration"/>
				</div>
			</div>
			<div class="form-group col-sm-12" >
				<form:label class="control-label col-sm-offset-3 col-sm-2" path="" >Replacement Cost</form:label>
				<div class="col-sm-4">
					<form:input class="form-control" path="replacementCost"/>
				</div>
			</div>
			<div class="form-group col-sm-12">
				<div class="col-sm-offset-3 col-sm-2">
					<form:button class="btn btn-primary" name="Add Movie" >Add Movie</form:button>
				</div>
			</div>	
		</form:form>	
	</div>
</body>
</html>