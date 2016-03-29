<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Edit Story</title>
	</head>
	<body>
		<h3>Use the form below to edit this story.</h3>
	
		<s:if test="story != null">
			<s:form action="executeStoryUpdate" method="post">
				<s:textfield name="story.name" label="Name" required="yes" size="136" />
				<s:textarea name="story.description" label="Description" cols="100" rows="20" />
				<s:hidden name="story.id" />
				<s:submit />
			</s:form>
	
		</s:if>
		<s:else>
			<p>No story was found.</p>
		</s:else>
	
		<p>
			<a href="index.jsp">Find another story</a>
		</p>
		<p>
			<a href="<s:url action='allStoriesFinder'/>">Find all stories</a>.
		</p>
	
	</body>
</html>