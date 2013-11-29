<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Story Found</title>
</head>
<body>
	<h3>Below are the details of the story found.</h3>

	<s:if test="story != null">
		<s:url action="inputStoryUpdate" id="editUrl">
			<s:param name="id" value="id" />
		</s:url>

		<s:url action="storyDelete" id="deleteUrl">
			<s:param name="id" value="id" />
		</s:url>

		<p>
			<s:property value="story.name" />
			<a href="<s:property value="#editUrl"/>">Edit</a> &nbsp;&nbsp; <a
				href="<s:property value="#deleteUrl"/>">Delete</a>
		</p>
	</s:if>
	<s:else>
		<p>No story was found for id: '<s:property value="id" />'</p>
	</s:else>

	<p>
		<a href="index.jsp">Find another story</a>
	</p>
	<p>
		<a href="<s:url action='allStoriesFinder'/>">Find all stories</a>.
	</p>

</body>
</html>