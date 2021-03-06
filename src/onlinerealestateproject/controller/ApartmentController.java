package onlinerealestateproject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onlinerealestateproject.domain.Order;
import onlinerealestateproject.dto.OrderDTO;
import onlinerealestateproject.lock.impl.ExclusiveWriteLockManager;
import onlinerealestateproject.service.ApartmentService;
import onlinerealestateproject.service.ApartmentServiceBean;
import onlinerealestateproject.service.OrderService;
import onlinerealestateproject.service.OrderServiceBean;
import onlinerealestateproject.service.imp.ApartmentServiceBeanImp;
import onlinerealestateproject.service.imp.ApartmentServiceImp;
import onlinerealestateproject.service.imp.OrderServiceBeanImp;
import onlinerealestateproject.service.imp.OrderServiceImp;

/**
 * Servlet implementation class ApartmentController
 */
@WebServlet("/ApartmentController")
public class ApartmentController extends ActionServlet {
	private static final long serialVersionUID = 1L;
	
	private static OrderService orderService = new OrderServiceImp();
	private static ApartmentService apartmentService = new ApartmentServiceImp();
	private static OrderServiceBean orderServiceBean = new OrderServiceBeanImp();
	private static ApartmentServiceBean apartmentServiceBean = new ApartmentServiceBeanImp();
       
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
		
		HttpSession session = request.getSession();
		SessionManager.getInstance().setHttpSession(session);
		
		int uid = Integer.parseInt(request.getParameter("client-id"));
		int apid = Integer.parseInt(request.getParameter("apartment-id"));
		String userName = request.getParameter("username");
		String inspectionTime = request.getParameter("inspection-time");
		// make an order via orderService
		if(request.getParameter("book") != null) {
			
			ExclusiveWriteLockManager.getInstance().acquireLock(apid, SessionManager.getInstance().getHttpSessionId());
			
			if(orderService.makeOrder(uid, apid, inspectionTime)) {
				session.setAttribute("userId", uid);
				session.setAttribute("apartmentId", apid);
				SessionManager.getInstance().setHttpSession(session);
				response.sendRedirect("./InspectionCart/InspectionCartPage.jsp?id="+uid);
			}
			
			ExclusiveWriteLockManager.getInstance().releaseLock(apid, SessionManager.getInstance().getHttpSessionId());
		}
		else if(request.getParameter("update") != null) {
			session.setAttribute("userId", uid);
			session.setAttribute("apartmentId", apid);
			SessionManager.getInstance().setHttpSession(session);
			response.sendRedirect("./ApartmentForm/ApartmentFormPage.jsp?id="+uid+"&apid="+apid);
		}
		else if(request.getParameter("delete") != null) {
//			if(apartmentService.deleteApartment(apid)) {
//				session.setAttribute("userId", uid);
//				session.setAttribute("apartmentId", apid);
//				session.setAttribute("userName", userName);
//				response.sendRedirect("./RealEstate/RealEstatePage.jsp?id="+uid+"&userName="+userName);
//			}
			//TODO: Need to get lock
			session.setAttribute("userId", uid);
			session.setAttribute("apartmentId", apid);
			session.setAttribute("userName", userName);
			SessionManager.getInstance().setHttpSession(session);
			
			ExclusiveWriteLockManager.getInstance().acquireLock(apid, SessionManager.getInstance().getHttpSessionId());
			
			apartmentServiceBean.deleteApartment(apid);
			
			ExclusiveWriteLockManager.getInstance().releaseLock(apid, SessionManager.getInstance().getHttpSessionId());
			
			response.sendRedirect("./RealEstate/RealEstatePage.jsp?id="+uid+"&userName="+userName);
			
		}
		
		
		
	}

}
