package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/checkBal")
public class BalanceChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BalanceChecker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		String CookieName=null;
		String CookieValue=null;
		int cookieStatus = 0;
		for(Cookie ck : cookies)
		{
			CookieName=ck.getName();
			CookieValue=ck.getValue();
			
			if(CookieName.equalsIgnoreCase("User-Cookie") && CookieValue.equalsIgnoreCase("SBICUST007"))
			{
				out.println("Hi"+" "+CookieValue+" "+"Your account balance is:"+" "+"5000.00");
				out.println("<a href='CookielogOut'>logout</a>");
				cookieStatus=1;
				break;
			
			}
		}
		if(cookieStatus!=1)
		{
			out.println("Invalid Cookies ...!!");
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
