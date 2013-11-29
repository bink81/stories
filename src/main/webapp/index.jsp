<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Find Story</title>
</head>

<body>
	<h3>Enter a name of the story you want to see.</h3>

		<s:form action="storyFinder">
		<s:textfield name="nameFilter" label="Search for a name" tooltip="You can use Hibernate Query Language (HQL) here" />
		<s:submit />
	</s:form>

	<p>
		or <a href="<s:url action='allStoriesFinder'/>">find all stories</a>...
	</p>

	<p>
		or <a href="<s:url action='inputStorySave'/>">create a new story</a>...
	</p>
</body>
</html>