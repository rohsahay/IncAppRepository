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
		<a id="signout" href="logoutHandler">Signout</a>
	</div>
	<div id="nav">
		<ul>
			<li><a href="CreateInc.jsp">New Incident</a></li>
			<li><a href="Controller?hidden=UserviewHandler">My Profile</a></li>
			<li><a href="Controller?hidden=inc_queue_view&a=1&b=10">Incident Queue</a></li>
			<li><a href="#">Link Four</a></li>
			<li><a href="#">Link Five</a></li>
		</ul>
	</div>
	<div id="section"> 			
		The current date is: <%= new java.util.Date() %><br>
		For queries contact admin at <%= getServletContext().getInitParameter("admin-email")%>
		<h4>Hello <%= session.getAttribute("name") %></h4>
		<% System.out.println("login "+session.getAttribute("login")); %>
		
		<% 	response.setHeader("Cache-Control","no-cache");
  			response.setHeader("Cache-Control","no-store");
  			response.setHeader("Pragma","no-cache");
  			response.setDateHeader ("Expires", 0); 
  			if(session.getAttribute("login")==null)
  		      response.sendRedirect("controller_inc?hidden=logout"); 
  			
  		%>
  		<%System.out.println("in incident queue jsp "); %>
			<table style="width=100%">
				<caption>Below are the incident details</caption>
				<tr>
					<th>Sr.No.</th>
					<th>Case#</th>
					<th>Assigned Date/Time</th>
					<th>Description</th>
					<th>Pending with</th>
					<th>Current Status</th>
					<th>Comment</th>
					<th>Analyst</th>
					<th colspan="2">Action</th>
				</tr>
				<%ArrayList<IncDto> inc=new ArrayList<IncDto>();
				inc=(ArrayList)request.getAttribute("Inclist"); 
				Iterator itr=inc.iterator();
				
				while(itr.hasNext()){
					IncDto incident=(IncDto)itr.next();	
				%>
				<tr>
				<td><%=incident.getSerialNo()%></td>
				<%String x,y;
				x=incident.getSerialNo();
				y=incident.getCasenmbr();%>
				<td><%=incident.getCasenmbr()%></td>
				<td><%=incident.getDate()%></td>
				<td><%=incident.getDesc()%></td>
				<td><%=incident.getPendingwth()%></td>
				<td><%=incident.getStatus()%></td>
				<td><%=incident.getComnt()%></td>
				<td><%=incident.getAnalyst()%></td>
	 			<td><a class="editbutton" href="Controller?hidden=inc_queue_view&a=<%=x%>&b=<%=x%>&act=edit">Edit</a></td>
	 			<td><a class="deletebutton" href="Controller?hidden=delete_inc&c=<%=y%>&act=delete">Delete</a></td> 
				</tr>
				<% } %>
			</table>
	</div>
	<div id="footer">
			<ul class="pagination">
  				<li><a href="Controller?hidden=inc_queue_view&a=1&b=10">1</a></li>
  				<li><a href="Controller?hidden=inc_queue_view&a=11&b=20">2</a></li>
  				<li><a href="Controller?hidden=inc_queue_view&a=21&b=30">3</a></li>
  				<li><a href="Controller?hidden=inc_queue_view&a=31&b=40">4</a></li>
  				<li><a href="Controller?hidden=inc_queue_view&a=41&b=50">5</a></li>
			</ul> 
		&#169;rohsahay@cisco.com | Help | Feedback
	</div>

</body>

</html>