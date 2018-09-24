package onlinerealestateproject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onlinerealestateproject.domain.Apartment;
import onlinerealestateproject.dto.ApartmentDTO;
import onlinerealestateproject.lock.impl.ExclusiveWriteLockManager;
import onlinerealestateproject.service.ApartmentService;
import onlinerealestateproject.service.ApartmentServiceBean;
import onlinerealestateproject.service.imp.ApartmentServiceBeanImp;
import onlinerealestateproject.service.imp.ApartmentServiceImp;
import onlinerealestateproject.util.UnitofWorkApartment;

/**
 * Servlet implementation class ApartmentFormController
 */
@WebServlet("/ApartmentFormController")
public class ApartmentFormController extends ActionServlet {
	private static final long serialVersionUID = 1L;
	
	private static ApartmentService apartmentService = new ApartmentServiceImp();
	private static ApartmentServiceBean apartmentServiceBean = new ApartmentServiceBeanImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApartmentFormController() {
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
		SessionManager.getInstance().setHttpSession(httpSession);
		
		int id = Integer.parseInt(request.getParameter("id"));
		int apid = Integer.parseInt(request.getParameter("apid"));
		httpSession.setAttribute("userId", id);
		httpSession.setAttribute("apartmentId", apid);
		SessionManager.getInstance().setHttpSession(httpSession);
		if(request.getParameter("confirm") != null) {
			String startRentTime = request.getParameter("startRentTime");
			String endRentTime = request.getParameter("endRentTime");
			String availability = request.getParameter("availability");
			int price = Integer.parseInt(request.getParameter("price"));
			int acreage = Integer.parseInt(request.getParameter("acreage"));
			String location = request.getParameter("location");
			String apartmentName = request.getParameter("apartmentName");
			
//			UnitofWorkApartment.newCurrent();
//			Apartment apartment = new Apartment(apid, startRentTime, endRentTime, 
//					availability, price, acreage, location, apartmentName);
//			if(apartmentService.updateApartment(apartment)) {
//				request.setAttribute("info", "Update Successfully");
//				//forward("./ApartmentForm/ApartmentFormPage.jsp?id="+id+"&apid="+apid, request, response);
//				response.sendRedirect("./RealEstate/RealEstatePage.jsp?id="+id);
//			}
			
			//TODO need to get a lock
			UnitofWorkApartment.newCurrent();
			ApartmentDTO apartmentDTO = new ApartmentDTO(apid, startRentTime, endRentTime, 
					availability, price, acreage, location, apartmentName);
			
			ExclusiveWriteLockManager.getInstance().acquireLock(apid, SessionManager.getInstance().getHttpSessionId());
			
			apartmentServiceBean.updateApartmentByByte(apid, ApartmentDTO.object2Byte(apartmentDTO));
			
			ExclusiveWriteLockManager.getInstance().releaseLock(apid, SessionManager.getInstance().getHttpSessionId());
			
			request.setAttribute("info", "Update Successfully");
			response.sendRedirect("./RealEstate/RealEstatePage.jsp?id="+id);
			
		}
		else if(request.getParameter("back") != null) {
			response.sendRedirect("./RealEstate/RealEstatePage.jsp?id="+id);
		}
	}

}
