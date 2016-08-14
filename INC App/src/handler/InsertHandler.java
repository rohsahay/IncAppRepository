package handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dto.IncDto;
import dao.IncDao;

/**
 * Servlet implementation class InsertHandler
 */
@WebServlet("/InsertHandler")
public class InsertHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session=request.getSession();
			String analyst=(String)session.getAttribute("name");
			logger.info("In insert handler,name in session as"+analyst);
			IncDto inc=new IncDto();
			inc.setCasenmbr(request.getParameter("case_nmbr"));
			inc.setDate(request.getParameter("Assign_date"));
			inc.setDesc(request.getParameter("desc"));
			inc.setPendingwth(request.getParameter("pendig_with"));
			inc.setStatus(request.getParameter("status"));
			inc.setComnt(request.getParameter("comment"));
			inc.setAnalyst(analyst);
//			PrintWriter out=response.getWriter();
//			out.println(inc.getDate());
			IncDao idao=new IncDao();
			boolean a=idao.insert(inc);
			if(a==true){
				RequestDispatcher rd=request.getRequestDispatcher("CreateInc.jsp?msg=successful");
				rd.forward(request,response);
			}
			else{
				RequestDispatcher rd=request.getRequestDispatcher("CreateInc.jsp?msg=unsuccessful");
				rd.forward(request,response);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
