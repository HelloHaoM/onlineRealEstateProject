package onlinerealestateproject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlinerealestateproject.domain.Apartment;
import onlinerealestateproject.service.ApartmentService;
import onlinerealestateproject.service.imp.ApartmentServiceImp;
import onlinerealestateproject.util.UnitofWorkApartment;

/**
 * Servlet implementation class NewApartmentFormController
 */
@WebServlet("/NewApartmentFormController")
public class NewApartmentFormController extends ActionServlet {
	private static final long serialVersionUID = 1L;
	
	private static ApartmentService apartmentService = new ApartmentServiceImp();
       
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
		int id = Integer.parseInt(request.getParameter("id"));
		if(request.getParameter("back") != null) {
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
			
			UnitofWorkApartment.newCurrent();
			Apartment apartment = new Apartment(0, startRentTime, endRentTime, 
					availability, price, acreage, location, apartmentName);
			if(apartmentService.addApartment(apartment)) {
				response.sendRedirect("./RealEstate/RealEstatePage.jsp?id="+id);
			}
			
		}
	}

}
