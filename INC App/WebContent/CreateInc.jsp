<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>INC Tracker</title>
<meta name="author" content="rohit sahay">
<meta name="description" content="Inc Tracker">
<link rel='stylesheet' type='text/css' href='css/userview.css'>
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
		<a id="signout" href="LogoutHandler">Signout</a>
	</div>
	<div id="nav">
		<ul>
			<li><a href="CreateInc.jsp">New Incident</a></li>
			<li><a href="UserView.jsp">My Profile</a></li>
			<li><a href="Controller?hidden=inc_queue_view&a=1&b=10">Incident Queue</a></li>
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
  		      response.sendRedirect("controller_inc?hidden=logout"); 
  			
  		%>
		The current date is: <%= new java.util.Date() %><br>
		
		<form action="controller_inc" method="post">
			<fieldset>
			<table style="width=100%">
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
					<td><input type="date" name="Assign_date"></td>
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