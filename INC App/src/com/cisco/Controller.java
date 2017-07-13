package com.cisco;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.*;





/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static final Logger logger = LogManager.getLogger();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.info(getServletConfig().getInitParameter("servletConfig")); //Servlet config value from DD
		String n=request.getParameter("hidden");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if (n!=null)
		{
			
			if(n.equals("login"))
			{
				logger.info("Got user request for login, dispatching request to login handler");
				RequestDispatcher rd=request.getRequestDispatcher("LoginHandler");   
				rd.forward(request, response);
				 
			}
			else if(n.equals("logout")){
				//this flow is successful
				logger.info("redirecting to welcome page");
				response.sendRedirect("Home.xhtml");
				
			}
// to view user profile			
			else if(n.equals("UserviewHandler")){
				RequestDispatcher rd=request.getRequestDispatcher("UserviewHandler");
				rd.forward(request,response);
				
				
			}
			else if(n.equals("adminview")){
				//this flow is successful
				out.println("successfully redirected to admin page");
/*				RequestDispatcher rd=request.getRequestDispatcher("adminview");
				rd.forward(request,response);
*/	
			}
			else if(n.equals("signup")){
				logger.info("Dispatching request to sign-up handler");
				RequestDispatcher rd=request.getRequestDispatcher("SignupHandler");
				rd.forward(request, response);
				
			}
			else if(n.equals("insert_inc")){
				logger.info("reached controller for inserting inc, dispatching request to insertHandler");
				RequestDispatcher rd=request.getRequestDispatcher("insertHandler.do");
				rd.forward(request, response);
				
			}		
//to view list of incidents for a user			
			else if(n.equals("inc_queue_view")){
				RequestDispatcher rd=request.getRequestDispatcher("incReadHandler.do");
				rd.forward(request, response);
			}
			else if(n.equals("update_inc")){
				logger.info("in controller for update filter: "+request.getParameter("filter"));
				logger.info("value of a and b in controller"+request.getParameter("a")+" "+request.getParameter("b"));
				logger.info("value of act"+request.getParameter("act"));
				RequestDispatcher rd=request.getRequestDispatcher("updateHandler.do");
				rd.forward(request, response);
			}
			else if(n.equals("delete_inc")){
				logger.info("in controller for deletion");
				logger.info("value of c in controller "+request.getParameter("c"));
				logger.info("value of act "+request.getParameter("act"));
				RequestDispatcher rd=request.getRequestDispatcher("deleteHandler.do");
				rd.forward(request, response);
			}
		}
		else
		{
			out.println("to errror page to not give empty fields");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
