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
	<h3>Below is an overview of all stories.</h3>

	<table border="">
		  <tr>
		  	<th>Id</th>
		    <th>Name</th>
		    <th>Description</th>
		    <th>Actions</th>
		  </tr>
			<s:iterator value="stories">
				<s:url action="inputStoryUpdate" id="editUrl">
					<s:param name="id" value="id" />
				</s:url>
			
				<s:url action="storyDelete" id="deleteUrl">
					<s:param name="id" value="id" />
				</s:url>
				
	  		<tr>
					<td><s:property value="id"/></td>
					<td><s:property value="name"/></td>
					<td><s:property value="description"/></td>
					<td>
							<a href="<s:property value="#editUrl"/>">Edit</a>
							&nbsp;&nbsp; 
							<a href="<s:property value="#deleteUrl"/>">Delete</a>
					</td>
			  </tr>
			</s:iterator>
		</table>

	<p>
		<a href="<s:url action='inputStorySave'/>">Create a new story</a>
	</p>

	<p>
		<a href="index.jsp">Return home</a>
	</p>

</body>
</html>