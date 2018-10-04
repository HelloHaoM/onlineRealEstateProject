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
 * Servlet implementation class NewApartmentFormController
 */
@WebServlet("/NewApartmentFormController")
public class NewApartmentFormController extends ActionServlet {
	private static final long serialVersionUID = 1L;
	
	private static ApartmentService apartmentService = new ApartmentServiceImp();
	private static ApartmentServiceBean apartmentServiceBean = new ApartmentServiceBeanImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewApartmentFormController() {
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
		if(request.getParameter("back") != null) {
			httpSession.setAttribute("userId", id);
			SessionManager.getInstance().setHttpSession(httpSession);
			response.sendRedirect("./RealEstate/RealEstatePage.jsp?id="+id);
		}
		else if(request.getParameter("create") != null) {
			String startRentTime = request.getParameter("startRentTime");
			String endRentTime = request.getParameter("endRentTime");
			String availability = request.getParameter("availability");
			int price = Integer.parseInt(request.getParameter("price"));
			int acreage = Integer.parseInt(request.getParameter("acreage"));
			String location = request.getParameter("location");
			String apartmentName = request.getParameter("apartmentName");
			
//			UnitofWorkApartment.newCurrent();
//			Apartment apartment = new Apartment(0, startRentTime, endRentTime, 
//					availability, price, acreage, location, apartmentName);
//			if(apartmentService.addApartment(apartment)) {
//				httpSession.setAttribute("userId", id);
//				response.sendRedirect("./RealEstate/RealEstatePage.jsp?id="+id);
//			}
			
			UnitofWorkApartment.newCurrent();
			ApartmentDTO apartmentDTO = new ApartmentDTO(0, startRentTime, endRentTime, 
					availability, price, acreage, location, apartmentName);
			
			apartmentServiceBean.createApartmentByByte(ApartmentDTO.object2Byte(apartmentDTO));
			httpSession.setAttribute("userId", id);
			SessionManager.getInstance().setHttpSession(httpSession);
			response.sendRedirect("./RealEstate/RealEstatePage.jsp?id="+id);
			
		}
	}

}
