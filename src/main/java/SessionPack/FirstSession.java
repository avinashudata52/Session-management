package SessionPack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstSession
 */
@WebServlet("/session1")
public class FirstSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//creating session object invoking getSession() of HttpServletResponse interface
		HttpSession session=request.getSession();
		out.println("<h3><font color='blue'session ID:"+session.getId()+"</font><h3>");
		//printing session creation time
		out.println("<h3><font color='red'>Session Enter Time:"
				+new Date(session.getCreationTime())+"</font></h3>");
	
	
	//binding a map object with session
	Map<Integer,Double> employees=new TreeMap();
	employees.put(108, 34000.00);
	employees.put(118, 70000.00);
	employees.put(8, 84000.00);
	employees.put(98, 94000.00);	

	// I will bind the entire map object whith session object
	// void setAttribute(String key, object obj)

	session.setAttribute("empKey", employees);
	RequestDispatcher rd=request.getRequestDispatcher("SessionLink.html");
	rd.include(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
