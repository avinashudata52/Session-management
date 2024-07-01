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
 * Servlet implementation class CookielogOut
 */
@WebServlet("/CookielogOut")
public class CookielogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**more
     * @see HttpServlet#HttpServlet()
     */
    public CookielogOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Cookie[] cookies=request.getCookies();
		int flag=0;
		for(Cookie ck:cookies)
		{
			String userName=ck.getName();
			if(userName.equals("User-Cookie"));
			{
			Cookie cookie=new Cookie(userName,"");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			flag=1;
			break;
		}
	}
	if(flag==1)
	{
	
		response.sendRedirect("CookieLogin.html");
	}
	else
	{
		out.println("not able logout");
	}
	}
	private Object newCookie(String userName, String string) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
