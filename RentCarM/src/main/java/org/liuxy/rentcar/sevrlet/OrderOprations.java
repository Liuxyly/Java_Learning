package org.liuxy.rentcar.sevrlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.liuxy.rentcar.service.OrderService;
import org.liuxy.rentcar.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderOprations
 */
@WebServlet("/OrderOprations")
public class OrderOprations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private OrderService orderService = new OrderServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderOprations() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opr = request.getParameter("opr");
		if (opr.equals("confirm")) {
			confirmOrder(request, response);
		}
		
		if (opr.equals("display")) {
			displayOrder(request, response);
		}
	}
	
	protected void confirmOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = (String)request.getAttribute("orderId");
		orderService.confirm(2, Integer.parseInt(orderId));
	}
	
	protected void displayOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
