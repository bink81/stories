<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Enter Story Id</title>
</head>

<body>
	<h3>Enter an Id of the story you want to find.</h3>

	<s:form action="storyFinder">
		<s:textfield name="id" label="Story Id" />
		<s:submit />
	</s:form>

	<p>
		<a href="<s:url action='allStoriesFinder'/>">Find all stories</a>.
	</p>

	<h3>Create a new story.</h3>

	<p>
		<a href="<s:url action='inputStorySave'/>">Create a new story</a>.
	</p>
</body>
</html>