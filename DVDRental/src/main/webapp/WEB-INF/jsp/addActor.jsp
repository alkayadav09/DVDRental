<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../../index.jsp" %>
	<div class="container-fluid">
		<h3><label class="label label-primary col-sm-6 col-sm-offset-3" > Add Actor Details</label></h3>
		<form:form class="form-horizontal" commandName="actor" action="saveActor.html">
			<div class="form-group col-sm-12">
				<form:label class="control-label col-sm-offset-3 col-sm-2" path=""/>
			</div>
			<div class="form-group col-sm-12">
				<form:label class="col-sm-2 col-sm-offset-3" path="">First Name</form:label>
				<div class="col-sm-4">
					<form:input class="form-control" path="firstName"/>
				</div>
			</div>
			<div class="form-group col-sm-12">
				<form:label class="col-sm-2 col-sm-offset-3" path="">Last Name</form:label>
				<div class="col-sm-4">
					<form:input class="form-control" path="lastName"/>
				</div>
			</div>
			<div class="form-group col-sm-12">
				<div class="col-sm-2 col-sm-offset-3">
					<form:button class="btn btn-primary">Add Actor</form:button>
				</div>
			</div>
		</form:form>
	
	</div>
</body>
</html>