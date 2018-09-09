package onlinerealestateproject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActionSevlet
 */
@WebServlet("/ActionSevlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * forward a request to other jsp
     * @param target
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void forward(String target, HttpServletRequest request,
    		HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher(target);
    	dispatcher.forward(request, response);
    }

}
