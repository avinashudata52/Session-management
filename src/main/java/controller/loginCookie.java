package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginCookie
 */
@WebServlet("/LoginWithCookie")
public class loginCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	List<String> username = new ArrayList();
	List<String> userPassword = new ArrayList();
	
    public loginCookie() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config)
    {
    	username.add("SBICUST007");
    	username.add("PNBCUST008");
    	username.add("HDFCCUST009");
    	
    	userPassword.add("SBI@123");
    	userPassword.add("PNB@3010");
    	userPassword.add("HDFC@748");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String un=request.getParameter("un");
		String pw=request.getParameter("pw");
		System.out.println(un+ " "+pw);
		int userflag=0;
		int passflag=0;
		//String[] userNames;
		for(String user:username)
		{
		//out.println("Hi"+user);
			if(user.equals(un))
			{
				userflag = 1;
				break;
			}
		}
		for(String pass:userPassword)
		{
			//out.println("Hello"+pass);
			if(pass.equals(pw))
			{
				passflag=1;
				break;
			}
		}
		if(userflag==1 && passflag==1)
		{
			//create object of cookie
			Cookie userCookie =  new Cookie("User-Cookie",un);
			Cookie passwordCookie = new Cookie("Pass-Cookie",pw);
			userCookie.setMaxAge(24*60*60);
			passwordCookie.setMaxAge(24*60*60);
			response.addCookie(userCookie);
			response.addCookie(passwordCookie);
			out.println("<script>alert('Login success')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("profile.html");
			rd.include(request, response);
			
			
		}
		else
		{
			out.println("<script>alert('Login failed')</script>");
		}
		
	}

}
