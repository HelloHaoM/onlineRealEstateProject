package onlinerealestateproject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onlinerealestateproject.service.UserService;
import onlinerealestateproject.service.imp.UserServiceImp;

/**
 * Servlet implementation class AdmLoginController
 */
@WebServlet("/AdmLoginController")
public class AdmLoginController extends ActionServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserServiceImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmLoginController() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession httpSession = request.getSession();
		
		if(request.getParameter("submit").equals("login")) {
			System.out.println(request.getParameter("username"));
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			if(userService.admLogin(userName, password)) {
				int id = userService.findUserId(userName, password);
				httpSession.setAttribute("userId", id);
				httpSession.setAttribute("userName", userName);
				response.sendRedirect("./RealEstate/RealEstatePage.jsp?id="+id+"&userName="+userName);
			}
			else {
				request.setAttribute("info", "Wrong User Name or Wrong Password");
				forward("AdmLoginPage.jsp", request, response);
			}
			
		}
	}

}
