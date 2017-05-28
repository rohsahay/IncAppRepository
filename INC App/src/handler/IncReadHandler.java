package handler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ReadIncDao;
import dao.ReadIncDao2;
import dto.User;
import dto.IncDto;
import dto.IncDto2;
/**
 * Servlet implementation class IncReadHandler
 */
@WebServlet("/IncReadHandler")
public class IncReadHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncReadHandler() {
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
			response.sendRedirect("controller_inc?hidden=logout");
		String n=(String)session.getAttribute("name");
		String startRow=(String)request.getParameter("a");
		String endRow=(String)request.getParameter("b");
		String act=request.getParameter("act");
		logger.info("Start row from request= "+startRow);
		logger.info("msg value "+request.getParameter("msg"));
//		logger.info("End row from request "+endRow);
		User usr=new User();
		usr.setCecid(n);
		ArrayList<IncDto2> inc=new ArrayList<IncDto2>(); 
		try{
			if(act==null){
				inc=ReadIncDao2.read(n,startRow,endRow);
			}
			else{
				inc=ReadIncDao2.read(request.getParameter("c"));				
			}
			request.setAttribute("Inclist",inc);
			logger.info("value of c from request "+request.getParameter("c"));
			logger.info("act value from request "+act);
			if (act!=null){
				if(act.equals("edit")){
					logger.info("disptching request to UpdateInc.jsp");
					RequestDispatcher rd=request.getRequestDispatcher("UpdateInc.jsp");
					rd.forward(request,response);
				}
			}
			else{
				logger.info("dispatching request to IncidentQueue2.jsp");
				RequestDispatcher rd=request.getRequestDispatcher("IncidentQueue2.jsp");
				rd.forward(request,response);
			}
			
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
