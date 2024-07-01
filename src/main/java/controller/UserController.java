package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserService;

import java.util.*;
import module.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/reg")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
		//fetching all requested input from html element
		String userName=request.getParameter("un");
		String userPassword=request.getParameter("pw");
		String userRole=request.getParameter("userRole");
		
		//constructing object of model class Called user using consturctor input
		
		User user=new User(userName, userPassword, userRole);
		
		//Now user object have to pass to server class
		UserService serviceObj = new UserService();
		
		// add the user object to my list
		User userStatusObj=serviceObj.addUser(user);
		if(userStatusObj!=null)
		{
			out.println("Welcome........"+userStatusObj.getUserName()+ " "+"to my website");
			out.print("you have successfully register in our System");
			out.print("<a href='SessionLogin.html'>GO BACK TO HOME</a>");
		}
		
		
		
	}

}
