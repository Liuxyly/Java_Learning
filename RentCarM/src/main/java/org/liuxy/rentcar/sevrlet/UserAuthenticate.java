package org.liuxy.rentcar.sevrlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.liuxy.rentcar.entity.AdminUser;
import org.liuxy.rentcar.entity.NormalUser;
import org.liuxy.rentcar.entity.Order;
import org.liuxy.rentcar.service.AdminUserService;
import org.liuxy.rentcar.service.NormalUserService;
import org.liuxy.rentcar.service.OrderService;
import org.liuxy.rentcar.service.impl.AdminUserServiceImpl;
import org.liuxy.rentcar.service.impl.NormalUserServiceImpl;
import org.liuxy.rentcar.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class UserAuthenticate
 */

@WebServlet("/UserAuthenticate") 
public class UserAuthenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String SALT = "QWERT";
	private NormalUserService normalUserService = new NormalUserServiceImpl();
	private AdminUserService adminUserService = new AdminUserServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAuthenticate() {
        super();
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
		// request.setCharacterEncoding("UTF-8"); Filter 过滤所有URL 并执行了该代码
		
		String opr = (String)request.getParameter("opr");
		
		if (opr.equals("add")) {
			add(request, response);
		}
		if (opr.equals("login")) {
			login(request, response);
		}
		if (opr.equals("adminLogin")) {
			adminLogin(request, response);
		} 
//		if (opr.equals("addAdmin")) {
//			addAdmin(request, response);
//		}
		
		
	}
	
	@SuppressWarnings("unused")
	private void addAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newAdminPwd = request.getParameter("newuserpwd");
		String value = new Sha256Hash(newAdminPwd, SALT).toString();
		
		String newAdminName = request.getParameter("newusername");
		
		AdminUser newUser = new AdminUser(newAdminName, value);
		System.out.println(newAdminPwd + "////" + value);
		
		int rcNumber = adminUserService.register(newUser);
		HttpSession httpSession = request.getSession();
		httpSession.removeAttribute("message");
		if (rcNumber > 0) {
			httpSession.setAttribute("message", "Successful");
		} else {
			httpSession.setAttribute("message", "Error");
		}
	}
	
	private void adminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminName = request.getParameter("adminName");
		String adminPwd = request.getParameter("adminPwd");
		
		String value = new Sha256Hash(adminPwd, SALT).toString();
		AdminUser adminUser = new AdminUser(adminName, value);
		
		AdminUser userInfo = (AdminUser) adminUserService.login(adminUser);
		
		System.out.println(adminPwd + "////" + value);
		
		HttpSession httpSession = request.getSession();
		OrderService orderService = new OrderServiceImpl();
		if (userInfo == null) {
			httpSession.setAttribute("message", "Error");
			response.sendRedirect("admin/login.jsp");
		} else {
			httpSession.setAttribute("orderList", orderService.listOrders());
			httpSession.setAttribute("adminUser", userInfo);
			response.sendRedirect("admin/index.jsp");
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		
		String value = new Sha256Hash(userPass, SALT).toString();
		NormalUser normalUser = new NormalUser(userName, value);
		
		System.out.println(userPass + "////" + value);
		
		NormalUser userInfo = (NormalUser) normalUserService.login(normalUser);
		HttpSession httpSession = request.getSession();
		
		if (userInfo == null) {
			httpSession.setAttribute("message", "Error");
			response.sendRedirect("login.jsp");
		} else {
			httpSession.setAttribute("normalUser", userInfo);
			response.sendRedirect("index.jsp");
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String newPhoneNumber = request.getParameter("phonenumber");
		String newUserPwd = request.getParameter("newuserpwd");
		String value = new Sha256Hash(newUserPwd, SALT).toString();
		
		String newUserName = request.getParameter("newusername");
		
		NormalUser newUser = new NormalUser(newPhoneNumber, newUserName, value);
		System.out.println(newUserPwd + "////" + value);
		
		int rcNumber = normalUserService.register(newUser);
		HttpSession httpSession = request.getSession();
		httpSession.removeAttribute("message");
		if (rcNumber > 0) {
			httpSession.setAttribute("message", "Successful");
			response.sendRedirect("register.jsp");
		} else {
			httpSession.setAttribute("message", "Error");
			response.sendRedirect("register.jsp");
		}
	}

}
