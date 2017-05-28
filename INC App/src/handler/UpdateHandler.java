package handler;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IncDao;
import dao.IncDao2;
import dao.ReadIncDao;
import dto.IncDto;
import dto.IncDto2;

/**
 * Servlet implementation class UpdateHandler
 */
@WebServlet("/UpdateHandler")
public class UpdateHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try{
			HttpSession session=request.getSession();
			String analyst=(String)session.getAttribute("name");
			logger.info("In update handler,name in session as"+analyst);
			IncDto2 inc=new IncDto2();
			inc.setCasenmbr(request.getParameter("case_nmbr"));
			inc.setDate(formatter.parse(request.getParameter("Assign_date")));
			inc.setDesc(request.getParameter("desc"));
			inc.setPendingwth(request.getParameter("pendig_with"));
			inc.setStatus(request.getParameter("status"));
			inc.setComnt(request.getParameter("comment"));
			inc.setFeanalyst(analyst);
			IncDao2 idao=new IncDao2();
			String filter=request.getParameter("filter");
			boolean a=idao.update(inc);
			
			if(a==true){
				logger.info("record updated successfully");
				RequestDispatcher rd=request.getRequestDispatcher("incReadHandler?msg=successful");
				rd.forward(request,response);
			}
			else{
				logger.info("record failed to be udpdated");
				RequestDispatcher rd=request.getRequestDispatcher("incReadHandler?msg=unsuccessful");
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
