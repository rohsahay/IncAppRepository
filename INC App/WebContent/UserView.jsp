<%@page import="dto.CounterDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>INC Tracker</title>
	<meta name="author" content="rohit sahay">
	<meta name="description" content="Inc Tracker">
	<link rel='stylesheet' type='text/css' href='css/otherPages.css'>
</head>

<body>
	<div id="header">
		<h1>Incident Tracker</h1>
		<a id="signout" href="logoutHandler">Signout</a>
	</div>
	<div id="nav">
		<ul>
			<li><a href="CreateInc.jsp">New Incident</a></li>
			<li><a href="Controller?hidden=UserviewHandler">My Profile</a></li>
			<li><a href="Controller?hidden=inc_queue_view&a=0&b=10">Incident Queue</a></li>
			<li><a href="#">Link Four</a></li>
			<li><a href="#">Link Five</a></li>
		</ul>
	</div>
	<div id="section">
		<h4>Hello <%= session.getAttribute("name") %></h1>
		<% System.out.println("login "+session.getAttribute("login")); %>
		<% 	response.setHeader("Cache-Control","no-cache");
  			response.setHeader("Cache-Control","no-store");
  			response.setHeader("Pragma","no-cache");
  			response.setDateHeader ("Expires", 0); 
  			if(session.getAttribute("login")==null)
  		      response.sendRedirect("controller_inc?hidden=logout"); 
  			
  		%>
  			
		The current date is: <%= new java.util.Date() %><br>
		For queries contact admin at <%= getServletContext().getInitParameter("admin-email")%>
		<h4>You have Visited this page <%= CounterDto.getCount() %> times</h4>
		<h1>This page has to display user profile</h1>
	</div>
	<div id="footer">
		&#169;rohsahay@cisco.com | Help | Feedback
	</div>

</body>

</html>