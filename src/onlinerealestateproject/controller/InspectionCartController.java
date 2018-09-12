package onlinerealestateproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.tools.DocumentationTool.Location;

import onlinerealestateproject.domain.Order;
import onlinerealestateproject.service.OrderService;
import onlinerealestateproject.service.imp.OrderServiceImp;

/**
 * Servlet implementation class InspectionCartController
 */
@WebServlet("/InspectionCartController")
public class InspectionCartController extends ActionServlet {
	private static final long serialVersionUID = 1L;
	private static OrderService orderService = new OrderServiceImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InspectionCartController() {
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
		
		if(request.getParameter("back") != null) {
			// back to main page
			int uid = Integer.parseInt(request.getParameter("id"));
			httpSession.setAttribute("userId", uid);
			response.sendRedirect("./RealEstate/RealEstatePage.jsp?id="+uid);
		}
		else if(request.getParameter("delete") != null) {
			// delete an order
			System.out.println("delete order");
			int uid = Integer.parseInt(request.getParameter("id"));
			int oid = Integer.parseInt(request.getParameter("order-id"));
			if(orderService.deleteOrder(uid, oid)) {
				httpSession.setAttribute("userId", uid);
				response.sendRedirect("./InspectionCart/InspectionCartPage.jsp?id="+uid);
				System.out.println("Delete Successful");
			}
		}else if(request.getParameter("confirm") != null) {
			// confirm and back to main page
			int uid = Integer.parseInt(request.getParameter("id"));
			httpSession.setAttribute("userId", uid);
			response.sendRedirect("./RealEstate/RealEstatePage.jsp?id="+uid);
		}else if(request.getParameter("update") != null) {
			// update an order
			int uid = Integer.parseInt(request.getParameter("id"));
			int oid = Integer.parseInt(request.getParameter("order-id"));
			String inspectionTime = request.getParameter("inspection-time");
			if(orderService.updateOrder(oid, inspectionTime)) {
				httpSession.setAttribute("userId", uid);
				request.setAttribute("info", "Update Successfully");
				forward("./InspectionCart/InspectionCartPage.jsp?id="+uid, request, response);
			}
		}
		
	}

}
