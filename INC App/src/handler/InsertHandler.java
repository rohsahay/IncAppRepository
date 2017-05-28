package handler;

import java.io.IOException;
import java.io.PrintWriter;
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

import dto.IncDto;
import dto.IncDto2;
import dao.IncDao;
import dao.IncDao2;

/**
 * Servlet implementation class InsertHandler
 */
@WebServlet("/InsertHandler")
public class InsertHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger();
	SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
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
			logger.info("In insert handler,name in session as "+analyst);
			IncDto2 inc=new IncDto2();
			inc.setCasenmbr(request.getParameter("case_nmbr"));
			logger.info("date from form "+request.getParameter("Assign_date"));
			inc.setDate(formatter.parse(request.getParameter("Assign_date")));
			logger.info("date as inserted in DTO "+inc.getDate());
			inc.setDesc(request.getParameter("desc"));
			inc.setPendingwth(request.getParameter("pendig_with"));
			inc.setStatus(request.getParameter("status"));
			inc.setComnt(request.getParameter("comment"));
			inc.setFeanalyst(analyst);
//			PrintWriter out=response.getWriter();
//			out.println(inc.getDate());
			IncDao2 idao=new IncDao2();
			boolean a=idao.insert(inc);
			if(a==true){
				System.out.println("record inserted successfully");
				RequestDispatcher rd=request.getRequestDispatcher("CreateInc.jsp?msg=successful");
				rd.forward(request,response);
			}
			else{
				System.out.println("Record insertion failed");
				RequestDispatcher rd=request.getRequestDispatcher("CreateInc.jsp?msg=unsuccessful");
				rd.forward(request,response);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
