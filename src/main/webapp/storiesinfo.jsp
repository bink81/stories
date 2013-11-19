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
	<h3>Below are the details for all the stories.</h3>

	<s:iterator value="stories">
		<s:url action="inputStoryUpdate" id="editUrl">
			<s:param name="id" value="id" />
		</s:url>

		<s:url action="storyDelete" id="deleteUrl">
			<s:param name="id" value="id" />
		</s:url>

		<%--if value attribute is not specified
		the property tag will call the toString method
		of each Story object in the stories collection. --%>
		<p>
			<s:property />
			<a href="<s:property value="#editUrl"/>">Edit</a> &nbsp;&nbsp; <a
				href="<s:property value="#deleteUrl"/>">Delete</a>
		</p>
	</s:iterator>

	<p>
		<a href="<s:url action='inputStorySave'/>">Create a new story</a>.
	</p>

	<p>
		<a href="index.jsp">Return home</a>
	</p>

</body>
</html>