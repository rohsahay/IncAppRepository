<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,dto.IncDto" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>INC Tracker</title>
<meta name="author" content="rohit sahay">
<meta name="description" content="Inc Tracker">
<link rel='stylesheet' type='text/css' href='css/otherPages.css'>
<!--  <style>
body{
	background-image: url("images/backimg.jpg");
	margin:0;
}
</style> -->
</head>

<body>
	<div id="header">
		<h1>Incident Tracker</h1>
		<a id="signout" href="logoutHandler.do">Signout</a>
	</div>
	<div id="nav">
		<ul>
			<li><a href="CreateInc.jsp">New Incident</a></li>
			<li><a href="UserView.jsp">My Profile</a></li>
			<li><a href="controller_inc.do?hidden=inc_queue_view&a=0&b=10">Incident Queue</a></li>
			<li><a href="#">Link Four</a></li>
			<li><a href="#">Link Five</a></li>
		</ul>
	</div>
	<div id="section">
		<p>Hello <%= session.getAttribute("name") %><p>
		<% System.out.println("login "+session.getAttribute("login")); %>
		<% 	response.setHeader("Cache-Control","no-cache");
  			response.setHeader("Cache-Control","no-store");
  			response.setHeader("Pragma","no-cache");
  			response.setDateHeader ("Expires", 0); 
  			if(session.getAttribute("login")==null)
  		      response.sendRedirect("controller_inc.do?hidden=logout"); 
  			
  		%>
		The current date is: <%= new java.util.Date() %><br>
		
		<form action="controller_inc.do" method="post">
			<fieldset>
			<table summary="This table is used to submit INCs">
				<caption>Fill in the requested details. All fields are mandatory</caption>
				<tr>
					<th>Case#</th>
					<th>Assigned Date/Time</th>
					<th>Description</th>
					<th>Pending with</th>
					<th>Current Status</th>
					<th>Comment</th>
				</tr>
				
				<tr>
					<td><textarea name="case_nmbr"></textarea></td>
					<td><input type="date" name="Assign_date" value="2011-01-13"></td>
					<td><textarea name="desc"></textarea></td>
					<td><textarea name="pendig_with"></textarea></td>
					<td><textarea name="status"></textarea></td>
					<td><textarea name="comment"></textarea></td>
				</tr>	
			</table>
			<input type="hidden" name="hidden" value="insert_inc"> 
			<input type="submit" name="submit" value="Submit">
			</fieldset>
		</form>
		<%String prntStatus=request.getParameter("msg"); %>
		<%=prntStatus %>
			
	</div>
	<div id="footer">
		&#169;rohsahay@cisco.com | Help | Feedback
	</div>

</body>

</html>