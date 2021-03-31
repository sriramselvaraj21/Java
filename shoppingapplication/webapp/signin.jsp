<!DOCTYPE html>
<%@page import="java.util.ResourceBundle"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/myjsptags.tld" prefix="mytags" %>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<style>
		body {text-align: center;}
	</style>
	<body>
		<h1>Welocome back... Your mobile number is your username..!</h1>
		<form action="</ActionServletURL/>" method="POST">
			<input type="hidden" name="formname"   value="signin"/>
			<label><mytags:bundle key="username"/></label>
			<input type = "text" placeholder="username" name="username"/>
			<br><br>
			<label><mytags:bundle key="password"/></label>
			<input type = "text" placeholder="password" name="password"/>
			<br><br>
			<button type="submit">LOGIN</button>
		</form>		
	</body>
</html>
