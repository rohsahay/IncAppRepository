package handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.SignupDto;
import dao.SignupDao;
/**
 * Servlet implementation class SignupHandler
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SignupHandler" })
public class SignupHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			SignupDto sdto=new SignupDto();
		
			sdto.setName(request.getParameter("cec_id"));
			sdto.setPassword(request.getParameter("pswrd"));
			PrintWriter out=response.getWriter();
		
			SignupDao sdao=new SignupDao();
			boolean s=sdao.signup(sdto);
			if(s){
				out.println("user successfully signedup");
				out.println("click to return to home page");
			}
			else{
				out.println("signup unsuccessful, please try again");
				out.println("click to return to home page");
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
