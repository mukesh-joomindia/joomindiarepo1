<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="header.jsp" %>
	<spring:url value="/resources/dist/js/country.js" var="countryJs"/>
	<script src="${countryJs}"></script>
</head>
<body>

<form action="" name="countryForm" method="post"></form>
<label>Country Name:</label>
	<input type="text" name="countryName" id="countryName"><br/>
	<label>ISO Number:</label>
	<input type="text" name="isonumber" id="isonumber"><br/>
<button onclick="saveCountry()">Click me</button>
</form>
</body>
</html>