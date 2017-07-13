package handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.DeleteIncDao;
import dao.IncDao2;
import dto.User;

/**
 * Servlet implementation class DeleteHandler
 */
@WebServlet("/DeleteHandler")
public class DeleteHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		if(session.getAttribute("login")==null)
		response.sendRedirect("controller_inc.do?hidden=logout");
		String n=(String)session.getAttribute("name");
		String c=(String)request.getParameter("c");
		logger.info("Case Number to be deleted "+c);
		User usr=new User();
		usr.setCecid(n);
		try{
			IncDao2 id = new IncDao2();		// using hibernate to delete
			id.delete(n, c);				//
//			DeleteIncDao.delete(n,c);		//using plain sql to delete
			logger.info("reloading incidentQueue.jsp");
			response.sendRedirect("controller_inc.do?hidden=inc_queue_view&a=0&b=10");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
