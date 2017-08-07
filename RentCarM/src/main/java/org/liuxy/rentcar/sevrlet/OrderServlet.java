package org.liuxy.rentcar.sevrlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.liuxy.rentcar.entity.CarInfo;
import org.liuxy.rentcar.entity.NormalUser;
import org.liuxy.rentcar.entity.Order;
import org.liuxy.rentcar.entity.Page;
import org.liuxy.rentcar.service.CarInfoService;
import org.liuxy.rentcar.service.OrderService;
import org.liuxy.rentcar.service.impl.CarInfoServiceImpl;
import org.liuxy.rentcar.service.impl.OrderServiceImpl;
import org.liuxy.util.DBConfig;

import com.alibaba.fastjson.JSON;

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
		case "display":
			displayOrder(request, response);
			break;
		case "toOrder":
			toOrder(request, response);
			break;
		case "tradeOrder":
			tradeOrder(request, response);
			break;
		case "rAlterOrder":
			rAlterOrder(request, response);
			break;
		case "alterOrder":
			alterOrder(request, response);
			break;
		case "cancelOrder":
			cancelOrder(request, response);
			break;
		case "getOrderPage":
			getOrderPage(request, response);
			break;
		case "getAdminOrderPage":
			getAdminOrderPage(request, response);
			break;
		case "confirmRentCar":
			confirmRentCar(request, response);
			break;
		case "closeRentCar":
			closeRentCar(request, response);
		default:
			break;
		}
	}

	protected void closeRentCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderIdVal = request.getParameter("orderId");
		String userIdVal = request.getParameter("userId");
		String carIdVal = request.getParameter("carId");
		
		int rc = orderService.closeOrderByOrderId(Long.parseLong(orderIdVal), Integer.parseInt(userIdVal), Integer.parseInt(carIdVal));
		PrintWriter out = response.getWriter();
		
		if (rc != 0) {
			out.print(true);
		} else {
			out.print(false);
		}
		
		out.close();
	}

	protected void confirmRentCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		int rc = orderService.confirm(3, Long.parseLong(orderId));
		PrintWriter out = response.getWriter();
		
		if (rc != 0) {
			out.print(true);
		} else {
			out.print(false);
		}
		
		out.close();
	}

	protected void getAdminOrderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> map = request.getParameterMap();
		List<String> orderState = null;
		List<String> brandId = null;
		List<String> userName = null;
		List<String> orderId = null;
		String pageNumber = null;
		
		Pattern pattern = Pattern.compile("\\[([^\\]]*)\\]");
		Matcher matcher = null;
		
		String tmpKey = null;
		
		Iterator<String> iter = map.keySet().iterator();
		
		while (iter.hasNext()) {
			String key = iter.next();
			matcher = pattern.matcher(key);
			
			if (matcher.find()){
				tmpKey = matcher.group(1);
			} else {
				tmpKey = "";
			}
			
			switch (tmpKey) {
			case "orderState":
				orderState = Arrays.asList((String[]) map.get(key));
				break;
			case "orderId":
				orderId = Arrays.asList((String[]) map.get(key));
				break;
			case "brandId":
					brandId = Arrays.asList((String[]) map.get(key));
				break;
			case "pageNumber":
				for (Object obj : map.get(key)) {
					pageNumber = (String)obj;
				}
				break;
			case "userName":
				userName = Arrays.asList((String[]) map.get(key));
				break;
			default:
				break;
			}
		}
		
		Page<Order> paging = new Page<>(orderService.getOrderCountByCondition(userName, orderState, brandId, orderId), Integer.parseInt(pageNumber), 6);
		
		paging.setPageList(orderService.findOrdersByCondition(userName, orderState, brandId, orderId, paging));
		
		String pagingJson = JSON.toJSONString(paging);
		System.out.println(pagingJson);
		PrintWriter out = response.getWriter();
		
		out.print(pagingJson);
		
		out.close();
	}

	protected void getOrderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> map = request.getParameterMap();
		List<String> orderState = null;
		List<String> brandId = null;
		List<String> userId = null;
		String pageNumber = null;
		
		Pattern pattern = Pattern.compile("\\[([^\\]]*)\\]");
		Matcher matcher = null;
		
		String tmpKey = null;
		
		Iterator<String> iter = map.keySet().iterator();
		
		while (iter.hasNext()) {
			String key = iter.next();
			matcher = pattern.matcher(key);
			
			if (matcher.find()){
				tmpKey = matcher.group(1);
			} else {
				tmpKey = "";
			}
			
			switch (tmpKey) {
			case "orderState":
				orderState = Arrays.asList((String[]) map.get(key));
				break;
			case "brandId":
					brandId = Arrays.asList((String[]) map.get(key));
				break;
			case "pageNumber":
				for (Object obj : map.get(key)) {
					pageNumber = (String)obj;
				}
				break;
			case "userId":
				userId = Arrays.asList((String[]) map.get(key));
				break;
			default:
				break;
			}
		}
		
		Page<Order> paging = new Page<>(orderService.getOrderCountByCondition(userId, orderState, brandId), Integer.parseInt(pageNumber), 6);
		
		paging.setPageList(orderService.findOrdersByCondition(userId, orderState, brandId, paging));
		
		String pagingJson = JSON.toJSONString(paging);
		System.out.println(pagingJson);
		PrintWriter out = response.getWriter();
		
		out.print(pagingJson);
		
		out.close();
		
	}

	protected void alterOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		String carId = request.getParameter("carId");
		String userId = request.getParameter("userId");
		String getDateVal = request.getParameter("getDate");
		String reDateVal = request.getParameter("reDate");
		String getAddress = request.getParameter("getAddress");
		String reAddress = request.getParameter("reAddress");
		String fee = request.getParameter("fee");
		
		String format = "yyyy年MM月dd日";
		
		DBConfig config = DBConfig.getInstance();
		
		Date getDate = config.getDateByFormat(getDateVal, format);
		Date reDate = config.getDateByFormat(reDateVal, format);
		
		Order order = new Order();
		order.setOrderId(Long.parseLong(orderId));
		
		NormalUser normalUser = new NormalUser();
		normalUser.setUserId(Integer.parseInt(userId));
		order.setNormalUser(normalUser);
		order.setGetDate(getDate);
		order.setReDate(reDate);
		order.setGetAddress(getAddress);
		order.setReAddress(reAddress);
		BigDecimal bigDecimal = new BigDecimal(fee);
		order.setFee(bigDecimal);
		
		orderService.updateOrderInfo(order);
		
		CarInfo tmpCarInfo = carInfoService.findCarInfoByCarId(Integer.parseInt(carId));
		
		request.removeAttribute("orderInfo");
		request.removeAttribute("orderCarInfo");
		request.setAttribute("orderInfo", order);
		request.setAttribute("orderCarInfo", tmpCarInfo);
		
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}

	protected void cancelOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderIdVal = request.getParameter("orderId");
		String userIdVal = request.getParameter("userId");
		String carIdVal = request.getParameter("carId");
		String req = request.getParameter("req");
		int rc = orderService.cancelOrderByOrderId(Long.parseLong(orderIdVal), Integer.parseInt(userIdVal), Integer.parseInt(carIdVal));
		
		if (Boolean.parseBoolean(req)) {
			Order order = new Order();
			order = orderService.findOrderByOrderIdAndUserId(Long.parseLong(orderIdVal), Integer.parseInt(userIdVal));
			
			CarInfo tmpCarInfo = carInfoService.findCarInfoByCarId(order.getCarInfo().getCarId());
			
			request.removeAttribute("orderInfo");
			request.removeAttribute("orderCarInfo");
			request.setAttribute("orderInfo", order);
			request.setAttribute("orderCarInfo", tmpCarInfo);
			request.getRequestDispatcher("cancelOrder.jsp").forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			if (rc != 0) {
				out.print(true);
			} else {
				out.print(false);
			}
			out.close();
		}
		
	}

	protected void rAlterOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderIdVal = request.getParameter("orderId");
		String userIdVal = request.getParameter("userId");
		
		Order order = new Order();
		order = orderService.findOrderByOrderIdAndUserId(Long.parseLong(orderIdVal), Integer.parseInt(userIdVal));
		
		CarInfo tmpCarInfo = carInfoService.findCarInfoByCarId(order.getCarInfo().getCarId());
		
		request.removeAttribute("orderInfo");
		request.removeAttribute("orderCarInfo");
		request.setAttribute("orderInfo", order);
		request.setAttribute("orderCarInfo", tmpCarInfo);
		
		request.getRequestDispatcher("alterOrder.jsp").forward(request, response);
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
		
		if (orderService.findOrderWithOrderState(order) == null) {
			orderService.tradeOrder(order);
		}
		
		order = orderService.findOrderWithOrderState(order);
		
		CarInfo tmpCarInfo = carInfoService.findCarInfoByCarId(carId);
		
		request.removeAttribute("orderInfo");
		request.removeAttribute("orderCarInfo");
		request.setAttribute("orderInfo", order);
		request.setAttribute("orderCarInfo", tmpCarInfo);
		
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}

	protected void toOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer carId = Integer.parseInt(request.getParameter("carId"));
		
		CarInfo carInfo = carInfoService.findCarInfoByCarId(carId);
		
		request.setAttribute("orderCarInfo", carInfo);
		
		request.getRequestDispatcher("trade.jsp").forward(request, response);
		
	}

	protected void displayOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
