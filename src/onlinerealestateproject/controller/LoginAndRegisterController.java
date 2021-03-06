package onlinerealestateproject.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onlinerealestateproject.domain.Client;
import onlinerealestateproject.domain.User;
import onlinerealestateproject.service.UserService;
import onlinerealestateproject.service.imp.UserServiceImp;
import onlinerealestateproject.util.UserFactory;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginAndRegisterController")
public class LoginAndRegisterController extends ActionServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserServiceImp();
       
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
		SessionManager.getInstance().setHttpSession(httpSession);
		
		if(request.getParameter("submit").equals("login")) {
			System.out.println(request.getParameter("username"));
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			if(userService.login(userName, password)) {
				int id = userService.findUserId(userName, password);
				httpSession.setAttribute("userId", id);
				httpSession.setAttribute("userName", userName);
				SessionManager.getInstance().setHttpSession(httpSession);
				response.sendRedirect("./RealEstate/RealEstatePage.jsp?id="+id+"&userName="+userName);
			}
			else {
				request.setAttribute("info", "Wrong User Name or Wrong Password");
				forward("LoginAndRegisterPage.jsp", request, response);
			}
			
		}
		else if(request.getParameter("submit").equals("register")) {
			String firstName = request.getParameter("register-firstname");
			String lastName = request.getParameter("register-lastname");
			String userName = request.getParameter("register-username");
			String password = request.getParameter("register-password");
			if(userService.register(firstName, lastName, userName, password)) {
				int id = userService.findUserId(userName, password);
				httpSession.setAttribute("userId", id);
				httpSession.setAttribute("userName", userName);
				SessionManager.getInstance().setHttpSession(httpSession);
				response.sendRedirect("./RealEstate/RealEstatePage.jsp?id="+id+"&userName="+userName);
			}else {
				request.setAttribute("info", "Register Failed");
				forward("LoginAndRegisterPage.jsp", request, response);
			}
		}
	}

}
