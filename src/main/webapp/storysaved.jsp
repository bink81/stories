<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Story Saved</title>
	</head>
	<body>
		<h3>Details of the story.</h3>
		
		<s:if test="story != null">
			<table border="">
			  <tr>
			    <th>Name</th>
			    <th>Description</th>
			  </tr>
			  <tr>
			    <td><s:property value="story.name" /></td>
			    <td><s:property value="story.description" /></td>
			  </tr>
			</table>
		</s:if>
		<s:else>
			<p>No story was saved.</p>
		</s:else>
	
		<p>
			<a href="index.jsp">Find a story</a>
		</p>
		<p>
			<a href="<s:url action='allStoriesFinder'/>">Find all stories</a>.
		</p>
	
	</body>
</html>