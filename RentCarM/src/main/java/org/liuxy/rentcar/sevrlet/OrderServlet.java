package org.liuxy.rentcar.sevrlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.liuxy.rentcar.entity.CarInfo;
import org.liuxy.rentcar.entity.NormalUser;
import org.liuxy.rentcar.entity.Order;
import org.liuxy.rentcar.service.CarInfoService;
import org.liuxy.rentcar.service.OrderService;
import org.liuxy.rentcar.service.impl.CarInfoServiceImpl;
import org.liuxy.rentcar.service.impl.OrderServiceImpl;
import org.liuxy.util.DBConfig;

/**
 * Servlet implementation class OrderOprations
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private OrderService orderService = new OrderServiceImpl();
	private CarInfoService carInfoService = new CarInfoServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
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
		
		switch (opr) {
		case "confirm":
			confirmOrder(request, response);
			break;
		case "display":
			displayOrder(request, response);
			break;
		case "toOrder":
			toOrder(request, response);
			break;
		case "tradeOrder":
			tradeOrder(request, response);
			break;
		default:
			break;
		}
		
		
	}
	
	protected void tradeOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer carId = Integer.parseInt(request.getParameter("carId"));
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		
		String format = "yyyy年MM月dd日";
		
		DBConfig config = DBConfig.getInstance();
		
		String getDateVal = request.getParameter("getDate");
		Date getDate = config.getDateByFormat(getDateVal, format);
		
		String reDateVal = request.getParameter("reDate");
		Date reDate = config.getDateByFormat(reDateVal, format);
		
		String getAddress = request.getParameter("getAddress");
		String reAddress = request.getParameter("reAddress");
		
		String fee = request.getParameter("fee");
		BigDecimal bigDecimal = new BigDecimal(fee);
		
		Order order = new Order();
		
		CarInfo carInfo = new CarInfo();
		carInfo.setCarId(carId);
		order.setCarInfo(carInfo);
		
		NormalUser normalUser = new NormalUser();
		normalUser.setUserId(userId);
		order.setNormalUser(normalUser);
		
		order.setGetDate(getDate);
		order.setReDate(reDate);
		order.setGetAddress(getAddress);
		order.setReAddress(reAddress);
		
		order.setFee(bigDecimal);
		order.setOrderState(0);
		
		orderService.tradeOrder(order);
		
		request.setAttribute("orderInfo", "");
		
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}

	protected void toOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer carId = Integer.parseInt(request.getParameter("carId"));
		
		CarInfo carInfo = carInfoService.findCarInfoByCarId(carId);
		
		request.setAttribute("orderCarInfo", carInfo);
		
		request.getRequestDispatcher("trade.jsp").forward(request, response);
		
	}

	protected void confirmOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = (String)request.getAttribute("orderId");
		orderService.confirm(2, Integer.parseInt(orderId));
	}
	
	protected void displayOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
