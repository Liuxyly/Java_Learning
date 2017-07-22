<%@ page language="java" pageEncoding="UTF-8"%>
<%
	if (session.getAttribute("adminUser") == null) {
		response.sendRedirect("login.jsp");
	}
%>