package SessionPack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.*;
import java.util.Map.Entry;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FetchempServlet
 */
@WebServlet("/session2")
public class FetchempServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchempServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		// getting old session object
		HttpSession session=request.getSession(false);
		// fetchinf the value from session object which is binded based on key
		// object getAttribute (Session key);
		Map<Integer,Double> mapObjects=(Map<Integer,Double>) session.getAttribute("empKey");

		out.print("<table border='2' cellpadding='2' cellspacing='2'>");
		out.print("<thread>");
		out.print("<th>ID</th>");
		out.print("<th>SALARY</th>");
		out.print("</thread>");
		for(Entry<Integer, Double> e:mapObjects.entrySet())
		{
			out.print("<tr>");
			out.print("<td bgcolor='pink'>"+e.getKey()+"</td>");
			out.print("<td bgcolor='red'>"+e.getValue()+"</td");
			out.print("</tr>");
		}
		
		out.print("</table>");
		out.print("Last Access Time of App:"+new Date(session.getLastAccessedTime()));
		out.print("<a href='SessionLink.html'> HOME </a>");	

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
