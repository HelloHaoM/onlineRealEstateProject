package onlinerealestateproject.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlinerealestateproject.service.UserService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginAndRegisterController")
public class LoginAndRegisterController extends ActionSevlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAndRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		UserService userService = new UserService();
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		if(request.getParameter("submit").equals("login")) {
			System.out.println(request.getParameter("username"));
			//request.getRequestDispatcher("./RealEstate/RealEstatePage.jsp").forward(request, response);
			//forward("/RealEstatePage.jsp", request, response);
			response.sendRedirect("./RealEstate/RealEstatePage.jsp");
		}
		else if(request.getParameter("submit").equals("register")) {
			System.out.println(request.getParameter("register-username"));
		}
	}

}
