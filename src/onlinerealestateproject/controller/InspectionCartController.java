package onlinerealestateproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.DocumentationTool.Location;

import onlinerealestateproject.domain.Order;
import onlinerealestateproject.service.OrderService;
import onlinerealestateproject.service.OrderServiceImp;

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
		
		if(request.getParameter("back") != null) {
			int uid = Integer.parseInt(request.getParameter("id"));
			response.sendRedirect("./RealEstate/RealEstatePage.jsp?id="+uid);
		}
		else if(request.getParameter("delete") != null) {
			System.out.println("delete order");
			int uid = Integer.parseInt(request.getParameter("id"));
			int oid = Integer.parseInt(request.getParameter("order-id"));
			if(orderService.deleteOrder(uid, oid)) {
				response.sendRedirect("./InspectionCart/InspectionCartPage.jsp?id="+uid);
				System.out.println("Delete Successful");
			}
		}else if(request.getParameter("confirm") != null) {
			int uid = Integer.parseInt(request.getParameter("id"));
			response.sendRedirect("./RealEstate/RealEstatePage.jsp?id="+uid);
		}else if(request.getParameter("update") != null) {
			int uid = Integer.parseInt(request.getParameter("id"));
			int oid = Integer.parseInt(request.getParameter("order-id"));
			String inspectionTime = request.getParameter("inspection-time");
			if(orderService.updateOrder(oid, inspectionTime)) {
				request.setAttribute("info", "Update Successfully");
				//request.getRequestDispatcher("LoginAndRegisterPage.jsp").forward(request, response);
				forward("./InspectionCart/InspectionCartPage.jsp?id="+uid, request, response);
				//response.sendRedirect("./InspectionCart/InspectionCartPage.jsp?id="+uid);
			}
		}
		
	}

}
