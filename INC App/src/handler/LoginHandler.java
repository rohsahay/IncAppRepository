package handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dto.LoginDto;
import dao.UserLoginDao2;

/**
 * Servlet implementation class LoginHandler
 */
@WebServlet("/LoginHandler")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			LoginDto ldto=new LoginDto();
			ldto.setName(request.getParameter("cec_id"));
			ldto.setPassword(request.getParameter("pswrd"));
			ldto.setPrivilege(request.getParameter("usr_adm"));
			String username=ldto.getName();
			PrintWriter out=response.getWriter();
			
/*			System.out.println("test context attribute");
			getServletContext().setAttribute("name","rohit");
			getServletContext().setAttribute("profession","ITprofessional");
			System.out.println(getServletContext().getAttribute("name"));
			System.out.println(getServletContext().getAttribute("profession"));
*/			
			if((request.getParameter("usr_adm")).equals("user")){
				
				UserLoginDao2 uldao=new UserLoginDao2();
				//user credential validation from database
				boolean val=uldao.validate(ldto);
					
				if (val){
				
					logger.info("user login Successful");
					logger.info("creating a new session if it doesnt exit");					
					HttpSession session=request.getSession();
					session.setAttribute("name",request.getParameter("cec_id"));
					session.setAttribute("login","ok");
//					session.setMaxInactiveInterval(1*60);
					if(session.isNew()){
						logger.info("this is a new session");
					}
					
					else{
						logger.info("welcome back, session alredy exists");
						logger.info("getting session id from cookie..");
						Cookie[] cookies=request.getCookies();
						for(int i=0;i<=cookies.length;i++){
							Cookie cookie=cookies[i];
							if(cookie.getName().equalsIgnoreCase("jsessionid")){
								String sessionid=cookie.getValue();
								logger.info("session id= "+sessionid);
								break;
							}
						}
					}
						
					response.sendRedirect("controller_inc?hidden=UserviewHandler");
					
				}
					
 					
				else{
				
					out.println("incorret user credentials");
//					response.sendRedirect("successfull.jsp?a=Incorrect Credentials");
			
				}
			}
			else{
				//Admin login validation from database
				UserLoginDao2 uldao=new UserLoginDao2();
				boolean val=uldao.validate(ldto);
				if (val){
					
					logger.info("admin login Successful");
					HttpSession session=request.getSession();
					session.setAttribute("name",request.getParameter("cec_id"));
					session.setAttribute("login","ok");
					if(session.isNew())
						logger.info("this is a new session");
					else
						logger.info("welcome back, session alredy exists");
					
					response.sendRedirect("controller_inc?hidden=adminview");
								
				}
				else{
					out.println("incorret admin credentials");
//					response.sendRedirect("successfull.jsp?a=Incorrect Credentials");
				}
			
			}	

		}
		catch (Exception e){
			e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
