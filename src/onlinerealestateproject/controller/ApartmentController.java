package onlinerealestateproject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlinerealestateproject.domain.Order;
import onlinerealestateproject.service.OrderService;
import onlinerealestateproject.service.OrderServiceImp;

/**
 * Servlet implementation class ApartmentController
 */
@WebServlet("/ApartmentController")
public class ApartmentController extends ActionServlet {
	private static final long serialVersionUID = 1L;
	
	private static OrderService orderService = new OrderServiceImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApartmentController() {
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
		int uid = Integer.parseInt(request.getParameter("client-id"));
		int apid = Integer.parseInt(request.getParameter("apartment-id"));
		System.out.println(uid);
		System.out.println(apid);
		if(orderService.makeOrder(uid, apid)) {
			response.sendRedirect("./InspectionCart/InspectionCartPage.jsp?id="+uid);
		}
		
		
	}

}
